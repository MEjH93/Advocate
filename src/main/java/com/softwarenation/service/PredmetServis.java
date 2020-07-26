package com.softwarenation.service;



import com.softwarenation.api.dto.PredmetDtoRequest;
import com.softwarenation.api.dto.PredmetDtoResponse;
import java.util.List;


public interface PredmetServis {
    PredmetDtoResponse savePredmet(Long id, PredmetDtoRequest predmetDtoRequest);

    List<PredmetDtoResponse> getAllPredmeti();
}


