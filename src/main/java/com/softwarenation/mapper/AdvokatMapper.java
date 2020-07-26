package com.softwarenation.mapper;

import com.softwarenation.api.dto.AdvokatDtoRequest;
import com.softwarenation.api.dto.AdvokatDtoResponse;
import com.softwarenation.domen.Advokat;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class AdvokatMapper {
    public Advokat toAdvokat(AdvokatDtoRequest advokatDtoRequest){
        return Advokat.builder()
                .ime(advokatDtoRequest.getImeAdvokata())
                .prezime(advokatDtoRequest.getPrezimeAdvokata())
                .build();
    }
    public AdvokatDtoResponse advokatDtoResponse (Advokat advokat){
        return AdvokatDtoResponse.builder()
                .idAdvokata(advokat.getId())
                .imeAdvokata(advokat.getIme())
                .prezimeAdvokata(advokat.getPrezime())
                .build();
    }

    public List<AdvokatDtoResponse> toAdvokatiRespknse(List<Advokat> advokati) {
        return advokati.stream().map(this::advokatDtoResponse).collect(Collectors.toList());

    }
}
