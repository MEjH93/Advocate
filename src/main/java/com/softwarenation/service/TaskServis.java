package com.softwarenation.service;

import com.softwarenation.api.dto.PredmetDtoRequest;
import com.softwarenation.api.dto.TaskDtorequest;
import com.softwarenation.api.dto.TaskDtoresponse;

import java.util.List;

public interface TaskServis {
    TaskDtoresponse saveTask(Long idAdvokat, Long idPodpredmet, TaskDtorequest taskDtorequest);

    List<TaskDtoresponse> getAllTaskovi();

    void deleteTask(Long idTask);
}
