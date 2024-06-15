package com.example.demo.controller;

import com.example.demo.dto.OrdineDto;
import com.example.demo.service.AquistoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin("*") // Replace with specific allowed origins
@RequestMapping("/api/v1/acquisto")
public class AcquistoController {

    @Autowired
    private AquistoService aquistoService;

    @Operation(summary = "Inserisce una nuova")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "è stata creata correttamente")
    })
    @PostMapping(value = "/create-acquisto")
    public ResponseEntity<Boolean> create(@RequestBody OrdineDto ordineDto) {
        boolean creationSuccessful = aquistoService.create(ordineDto);
        return new ResponseEntity<>(creationSuccessful, HttpStatus.OK);
    }

    @Operation(summary = "Elimina una esistente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "eliminata correttamente")
    })
    @DeleteMapping(value = "/delete-acquisto/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) throws Exception {
        aquistoService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Use 204 No Content for successful deletions
    }

    @Operation(summary = "Recupera tutte")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "trovate correttamente")
    })
    @GetMapping(value = "/all")
    public ResponseEntity<List<OrdineDto>> getAll() {
        List<OrdineDto> dtoList = aquistoService.getAll();
        return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }
}
