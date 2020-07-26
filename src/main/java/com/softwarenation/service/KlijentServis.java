package com.softwarenation.service;

import com.softwarenation.api.dto.KlijentDtoRequest;
import com.softwarenation.api.dto.KlijentDtoTask;
import com.softwarenation.api.dto.KlijnetDtoResonse;

import java.util.List;

public interface KlijentServis {
    KlijnetDtoResonse save(KlijentDtoRequest klijent);

    List<KlijnetDtoResonse> getAllKlijenti();

    KlijentDtoTask getKlijent(Long idKlijent);
}
