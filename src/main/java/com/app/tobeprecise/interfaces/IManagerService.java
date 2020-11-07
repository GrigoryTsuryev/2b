package com.app.tobeprecise.interfaces;

import com.app.tobeprecise.dtos.ManagerDTO;
import com.app.tobeprecise.dtos.ReportDTO;
import com.app.tobeprecise.dtos.TaskDTO;
import com.app.tobeprecise.entities.Manager;
import com.app.tobeprecise.entities.Task;

import java.util.List;

public interface IManagerService {
    ManagerDTO save(Manager m);

    List<ReportDTO> findReportsByManager(long managerId);


    TaskDTO createTask(long managerId, long id, Task task);
}
