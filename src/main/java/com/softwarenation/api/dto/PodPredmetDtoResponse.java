package com.softwarenation.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PodPredmetDtoResponse {
    private Long id_podpredmet;
    private String naziv_podpredmeta;
    private String sifra_podpredmeta;
}
