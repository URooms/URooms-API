package com.upc.uroomsapi.users.application.services;

import com.upc.uroomsapi.shared.interfaces.rest.MessageResponse;
import com.upc.uroomsapi.users.application.dtos.request.StudentRequest;
import com.upc.uroomsapi.users.application.handlers.commands.RegisterStudentHandler;
import com.upc.uroomsapi.users.application.messages.commands.RegisterStudentCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    private RegisterStudentHandler registerStudentHandler;

    /**
     * Crea un nuevo Student
     * @param request Data a crear
     * @return Un mensaje
     */
    public MessageResponse createStudent(StudentRequest request) {
        //dto to command
        var command = new RegisterStudentCommand();
        command.setDni(request.getDni());
        command.setEmail(request.getEmail());
        command.setGender(request.getGender());
        command.setPassword(request.getPassword());
        command.setUsername(request.getUsername());
        command.setPersonalInfo(request.getPersonalInfo());
        command.setPhoneNumber(request.getPhoneNumber());
        command.setInstitution(request.getInstitution());

        //execute command
        registerStudentHandler.execute(command);

        return new MessageResponse("Estudiante creado correctamente");
    }
}
