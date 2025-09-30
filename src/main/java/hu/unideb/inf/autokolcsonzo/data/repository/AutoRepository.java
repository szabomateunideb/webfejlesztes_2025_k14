package hu.unideb.inf.autokolcsonzo.data.repository;

import hu.unideb.inf.autokolcsonzo.data.entity.AutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutoRepository
        extends JpaRepository<AutoEntity, Long> {
}
