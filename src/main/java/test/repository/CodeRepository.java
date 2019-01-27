package test.repository;

        import test.model.Code;
        import org.springframework.data.domain.Page;
        import org.springframework.data.domain.Pageable;
        import org.springframework.data.domain.Sort;
        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.stereotype.Repository;

        import javax.transaction.Transactional;
        import java.util.List;
        import java.util.Optional;



@Repository
public interface CodeRepository extends JpaRepository<Code, Long> {

        @Transactional
        Boolean existsByCode(String code);

}