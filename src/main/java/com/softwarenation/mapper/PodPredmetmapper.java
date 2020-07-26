package com.softwarenation.mapper;

import com.softwarenation.api.dto.PodPredmetDtoRequest;
import com.softwarenation.api.dto.PodPredmetDtoResponse;
import com.softwarenation.domen.Podpredmet;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PodPredmetmapper {
    public Podpredmet toPodpredmet(PodPredmetDtoRequest podPredmetDtoRequest){
        return Podpredmet.builder()
                .naziv_podpredmeta(podPredmetDtoRequest.getNaziv_podpredmeta())
                .sifra_podpredmeta(podPredmetDtoRequest.getSifra_podpredmeta())
                .build();
    }

    public PodPredmetDtoResponse toPredmetResponse(Podpredmet save) {
        return PodPredmetDtoResponse.builder()
                .id_podpredmet(save.getId())
                .naziv_podpredmeta(save.getNaziv_podpredmeta())
                .sifra_podpredmeta(save.getSifra_podpredmeta())
                .build();
    }

    public List<PodPredmetDtoResponse> toListPodepredmet(List<Podpredmet> podpredmets) {
        return podpredmets.stream().map(this::toPredmetResponse).collect(Collectors.toList());
    }
}
