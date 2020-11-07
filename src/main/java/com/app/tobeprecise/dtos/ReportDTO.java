package com.app.tobeprecise.dtos;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
@ToString
@EqualsAndHashCode
@Getter
@Setter
public class ReportDTO {
    private String text;
    private LocalDate date;

    public ReportDTO(String text, LocalDate date) {
        this.text = text;
        this.date = date;
    }
}
