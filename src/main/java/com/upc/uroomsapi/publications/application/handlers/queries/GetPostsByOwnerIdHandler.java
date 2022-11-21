package com.upc.uroomsapi.publications.application.handlers.queries;

import com.upc.uroomsapi.publications.application.dtos.response.PostResponse;
import com.upc.uroomsapi.publications.application.messages.queries.GetPostsByOwnerId;
import com.upc.uroomsapi.publications.infrastructure.persistence.repositories.PostRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GetPostsByOwnerIdHandler {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PostRepository postRepository;

    public List<PostResponse> execute(GetPostsByOwnerId query) {
        var postList = postRepository.findByOwner(query.getOwnerId());

        return postList.stream()
                .map(post -> modelMapper.map(post, PostResponse.class)) //lambda que mapea cada item al dto (response)
                .collect(Collectors.toList());
    }
}
