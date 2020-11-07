package com.app.tobeprecise.services;

import com.app.tobeprecise.dtos.EmployeeManagerDTO;
import com.app.tobeprecise.entities.Employee;
import com.app.tobeprecise.entities.Task;
import com.app.tobeprecise.interfaces.IOverloadedService;
import com.app.tobeprecise.repos.EmployeeRepository;
import com.app.tobeprecise.utils.MathUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class OverloadedEmployeesImpl implements IOverloadedService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public OverloadedEmployeesImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    @Override
    public List<EmployeeManagerDTO> findOverloadedEmployeesPerManager() {
        Map<Employee, List<Task>> tasksPerEmployee = StreamSupport.stream(employeeRepository.findAll().spliterator(), false)
                .filter(employee -> !employee.getTasks().isEmpty())
                .collect(Collectors.toMap(Function.identity(), Employee::getTasks));
        double[] amountOfTasksPerEmployee = tasksPerEmployee
                .values()
                .stream()
                .map(List::size)
                .mapToDouble(Integer::doubleValue)
                .toArray();
        if (amountOfTasksPerEmployee.length == 0) return Collections.emptyList();
        double overload = MathUtils.calculateOverload(amountOfTasksPerEmployee);
        return tasksPerEmployee.entrySet().stream()
                .filter(el->el.getValue().size()>overload)
                .map(Map.Entry::getKey)
                .map(employee -> new EmployeeManagerDTO(employee.getManager(), employee))
                .collect(Collectors.toList());
    }





}
