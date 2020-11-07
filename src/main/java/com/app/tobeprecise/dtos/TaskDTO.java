package com.app.tobeprecise.dtos;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@ToString
@EqualsAndHashCode
@Getter
@Setter
public class TaskDTO implements Serializable {
    private String text;
    private LocalDate assignDate;
    private LocalDate dueDate;

    public TaskDTO(String text, LocalDate assignDate, LocalDate dueDate) {
        this.text = text;
        this.assignDate = assignDate;
        this.dueDate = dueDate;
    }

}
