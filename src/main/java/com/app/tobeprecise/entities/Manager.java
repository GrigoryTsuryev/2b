package com.app.tobeprecise.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Table(name = "managers")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Manager  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long managerId;

    @Column(name = "first_name", nullable = false)
    @NotBlank
    private String firstName;

    @Column(name = "last_name", nullable = false)
    @NotBlank
    private String lastName;

    @OneToMany(mappedBy="manager", cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Employee> employees;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getManagerId() {
        return managerId;
    }
    @JsonIgnore
    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Manager manager = (Manager) o;

        if (managerId != null ? !managerId.equals(manager.managerId) : manager.managerId != null) return false;
        if (firstName != null ? !firstName.equals(manager.firstName) : manager.firstName != null) return false;
        if (lastName != null ? !lastName.equals(manager.lastName) : manager.lastName != null) return false;
        return employees != null ? employees.equals(manager.employees) : manager.employees == null;
    }


    @Override
    public String toString() {
        return "Manager{" +
                "managerId=" + managerId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
