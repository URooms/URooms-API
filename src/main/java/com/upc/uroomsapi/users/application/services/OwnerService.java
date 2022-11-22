package com.upc.uroomsapi.users.application.services;

import com.upc.uroomsapi.users.application.handlers.commands.RegisterOwnerHandler;
import com.upc.uroomsapi.users.application.messages.commands.RegisterOwnerCommand;
import com.upc.uroomsapi.users.application.dtos.request.OwnerRequest;
import com.upc.uroomsapi.shared.interfaces.rest.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OwnerService {
    @Autowired
    private RegisterOwnerHandler registerOwnerHandler;

    /**
     * Crea un nuevo Owner
     * @param request Data a crear
     * @return Un mensaje
     */
    public MessageResponse createOwner(OwnerRequest request) {
        //dto to command
        var command = new RegisterOwnerCommand();
        command.setDni(request.getDni());
        command.setEmail(request.getEmail());
        command.setGender(request.getGender());
        command.setPassword(request.getPassword());
        command.setUsername(request.getUsername());
        command.setPersonalInfo(request.getPersonalInfo());
        command.setPhoneNumber(request.getPhoneNumber());

        //execute command
        registerOwnerHandler.execute(command);

        return new MessageResponse("Arrendador creado correctamente");
    }
}
