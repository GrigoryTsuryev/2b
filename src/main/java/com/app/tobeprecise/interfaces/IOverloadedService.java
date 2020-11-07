package com.app.tobeprecise.interfaces;

import com.app.tobeprecise.dtos.EmployeeManagerDTO;

import java.util.List;

public interface IOverloadedService {

    List<EmployeeManagerDTO> findOverloadedEmployeesPerManager();
}
