package com.app.tobeprecise.repos;

import com.app.tobeprecise.entities.Employee;
import com.app.tobeprecise.entities.Task;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TaskRepository extends CrudRepository<Task, Long> {

    @Query("SELECT t FROM Task t WHERE t.employee.employeeId = :employeeId")
    List<Task> findTaskByEmployeeId(long employeeId);

    @Query("SELECT COUNT(taskId) FROM Task t GROUP BY t.employee")
    List<Long> findAmountOfTasksByEmployees();

}
