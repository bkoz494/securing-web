package com.example.securingweb.Service;

import com.example.securingweb.DAO.JournalRepo;
import com.example.securingweb.DAO.UserRepository;
import com.example.securingweb.Model.JournalEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateServise {
    @Autowired
    UserRepository uRepo;
    @Autowired
    JournalRepo jRepo;

    public String accessEntryConfirmation(Long entryId, Long userId){
        String message = "";
        Optional<JournalEntry> optEntry = jRepo.findById(entryId);
        if(optEntry.isPresent()){
            if(!optEntry.get().getUserId().equals(userId)){
                message = "You have no access to entry"+entryId.toString();
            }
        } else {
            message = "You have no access to entry"+entryId.toString();
        }
        return message;
    }
}
