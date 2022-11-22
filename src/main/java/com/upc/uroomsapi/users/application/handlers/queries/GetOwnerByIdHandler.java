package com.upc.uroomsapi.users.application.handlers.queries;

import com.upc.uroomsapi.shared.application.exception.ResourceNotFoundException;
import com.upc.uroomsapi.users.application.dtos.response.OwnerResponse;
import com.upc.uroomsapi.users.application.messages.queries.GetOwnerById;
import com.upc.uroomsapi.users.infrastructure.persistence.repositories.OwnerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetOwnerByIdHandler {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private OwnerRepository ownerRepository;

    public OwnerResponse execute(GetOwnerById query) {
        var owner = ownerRepository.findById(query.getUserId()).orElseThrow(
                () -> new ResourceNotFoundException("Owner", "ID", query.getUserId())
        );

        return modelMapper.map(owner, OwnerResponse.class);
    }
}
