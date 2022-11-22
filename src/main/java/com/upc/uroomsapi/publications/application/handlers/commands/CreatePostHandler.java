package com.upc.uroomsapi.publications.application.handlers.commands;

import com.upc.uroomsapi.shared.application.exception.ResourceNotFoundException;
import com.upc.uroomsapi.notifications.application.handlers.events.PostCreatedHandler;
import com.upc.uroomsapi.publications.application.messages.commands.CreatePostCommand;
import com.upc.uroomsapi.publications.domain.events.PostCreated;
import com.upc.uroomsapi.publications.infrastructure.persistence.entities.Post;
import com.upc.uroomsapi.publications.infrastructure.persistence.repositories.PostRepository;
import com.upc.uroomsapi.users.infrastructure.persistence.repositories.OwnerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreatePostHandler {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private OwnerRepository ownerRepository;

    public Post execute(CreatePostCommand command) {
        //map command to domain
        var postToCreate = modelMapper.map(command, Post.class);

        //busca el usuario donde se creara el post
        var owner = ownerRepository.findById(command.getOwnerId())
                .orElseThrow(() -> new ResourceNotFoundException("Owner", "ID", command.getOwnerId()));

        postToCreate.setOwner(owner); //asigna el usuario buscado
        var postCreated = postRepository.save(postToCreate); //crea el post

        //react to event
        var event = new PostCreated(
                postCreated.getTitle(),
                postCreated.getPostId()
        );
        new PostCreatedHandler().handle(event);

        //return postRepository.save(postToCreate);
        return postCreated;
    }
}
