package com.app.tobeprecise.interfaces;


import com.app.tobeprecise.entities.Employee;
import com.app.tobeprecise.entities.Report;
import com.app.tobeprecise.entities.Task;

import java.util.List;

public interface IEmployeeService {

    Employee save(Employee e);

    Report createReport(long id, Report report);

    List<Task> findTasksByEmployeeId(long employeeId);



}
