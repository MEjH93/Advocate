package com.softwarenation.service;

import com.softwarenation.api.dto.AdvokatDtoRequest;
import com.softwarenation.api.dto.AdvokatDtoResponse;
import com.softwarenation.api.dto.TaskDtoresponse;

import java.util.List;

public interface AdvokatServis {
    AdvokatDtoResponse saveAdvokat(AdvokatDtoRequest advokatDtoRequest);

    List<AdvokatDtoResponse> getAllAdvokati();

    List<TaskDtoresponse> getAllTask(Long idAdvokat);

    // AdvokatDtoResponse deleteAdvokat(AdvokatDtoRequest advokatDtoRequest);
}

