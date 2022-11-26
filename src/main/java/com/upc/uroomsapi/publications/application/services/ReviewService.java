package com.upc.uroomsapi.publications.application.services;

import com.upc.uroomsapi.publications.application.dtos.request.ReviewRequest;
import com.upc.uroomsapi.publications.application.handlers.commands.WriteReviewHandler;
import com.upc.uroomsapi.publications.application.messages.commands.WriteReviewCommand;
import com.upc.uroomsapi.shared.interfaces.rest.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    @Autowired
    private WriteReviewHandler writeReviewHandler;

    /**
     * Crea una nueva Reseña para un post específico
     * @param request Data a crear
     * @return Un mensaje
     */
    public MessageResponse writeReview(long postId, long studentId, ReviewRequest request) {
        //dto to command
        var command = new WriteReviewCommand();
        command.setPostId(postId);
        command.setStudentId(studentId);
        command.setComment(request.getComment());
        command.setScore(request.getScore());

        //execute command
        writeReviewHandler.execute(command);

        return new MessageResponse("Reseña creada correctamente para el post " + postId);
    }
}
