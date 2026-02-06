package naderdeghaili.u5w1d5wp.repositories;

import naderdeghaili.u5w1d5wp.entities.Edificio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EdificioRepository extends JpaRepository<Edificio, Long> {


}
