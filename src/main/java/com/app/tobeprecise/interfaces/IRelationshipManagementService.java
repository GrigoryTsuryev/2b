package com.app.tobeprecise.interfaces;


import com.app.tobeprecise.entities.Employee;

public interface IRelationshipManagementService {

    Employee assignEmployeeToManager(long managerId, long employeeId);

}
