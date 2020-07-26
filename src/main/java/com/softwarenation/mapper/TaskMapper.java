package com.softwarenation.mapper;

import com.softwarenation.api.dto.TaskDtorequest;
import com.softwarenation.api.dto.TaskDtoresponse;
import com.softwarenation.domen.Task;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TaskMapper {
    public Task toTask(TaskDtorequest taskDtorequest){
        return Task.builder()
                .datum(taskDtorequest.getDatum())
                .opis(taskDtorequest.getOpis())
                .utrosenoVreme(taskDtorequest.getUtrosenoVreme())
                .build();

    }

    public TaskDtoresponse toResponse(Task task) {
        return TaskDtoresponse.builder()
                .idTask(task.getId())
                .datum(task.getDatum())
                .utrosenoVreme(task.getUtrosenoVreme())
                .opis(task.getOpis())
                .build();
    }

    public List<TaskDtoresponse> toResponseList(List<Task> taskovi) {
       return taskovi.stream().map(this::toResponse).collect(Collectors.toList());
    }
}
