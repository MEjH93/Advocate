package com.softwarenation.api.dto;

import com.softwarenation.domen.Klijent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PredmetDtoRequest {
    private String nazivPredmeta;
    private String sifraPredmeta;
}
