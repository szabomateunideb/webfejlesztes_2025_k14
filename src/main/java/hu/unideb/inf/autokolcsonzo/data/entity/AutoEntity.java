package hu.unideb.inf.autokolcsonzo.data.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "car")
public class AutoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "license_plate", unique = true, nullable = false)
    private String rendszam;
    @Column(name = "make")
    private String gyartmany;
    @Column(name = "model")
    private String modell;
    @Column(name = "production_year")
    private Date evjarat;
    @Column(name = "fuel")
    private String uzemanyag;
    @Column(name = "color")
    private String szin;
    @Column(name = "seat_count")
    private Integer ulesek;
    @Column(name = "climate")
    private String klima;
    @Column(name = "description")
    private String leiras;


}