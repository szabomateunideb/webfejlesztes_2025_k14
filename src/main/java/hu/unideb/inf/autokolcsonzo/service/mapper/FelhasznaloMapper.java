package hu.unideb.inf.autokolcsonzo.service.mapper;

import hu.unideb.inf.autokolcsonzo.data.entity.FelhasznaloEntity;
import hu.unideb.inf.autokolcsonzo.service.dto.RegisztracioDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface FelhasznaloMapper {

    RegisztracioDto reg(FelhasznaloEntity felhasznalo);

    @Mapping(target = "jogosultsag", ignore = true)
    @Mapping(target = "jogositvanySzam", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "authorities", ignore = true)
    FelhasznaloEntity regFelh(RegisztracioDto regisztracio);
}
