package naderdeghaili.u5w1d5wp.repositories;

import naderdeghaili.u5w1d5wp.entities.Postazione;
import naderdeghaili.u5w1d5wp.entities.PostazioneTipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostazioneRepository extends JpaRepository<Postazione, Long> {

    List<Postazione> findByTipoAndEdificioCitta(PostazioneTipo tipo, String citta);
}
