package com.softwarenation.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AdvokatDtoResponse {
    private Long idAdvokata;
    private String imeAdvokata;
    private String prezimeAdvokata;
}
