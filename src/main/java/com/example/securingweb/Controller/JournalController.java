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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Calendar;

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
        LocalDateTime dateTime = LocalDateTime.now();
//        DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT).format(dateTime);
        journalEntry.setDateAndTime(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).format(dateTime).toString());
        journalRepo.save(journalEntry);
        return "redirect:/journal";
    }

    @PostMapping("/updateEntry")
    public String saveEmployee(@ModelAttribute("journalEntry") JournalEntry journalEntry) {
        System.out.println("----------------------\n"+journalEntry.toString());
//        journalRepo.updateById(journalEntry.getText(), journalEntry.getId());
//        LocalDateTime dateTime = LocalDateTime.now();
        journalRepo.updateByDate(journalEntry.getText(), journalEntry.getDateAndTime());
//        Long id =
        return "redirect:/journal";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String updateForm(@PathVariable(value = "id") long id, Model model) {
        JournalEntry journalEntry = journalRepo.findById(id).orElse(new JournalEntry());
        System.out.println("------------------ Entry tu update:\n"+journalEntry.toString());
        model.addAttribute("journalEntry", journalEntry);
        return "update";
    }

    @GetMapping("/deleteEntry/{id}")
    public String deleteThroughId(@PathVariable(value = "id") long id) {
        journalRepo.deleteById(id);
        return "redirect:/journal";

    }
}
