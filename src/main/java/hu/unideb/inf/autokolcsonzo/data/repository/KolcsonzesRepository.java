package hu.unideb.inf.autokolcsonzo.data.repository;

import hu.unideb.inf.autokolcsonzo.data.entity.KolcsonzesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KolcsonzesRepository
        extends JpaRepository<KolcsonzesEntity, Long> {
}
