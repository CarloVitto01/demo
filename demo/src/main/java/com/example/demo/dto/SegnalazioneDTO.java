package com.example.demo.dto;

import java.time.LocalDate;

public class SegnalazioneDTO {
    private long id;
    private String description;
    private LocalDate date;
    private ClienteDTO cliente;
    private TecnicoDTO tecnico;

    public SegnalazioneDTO(long id, String description, LocalDate date, ClienteDTO cliente, TecnicoDTO tecnico) {
        this.id = id;
        this.description = description;
        this.date = date;
        this.cliente = cliente;
        this.tecnico = tecnico;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public ClienteDTO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteDTO cliente) {
        this.cliente = cliente;
    }

    public TecnicoDTO getTecnico() {
        return tecnico;
    }

    public void setTecnico(TecnicoDTO tecnico) {
        this.tecnico = tecnico;
    }
}
