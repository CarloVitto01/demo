package com.example.demo.controller;

import com.example.demo.dto.SegnalazioneDTO;
import com.example.demo.mapper.SegnalazioneMapper;
import com.example.demo.service.SegnalazioneService;

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
@CrossOrigin("*")
@RequestMapping("/api/v1/segnalazioni")
public class SegnalazioneController {
    @Autowired
    private SegnalazioneService segnalazioneService;
    @Autowired
    private SegnalazioneMapper segnalazioneMapper;

    @Operation(summary = "Recupera l'elenco delle segnalazioni filtrato")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Lista recuperata correttamente")
    })
    @GetMapping(value = "/")
    public ResponseEntity<List<SegnalazioneDTO>> getAllSegnalazioni(){
        List<SegnalazioneDTO> dtoList = segnalazioneService.getAllFiltered();
        return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }
 
    @Operation(summary = "Inserisce una nuova segnalazione")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "La segnalazione  creata correttamente")
    })
    @PostMapping(value = "/")
    public ResponseEntity<Boolean> createSegnalazione(@RequestBody SegnalazioneDTO dto){
        boolean createReq = segnalazioneService.create(dto);
        return new ResponseEntity<>(createReq, HttpStatus.OK);
    }

    @Operation(summary = "Elimina una segnalazione esistente")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Segnalazione eliminata correttamente")
    })
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Boolean> deleteSegnalazione(@PathVariable long id){
        boolean deleteReq = segnalazioneService.delete(id);
        return new ResponseEntity<>(deleteReq, HttpStatus.OK);
    }

    @Operation(summary = "Inserisce filtri")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Segnalazioni trovate correttamente")
    })
    @GetMapping(value = "/{date}")
    public ResponseEntity<List<SegnalazioneDTO>> getFilteredSegnalazioni(
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        List<SegnalazioneDTO> dtoList = segnalazioneService.filteredByDate(date);
        return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }
}
