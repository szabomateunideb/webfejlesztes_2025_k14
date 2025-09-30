package hu.unideb.inf.autokolcsonzo.data.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "Users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FelhasznaloEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "name", nullable = false)
    private String nev;
    @Column(name = "date_of_birth")
    private Date szuletesiDatum;
    @Column(name = "username")
    private String felhasznaloNev;
    @Column(name = "password")
    private String jelszo;
    @Column(name = "driversLicence")
    private String jogositvanySzam;
}
