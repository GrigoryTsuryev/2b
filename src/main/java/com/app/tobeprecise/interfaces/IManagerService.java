package com.app.tobeprecise.interfaces;

import com.app.tobeprecise.entities.Manager;
import com.app.tobeprecise.entities.Report;

import java.util.List;

public interface IManagerService {
    Manager save(Manager m);

    List<Report> findReportsByManager(long managerId);

}
