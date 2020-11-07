package com.app.tobeprecise.interfaces;

import com.app.tobeprecise.dtos.TaskDTO;
import com.app.tobeprecise.entities.Task;

public interface ITaskService {

    TaskDTO createTask(long managerId, long id, Task task);

}
