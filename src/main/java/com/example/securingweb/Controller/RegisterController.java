package com.example.securingweb.Controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.example.securingweb.DAO.UserRepository;
import com.example.securingweb.Model.User;
import com.example.securingweb.RegisterInfo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.net.SocketAddress;
import java.util.Optional;

@Controller
public class RegisterController {
    @GetMapping("/register")
    public String greetingForm(Model model) {
        model.addAttribute("registerInfo", new RegisterInfo());
        return "register";
    }

    @PostMapping("/register")
    public String greetingSubmit(@ModelAttribute RegisterInfo registerInfo, Model model) {
        System.out.println("------------------------");
        System.out.println(registerInfo.toString());

        model.addAttribute("registerInfo", registerInfo);
        return "registerInfo";
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