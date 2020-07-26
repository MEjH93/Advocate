package com.softwarenation.api.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaskDtoresponse {
    private Long idTask;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate datum;
    private Integer utrosenoVreme;
    private String opis;
}