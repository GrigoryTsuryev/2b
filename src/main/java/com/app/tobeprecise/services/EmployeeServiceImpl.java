package com.app.tobeprecise.services;


import com.app.tobeprecise.dtos.EmployeeDTO;
import com.app.tobeprecise.dtos.EmployeeManagerDTO;
import com.app.tobeprecise.dtos.ReportDTO;
import com.app.tobeprecise.dtos.TaskDTO;
import com.app.tobeprecise.entities.Employee;
import com.app.tobeprecise.entities.Manager;
import com.app.tobeprecise.entities.Report;
import com.app.tobeprecise.exeptions.EmployeeNotFoundException;
import com.app.tobeprecise.exeptions.ManagerNotFoundException;
import com.app.tobeprecise.interfaces.IEmployeeService;
import com.app.tobeprecise.interfaces.IRelationshipManagementService;
import com.app.tobeprecise.repos.EmployeeRepository;
import com.app.tobeprecise.repos.ManagerRepository;
import com.app.tobeprecise.repos.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements IEmployeeService, IRelationshipManagementService {

    private EmployeeRepository employeeRepository;

    private ReportRepository reportRepository;

    private ManagerRepository managerRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, ReportRepository reportRepository, ManagerRepository managerRepository) {
        this.employeeRepository = employeeRepository;
        this.reportRepository = reportRepository;
        this.managerRepository = managerRepository;
    }

    @Override
    public EmployeeDTO save(Employee e) {
        Employee saved = employeeRepository.save(e);
        return new EmployeeDTO(saved.getFirstName(), saved.getLastName());
    }

    @Override
    public EmployeeManagerDTO assignEmployeeToManager(long managerId, long employeeId){
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(EmployeeNotFoundException::new);
        Manager manager = managerRepository.findById(managerId).orElseThrow(ManagerNotFoundException::new);
        employee.setManager(manager);
        Employee saved = employeeRepository.save(employee);
        return new EmployeeManagerDTO(manager, saved);
    }

    @Override
    public ReportDTO createReport(long id, Report report) {
        Employee employee = employeeRepository.findById(id).orElseThrow(EmployeeNotFoundException::new);
        report.setEmployee(employee);
        Report savedReport = reportRepository.save(report);
        return new ReportDTO(savedReport.getText(),savedReport.getDate());
    }

    @Override
    public List<TaskDTO> findTasksByEmployeeId(long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(EmployeeNotFoundException::new);
        return employee.getTasks().stream()
                .map(task -> new TaskDTO(task.getText(), task.getAssignDate(), task.getDueDate()))
                .collect(Collectors.toList());
    }



}
