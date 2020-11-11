package com.app.tobeprecise.repos;

import com.app.tobeprecise.entities.Employee;
import com.app.tobeprecise.entities.Task;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {


    @Query("select e from Employee e where size(e.tasks)> :overload ")
    List<Employee> findOverloadedEmployees(int overload);
}
