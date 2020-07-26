package com.softwarenation.mapper;

import com.softwarenation.api.dto.KlijnetDtoResonse;
import com.softwarenation.domen.Klijent;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

//@Mapper
public interface KlinentMapper1 {
    KlinentMapper1 INSTANCE = Mappers.getMapper(KlinentMapper1.class);
    Klijent toKlijent(KlijnetDtoResonse klijnetDtoResonse);
}
