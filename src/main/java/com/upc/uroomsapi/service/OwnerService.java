package com.upc.uroomsapi.service;

import com.upc.uroomsapi.exception.ResourceNotFoundException;
import com.upc.uroomsapi.model.entity.Owner;
import com.upc.uroomsapi.model.request.OwnerRequest;
import com.upc.uroomsapi.model.response.MessageResponse;
import com.upc.uroomsapi.model.response.OwnerResponse;
import com.upc.uroomsapi.repository.OwnerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OwnerService {
    //inyecta el modelMapper
    @Autowired
    private ModelMapper modelMapper;

    //inyecta los métodos CRUD del repository
    @Autowired
    private OwnerRepository repo;

    /**
     * Obtiene el listado de arrendadores
     * @return Lista de arrendadores
     */
    public List<OwnerResponse> getAllOwners() {
        var ownerList = repo.findAll(); //listado

        return ownerList.stream()
                .map(owner -> modelMapper.map(owner, OwnerResponse.class)) //lambda que mapea cada item al dto (response)
                .collect(Collectors.toList());
    }

    /**
     * Obtiene un Owner por su ID
     * @param ownerId ID del Owner
     * @return El Owner
     */
    public OwnerResponse getOwnerById(long ownerId) {
        var owner = repo.findById(ownerId).orElseThrow(() -> new ResourceNotFoundException("Owner", "ID", ownerId));
        return modelMapper.map(owner, OwnerResponse.class);
    }

    /**
     * Crea un nuevo Owner
     * @param request Data a crear
     * @return Un mensaje
     */
    public MessageResponse createOwner(OwnerRequest request) {
        Owner owner = modelMapper.map(request, Owner.class); //mapea el dto (request) a la entidad
        repo.save(owner); //crea el arrendador

        return new MessageResponse("Arrendador creado correctamente");
    }
}
