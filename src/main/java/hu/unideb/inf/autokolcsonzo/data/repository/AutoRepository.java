package hu.unideb.inf.autokolcsonzo.data.repository;

import hu.unideb.inf.autokolcsonzo.data.entity.AutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface AutoRepository
        extends JpaRepository<AutoEntity, Long> {

    AutoEntity getByRendszam(String rendszam);

    @Modifying
    @Transactional
    @Query("DELETE From AutoEntity c where lower(c.gyartmany) = lower(:gyartmany)")
    void deleteByGyartmany(String gyartmany);
}
