package com.app.tobeprecise.repos;

import com.app.tobeprecise.entities.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {


}
