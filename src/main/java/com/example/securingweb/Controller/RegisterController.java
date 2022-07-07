package com.example.securingweb.Controller;

import com.example.securingweb.DAO.UserRepository;
import com.example.securingweb.Model.User;
import com.example.securingweb.Model.RegisterInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class RegisterController {

    @Autowired
    UserRepository repository;

    @GetMapping("/register")
    public String greetingForm(Model model) {
        model.addAttribute("registerInfo", new RegisterInfo());
        return "register";
    }

    @PostMapping("/register")
    public String greetingSubmit(@ModelAttribute @Valid RegisterInfo registerInfo, BindingResult result, Model model) {

        if (result.hasErrors()) {
            return "register";
        }
        repository.save(new User(registerInfo.getUsername(), registerInfo.getPassword()));
//        System.out.println("---------------- SAVE TO DB");
//        System.out.println(repository.findByUsername(registerInfo.getUsername()).toString());

        model.addAttribute("registerSuccess", registerInfo);
        return "registerSuccess";
    }
    /*public UserDetailsService userDetailsService() {
        UserDetails user =
                User.withDefaultPasswordEncoder()
                        .username("user")
                        .password("password")
                        .roles("USER")
                        .build();

        return new InMemoryUserDetailsManager(user);
    }*/

}