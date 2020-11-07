package com.app.tobeprecise.interfaces;


import com.app.tobeprecise.dtos.EmployeeDTO;
import com.app.tobeprecise.dtos.EmployeeManagerDTO;
import com.app.tobeprecise.dtos.ReportDTO;
import com.app.tobeprecise.dtos.TaskDTO;
import com.app.tobeprecise.entities.Employee;
import com.app.tobeprecise.entities.Report;

import java.util.List;

public interface IEmployeeService {

    EmployeeDTO save(Employee e);

    EmployeeManagerDTO assignEmployeeToManager(long managerId, long employeeId);

    List<EmployeeManagerDTO> findOverloadedEmployeesPerManager();
    List<TaskDTO> findTasksByEmployeeId(long employeeId);
    ReportDTO createReport(long id, Report report);


}
