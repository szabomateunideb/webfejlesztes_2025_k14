package hu.unideb.inf.autokolcsonzo.service.mapper;

import hu.unideb.inf.autokolcsonzo.data.entity.AutoEntity;
import hu.unideb.inf.autokolcsonzo.service.dto.AutoDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AutoMapper {

    AutoDto autoEntityToDto(AutoEntity entity);
    List<AutoDto> autoEntityToDto(List<AutoEntity> entity);
    AutoEntity autoDtoToEntity(AutoDto dto);
    List<AutoEntity> autoDtoToEntity(List<AutoDto> dto);
}
