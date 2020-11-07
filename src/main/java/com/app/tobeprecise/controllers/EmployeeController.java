package com.app.tobeprecise.controllers;


import com.app.tobeprecise.dtos.EmployeeDTO;
import com.app.tobeprecise.dtos.EmployeeManagerDTO;
import com.app.tobeprecise.dtos.ReportDTO;
import com.app.tobeprecise.dtos.TaskDTO;
import com.app.tobeprecise.entities.Employee;
import com.app.tobeprecise.entities.Report;
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


    private IEmployeeService employeeService;

    private IRelationshipManagementService relationshipManagementService;

    private IOverloadedService overloadedService;

    @Autowired
    public EmployeeController(IEmployeeService employeeService, IRelationshipManagementService relationshipManagementService, IOverloadedService overloadedService) {
        this.employeeService = employeeService;
        this.relationshipManagementService = relationshipManagementService;
        this.overloadedService = overloadedService;
    }

    @PostMapping(path = "save")
    public ResponseEntity<EmployeeDTO> save(@RequestBody Employee employee){
        return new ResponseEntity<>(employeeService.save(employee), HttpStatus.CREATED);
    }

    @PostMapping("{employeeId}/report")
    public ResponseEntity<ReportDTO> createReport(@RequestBody Report report, @PathVariable long employeeId){
        return new ResponseEntity<>(employeeService.createReport(employeeId, report), HttpStatus.CREATED);
    }

    @PostMapping("relationship/assign")
    public ResponseEntity<EmployeeManagerDTO> assign(@RequestParam long managerId, @RequestParam long employeeId){
        return new ResponseEntity<>(relationshipManagementService.assignEmployeeToManager(managerId, employeeId), HttpStatus.OK);
    }

    @GetMapping("{employeeId}/tasks")
    public ResponseEntity<List<TaskDTO>> getTasksByEmployeeId(@PathVariable long employeeId){
        return new ResponseEntity<>(employeeService.findTasksByEmployeeId( employeeId), HttpStatus.OK);
    }

    @GetMapping("overloaded")
    public ResponseEntity<List<EmployeeManagerDTO>> getOverloadedEmployees(){
        return new ResponseEntity<>(overloadedService.findOverloadedEmployeesPerManager(), HttpStatus.OK);
    }






}
