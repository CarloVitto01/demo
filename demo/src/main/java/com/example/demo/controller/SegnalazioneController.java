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
@CrossOrigin(origins = "https://demo-1-prova.up.railway.app") // Replace with specific allowed origins
@RequestMapping("/api/v1/segnalazione")
public class SegnalazioneController {

    @Autowired
    private SegnalazioneService segnalazioneService;
    @Autowired
    private SegnalazioneMapper segnalazioneMapper;

    @Operation(summary = "Inserisce una nuova segnalazione")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "La segnalazione è stata creata correttamente")
    })
    @PostMapping(value = "/segnalazione")
    public ResponseEntity<Boolean> createSegnalazione(@RequestBody SegnalazioneDTO segnalazioneDTO) {
        boolean creationSuccessful = segnalazioneService.createSegnalazione(segnalazioneDTO);
        return new ResponseEntity<>(creationSuccessful, HttpStatus.OK);
    }

    @Operation(summary = "Elimina una segnalazione esistente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Segnalazione eliminata correttamente")
    })
    @DeleteMapping(value = "/segnalazione/{id}")
    public ResponseEntity<Void> deleteSegnalazione(@PathVariable long id) throws Exception {
        segnalazioneService.deleteSegnalazione(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Use 204 No Content for successful deletions
    }

    @Operation(summary = "Recupera le segnalazioni filtrate")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Segnalazioni trovate correttamente")
    })
    @GetMapping(value = "/filteredList")
    public ResponseEntity<List<SegnalazioneDTO>> getFilteredSegnalazioni(
            @RequestParam(required = false) String surname,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        List<SegnalazioneDTO> dtoList = segnalazioneService.filteredBy(surname, date);
        return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }
}