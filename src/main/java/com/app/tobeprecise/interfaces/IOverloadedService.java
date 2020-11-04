package com.app.tobeprecise.interfaces;

import com.app.tobeprecise.entities.Employee;

import java.util.List;

public interface IOverloadedService {

    List<Employee> findOverloadedEmployeesPerManager();
}
