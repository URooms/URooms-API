package com.upc.uroomsapi.users.application.handlers.queries;

import com.upc.uroomsapi.users.application.dtos.response.StudentResponse;
import com.upc.uroomsapi.users.application.messages.queries.GetAllStudents;
import com.upc.uroomsapi.users.infrastructure.persistence.repositories.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GetAllStudentsHandler {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private StudentRepository studentRepository;

    public List<StudentResponse> execute(GetAllStudents query) {
        var studentList = studentRepository.findAll();

        return studentList.stream()
                .map(owner -> modelMapper.map(owner, StudentResponse.class))
                .collect(Collectors.toList());
    }
}
