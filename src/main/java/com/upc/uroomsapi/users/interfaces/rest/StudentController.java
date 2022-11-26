package com.upc.uroomsapi.users.interfaces.rest;

import com.upc.uroomsapi.shared.interfaces.rest.MessageResponse;
import com.upc.uroomsapi.users.application.dtos.request.StudentRequest;
import com.upc.uroomsapi.users.application.dtos.response.StudentResponse;
import com.upc.uroomsapi.users.application.handlers.queries.GetAllStudentsHandler;
import com.upc.uroomsapi.users.application.messages.queries.GetAllStudents;
import com.upc.uroomsapi.users.application.services.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/student")
@CrossOrigin(origins = "*")
@Tag(name = "Student")
public class StudentController {
    @Autowired
    private StudentService service;

    @Autowired
    private GetAllStudentsHandler getAllStudentsHandler;

    //GET
    @Operation(summary = "Obtiene la lista de estudiantes registrado")
    @GetMapping("/list")
    public ResponseEntity<List<StudentResponse>> listWorkspace() {
        var query = new GetAllStudents();
        var students = getAllStudentsHandler.execute(query);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    //POST
    @Operation(summary = "Registra un nuevo usuario estudiante")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Objeto creado"),
            @ApiResponse(responseCode = "400", description = "Error al crear")
    })
    @PostMapping("/create")
    public ResponseEntity<MessageResponse> createOwner(@Valid @RequestBody StudentRequest request) {
        var msg = service.createStudent(request);
        return new ResponseEntity<>(msg, HttpStatus.CREATED);
    }
}
