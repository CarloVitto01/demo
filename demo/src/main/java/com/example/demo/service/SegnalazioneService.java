package com.example.demo.service;

import com.example.demo.dto.SegnalazioneDTO;
import com.example.demo.entity.TbSegnalazione;

import java.time.LocalDate;
import java.util.List;


public interface SegnalazioneService {
    List<SegnalazioneDTO> getAllFiltered();
    boolean create(SegnalazioneDTO segnalazione);
    boolean delete(long id);

    List<SegnalazioneDTO> filteredByDate(LocalDate date);
}
