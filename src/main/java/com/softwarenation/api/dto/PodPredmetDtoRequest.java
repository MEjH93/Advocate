package com.softwarenation.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PodPredmetDtoRequest {
    private String naziv_podpredmeta;
    private String sifra_podpredmeta;
}
