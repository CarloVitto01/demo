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
public class SegnalazioneController {
    @Autowired
    private SegnalazioneService segnalazioneService;
    @Autowired
    private SegnalazioneMapper segnalazioneMapper;

 
    @Operation(summary = "Inserisce una nuova segnalazione")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "La segnalazione  creata correttamente")
    })
    @PostMapping(value = "/segnalazione")
    public ResponseEntity<Boolean> createSegnalazione(@RequestBody SegnalazioneDTO segnalazioneDTO) {
        boolean createReq = segnalazioneService.createSegnalazione(segnalazioneDTO);
        return new ResponseEntity<>(createReq, HttpStatus.OK);
    }

    @Operation(summary = "Elimina una segnalazione esistente")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Segnalazione eliminata correttamente")
    })
    @DeleteMapping(value = "/segnalazione/{id}")
    public ResponseEntity<Boolean> deleteSegnalazione(@PathVariable long id) throws Exception {
        boolean deleteReq = segnalazioneService.deleteSegnalazione(id);
        return new ResponseEntity<>(deleteReq, HttpStatus.OK);
    }

    @Operation(summary = "Inserisci i filtri")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Segnalazioni trovate correttamente")
    })
    @GetMapping(value = "/filteredList")
    public ResponseEntity<List<SegnalazioneDTO>> getFilteredSegnalazioni(@RequestParam(required = false) String surname, @RequestParam(required = false) LocalDate date) {
        List<SegnalazioneDTO> dtoList = segnalazioneService.filteredBy(surname, date);
        return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }
}
