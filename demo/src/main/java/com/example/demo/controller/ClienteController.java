package com.example.demo.controller;

import com.example.demo.dto.ClienteDTO;
import com.example.demo.dto.OrdineDto;
import com.example.demo.service.AquistoService;
import com.example.demo.service.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*") // Replace with specific allowed origins
@RequestMapping("/api/v1/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @Operation(summary = "Inserisce una nuova")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "è stata creata correttamente")
    })
    @PostMapping(value = "/create-cliente")
    public ResponseEntity<Boolean> create(@RequestBody ClienteDTO clienteDTO) {
        boolean creationSuccessful = clienteService.create(clienteDTO);
        return new ResponseEntity<>(creationSuccessful, HttpStatus.OK);
    }

    @Operation(summary = "Recupera tutte")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "trovate correttamente")
    })
    @GetMapping(value = "/all")
    public ResponseEntity<List<ClienteDTO>> getAll() {
        List<ClienteDTO> dtoList = clienteService.getAll();
        return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }
}
