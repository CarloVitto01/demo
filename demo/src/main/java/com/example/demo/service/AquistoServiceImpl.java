package com.example.demo.service;

import com.example.demo.dto.OrdineDto;
import com.example.demo.entity.Ordine;
import com.example.demo.mapper.OrdineMapper;
import com.example.demo.repository.OrdineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AquistoServiceImpl implements AquistoService {
    @Autowired
    private OrdineRepository ordineRepository;
    @Autowired
    private OrdineMapper ordineMapper;

    @Override
    public List<OrdineDto> getAll() {
        List<Ordine> allOrders = ordineRepository.findAll();
        return ordineMapper.mapListToDTOs(allOrders);
    }

    @Override
    public boolean create(OrdineDto ordineDto) {
        ordineDto.setDate(LocalDate.now());
        ordineRepository.save(ordineMapper.toEntity(ordineDto));
        return true;
    }

    @Override
    public boolean delete(long id) {
            ordineRepository.deleteById(id);
            return true;
    }

}
