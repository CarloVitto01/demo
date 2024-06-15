package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "prodotto")
public class Prodotto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_prodotto")
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "prezzo")
    private double prezzo;


    public Prodotto(long id, String name, double prezzo) {
        this.id = id;
        this.name = name;
        this.prezzo = prezzo;
    }

    public Prodotto() {
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

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }
}
