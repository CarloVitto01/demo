package com.example.demo.service;

import com.example.demo.dto.SegnalazioneDTO;
import com.example.demo.mapper.SegnalazioneMapper;
import com.example.demo.repository.SegnalazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class SegnalazioneServiceImpl implements SegnalazioneService{
    @Autowired
    private SegnalazioneRepository repo;
    @Autowired
    private SegnalazioneMapper segnalazioneMapper;
    
    @Override
    public List<SegnalazioneDTO> getAllFiltered() {
        return segnalazioneMapper.mapListToDTOs(repo.findAll());
    }
 
    @Override
    public boolean create(SegnalazioneDTO segnalazione) {
        repo.save(segnalazioneMapper.toEntity(segnalazione));
        return true;
    }

    @Override
    public boolean delete(long id) {
        repo.deleteById(id);
        return true;
    }

    @Override
    public List<SegnalazioneDTO> filteredByDate(LocalDate date) {
        return segnalazioneMapper.mapListToDTOs(repo.findByDate(date));
    }
}
