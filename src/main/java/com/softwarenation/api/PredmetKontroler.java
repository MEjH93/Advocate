package com.softwarenation.api;

import com.softwarenation.api.dto.PredmetDtoRequest;
import com.softwarenation.api.dto.PredmetDtoResponse;
import com.softwarenation.service.PredmetServis;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/predmeti/")
@CrossOrigin("http://localhost:3000")
public class PredmetKontroler {

    private final PredmetServis predmetServis;
    @Autowired
    public PredmetKontroler(PredmetServis predmetServis) {
        this.predmetServis = predmetServis;
    }

    @PostMapping("{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public PredmetDtoResponse save(@PathVariable Long id, @RequestBody PredmetDtoRequest predmetDtoRequest){

        return predmetServis.savePredmet(id, predmetDtoRequest);
    }
    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<PredmetDtoResponse> getAllPredmeti(){

        return predmetServis.getAllPredmeti();
    }

}