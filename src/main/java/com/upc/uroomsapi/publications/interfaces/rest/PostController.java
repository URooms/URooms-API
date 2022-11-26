package com.upc.uroomsapi.publications.interfaces.rest;

import com.upc.uroomsapi.publications.application.dtos.request.PostRequest;
import com.upc.uroomsapi.publications.application.dtos.response.PostResponseV1;
import com.upc.uroomsapi.publications.application.handlers.queries.GetPostByIdHandler;
import com.upc.uroomsapi.publications.application.messages.queries.GetPostById;
import com.upc.uroomsapi.shared.interfaces.rest.MessageResponse;
import com.upc.uroomsapi.publications.application.dtos.response.PostResponse;
import com.upc.uroomsapi.publications.application.handlers.queries.GetAllPostsHandler;
import com.upc.uroomsapi.publications.application.handlers.queries.GetPostsByOwnerIdHandler;
import com.upc.uroomsapi.publications.application.messages.queries.GetAllPosts;
import com.upc.uroomsapi.publications.application.messages.queries.GetPostsByOwnerId;
import com.upc.uroomsapi.publications.application.services.PostService;
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
@RequestMapping("/api/post")
@CrossOrigin(origins = "*")
@Tag(name = "Post")
public class PostController {
    @Autowired
    private PostService service;

    @Autowired
    private GetAllPostsHandler getAllPostsHandler;

    @Autowired
    private GetPostsByOwnerIdHandler getPostsByOwnerIdHandler;

    @Autowired
    private GetPostByIdHandler getPostByIdHandler;

    //GET
    @Operation(summary = "Obtiene la lista de publicaciones creadas por los arrendadores")
    @GetMapping("/list")
    public ResponseEntity<List<PostResponse>> listPosts() {
        var query = new GetAllPosts();
        var posts = getAllPostsHandler.execute(query);
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    //GET
    @Operation(summary = "Obtiene la lista de publicaciones creadas por un arrendador de acuerdo a su Id")
    @GetMapping("/list/owner/{ownerId}")
    public ResponseEntity<List<PostResponse>> listPostsByOwnerId(
            @PathVariable(value = "ownerId") Long ownerId
    ) {
        var query = new GetPostsByOwnerId(ownerId);
        var posts = getPostsByOwnerIdHandler.execute(query);
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    //GET
    @Operation(summary = "Obtiene una publicación detallada por su Id")
    @GetMapping("/list/post/{postId}")
    public ResponseEntity<PostResponseV1> getPostById(
            @PathVariable(value = "postId") Long postId
    ) {
        var query = new GetPostById(postId);
        var post = getPostByIdHandler.execute(query);
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    //POST
    @Operation(summary = "Crea una nueva publicación")
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
