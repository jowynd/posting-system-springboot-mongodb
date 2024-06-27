package com.test.workshopmongo.resources;

import com.test.workshopmongo.entities.Post;
import com.test.workshopmongo.repositorys.PostRepository;
import com.test.workshopmongo.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class PostResources {
    private PostService service;

    @GetMapping(name = "/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id) {
        Post post = service.findById(id);

        return ResponseEntity.ok().body(post);
    }

}
