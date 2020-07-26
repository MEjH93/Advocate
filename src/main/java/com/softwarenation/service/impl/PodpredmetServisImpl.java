package com.softwarenation.service.impl;

import com.softwarenation.api.dto.AdvokatDtoResponse;
import com.softwarenation.api.dto.PodPredmetDtoRequest;
import com.softwarenation.api.dto.PodPredmetDtoResponse;
import com.softwarenation.domen.Podpredmet;
import com.softwarenation.domen.Predmet;
import com.softwarenation.mapper.PodPredmetmapper;
import com.softwarenation.repository.PodpredmetRespoitory;
import com.softwarenation.repository.PredmetRepository;
import com.softwarenation.service.PodpredmetServis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PodpredmetServisImpl implements PodpredmetServis {
    private final PodpredmetRespoitory podpredmetRespoitory;
    private final PredmetRepository predmetRepository;
    private final PodPredmetmapper podPredmetmapper;
    @Autowired
    public PodpredmetServisImpl(PodpredmetRespoitory podpredmetRespoitory, PredmetRepository predmetRepository, PodPredmetmapper podPredmetmapper) {
        this.podpredmetRespoitory = podpredmetRespoitory;
        this.predmetRepository = predmetRepository;
        this.podPredmetmapper = podPredmetmapper;
    }

    @Override
    @Transactional
    public PodPredmetDtoResponse savePodPredmet(Long id, PodPredmetDtoRequest podPredmetDtoRequest) {
        Predmet predmet = predmetRepository.findById(id).get();
        if(predmet == null)throw new RuntimeException("Ne postoji predmet");
        Podpredmet podpredmet = podPredmetmapper.toPodpredmet(podPredmetDtoRequest);
        podpredmet.setPredmet(predmet);
        return podPredmetmapper.toPredmetResponse(podpredmetRespoitory.save(podpredmet));
    }

    @Override
    public List<PodPredmetDtoResponse> getAllPodpredmet() {
        return podPredmetmapper.toListPodepredmet(podpredmetRespoitory.findAll());
    }

}
