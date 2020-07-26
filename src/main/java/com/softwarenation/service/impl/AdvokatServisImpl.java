package com.softwarenation.service.impl;

import com.softwarenation.api.dto.AdvokatDtoRequest;
import com.softwarenation.api.dto.AdvokatDtoResponse;
import com.softwarenation.api.dto.TaskDtoresponse;
import com.softwarenation.domen.Advokat;
import com.softwarenation.domen.Task;
import com.softwarenation.mapper.AdvokatMapper;
import com.softwarenation.mapper.TaskMapper;
import com.softwarenation.repository.AdvokatRepository;
import com.softwarenation.repository.TaskRepository;
import com.softwarenation.service.AdvokatServis;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AdvokatServisImpl implements AdvokatServis {
    private final AdvokatRepository advokatRepository;
    private final AdvokatMapper advokatMapper;
    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    public AdvokatServisImpl(AdvokatRepository advokatRepository, AdvokatMapper advokatMapper, TaskRepository taskRepository, TaskMapper taskMapper) {
        this.advokatRepository = advokatRepository;
        this.advokatMapper = advokatMapper;
        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
    }


    @Override
    @Transactional
    public AdvokatDtoResponse saveAdvokat(AdvokatDtoRequest advokatDtoRequest) {
        Advokat advokat = advokatMapper.toAdvokat(advokatDtoRequest);
        return advokatMapper.advokatDtoResponse(advokatRepository.save(advokat));
    }

    @Override
    @Transactional(readOnly = true)
    public List<AdvokatDtoResponse> getAllAdvokati() {
        List<Advokat>advokati =  advokatRepository.findAll();
        return advokatMapper.toAdvokatiRespknse(advokati);
    }

    @Override
    @Transactional
    public List<TaskDtoresponse> getAllTask(Long idAdvokat) {
        List<Task>taskovi = taskRepository.findByAdvokaId(idAdvokat);
        return taskMapper.toResponseList(taskovi);
    }

  /*  @Override
    @Transactional
    public AdvokatDtoResponse deleteAdvokat(AdvokatDtoRequest advokatDtoRequest) {
        Advokat advokat = advokatMapper.toAdvokat(advokatDtoRequest);
        return advokatMapper.advokatDtoResponse(advokatRepository.deleteById(advokat));
    }*/
}
