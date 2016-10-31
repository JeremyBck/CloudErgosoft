package com.bancker.ergosoft.persistence.service;

import com.bancker.ergosoft.persistence.entity.Patient;
import com.bancker.ergosoft.persistence.entity.User;
import com.bancker.ergosoft.persistence.repository.UserRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private static Logger log = Logger.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PatientService patientService;

    public User addUser(User userToCreate){
        log.info("New user saved !");
        return userRepository.save(userToCreate);
    }

    public void removeUser(User userToDelete){
        List<Patient> patientList=patientService.findByUser(userToDelete);
        //before to delete a user, we need to detach all the patients associated
        patientList.stream().forEach(patient -> {
            List<User> userList=patient.getUserList();
            if(!userList.remove(userToDelete)){
                log.warn("No patient was associated to this user !");
            }
            else{
                patient.setUserList(userList);
                patientService.updatePatient(patient);
            }
        }
        );
        userRepository.delete(userToDelete);
    }

    /*
    public User updateUser(User newUser, String email){
        User userToUpdate=findByEmail(email);
        if (userToUpdate != null){

            userToUpdate.setFirstName(newUser.getFirstName());
            userToUpdate.setSurname(newUser.getSurname());
            userToUpdate.setEmail(newUser.getEmail());
            userToUpdate.setEncodedPassword(newUser.getEncodedPassword());
            userToUpdate.set
        }
        else{
            log.error("No user found for email {"+email+"}");
        }
    }*/

    public User findByEmail(String email){
        return userRepository.findByEmail(email);
    }

}
