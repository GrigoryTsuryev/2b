package com.app.tobeprecise.services;


import com.app.tobeprecise.dtos.EmployeeDTO;
import com.app.tobeprecise.dtos.EmployeeManagerDTO;
import com.app.tobeprecise.dtos.ReportDTO;
import com.app.tobeprecise.dtos.TaskDTO;
import com.app.tobeprecise.entities.*;
import com.app.tobeprecise.exeptions.EmployeeNotFoundException;
import com.app.tobeprecise.exeptions.ManagerNotFoundException;
import com.app.tobeprecise.interfaces.IEmployeeService;
import com.app.tobeprecise.repos.*;
import com.app.tobeprecise.utils.MathUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ReportRepository reportRepository;

    @Autowired
    private ManagerRepository managerRepository;

    @Autowired
    private TaskRepository taskRepository;


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
        List<Task> tasks = taskRepository.findTaskByEmployeeId(employeeId);
        return tasks.stream().map(task -> new TaskDTO(task.getText(), task.getAssignDate(), task.getDueDate()))
                .collect(Collectors.toList());
    }

    @Override
    public List<EmployeeManagerDTO> findOverloadedEmployeesPerManager() {
        List<Long> amountOfTasksPerEmployee = taskRepository.findAmountOfTasksByEmployees();
        double overload = MathUtils.calculateOverload(amountOfTasksPerEmployee.stream().mapToDouble(Long::doubleValue).toArray());
        List<Employee> employees = employeeRepository.findOverloadedEmployees((int)Math.abs(overload));
        return employees.stream().map(employee -> new EmployeeManagerDTO(employee.getManager(), employee))
                .collect(Collectors.toList());

    }

}
