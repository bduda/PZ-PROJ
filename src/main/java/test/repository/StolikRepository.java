package test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import test.model.Stolik;

import javax.transaction.Transactional;

@Repository
public interface StolikRepository extends JpaRepository<Stolik,Long> {

    @Transactional
    @Modifying
    @Query(value = "UPDATE stolik s set pojemnosc =:pojemnosc, aktywnosc=:aktywnosc,aktyp=:aktyp, akview=:akview, akdsbl=:akdsbl,zajetosc=:zajetosc where s.numer = :numer", nativeQuery = true)
    void updateUser(@Param("pojemnosc") int pojemnosc, @Param("aktywnosc") String aktywnosc, @Param("aktyp") String aktyp, @Param("akview") String akview, @Param("akdsbl") String akdsbl, @Param("zajetosc") String zajetosc, @Param("numer") int numer);
}
