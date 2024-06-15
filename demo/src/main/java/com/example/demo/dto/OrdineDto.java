package com.example.demo.dto;

import java.time.LocalDate;

public class OrdineDto {
    private long id;
    private LocalDate date;
    private ClienteDTO cliente;
    private ProdottoDto prodotto;

    public OrdineDto(long id, LocalDate date, ClienteDTO cliente, ProdottoDto prodotto) {
        this.id = id;
        this.date = date;
        this.cliente = cliente;
        this.prodotto = prodotto;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public ProdottoDto getProdotto() {
        return prodotto;
    }

    public void setProdotto(ProdottoDto prodotto) {
        this.prodotto = prodotto;
    }
}
