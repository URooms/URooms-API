package com.upc.uroomsapi.controller;

import com.upc.uroomsapi.model.request.OwnerRequest;
import com.upc.uroomsapi.model.response.MessageResponse;
import com.upc.uroomsapi.model.response.OwnerResponse;
import com.upc.uroomsapi.service.OwnerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
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
@RequestMapping("/api/v1/owner")
@CrossOrigin(origins = "*")
@Tag(name = "Owner")
public class OwnerController {
    @Autowired
    OwnerService service;

    //GET
    @Operation(summary = "Obtiene la lista de arrendadores creados")
    @GetMapping("/list")
    public ResponseEntity<List<OwnerResponse>> listWorkspace() {
        var owners = service.getAllOwners();
        return new ResponseEntity<>(owners, HttpStatus.OK);
    }

    //GET
    @Operation(summary = "Obtiene el detalle de un arrendador")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "El objeto no existe", content = @Content)
    })
    @GetMapping("/detail/{id}")
    public ResponseEntity<OwnerResponse> getOwnerById(@PathVariable("id") Long id) {
        var response = service.getOwnerById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //POST
    @Operation(summary = "Crea un arrendador")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Objeto creado"),
            @ApiResponse(responseCode = "400", description = "Error al crear")
    })
    @PostMapping("/create")
    public ResponseEntity<MessageResponse> createOwner(@Valid @RequestBody OwnerRequest request) {
        var msg = service.createOwner(request);
        return new ResponseEntity<>(msg, HttpStatus.CREATED);
    }
}
