package com.upc.uroomsapi.service;

import com.upc.uroomsapi.exception.ResourceNotFoundException;
import com.upc.uroomsapi.model.entity.Post;
import com.upc.uroomsapi.model.request.PostRequest;
import com.upc.uroomsapi.model.response.MessageResponse;
import com.upc.uroomsapi.model.response.PostResponse;
import com.upc.uroomsapi.repository.OwnerRepository;
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
    private PostRepository postRepo;

    //inyecta los métodos CRUD del repository
    @Autowired
    private OwnerRepository ownerRepo;


    /**
     * Obtiene el listado de publicaciones
     * @return Lista de publicaciones
     */
    public List<PostResponse> getAllPosts() {
        var postList = postRepo.findAll(); //listado

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
        var post = postRepo.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "ID", postId));
        return modelMapper.map(post, PostResponse.class);
    }

    /**
     * Crea un nuevo Post
     * @param request Data a crear
     * @return Un mensaje
     */
    public MessageResponse createPost(long ownerId, PostRequest request) {
        var post = modelMapper.map(request, Post.class); //mapea el dto (request) a la entidad (desde el dto se obtiene la entidad)

        //busca el usuario donde se creara el post
        var owner = ownerRepo.findById(ownerId)
                .orElseThrow(() -> new ResourceNotFoundException("Owner", "ID", ownerId));

        post.setOwner(owner); //asigna el usuario buscado
        postRepo.save(post); //crea el post

        return new MessageResponse("Post creado correctamente");
    }
}
