package com.example.demo.dto;

public class ProdottoDto {
    private long id;
    private String name;
    private double prezzo;

    public ProdottoDto(long id, String name, double prezzo) {
        this.id = id;
        this.name = name;
        this.prezzo = prezzo;
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
