package com.example.securingweb.Controller;

import com.example.securingweb.DAO.UserRepository;
import com.example.securingweb.Model.MyUser;
import com.example.securingweb.Model.RegisterInfo;
import com.example.securingweb.Service.RegisterValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.security.core.userdetails.User;

import javax.validation.Valid;

@Controller
public class RegisterController {

    @Autowired
    private UserRepository repository;
    @Autowired
    private RegisterValidationService registerValidation;

    @GetMapping("/register")
    public String greetingForm(Model model) {
        model.addAttribute("registerInfo", new RegisterInfo());
        return "register";
    }

    @PostMapping("/register")
    public String greetingSubmit(@ModelAttribute @Valid RegisterInfo registerInfo, BindingResult result, Model model) {
        String err = registerValidation.passwordConfirmation(registerInfo);
        if (!err.isEmpty()) {
            ObjectError error = new ObjectError("globalError", err);
            result.addError(error);
        }
        if (result.hasErrors()) {
            return "register";
        }
        repository.save(new MyUser(registerInfo.getUsername(), registerInfo.getPassword()));
//        System.out.println("---------------- SAVE TO DB");
//        System.out.println(repository.findByUsername(registerInfo.getUsername()).toString());

        model.addAttribute("registerSuccess", registerInfo);
        return "registerSuccess";
    }
//    public UserDetailsService userDetailsService(String username, String password) {
//        UserDetails user =
//                User.withDefaultPasswordEncoder()
//                        .username("user")
//                        .password("password")
//                        .roles("USER")
//                        .build();
//
//        return new InMemoryUserDetailsManager(user);
//    }

}