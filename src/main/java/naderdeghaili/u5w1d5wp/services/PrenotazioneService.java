package naderdeghaili.u5w1d5wp.services;


import lombok.extern.slf4j.Slf4j;
import naderdeghaili.u5w1d5wp.entities.Postazione;
import naderdeghaili.u5w1d5wp.entities.Prenotazione;
import naderdeghaili.u5w1d5wp.entities.Utente;
import naderdeghaili.u5w1d5wp.exceptions.NotFoundException;
import naderdeghaili.u5w1d5wp.exceptions.ValidationException;
import naderdeghaili.u5w1d5wp.repositories.PostazioneRepository;
import naderdeghaili.u5w1d5wp.repositories.PrenotazioneRepository;
import naderdeghaili.u5w1d5wp.repositories.UtenteRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@Slf4j
public class PrenotazioneService {
    private final PrenotazioneRepository pr;
    private final UtenteRepository ur;
    private final PostazioneRepository por;

    public PrenotazioneService(PrenotazioneRepository pr, UtenteRepository ur, PostazioneRepository por) {
        this.pr = pr;
        this.ur = ur;
        this.por = por;
    }

    public void savePrenotazione(Long utenteId, Long postazioneId, LocalDate data) {

        Utente utente = ur.findById(utenteId).orElseThrow(() -> new NotFoundException(utenteId));
        Postazione postazione = por.findById(postazioneId).orElseThrow(() -> new NotFoundException(postazioneId));

        if (pr.existsByDataAndPostazione(data, postazione))
            throw new ValidationException("Postazione già prenotata in questa data");
        if (pr.existsByUtenteAndData(utente, data))
            throw new ValidationException("L'utente ha già una prenotazione per questa data");

        Prenotazione prenotazione = new Prenotazione(data, postazione, utente);
        pr.save(prenotazione);

        log.info("Prenotazione salvata per l'utente: " + utente.getNomeCognome() + " | postazione: " + postazione.getId() + " | data: " + data);


    }
}
