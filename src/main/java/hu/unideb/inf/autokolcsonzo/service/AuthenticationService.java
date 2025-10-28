package hu.unideb.inf.autokolcsonzo.service;

import hu.unideb.inf.autokolcsonzo.service.dto.BejelentkezesDto;
import hu.unideb.inf.autokolcsonzo.service.dto.RegisztracioDto;

public interface AuthenticationService {

    public void regisztracio(RegisztracioDto regisztracioDto);
    public void bejelentkezes(BejelentkezesDto bejelentkezesDto);
}
