package hu.unideb.inf.autokolcsonzo.service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class RegisztracioDto {
    @NotBlank(message = "Ne legyen üres")
    @Size(min = 5, max = 100, message = "Legyen 5 és 100 között!")
    private String felhasznaloNev;
    private String nev;
    @Past
    private Date szuletesiDatum;
    @NotBlank
    @Size(min = 8, max = 200)
    private String jelszo;
}
