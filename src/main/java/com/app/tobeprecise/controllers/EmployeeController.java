package com.app.tobeprecise.controllers;


import com.app.tobeprecise.dtos.EmployeeDTO;
import com.app.tobeprecise.dtos.EmployeeManagerDTO;
import com.app.tobeprecise.dtos.ReportDTO;
import com.app.tobeprecise.dtos.TaskDTO;
import com.app.tobeprecise.entities.Employee;
import com.app.tobeprecise.entities.Report;
import com.app.tobeprecise.interfaces.IEmployeeService;
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

    @PostMapping("save")
    public ResponseEntity<EmployeeDTO> save(@RequestBody Employee employee){
        return new ResponseEntity<>(employeeService.save(employee), HttpStatus.CREATED);
    }

    @PostMapping("{employeeId}/report")
    public ResponseEntity<ReportDTO> createReport(@RequestBody Report report, @PathVariable long employeeId){
        return new ResponseEntity<>(employeeService.createReport(employeeId, report), HttpStatus.CREATED);
    }

    @PostMapping("relationship/assign")
    public ResponseEntity<EmployeeManagerDTO> assign(@RequestParam long managerId, @RequestParam long employeeId){
        return new ResponseEntity<>(employeeService.assignEmployeeToManager(managerId, employeeId), HttpStatus.OK);
    }

    @GetMapping("{employeeId}/tasks")
    public ResponseEntity<List<TaskDTO>> getTasksByEmployeeId(@PathVariable long employeeId){
        return new ResponseEntity<>(employeeService.findTasksByEmployeeId( employeeId), HttpStatus.OK);
    }

    @GetMapping("overloaded")
    public ResponseEntity<List<EmployeeManagerDTO>> getOverloadedEmployees(){
        return new ResponseEntity<>(employeeService.findOverloadedEmployeesPerManager(), HttpStatus.OK);
    }






}
