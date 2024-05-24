package com.example.demo.service;

import com.example.demo.dto.SegnalazioneDTO;

import java.time.LocalDate;
import java.util.List;


public interface SegnalazioneService {
    boolean createSegnalazione(SegnalazioneDTO segnalazione) throws Exception;
    boolean deleteSegnalazione(long id) throws Exception;

    List<SegnalazioneDTO> filteredBy(String surname, LocalDate date);
}
