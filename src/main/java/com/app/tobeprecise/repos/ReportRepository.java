package com.app.tobeprecise.repos;

import com.app.tobeprecise.entities.Manager;
import com.app.tobeprecise.entities.Report;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReportRepository extends CrudRepository<Report, Long> {

    @Query("SELECT r FROM Report r WHERE r.employee.manager.managerId = :managerId")
    List<Report> findReportsByManagerId(long managerId);

}
