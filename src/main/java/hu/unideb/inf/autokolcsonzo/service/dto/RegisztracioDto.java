package hu.unideb.inf.autokolcsonzo.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class RegisztracioDto {
    private String felhasznaloNev;
    private String nev;
    private Date szuletesiDatum;
    private String jelszo;
}
