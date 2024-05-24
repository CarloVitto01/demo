package com.example.demo.service;

import com.example.demo.dto.SegnalazioneDTO;
import com.example.demo.entity.Segnalazione;
import com.example.demo.mapper.SegnalazioneMapper;
import com.example.demo.repository.SegnalazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class SegnalazioneServiceImpl implements SegnalazioneService{
    @Autowired
    private SegnalazioneRepository segnalazioneRepository;
    @Autowired
    private SegnalazioneMapper segnalazioneMapper;
 
    @Override
    public boolean createSegnalazione(SegnalazioneDTO segnalazioneDto) {
        segnalazioneDto.setDate(LocalDate.now());
        segnalazioneRepository.save(segnalazioneMapper.toEntity(segnalazioneDto));
        return true;
    }

    @Override
    public boolean deleteSegnalazione(long id) {
            segnalazioneRepository.deleteById(id);
            return true;
    }

    @Override
    public List<SegnalazioneDTO> filteredBy(String surname, LocalDate date) {
        List<Segnalazione> segnalazioneList;
        if (surname == null && date != null) {
            segnalazioneList = segnalazioneRepository.segnalazioneFilteredByDate(date);
        } else if (surname != null && date == null) {
            segnalazioneList = segnalazioneRepository.segnalazioneFilteredBySurname(surname);
        } else if (surname != null && date != null) {
            segnalazioneList = segnalazioneRepository.segnalazioneFilteredByDateAndSurname(date, surname);
        } else {
            segnalazioneList = segnalazioneRepository.findAll();
        }
        return segnalazioneMapper.mapListToDTOs(segnalazioneList);
    }

}
