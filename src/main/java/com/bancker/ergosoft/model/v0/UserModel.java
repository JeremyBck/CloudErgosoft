package com.bancker.ergosoft.model.v0;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserModel {

    private String surname;

    private String firstName;

    private String email;

    private String encodedPassword;
}
