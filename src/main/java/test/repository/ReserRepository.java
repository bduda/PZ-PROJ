package test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import test.model.Menu;
import test.model.Reser;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ReserRepository extends JpaRepository<Reser, Long> {

    @Transactional
    Boolean existsById(long id);

}