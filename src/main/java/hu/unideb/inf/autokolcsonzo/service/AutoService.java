package hu.unideb.inf.autokolcsonzo.service;

import hu.unideb.inf.autokolcsonzo.service.dto.AutoDto;

import java.util.List;

public interface AutoService {

    AutoDto getById(Long id);
    AutoDto getByRendszam(String rsz);
    AutoDto removeById(Long id);
    AutoDto updateByRendszam(AutoDto autoDto, String rsz);
    List<AutoDto> getAll();
    AutoDto registerWithRendszam(AutoDto autoDto, String rendszam);
}
