package com.example.securingweb.DAO;

import com.example.securingweb.Model.JournalEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
public interface JournalRepo extends JpaRepository<JournalEntry, Long> {
    List<JournalEntry> findByUserId(Long userId);
    @Modifying(clearAutomatically = true)
    @Query("update JournalEntry u set u.text = :text, u.dateAndTime = :date where u.id = :id")
    void updateById(@Param("text") String text, @Param("date") String date, @Param("id") Long id);
//    @Modifying(clearAutomatically = true)
//    @Query("update JournalEntry u set u.text = :text where u.dateAndTime = :date")
//    void updateByDate(@Param("text") String text, @Param("date") String date);
}