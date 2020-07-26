package com.softwarenation.api.dto;

import com.softwarenation.domen.Advokat;
import com.softwarenation.domen.Podpredmet;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaskDtorequest {
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate datum;
    private Integer utrosenoVreme;
    private String opis;

}
