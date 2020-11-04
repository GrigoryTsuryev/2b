package com.app.tobeprecise.interfaces;

import com.app.tobeprecise.entities.Task;

public interface ITaskService {

    Task createTask(long managerId, long id, Task task);

}
