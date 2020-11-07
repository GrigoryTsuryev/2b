package com.app.tobeprecise.dtos;

import com.app.tobeprecise.entities.Employee;
import com.app.tobeprecise.entities.Manager;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class EmployeeManagerDTO {

    private Manager manager;
    private Employee employee;

    public EmployeeManagerDTO(Manager manager, Employee employee) {
        this.manager = manager;
        this.employee = employee;
    }
}
