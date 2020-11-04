package com.app.tobeprecise.services;

import com.app.tobeprecise.entities.Employee;
import com.app.tobeprecise.interfaces.IOverloadedService;
import com.app.tobeprecise.repos.EmployeeRepository;
import com.app.tobeprecise.repos.TaskRepository;
import com.app.tobeprecise.utils.MathUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.*;

@Service
public class OverloadedEmployeesImpl implements IOverloadedService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private EmployeeRepository employeeRepository;



    @Override
    public List<Employee> findOverloadedEmployeesPerManager() {
        double[] tasksPerEmployee1 = StreamSupport.stream(employeeRepository.findAll().spliterator(), false)
                .map(task -> Double.valueOf(Long.toString(task.getTasks().size())))
                .mapToDouble(Double::doubleValue).toArray();
        double average = Arrays.stream(tasksPerEmployee1).average().getAsDouble();
        double standardDeviation = MathUtils.calculateStandardDeviation(tasksPerEmployee1);
        double overload = average + standardDeviation;
        return StreamSupport.stream(employeeRepository.findAll().spliterator(), false)
                .filter(employee -> employee.getTasks().size() > overload)
                .collect(Collectors.toList());
    }





}
