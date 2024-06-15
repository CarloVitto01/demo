package com.example.demo.service;

import com.example.demo.dto.ClienteDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClienteService {

    boolean create(ClienteDTO clienteDTO);

    List<ClienteDTO> getAll();
}
