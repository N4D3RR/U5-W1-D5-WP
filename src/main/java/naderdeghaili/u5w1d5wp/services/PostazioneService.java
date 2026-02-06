package naderdeghaili.u5w1d5wp.services;

import lombok.extern.slf4j.Slf4j;
import naderdeghaili.u5w1d5wp.entities.Postazione;
import naderdeghaili.u5w1d5wp.entities.PostazioneTipo;
import naderdeghaili.u5w1d5wp.exceptions.NotFoundException;
import naderdeghaili.u5w1d5wp.exceptions.ValidationException;
import naderdeghaili.u5w1d5wp.repositories.PostazioneRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PostazioneService {

    private final PostazioneRepository por;

    public PostazioneService(PostazioneRepository por) {
        this.por = por;
    }

    public void savePostazione(Postazione newPostazione) {
        if (newPostazione.getEdificio() == null) throw new ValidationException("L'edificio è obbligatorio");
        if (newPostazione.getTipo() == null) throw new ValidationException("Il tipo di postazione è obbligatorio");
        if (newPostazione.getOccupantiMassimi() < 1)
            throw new ValidationException("La postazione deve avere almeno un posto");
        por.save(newPostazione);
        log.info("Postazione con id: " + newPostazione.getId() + " salvata");
    }

    public Postazione findById(Long id) {
        return por.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public List<Postazione> findAll() {
        return por.findAll();
    }

    public List<Postazione> getByTipoAndCitta(PostazioneTipo tipo, String citta) {
        return por.findByTipoAndEdificioCitta(tipo, citta);
    }
}
