package naderdeghaili.u5w1d5wp.repositories;

import naderdeghaili.u5w1d5wp.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UtenteRepository extends JpaRepository<Utente, Long> {

    List<Utente> findByNomeCognome(String nomeCognome);

    boolean existsByEmail(String email);

    Optional<Utente> findByEmail(String email);


}
