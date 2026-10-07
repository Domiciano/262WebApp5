package edu.co.icesi.introspringboot.service;

import edu.co.icesi.introspringboot.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> findAll();

    Optional<User> findById(Integer id);

    User save(User user);

    void deleteById(Integer id);

    User findByUsername(String username);
}
