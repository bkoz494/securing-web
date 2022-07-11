package com.example.securingweb.DAO;

import com.example.securingweb.Model.JournalEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface JournalRepo extends JpaRepository<JournalEntry, Long> {
    List<JournalEntry> findByUserId(Long userId);
//    void updateById(Long id);
}
