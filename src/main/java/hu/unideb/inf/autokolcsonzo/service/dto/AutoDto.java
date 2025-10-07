package hu.unideb.inf.autokolcsonzo.service.dto;

import jakarta.persistence.Column;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class AutoDto {
    private Long id;
    private String gyartmany;
    private String modell;
    private Date evjarat;
    private String uzemanyag;
    private String szin;
    private String klima;
    private String leiras;
}
