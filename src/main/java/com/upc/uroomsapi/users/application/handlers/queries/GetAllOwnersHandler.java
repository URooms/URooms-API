package com.upc.uroomsapi.users.application.handlers.queries;

import com.upc.uroomsapi.users.application.dtos.response.OwnerResponse;
import com.upc.uroomsapi.users.application.messages.queries.GetAllOwners;
import com.upc.uroomsapi.users.infrastructure.persistence.repositories.OwnerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GetAllOwnersHandler {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private OwnerRepository ownerRepository;

    public List<OwnerResponse> execute(GetAllOwners query) {
        var ownerList = ownerRepository.findAll(); //listado

        return ownerList.stream()
                .map(owner -> modelMapper.map(owner, OwnerResponse.class)) //lambda que mapea cada item al dto (response)
                .collect(Collectors.toList());
    }
}
