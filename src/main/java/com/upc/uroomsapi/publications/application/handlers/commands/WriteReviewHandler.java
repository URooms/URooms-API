package com.upc.uroomsapi.publications.application.handlers.commands;

import com.upc.uroomsapi.notifications.application.handlers.events.ReviewCreatedHandler;
import com.upc.uroomsapi.publications.application.messages.commands.WriteReviewCommand;
import com.upc.uroomsapi.publications.domain.events.ReviewCreated;
import com.upc.uroomsapi.publications.infrastructure.persistence.entities.Review;
import com.upc.uroomsapi.publications.infrastructure.persistence.repositories.PostRepository;
import com.upc.uroomsapi.publications.infrastructure.persistence.repositories.ReviewRepository;
import com.upc.uroomsapi.shared.application.exception.ResourceNotFoundException;
import com.upc.uroomsapi.users.infrastructure.persistence.entities.Student;
import com.upc.uroomsapi.users.infrastructure.persistence.repositories.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WriteReviewHandler {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    public Review execute(WriteReviewCommand command) {
        //map command to domain
        var reviewToCreate = new Review();
        reviewToCreate.setComment(command.getComment());
        reviewToCreate.setScore(command.getScore());

        //busca el post donde se creara el review
        var post = postRepository.findById(command.getPostId())
                .orElseThrow(() -> new ResourceNotFoundException("Post", "ID", command.getPostId()));

        //busca el estudiante que creara el review
        var student = studentRepository.findById(command.getStudentId())
                .orElseThrow(() -> new ResourceNotFoundException("Student", "ID", command.getStudentId()));

        reviewToCreate.setPost(post); //asigna el post buscado
        reviewToCreate.setStudent(student); //asigna el autor

        //crea el review
        var reviewCreated = reviewRepository.save(reviewToCreate);

        //react to event
        var event = new ReviewCreated(
                reviewCreated.getPost(),
                reviewCreated.getStudent(),
                reviewCreated.getComment(),
                reviewCreated.getScore()
        );
        new ReviewCreatedHandler().handle(event);

        return reviewCreated;
    }
}
