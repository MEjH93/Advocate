package com.softwarenation.mapper;

import com.softwarenation.api.dto.AdvokatDtoRequest;
import com.softwarenation.api.dto.AdvokatDtoResponse;
import com.softwarenation.api.dto.PredmetDtoRequest;
import com.softwarenation.api.dto.PredmetDtoResponse;
import com.softwarenation.domen.Advokat;
import com.softwarenation.domen.Predmet;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PredmetMapper {

        public Predmet toPredmet(PredmetDtoRequest predmetDtoRequest){
            return Predmet.builder()
                    .naziv_predmeta(predmetDtoRequest.getNazivPredmeta())
                    .sifra_predmeta(predmetDtoRequest.getSifraPredmeta())
                    .build();
            //ostalo je za klijent id nzm dal ovde ide ili sta
        }
        public PredmetDtoResponse predmetDtoResponse (Predmet predmet){
            return PredmetDtoResponse.builder()
                    .idPredmet(predmet.getId())
                    .nazivPredmeta(predmet.getNaziv_predmeta())
                    .sifraPredmeta(predmet.getSifra_predmeta())
                   // .klijent(predmet.getKlijent().getId()) ovo treba da se fix
                    .build();
            //ostalo je za klijent id nzm dal ovde ide ili sta
        }

        public List<PredmetDtoResponse> toPredmetDtoResponse(List<Predmet> predmeti) {
            return  predmeti.stream().map(this::predmetDtoResponse).collect(Collectors.toList());

        }

}
