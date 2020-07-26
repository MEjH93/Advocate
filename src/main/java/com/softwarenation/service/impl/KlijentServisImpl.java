package com.softwarenation.service.impl;

import com.softwarenation.api.dto.KlijentDtoRequest;
import com.softwarenation.api.dto.KlijentDtoTask;
import com.softwarenation.api.dto.KlijnetDtoResonse;
import com.softwarenation.domen.*;
import com.softwarenation.mapper.KlijentMapper;

import com.softwarenation.repository.KlijentRepository;
import com.softwarenation.service.KlijentServis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class KlijentServisImpl implements KlijentServis {

    private final KlijentRepository klijentRepository;
    private final KlijentMapper klijentMapper;
    //private final KlinentMapper1 klijentMapper1;
    @Autowired
    public KlijentServisImpl(KlijentRepository klijentRepository, KlijentMapper klijentMapper/*,KlinentMapper1 klijentMapper1*/) {
        this.klijentRepository = klijentRepository;
        this.klijentMapper = klijentMapper;
      // this.klijentMapper1 = klijentMapper1;
    }

    @Override
    @Transactional
    public KlijnetDtoResonse save(KlijentDtoRequest klijentDtoRequest) {

        Klijent klijent = klijentRepository.save(klijentMapper.toKlijent(klijentDtoRequest));

        return klijentMapper.toReposnseKlijent(klijent);
    }

    @Override
    public List<KlijnetDtoResonse> getAllKlijenti() {
        return klijentMapper.toKlijentResponse(klijentRepository.findAll());
    }

    @Override
    @Transactional
    public KlijentDtoTask getKlijent(Long idKlijent) {
        Klijent klijent = klijentRepository.findByIdKlijnet(idKlijent);
        if(klijent == null)throw new RuntimeException("ne postoji klijent");
        Set<Predmet> predmeti = klijent.getPredmeti();
        Set<Podpredmet>podpredmeti = new HashSet<>();
        Set<Task>taskovi = new HashSet<>();
        Set<Advokat>advokati = new HashSet<>();
        predmeti.stream().forEach(predmet -> podpredmeti.addAll(predmet.getPodpredmeti()));
        podpredmeti.stream().forEach(podpredmet -> taskovi.addAll(podpredmet.getTaskovi()));
        taskovi.stream().forEach(task -> advokati.add(task.getAdvokat()));
        return klijentMapper.toReposnseTaskovi(predmeti,podpredmeti,taskovi, advokati);
    }
}
