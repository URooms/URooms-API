package com.upc.uroomsapi.users.application.handlers.commands;

import com.upc.uroomsapi.notifications.application.handlers.events.StudentRegisteredHandler;
import com.upc.uroomsapi.users.application.messages.commands.RegisterStudentCommand;
import com.upc.uroomsapi.users.domain.events.StudentRegistered;
import com.upc.uroomsapi.users.infrastructure.persistence.entities.Student;
import com.upc.uroomsapi.users.infrastructure.persistence.repositories.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterStudentHandler {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private StudentRepository studentRepository;

    public Student execute(RegisterStudentCommand command) {
        //map command to domain
        var studentToCreate = modelMapper.map(command, Student.class);

        //create student
        var studentCreated = studentRepository.save(studentToCreate);

        //react to event
        var event = new StudentRegistered(
                studentCreated.getPersonalInfo().getFirstname() + studentCreated.getPersonalInfo().getSurname(),
                studentCreated.getUserId()
        );
        new StudentRegisteredHandler().handle(event);

        return studentCreated;
    }
}
