package com.upc.uroomsapi.service;

import com.upc.uroomsapi.exception.ResourceNotFoundException;
import com.upc.uroomsapi.model.entity.Owner;
import com.upc.uroomsapi.model.entity.Post;
import com.upc.uroomsapi.model.request.PostRequest;
import com.upc.uroomsapi.model.response.MessageResponse;
import com.upc.uroomsapi.model.response.PostResponse;
import com.upc.uroomsapi.repository.PostRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {
    //inyecta el modelMapper
    @Autowired
    private ModelMapper modelMapper;

    //inyecta los métodos CRUD del repository
    @Autowired
    private PostRepository repo;

    /**
     * Obtiene el listado de publicaciones
     * @return Lista de publicaciones
     */
    public List<PostResponse> getAllPosts() {
        var postList = repo.findAll(); //listado

        return postList.stream()
                .map(post -> modelMapper.map(post, PostResponse.class)) //lambda que mapea cada item al dto (response)
                .collect(Collectors.toList());
    }

    /**
     * Obtiene un Post por su ID
     * @param postId ID del Post
     * @return El Post
     */
    public PostResponse getPostById(long postId) {
        var post = repo.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "ID", postId));
        return modelMapper.map(post, PostResponse.class);
    }

    /**
     * Crea un nuevo Post
     * @param request Data a crear
     * @return Un mensaje
     */
    public MessageResponse createPost(PostRequest request) {
        //Post post = modelMapper.map(request, Post.class); //mapea el dto (request) a la entidad

        var owner = new Owner();
        owner.setUserId(request.getOwnerId());

        var post = new Post();
        post.setTitle(request.getTitle());
        post.setDescription(request.getDescription());
        post.setOwner(owner);

        repo.save(post); //crea el post

        return new MessageResponse("Post creado correctamente");
    }
}
