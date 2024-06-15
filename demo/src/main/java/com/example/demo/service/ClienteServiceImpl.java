package com.example.demo.service;

import com.example.demo.dto.ClienteDTO;
import com.example.demo.entity.Cliente;
import com.example.demo.mapper.ClienteMapper;
import com.example.demo.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService{

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ClienteMapper clienteMapper;

    @Override
    public boolean create(ClienteDTO clienteDTO) {
        clienteRepository.save(clienteMapper.toEntity(clienteDTO));
        return true;
    }

    @Override
    public List<ClienteDTO> getAll() {
        List<Cliente> allClienti = clienteRepository.findAll();
        return clienteMapper.mapListToDTOs(allClienti);
    }
}
