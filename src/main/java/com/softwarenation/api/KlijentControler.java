package com.softwarenation.api;

import com.softwarenation.api.dto.KlijentDtoRequest;
import com.softwarenation.api.dto.KlijentDtoTask;
import com.softwarenation.api.dto.KlijnetDtoResonse;
import com.softwarenation.service.KlijentServis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/klijenti/")
@CrossOrigin
public class KlijentControler {
    private final KlijentServis klijentServis;
    @Autowired
    public KlijentControler(KlijentServis klijentServis) {
        this.klijentServis = klijentServis;
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public KlijnetDtoResonse save(@RequestBody KlijentDtoRequest klijent){

        return klijentServis.save(klijent);
    }

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<KlijnetDtoResonse> getAllAdvokati(){

        return klijentServis.getAllKlijenti();
    }
    @GetMapping("{idKlijent}")
    @ResponseStatus(HttpStatus.OK)
    public KlijentDtoTask getKlijent(@PathVariable Long idKlijent){

        return klijentServis.getKlijent(idKlijent);
    }
}
