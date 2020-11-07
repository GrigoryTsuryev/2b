package com.app.tobeprecise.dtos;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@Getter
@Setter
public class EmployeeDTO {

    private String firstName;
    private String lastName;

    public EmployeeDTO(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

}
