package com.softwarenation.api;

import com.softwarenation.api.dto.AdvokatDtoResponse;
import com.softwarenation.api.dto.PodPredmetDtoRequest;
import com.softwarenation.api.dto.PodPredmetDtoResponse;
import com.softwarenation.service.PodpredmetServis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/podpredmeti/")
@CrossOrigin("http://localhost:3000")
public class PodpredmetControler {
    private final PodpredmetServis podpredmetServis;
    @Autowired
    public PodpredmetControler(PodpredmetServis podpredmetServis) {
        this.podpredmetServis = podpredmetServis;
    }


    @PostMapping("{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public PodPredmetDtoResponse save(@PathVariable Long id, @RequestBody PodPredmetDtoRequest podPredmetDtoRequest){

        return podpredmetServis.savePodPredmet(id,podPredmetDtoRequest);
    }
    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<PodPredmetDtoResponse> getAllAdvokati(){

        return podpredmetServis.getAllPodpredmet();
    }
}
