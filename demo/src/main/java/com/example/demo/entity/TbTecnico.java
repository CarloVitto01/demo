package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Tb_Tecnico")
public class TbTecnico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tecnico")
    private long id;
    @Column(name = "name_tecnico")
    private String name;
    @Column(name = "surname_tecnico")
    private String surname;

    public TbTecnico(long id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    public TbTecnico() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
