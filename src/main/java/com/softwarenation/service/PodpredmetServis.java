package com.softwarenation.service;

import com.softwarenation.api.dto.AdvokatDtoResponse;
import com.softwarenation.api.dto.PodPredmetDtoRequest;
import com.softwarenation.api.dto.PodPredmetDtoResponse;

import java.util.List;

public interface PodpredmetServis {
    PodPredmetDtoResponse savePodPredmet(Long id, PodPredmetDtoRequest podPredmetDtoRequest);

    List<PodPredmetDtoResponse> getAllPodpredmet();
}
