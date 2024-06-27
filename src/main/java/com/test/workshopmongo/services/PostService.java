package com.test.workshopmongo.services;

import com.test.workshopmongo.entities.Post;
import com.test.workshopmongo.repositorys.PostRepository;
import com.test.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class PostService {

    @Autowired
    private PostRepository repository;

    public Post findById(String id) {
        Optional<Post> post = repository.findById(id);

        return post.orElseThrow(() -> new ObjectNotFoundException("Not found."));
    }
}
