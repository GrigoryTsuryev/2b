package com.app.tobeprecise.controllers;

import com.app.tobeprecise.dtos.ManagerDTO;
import com.app.tobeprecise.dtos.ReportDTO;
import com.app.tobeprecise.dtos.TaskDTO;
import com.app.tobeprecise.entities.Manager;
import com.app.tobeprecise.entities.Task;
import com.app.tobeprecise.interfaces.IManagerService;
import com.app.tobeprecise.interfaces.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("managers")
public class ManagerController {

    private IManagerService managerService;
    private ITaskService taskService;

    @Autowired
    public ManagerController(IManagerService managerService, ITaskService taskService) {
        this.managerService = managerService;
        this.taskService = taskService;
    }

    @PostMapping("save")
    public ResponseEntity<ManagerDTO> save(@RequestBody Manager manager){
        return new ResponseEntity<>(managerService.save(manager), HttpStatus.CREATED);
    }


    @PostMapping("{managerId}/employees/{employeeId}/tasks")
    public ResponseEntity<TaskDTO> save(@RequestBody Task task, @PathVariable long employeeId, @PathVariable long managerId){
        return new ResponseEntity<>(taskService.createTask(managerId, employeeId, task), HttpStatus.CREATED);
    }

    @GetMapping("{managerId}/reports")
    public ResponseEntity<List<ReportDTO>> findReportsByManager(@PathVariable long managerId){
        return new ResponseEntity<>(managerService.findReportsByManager(managerId), HttpStatus.OK);
    }


}
