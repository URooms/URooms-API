package com.upc.uroomsapi.publications.application.handlers.queries;

import com.upc.uroomsapi.publications.application.dtos.response.PostResponseV1;
import com.upc.uroomsapi.publications.application.messages.queries.GetPostById;
import com.upc.uroomsapi.publications.infrastructure.persistence.repositories.PostRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetPostByIdHandler {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PostRepository postRepository;

    public PostResponseV1 execute(GetPostById query) {
        var postResult = postRepository.findById(query.getPostId()).get();
        return modelMapper.map(postResult, PostResponseV1.class);
    }
}
