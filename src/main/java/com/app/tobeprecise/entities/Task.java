package com.app.tobeprecise.entities;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Entity
@Table(name = "tasks")
@EqualsAndHashCode
@ToString
public class Task  {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long taskId;

    @Column(name = "text")
    @NotBlank
    private String text;

    @Column(name = "assign_date", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @FutureOrPresent
    private LocalDate assignDate;

    @Column(name = "due_date", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @FutureOrPresent
    private LocalDate dueDate;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    @JsonIgnore
    private Employee employee;

    public Long getTaskId() {
        return taskId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDate getAssignDate() {
        return assignDate;
    }

    public void setAssignDate(LocalDate assignDate) {
        this.assignDate = assignDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

}
