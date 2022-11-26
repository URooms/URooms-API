package com.upc.uroomsapi.users.application.handlers.commands;

import com.upc.uroomsapi.notifications.application.handlers.events.OwnerRegisteredHandler;
import com.upc.uroomsapi.users.application.messages.commands.RegisterOwnerCommand;
import com.upc.uroomsapi.users.domain.events.OwnerRegistered;
import com.upc.uroomsapi.users.infrastructure.persistence.entities.Owner;
import com.upc.uroomsapi.users.infrastructure.persistence.repositories.OwnerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterOwnerHandler {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private OwnerRepository ownerRepository;

    public Owner execute(RegisterOwnerCommand command) {
        //map command to domain
        var ownerToCreate = modelMapper.map(command, Owner.class);

        //create owner
        var ownerCreated = ownerRepository.save(ownerToCreate);

        //react to event
        var event = new OwnerRegistered(
                ownerCreated.getPersonalInfo().getFirstname() + ownerCreated.getPersonalInfo().getSurname(),
                ownerCreated.getUserId()
        );
        new OwnerRegisteredHandler().handle(event);

        return ownerCreated;
    }
}
