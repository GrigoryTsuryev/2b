package com.app.tobeprecise.services;


import com.app.tobeprecise.entities.Employee;
import com.app.tobeprecise.entities.Manager;
import com.app.tobeprecise.entities.Report;
import com.app.tobeprecise.entities.Task;
import com.app.tobeprecise.interfaces.IEmployeeService;
import com.app.tobeprecise.interfaces.IRelationshipManagementService;
import com.app.tobeprecise.repos.EmployeeRepository;
import com.app.tobeprecise.repos.ManagerRepository;
import com.app.tobeprecise.repos.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements IEmployeeService, IRelationshipManagementService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ReportRepository reportRepository;

    @Autowired
    private ManagerRepository managerRepository;

    @Override
    public Employee save(Employee e) {
        return employeeRepository.save(e);
    }

    @Override
    public Employee assignEmployeeToManager(long managerId, long employeeId){
        Employee employee = employeeRepository.findById(employeeId).get();
        if(employee == null) throw new IllegalArgumentException("Employee with Id " + employeeId + " doesn't exist");
        Manager manager = managerRepository.findById(managerId).get();
        if(manager == null) throw new IllegalArgumentException("Manager with Id " + managerId + " doesn't exist");
        employee.setManager(manager);
        return employeeRepository.save(employee);
    }

    @Override
    public Report createReport(long id, Report report) {
        Employee employee = employeeRepository.findById(id).get();
        if (employee == null) throw new IllegalArgumentException("Employee with Id " + id + " doesn't exist");
        report.setEmployee(employee);
        return reportRepository.save(report);
    }

    @Override
    public List<Task> findTasksByEmployeeId(long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).get();
        if (employee == null) throw new IllegalArgumentException("Employee with Id " + employeeId + " doesn't exist");
        return new ArrayList<>(employee.getTasks());
    }



}
