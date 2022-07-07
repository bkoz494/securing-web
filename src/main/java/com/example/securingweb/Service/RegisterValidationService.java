package com.example.securingweb.Service;

import com.example.securingweb.Model.RegisterInfo;
import org.springframework.stereotype.Service;

@Service
public class RegisterValidationService {
    public String passwordConfirmation (RegisterInfo registerInfo){
        String message = "";
        if(!registerInfo.getPassword().equals(registerInfo.getConfirmPassword())){
            message = "Password and its confirmation are not the same.";
        }
        return message;
    }
}
