package hu.unideb.inf.autokolcsonzo.data.repository;

import hu.unideb.inf.autokolcsonzo.data.entity.JogosultsagEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JogosultsagRepository
        extends JpaRepository<JogosultsagEntity, Long> {

    JogosultsagEntity findByNev(String nev);
}
