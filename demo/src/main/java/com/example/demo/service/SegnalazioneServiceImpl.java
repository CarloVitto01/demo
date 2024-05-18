package com.example.demo.service;

import com.example.demo.dto.SegnalazioneDTO;
import com.example.demo.entity.Segnalazione;
import com.example.demo.mapper.SegnalazioneMapper;
import com.example.demo.repository.SegnalazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class SegnalazioneServiceImpl implements SegnalazioneService{
    @Autowired
    private SegnalazioneRepository segnalazioneRepository;
    @Autowired
    private SegnalazioneMapper segnalazioneMapper;
    
    @Override
    public List<SegnalazioneDTO> getAllSegnalazioni() {
        List<Segnalazione> segnalazioneList = segnalazioneRepository.findAll();
        return segnalazioneMapper.mapListToDTOs(segnalazioneList);
    }
 
    @Override
    public boolean createSegnalazione(SegnalazioneDTO segnalazioneDto) throws Exception {
        boolean result = false;
        Segnalazione segnalazione;
        try {
            segnalazione = segnalazioneMapper.toEntity(segnalazioneDto);
            segnalazione.setDate(LocalDate.now());
            segnalazioneRepository.save(segnalazione);
            result = true;
        } catch (Exception e){
            throw new Exception("Errore nella creazione della segnalazione!");
        }
        return result;
    }

    @Override
    public boolean deleteSegnalazione(long id) throws Exception{
        boolean result = false;
        try {
            segnalazioneRepository.findById(id).orElseThrow();
            segnalazioneRepository.deleteById(id);
            result = true;
        } catch (Exception e){
            throw new Exception("Errore nella cancellazione della segnalazione!");
        }
        return result;
    }

    @Override
    public List<SegnalazioneDTO> filteredByDateSegnalazione(LocalDate firstDate) {
        List<Segnalazione> segnalazioneList = segnalazioneRepository.segnalazioneFiltered(firstDate);
        return segnalazioneMapper.mapListToDTOs(segnalazioneList);
    }
}
