package com.softwarenation.api;

import com.softwarenation.api.dto.*;
import com.softwarenation.service.AdvokatServis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/advokati/")
@CrossOrigin("http://localhost:3000")
public class AdvokatKontroler {

    private final AdvokatServis advokatServis;
    @Autowired
    public AdvokatKontroler(AdvokatServis advokatServis) {
        this.advokatServis = advokatServis;
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public AdvokatDtoResponse save(@RequestBody AdvokatDtoRequest advokatDtoRequest){

        return advokatServis.saveAdvokat(advokatDtoRequest);
    }
    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<AdvokatDtoResponse> getAllAdvokati(){

        return advokatServis.getAllAdvokati();
    }
    @GetMapping("{idAdvokat}")
    @ResponseStatus(HttpStatus.OK)
    public List<TaskDtoresponse> getAllTask(@PathVariable Long idAdvokat){

        return advokatServis.getAllTask(idAdvokat);
    }
  /*  @PostMapping("") // ovo na dole sve da se objasni
    @ResponseStatus(HttpStatus.OK)
    public AdvokatDtoResponse delete(@RequestBody AdvokatDtoRequest advokatDtoRequest){

        return advokatServis.deleteAdvokat(advokatDtoRequest);
    }*/

}
