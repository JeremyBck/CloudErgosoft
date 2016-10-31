package com.bancker.ergosoft.controller;

import com.bancker.ergosoft.commands.user.UserToUpdateOrDelete;
import com.bancker.ergosoft.converters.UserConverter;
import com.bancker.ergosoft.model.v0.UserModel;
import com.bancker.ergosoft.persistence.entity.User;
import com.bancker.ergosoft.persistence.repository.UserRepository;
import com.bancker.ergosoft.persistence.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/api/v0/user")
public class UserController {

    private static Logger log = Logger.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity addUser(@RequestBody UserModel userModel){
        User user=UserConverter.convertUserModelToUser(userModel);
        if(user!=null){
            user=userService.addUser(user);
            return new ResponseEntity(user, HttpStatus.OK);
        }
        else {
            //a problem occurred ?
            return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity removeUser(@RequestBody UserToUpdateOrDelete userToDelete){
        User user=userService.findByEmail(userToDelete.getEmail());
        if(user!=null){
            userService.removeUser(user);
            return new ResponseEntity(HttpStatus.OK);
        }
        else{
            return new ResponseEntity("No user found for email {"+userToDelete.getEmail()+"}", HttpStatus.BAD_REQUEST);
        }
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity updateUser(@RequestBody UserModel updatedUser, String email){
        User userToUpdate = userService.findByEmail(email);
        if (userToUpdate!=null){
            userToUpdate.setSurname(updatedUser.getSurname());
            userToUpdate.setFirstName(updatedUser.getFirstName());
            userToUpdate.setEmail(updatedUser.getEmail());
            userToUpdate.setEncodedPassword(updatedUser.getEncodedPassword());
            final User finalUpdatedUser=userRepository.save(userToUpdate);
            return new ResponseEntity(finalUpdatedUser, HttpStatus.OK);
        }
        else{
            return new ResponseEntity("No user found for this email !", HttpStatus.BAD_REQUEST);
        }
    }

}
