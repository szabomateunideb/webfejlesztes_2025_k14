package hu.unideb.inf.autokolcsonzo.service.mapper;

import hu.unideb.inf.autokolcsonzo.data.entity.FelhasznaloEntity;
import hu.unideb.inf.autokolcsonzo.service.dto.RegisztracioDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FelhasznaloMapper {

    RegisztracioDto reg(FelhasznaloEntity felhasznalo);

    FelhasznaloEntity regFelh(RegisztracioDto regisztracio);
}
