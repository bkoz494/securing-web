package com.example.securingweb.Controller;

import com.example.securingweb.DAO.JournalRepo;
import com.example.securingweb.Model.MyUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class JournalController {

    @Autowired
    private JournalRepo journalRepo;
//    @Autowired
//    private MyUser currentUser;

    @GetMapping({"/journal"})
    public ModelAndView getUsersEntrys(MyUser currentUser) {
        ModelAndView mav = new ModelAndView("journal");
        mav.addObject("entries", journalRepo.findByUserId(currentUser.getId()));
        return mav;
    }
}
