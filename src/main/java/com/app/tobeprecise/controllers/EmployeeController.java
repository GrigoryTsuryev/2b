package com.app.tobeprecise.controllers;


import com.app.tobeprecise.entities.Employee;
import com.app.tobeprecise.entities.Report;
import com.app.tobeprecise.entities.Task;
import com.app.tobeprecise.interfaces.IEmployeeService;
import com.app.tobeprecise.interfaces.IOverloadedService;
import com.app.tobeprecise.interfaces.IRelationshipManagementService;
import com.app.tobeprecise.interfaces.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("employees")
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;


    @Autowired
    private IRelationshipManagementService relationshipManagementService;

    @Autowired
    private IOverloadedService overloadedService;

    @PostMapping(path = "save")
    public Employee save(@RequestBody Employee employee){
        return  employeeService.save(employee);
    }

    @PostMapping("{employeeId}/report")
    public Report createReport(@RequestBody Report report, @PathVariable long employeeId){
        return employeeService.createReport(employeeId, report);
    }

    @PostMapping("relationship/assign")
    public Employee assign(@RequestParam long managerId, @RequestParam long employeeId){
        return relationshipManagementService.assignEmployeeToManager(managerId, employeeId);
    }

    @GetMapping("{employeeId}/tasks")
    public List<Task> getTasksByEmployeeId(@PathVariable long employeeId){
        return employeeService.findTasksByEmployeeId( employeeId);
    }

    @GetMapping("overloaded")
    public List<Employee> getOverloadedEmployees(){
        return overloadedService.findOverloadedEmployeesPerManager();
    }






}
