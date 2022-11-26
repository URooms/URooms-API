package com.upc.uroomsapi.publications.interfaces.rest;

import com.upc.uroomsapi.publications.application.dtos.request.ReviewRequest;
import com.upc.uroomsapi.publications.application.dtos.response.ReviewResponseV1;
import com.upc.uroomsapi.publications.application.handlers.queries.GetReviewsByStudentIdHandler;
import com.upc.uroomsapi.publications.application.messages.queries.GetReviewsByStudentId;
import com.upc.uroomsapi.publications.application.services.ReviewService;
import com.upc.uroomsapi.shared.interfaces.rest.MessageResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/review")
@CrossOrigin(origins = "*")
@Tag(name = "Review")
public class ReviewController {
    @Autowired
    private ReviewService service;

    @Autowired
    private GetReviewsByStudentIdHandler getReviewsByStudentIdHandler;

    //GET
    @Operation(summary = "Obtiene la lista de reseñas que hizo un estudiante")
    @GetMapping("/list/student/{studentId}")
    public ResponseEntity<List<ReviewResponseV1>> listReviewsByStudentId(
            @PathVariable(value = "studentId") Long studentId
    ) {
        var query = new GetReviewsByStudentId(studentId);
        var reviews = getReviewsByStudentIdHandler.execute(query);
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

    //POST
    @Operation(summary = "Crea una nueva reseña")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Objeto creado"),
            @ApiResponse(responseCode = "400", description = "Error al crear")
    })
    @PostMapping("/create/{postId}/{studentId}")
    public ResponseEntity<MessageResponse> createPost(
            @PathVariable(value = "postId") Long postId,
            @PathVariable(value = "studentId") Long studentId,
            @Valid @RequestBody ReviewRequest request
    ) {
        var msg = service.writeReview(postId, studentId, request);
        return new ResponseEntity<>(msg, HttpStatus.CREATED);
    }
}
