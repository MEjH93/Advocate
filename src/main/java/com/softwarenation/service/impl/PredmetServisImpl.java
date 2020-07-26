package com.softwarenation.service.impl;

import com.softwarenation.api.dto.PredmetDtoRequest;
import com.softwarenation.api.dto.PredmetDtoResponse;
import com.softwarenation.domen.Klijent;
import com.softwarenation.domen.Predmet;
import com.softwarenation.mapper.PredmetMapper;
import com.softwarenation.repository.KlijentRepository;
import com.softwarenation.repository.PredmetRepository;
import com.softwarenation.service.PredmetServis;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import java.util.List;

@Component
public class PredmetServisImpl implements PredmetServis {

    private final PredmetRepository predmetRepository;
    private final KlijentRepository klijentRepository;
    private  final PredmetMapper predmetMapper;

    public PredmetServisImpl(PredmetRepository predmetRepository, KlijentRepository klijentRepository, PredmetMapper predmetMapper) {
        this.predmetRepository = predmetRepository;
        this.klijentRepository = klijentRepository;
        this.predmetMapper = predmetMapper;
    }

    @Override
    public PredmetDtoResponse savePredmet(Long id, PredmetDtoRequest predmetDtoRequest) {
        Klijent klijent = klijentRepository.findById(id).get();
        if(klijent == null)throw  new RuntimeException("Ne postoji klijent");
       Predmet predmet = predmetMapper.toPredmet(predmetDtoRequest);
       predmet.setKlijent(klijent);



        return predmetMapper.predmetDtoResponse(predmetRepository.save(predmet));
    }

    @Override
    public List<PredmetDtoResponse> getAllPredmeti() {

        return predmetMapper.toPredmetDtoResponse(predmetRepository.findAll());
    }
}
