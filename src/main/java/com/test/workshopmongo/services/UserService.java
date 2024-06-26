package com.test.workshopmongo.services;

import com.test.workshopmongo.entities.User;
import com.test.workshopmongo.repositorys.UserRepository;
import com.test.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(String id) {
        Optional<User> user = repository.findById(id);
       return user.orElseThrow(() -> new ObjectNotFoundException("Object not found."));
    }
}
