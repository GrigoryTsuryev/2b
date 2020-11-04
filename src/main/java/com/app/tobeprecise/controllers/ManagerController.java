package com.app.tobeprecise.controllers;

import com.app.tobeprecise.entities.Manager;
import com.app.tobeprecise.entities.Report;
import com.app.tobeprecise.entities.Task;
import com.app.tobeprecise.interfaces.IManagerService;
import com.app.tobeprecise.interfaces.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("managers")
public class ManagerController {

    @Autowired
    private IManagerService managerService;

    @Autowired
    private ITaskService taskService;

    @PostMapping(path = "save")
    public Manager save(@RequestBody Manager manager){
        return  managerService.save(manager);
    }


    @PostMapping("{managerId}/employees/{employeeId}/tasks")
    public Task save(@RequestBody Task task, @PathVariable long employeeId, @PathVariable long managerId){
        return  taskService.createTask(managerId, employeeId,task);
    }

    @GetMapping("{managerId}//reports")
    public List<Report> findReportsByManager(@PathVariable long managerId){
        return managerService.findReportsByManager(managerId);
    }


}
