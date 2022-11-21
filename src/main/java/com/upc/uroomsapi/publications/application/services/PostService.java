package com.upc.uroomsapi.publications.application.services;

import com.upc.uroomsapi.publications.application.handlers.commands.CreatePostHandler;
import com.upc.uroomsapi.publications.application.messages.commands.CreatePostCommand;
import com.upc.uroomsapi.publications.application.dtos.request.PostRequest;
import com.upc.uroomsapi.shared.interfaces.rest.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    @Autowired
    private CreatePostHandler createPostHandler;

    /**
     * Crea un nuevo Post
     * @param request Data a crear
     * @return Un mensaje
     */
    public MessageResponse createPost(long ownerId, PostRequest request) {
        //dto to command
        var command = new CreatePostCommand();
        command.setOwnerId(ownerId);
        command.setTitle(request.getTitle());
        command.setDescription(request.getDescription());
        command.setPropertyAddress(request.getPropertyAddress());
        command.setPropertyDimensions(request.getPropertyDimensions());
        command.setPropertyType(request.getPropertyType());
        command.setPricePerMonth(request.getPricePerMonth());

        //execute command
        createPostHandler.execute(command);

        return new MessageResponse("Post creado correctamente");
    }
}
