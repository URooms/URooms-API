package com.upc.uroomsapi.controller;

import com.upc.uroomsapi.model.request.PostRequest;
import com.upc.uroomsapi.model.response.MessageResponse;
import com.upc.uroomsapi.model.response.PostResponse;
import com.upc.uroomsapi.service.PostService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
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
@RequestMapping("/api/v1/post")
@CrossOrigin(origins = "*")
@Tag(name = "Post")
public class PostController {
    @Autowired
    PostService service;

    //GET
    @Operation(summary = "Obtiene la lista de posts creados")
    @GetMapping("/list")
    public ResponseEntity<List<PostResponse>> listWorkspace() {
        var posts = service.getAllPosts();
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    //GET
    @Operation(summary = "Obtiene el detalle de un post")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "El objeto no existe", content = @Content)
    })
    @GetMapping("/detail/{id}")
    public ResponseEntity<PostResponse> getPostById(@PathVariable("id") Long id) {
        var response = service.getPostById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //POST
    @Operation(summary = "Crea un post")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Objeto creado"),
            @ApiResponse(responseCode = "400", description = "Error al crear")
    })
    @PostMapping("/create/{ownerId}")
    public ResponseEntity<MessageResponse> createPost(
            @PathVariable(value = "ownerId") Long ownerId,
            @Valid @RequestBody PostRequest request
    ) {
        var msg = service.createPost(ownerId, request);
        return new ResponseEntity<>(msg, HttpStatus.CREATED);
    }
}
