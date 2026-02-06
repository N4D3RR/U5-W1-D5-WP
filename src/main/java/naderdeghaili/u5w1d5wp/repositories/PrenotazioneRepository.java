package naderdeghaili.u5w1d5wp.repositories;

import naderdeghaili.u5w1d5wp.entities.Postazione;
import naderdeghaili.u5w1d5wp.entities.Prenotazione;
import naderdeghaili.u5w1d5wp.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long> {

    List<Prenotazione> findByUtenteNomeCognome(String nomeCognome);

    boolean existsByDataAndPostazione(LocalDate data, Postazione postazione);

    boolean existsByUtenteAndData(Utente utente, LocalDate data);
}
