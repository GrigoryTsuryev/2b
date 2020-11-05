package com.app.tobeprecise.controllers;


import com.app.tobeprecise.entities.Employee;
import com.app.tobeprecise.entities.Report;
import com.app.tobeprecise.entities.Task;
import com.app.tobeprecise.interfaces.IEmployeeService;
import com.app.tobeprecise.interfaces.IOverloadedService;
import com.app.tobeprecise.interfaces.IRelationshipManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Employee> save(@RequestBody Employee employee){
        return new ResponseEntity<>(employeeService.save(employee), HttpStatus.CREATED);
    }

    @PostMapping("{employeeId}/report")
    public ResponseEntity<Report> createReport(@RequestBody Report report, @PathVariable long employeeId){
        return new ResponseEntity<>(employeeService.createReport(employeeId, report), HttpStatus.CREATED);
    }

    @PostMapping("relationship/assign")
    public ResponseEntity<Employee> assign(@RequestParam long managerId, @RequestParam long employeeId){
        return new ResponseEntity<>(relationshipManagementService.assignEmployeeToManager(managerId, employeeId), HttpStatus.OK);
    }

    @GetMapping("{employeeId}/tasks")
    public ResponseEntity<List<Task>> getTasksByEmployeeId(@PathVariable long employeeId){
        return new ResponseEntity<>(employeeService.findTasksByEmployeeId( employeeId), HttpStatus.OK);
    }

    @GetMapping("overloaded")
    public ResponseEntity<List<Employee>> getOverloadedEmployees(){
        return new ResponseEntity<>(overloadedService.findOverloadedEmployeesPerManager(), HttpStatus.OK);
    }






}
