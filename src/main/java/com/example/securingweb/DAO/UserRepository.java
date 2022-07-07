package com.example.securingweb.DAO;

import com.example.securingweb.Model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.LinkedList;
import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findByUsername(String username);
}
