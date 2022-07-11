package com.example.securingweb.DAO;

import com.example.securingweb.Model.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<MyUser, Long> {
    MyUser findByUsername(String username);
}
