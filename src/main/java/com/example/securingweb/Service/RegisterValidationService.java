package com.example.securingweb.Service;

import com.example.securingweb.DAO.UserRepository;
import com.example.securingweb.Model.MyUser;
import com.example.securingweb.Model.RegisterInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RegisterValidationService {
    @Autowired
    UserRepository uRepo;
    public String passwordConfirmation (RegisterInfo registerInfo){
        String message = "";
        if(!registerInfo.getPassword().equals(registerInfo.getConfirmPassword())){
            message = "Password and its confirmation are not the same.";
        }
        return message;
    }

    public String uniquenessConfirmation(RegisterInfo registerInfo){
        String message = "";
        Optional<MyUser> user = Optional.ofNullable(uRepo.findByUsername(registerInfo.getUsername()));
        if(user.isPresent()){
            message = "This username already exists in database";
        }
        return message;
    }
}
