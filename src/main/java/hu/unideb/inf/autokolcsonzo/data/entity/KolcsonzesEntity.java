package hu.unideb.inf.autokolcsonzo.data.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "rent")
public class KolcsonzesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "rent_from")
    private Date mettol;
    @Column(name = "rent_to")
    private Date meddig;
    @ManyToOne
    @JoinColumn(name = "felh_id")
    private FelhasznaloEntity felh;
    @ManyToMany
    @JoinTable( name = "car_rent",
            joinColumns = @JoinColumn(name = "rent_id"),
            inverseJoinColumns = @JoinColumn(name = "car_id"))
    private List<AutoEntity> autoKolcsonzesek;


}