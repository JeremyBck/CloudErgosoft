package com.bancker.ergosoft.converters;


import com.bancker.ergosoft.model.v0.UserModel;
import com.bancker.ergosoft.persistence.entity.User;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.crypto.keygen.KeyGenerators;

public interface UserConverter {
    static User convertUserModelToUser(UserModel userModel){
        String salt=KeyGenerators.string().toString();
        String encodedPassWord=new ShaPasswordEncoder(256).encodePassword(userModel.getEncodedPassword(), salt);
        return new User(null, userModel.getSurname(), userModel.getFirstName(), userModel.getEmail(), encodedPassWord, salt, null);
    }
}
