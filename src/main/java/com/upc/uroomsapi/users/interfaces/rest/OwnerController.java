package com.upc.uroomsapi.users.interfaces.rest;

import com.upc.uroomsapi.publications.application.messages.queries.GetAllPosts;
import com.upc.uroomsapi.publications.application.messages.queries.GetPostsByOwnerId;
import com.upc.uroomsapi.shared.interfaces.rest.MessageResponse;
import com.upc.uroomsapi.users.application.dtos.request.OwnerRequest;
import com.upc.uroomsapi.users.application.dtos.response.OwnerResponse;
import com.upc.uroomsapi.users.application.handlers.queries.GetAllOwnersHandler;
import com.upc.uroomsapi.users.application.handlers.queries.GetOwnerByIdHandler;
import com.upc.uroomsapi.users.application.messages.queries.GetAllOwners;
import com.upc.uroomsapi.users.application.messages.queries.GetOwnerById;
import com.upc.uroomsapi.users.application.services.OwnerService;
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
    private OwnerService service;

    @Autowired
    private GetAllOwnersHandler getAllOwnersHandler;

    @Autowired
    private GetOwnerByIdHandler getOwnerByIdHandler;

    //GET
    @Operation(summary = "Obtiene la lista de arrendadores creados")
    @GetMapping("/list")
    public ResponseEntity<List<OwnerResponse>> listWorkspace() {
        var query = new GetAllOwners();
        var owners = getAllOwnersHandler.execute(query);
        return new ResponseEntity<>(owners, HttpStatus.OK);
    }

    //GET
    @Operation(summary = "Obtiene la información de un arrendador según su Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "El objeto no existe", content = @Content)
    })
    @GetMapping("/detail/{id}")
    public ResponseEntity<OwnerResponse> getOwnerById(@PathVariable("id") Long id) {
        var query = new GetOwnerById(id);
        var owner = getOwnerByIdHandler.execute(query);
        return new ResponseEntity<>(owner, HttpStatus.OK);
    }

    //POST
    @Operation(summary = "Crea un nuevo usuario  arrendador")
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
