package com.example.securingweb.Controller;

import com.example.securingweb.DAO.JournalRepo;
import com.example.securingweb.DAO.UserRepository;
import com.example.securingweb.Model.JournalEntry;
import com.example.securingweb.Model.MyUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class JournalController {

    @Autowired
    private JournalRepo journalRepo;
    @Autowired
    private UserRepository userRepo;
//    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();


    @GetMapping({"/journal"})
    public ModelAndView showUsersEntries(@CurrentSecurityContext(expression = "authentication") Authentication authentication) {
        String currentPrincipalName = authentication.getName();
        MyUser currentUser = userRepo.findByUsername(currentPrincipalName);
        ModelAndView mav = new ModelAndView("journal");
        mav.addObject("entries", journalRepo.findByUserId(currentUser.getId()));
        return mav;
    }

    @GetMapping({"/addnew"})
    public String addEntry (Model model){
        JournalEntry journalEntry = new JournalEntry();
        model.addAttribute("journalEntry", journalEntry);
        return "newEntry";
    }

    @PostMapping({"/save"})
    public String saveEntry(@ModelAttribute("journalEntry") JournalEntry journalEntry, @CurrentSecurityContext(expression = "authentication") Authentication authentication) {
        String currentPrincipalName = authentication.getName();
        MyUser currentUser = userRepo.findByUsername(currentPrincipalName);
        journalEntry.setUserId(currentUser.getId());
        journalRepo.save(journalEntry);
        return "redirect:/journal";
    }

}
