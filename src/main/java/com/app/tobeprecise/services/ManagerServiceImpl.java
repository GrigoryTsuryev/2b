package com.app.tobeprecise.services;

import com.app.tobeprecise.dtos.ManagerDTO;
import com.app.tobeprecise.dtos.ReportDTO;
import com.app.tobeprecise.dtos.TaskDTO;
import com.app.tobeprecise.entities.Employee;
import com.app.tobeprecise.entities.Manager;
import com.app.tobeprecise.entities.Task;
import com.app.tobeprecise.exeptions.ManagerNotFoundException;
import com.app.tobeprecise.interfaces.IManagerService;
import com.app.tobeprecise.repos.EmployeeRepository;
import com.app.tobeprecise.repos.ManagerRepository;
import com.app.tobeprecise.repos.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ManagerServiceImpl  implements  IManagerService {

    @Autowired
    private ManagerRepository managerRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private TaskRepository taskRepository;

    @Override
    public ManagerDTO save(Manager m) {
        Manager saved = managerRepository.save(m);
        return new ManagerDTO(saved.getFirstName(), saved.getLastName());
    }

    @Override
    public List<ReportDTO> findReportsByManager(long managerId) {
        Manager manager = managerRepository.findById(managerId).orElseThrow(ManagerNotFoundException::new);
        return manager.getEmployees().stream()
                .map(Employee::getReports)
                .flatMap(List::stream)
                .map(report -> new ReportDTO(report.getText(), report.getDate()))
                .collect(Collectors.toList());
    }

    @Override
    public TaskDTO createTask(long managerId, long employeeId, Task task) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(ManagerNotFoundException::new);
        if(employee.getManager().getManagerId() != managerId)
            throw new IllegalArgumentException("Manager is not assigned for this Employee");
        if(task.getAssignDate().compareTo(task.getDueDate()) > 0){
            throw new IllegalArgumentException("Assign date cant be bigger then due date");
        }
        task.setEmployee(employee);
        Task savedTask = taskRepository.save(task);
        return new TaskDTO(savedTask.getText(), savedTask.getAssignDate(), savedTask.getDueDate());
    }
}
