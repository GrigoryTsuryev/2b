package com.app.tobeprecise.interfaces;


import com.app.tobeprecise.dtos.EmployeeManagerDTO;

public interface IRelationshipManagementService {

    EmployeeManagerDTO assignEmployeeToManager(long managerId, long employeeId);

}
