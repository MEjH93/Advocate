package com.softwarenation.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class KlijentDtoTask {
    private List<String> nazivPredmeta;
    private List<String> nazivPodpredmeta;
    private List<String> advokat;
    private List<TaskDtoresponse>taskDtoresponses;
}
