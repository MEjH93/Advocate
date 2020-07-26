package com.softwarenation.mapper;

import com.softwarenation.api.dto.KlijentDtoRequest;
import com.softwarenation.api.dto.KlijentDtoTask;
import com.softwarenation.api.dto.KlijnetDtoResonse;
import com.softwarenation.api.dto.TaskDtoresponse;
import com.softwarenation.domen.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class KlijentMapper {

    private final TaskMapper taskMapper;

    public KlijentMapper(TaskMapper taskMapper) {
        this.taskMapper = taskMapper;
    }

    public Klijent toKlijent(KlijentDtoRequest klijentDtoRequest){
        return Klijent.builder().
                naziv(klijentDtoRequest.getNaziv())
                .build();
    }
    public KlijnetDtoResonse toReposnseKlijent(Klijent klijent){
        return KlijnetDtoResonse.builder()
                .naziv_klijenta(klijent.getNaziv())
                .id_klijent(klijent.getId())
                .build();
    }

    public List<KlijnetDtoResonse> toKlijentResponse(List<Klijent> klijents) {
        return klijents.stream().map(this::toReposnseKlijent).collect(Collectors.toList());

    }


    public KlijentDtoTask toReposnseTaskovi(Set<Predmet> predmeti, Set<Podpredmet> podpredmeti, Set<Task> taskovi, Set<Advokat> advokati) {
        List<String> nazivPredmeta = predmeti.stream().map(predmet -> predmet.getNaziv_predmeta()).collect(Collectors.toList());
        List<String>nazivPodpredmeta = podpredmeti.stream().map(podpredmet -> podpredmet.getNaziv_podpredmeta()).collect(Collectors.toList());
        List<TaskDtoresponse>taksovi  = taskMapper.toResponseList((List<Task>) taskovi);
        List<String>advokatiList = advokati.stream().map(advokat -> advokat.getIme()).collect(Collectors.toList());
       return KlijentDtoTask.builder()
                .nazivPredmeta(nazivPredmeta)
                .nazivPodpredmeta(nazivPodpredmeta)
                .advokat(advokatiList)
                .taskDtoresponses(taksovi)
                .build();




    }
}
