package test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import test.model.Menu;
import test.model.MenuTmp;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface MenuTmpRepository extends JpaRepository<MenuTmp, Long> {

    @Transactional
    Boolean existsById(String code);


}