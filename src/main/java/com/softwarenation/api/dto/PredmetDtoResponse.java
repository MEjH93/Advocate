package com.softwarenation.api.dto;

import com.softwarenation.domen.Klijent;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PredmetDtoResponse {
    private Long idPredmet;
    private String nazivPredmeta;
    private String sifraPredmeta;
    private Klijent klijent;
}
