package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.time.LocalDate;

@Entity
@Table(name = "Tb_Segnalazione")
public class TbSegnalazione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_segnalazione")
    private long id;
    @Column(name = "description_segnalazione")
    private String description;
    @Column(name = "date_segnalazione")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    @ManyToOne
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @JoinColumn(name = "id_cliente", nullable = false)
    private TbCliente tbCliente;
    @ManyToOne
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @JoinColumn(name = "id_tecnico", nullable = false)
    private TbTecnico tbTecnico;

    public TbSegnalazione(long id, String description, LocalDate date, TbCliente tbCliente, TbTecnico tbTecnico) {
        this.id = id;
        this.description = description;
        this.date = date;
        this.tbCliente = tbCliente;
        this.tbTecnico = tbTecnico;
    }

    public TbSegnalazione() {
    }

    public TbSegnalazione(String description, LocalDate date, TbCliente tbCliente, TbTecnico tbTecnico) {
        this.description = description;
        this.date = date;
        this.tbCliente = tbCliente;
        this.tbTecnico = tbTecnico;
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

    public TbCliente getTbCliente() {
        return tbCliente;
    }

    public void setTbCliente(TbCliente tbCliente) {
        this.tbCliente = tbCliente;
    }

    public TbTecnico getTbTecnico() {
        return tbTecnico;
    }

    public void setTbTecnico(TbTecnico tbTecnico) {
        this.tbTecnico = tbTecnico;
    }
}
