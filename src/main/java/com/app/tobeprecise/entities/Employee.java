package com.app.tobeprecise.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "employees")
public class Employee  {


    @Id
    @GeneratedValue
    private Long employeeId;

    @Column(name = "first_name")
    @NotBlank
    private String firstName;

    @Column(name = "last_name")
    @NotBlank
    private String lastName;

    @ManyToOne(cascade = CascadeType.ALL, fetch= FetchType.EAGER)
    @JoinColumn(name = "manager_id")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Manager manager;

    @OneToMany(mappedBy="employee", cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Report> reports;

    @OneToMany(mappedBy="employee", cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Task> tasks;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    @JsonIgnore
    public List<Report> getReports() {
        if (reports == null) reports = new ArrayList<>();
        return reports;
    }

    public void setReports(List<Report> reports) {
        this.reports = reports;
    }
    @JsonIgnore
    public List<Task> getTasks() {
        if (tasks == null) tasks = new ArrayList<>();
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", manager=" + manager +
                ", reports=" + reports +
                ", tasks=" + tasks +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (employeeId != null ? !employeeId.equals(employee.employeeId) : employee.employeeId != null) return false;
        if (firstName != null ? !firstName.equals(employee.firstName) : employee.firstName != null) return false;
        if (lastName != null ? !lastName.equals(employee.lastName) : employee.lastName != null) return false;
        if (manager != null ? !manager.equals(employee.manager) : employee.manager != null) return false;
        if (reports != null ? !reports.equals(employee.reports) : employee.reports != null) return false;
        return tasks != null ? tasks.equals(employee.tasks) : employee.tasks == null;
    }

}
