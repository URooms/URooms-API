package com.upc.uroomsapi.publications;

import com.upc.uroomsapi.publications.infrastructure.persistence.entities.Post;
import com.upc.uroomsapi.publications.infrastructure.persistence.repositories.PostRepository;
import com.upc.uroomsapi.users.infrastructure.persistence.entities.Owner;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class PostTest {
    @Autowired
    private PostRepository repo;

    @Test
    @Transactional
    public void testCreatePost() {
        var previousPostsCount = repo.findAll().size();

        //create new example post
        var exampleOwner = new Owner();
        exampleOwner.setUserId(3L);

        var newPost = new Post();
        newPost.setTitle("example title");
        newPost.setDescription("example description");
        newPost.setPricePerMonth(1000);
        newPost.setAvailable(true);
        newPost.setOwner(exampleOwner);
        var postCreated = repo.save(newPost);

        var newPostsCount = repo.findAll().size();

        //delete example post
        repo.deleteById(postCreated.getPostId());

        assertThat(newPostsCount).isGreaterThan(previousPostsCount);
    }
}
