package com.test.workshopmongo.services;

import com.test.workshopmongo.dto.UserDTO;
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

    public User insert(User user) {
        return repository.insert(user);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }
    public User update(User obj) {
        User newObj = findById(obj.getId());
        updateData(newObj, obj);
        return repository.save(newObj);
    }

    public void updateData(User entity, User obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
    }

    public User fromDTO(UserDTO userDto) {
        return new User(userDto.getId(), userDto.getName(), userDto.getEmail());
    }
}
