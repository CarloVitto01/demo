package com.example.demo.mapper;

import com.example.demo.dto.ProdottoDto;
import com.example.demo.entity.Prodotto;
import org.springframework.stereotype.Component;

@Component
public class ProdottoMapper {
    public ProdottoDto toDto(Prodotto prodotto){
        ProdottoDto dto = new ProdottoDto(
                prodotto.getId(),
                prodotto.getName(),
                prodotto.getPrezzo()
        );
        return dto;
    }

    public Prodotto toEntity(ProdottoDto prodottodto){
        Prodotto prodotto = new Prodotto(
                prodottodto.getId(),
                prodottodto.getName(),
                prodottodto.getPrezzo()
        );
        return prodotto;
    }
}
