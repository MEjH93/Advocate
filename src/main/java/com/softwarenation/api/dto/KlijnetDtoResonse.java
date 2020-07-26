package com.softwarenation.api.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class KlijnetDtoResonse {
    private Long id_klijent;
    private String naziv_klijenta;

}
