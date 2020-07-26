package com.softwarenation.api;

import com.softwarenation.api.dto.PredmetDtoRequest;
import com.softwarenation.api.dto.PredmetDtoResponse;
import com.softwarenation.api.dto.TaskDtorequest;
import com.softwarenation.api.dto.TaskDtoresponse;
import com.softwarenation.service.TaskServis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/taskovi/")
@CrossOrigin("http://localhost:3000")
public class TaskControler {
    private final TaskServis taskServis;
    @Autowired
    public TaskControler(TaskServis taskServis) {
        this.taskServis = taskServis;
    }


    @PostMapping("{idAdvokat}/{idPodpredmet}")
    @ResponseStatus(HttpStatus.CREATED)
    public TaskDtoresponse save(@PathVariable Long idAdvokat, @PathVariable Long idPodpredmet, @RequestBody TaskDtorequest taskDtorequest){

        return taskServis.saveTask(idAdvokat,idPodpredmet, taskDtorequest);
    }
    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<TaskDtoresponse> getAllPredmeti(){
        return taskServis.getAllTaskovi();
    }

    @DeleteMapping("{idTask}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteTask(@PathVariable Long idTask){
        taskServis.deleteTask(idTask);
    }
}
