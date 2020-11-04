package com.app.tobeprecise.services;

import com.app.tobeprecise.entities.Employee;
import com.app.tobeprecise.entities.Manager;
import com.app.tobeprecise.entities.Report;
import com.app.tobeprecise.entities.Task;
import com.app.tobeprecise.interfaces.IManagerService;
import com.app.tobeprecise.interfaces.ITaskService;
import com.app.tobeprecise.repos.EmployeeRepository;
import com.app.tobeprecise.repos.ManagerRepository;
import com.app.tobeprecise.repos.ReportRepository;
import com.app.tobeprecise.repos.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ManagerServiceImpl  implements  IManagerService, ITaskService {

    @Autowired
    private ManagerRepository managerRepository;

    @Autowired
    private ReportRepository reportRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Manager save(Manager m) {
            return managerRepository.save(m);
    }

    @Override
    public List<Report> findReportsByManager(long managerId) {

        Manager manager = managerRepository.findById(managerId).get();
        if (manager == null)
            throw new IllegalArgumentException("Manager doest exist");
        List<Long> employeeIds = manager.getEmployees()
                .stream().map(Employee::getEmployeeId).collect(Collectors.toList());
        List<Employee> employees = employeeRepository.findByEmployeeIdIn(employeeIds);
        return employees
                .stream()
                .map(Employee::getReports)
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    @Override
    public Task createTask(long managerId, long employeeId, Task task) {
        Employee employee = employeeRepository.findById(employeeId).get();
        if (employee == null) throw new IllegalArgumentException("Employee with Id " + employeeId + " doesn't exist");
        if(employee.getManager().getManagerId() != managerId)
            throw new IllegalArgumentException("Manager is not assigned for this Employee");
        if(task.getAssignDate().compareTo(task.getDueDate()) > 0){
            throw new IllegalArgumentException("Assign date cant be bigger then due date");
        }
        task.setEmployee(employee);
        return taskRepository.save(task);

    }


}
