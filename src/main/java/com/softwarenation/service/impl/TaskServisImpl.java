package com.softwarenation.service.impl;

import com.softwarenation.api.dto.TaskDtorequest;
import com.softwarenation.api.dto.TaskDtoresponse;
import com.softwarenation.domen.Advokat;
import com.softwarenation.domen.Podpredmet;
import com.softwarenation.domen.Task;
import com.softwarenation.mapper.TaskMapper;
import com.softwarenation.repository.AdvokatRepository;
import com.softwarenation.repository.PodpredmetRespoitory;
import com.softwarenation.repository.TaskRepository;
import com.softwarenation.service.TaskServis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class TaskServisImpl implements TaskServis {
    private final TaskRepository taskRepository;
    private final AdvokatRepository advokatRepository;
    private final PodpredmetRespoitory podpredmetRespoitory;
    private final TaskMapper taskMapper;

    @Autowired
    public TaskServisImpl(TaskRepository taskRepository, AdvokatRepository advokatRepository, PodpredmetRespoitory podpredmetRespoitory, TaskMapper taskMapper) {
        this.taskRepository = taskRepository;
        this.advokatRepository = advokatRepository;
        this.podpredmetRespoitory = podpredmetRespoitory;
        this.taskMapper = taskMapper;
    }

    @Override
    @Transactional
    public TaskDtoresponse saveTask(Long idAdvokat, Long idPodpredmet, TaskDtorequest taskDtorequest) {
        Advokat advokat = advokatRepository.findById(idAdvokat).get();
        if(advokat == null)throw new RuntimeException("ne postoji advokat");
        Podpredmet podpredmet = podpredmetRespoitory.findById(idPodpredmet).get();
        if(podpredmet == null)throw new RuntimeException("ne postoji podpredmet");
        Task task = taskMapper.toTask(taskDtorequest);
        task.setAdvokat(advokat);
        task.setPodpredmet(podpredmet);
        return taskMapper.toResponse(taskRepository.save(task));


    }

    @Override
    public List<TaskDtoresponse> getAllTaskovi() {

        return taskMapper.toResponseList(taskRepository.findAll());
    }

    @Override
    public void deleteTask(Long idTask) {
        Task task = taskRepository.findById(idTask).get();
        taskRepository.delete(task);
    }
}
