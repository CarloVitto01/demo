package com.example.demo.service;

import com.example.demo.dto.OrdineDto;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public interface AquistoService {
    List<OrdineDto> getAll();

    boolean create(OrdineDto ordineDto);

    boolean delete(long id);
}
