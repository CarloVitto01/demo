package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Tb_Segnalazione")
public class Segnalazione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_segnalazione")
    private long id;
    @Column(name = "description_segnalazione", nullable = false)
    private String description;
    @Column(name = "date_segnalazione")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Europe/Rome")
    private LocalDate date;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_tecnico", nullable = false)
    private Tecnico tecnico;

    public Segnalazione(long id, String description, LocalDate date, Cliente cliente, Tecnico tecnico) {
        this.id = id;
        this.description = description;
        this.date = date;
        this.cliente = cliente;
        this.tecnico = tecnico;
    }

    public Segnalazione() {
    }

    public Segnalazione(String description, LocalDate date, Cliente cliente, Tecnico tecnico) {
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

    public Cliente getTbCliente() {
        return cliente;
    }

    public void setTbCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Tecnico getTbTecnico() {
        return tecnico;
    }

    public void setTbTecnico(Tecnico tecnico) {
        this.tecnico = tecnico;
    }
}
