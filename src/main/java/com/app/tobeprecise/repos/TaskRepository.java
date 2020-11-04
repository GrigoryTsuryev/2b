package com.app.tobeprecise.repos;

import com.app.tobeprecise.entities.Task;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Task, Long> {

}
