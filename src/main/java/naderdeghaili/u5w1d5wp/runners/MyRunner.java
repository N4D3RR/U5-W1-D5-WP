package naderdeghaili.u5w1d5wp.runners;


import lombok.extern.slf4j.Slf4j;
import naderdeghaili.u5w1d5wp.entities.PostazioneTipo;
import naderdeghaili.u5w1d5wp.exceptions.ValidationException;
import naderdeghaili.u5w1d5wp.services.EdificioService;
import naderdeghaili.u5w1d5wp.services.PostazioneService;
import naderdeghaili.u5w1d5wp.services.PrenotazioneService;
import naderdeghaili.u5w1d5wp.services.UtenteService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Slf4j
public class MyRunner implements CommandLineRunner {

    private final UtenteService us;
    private final PrenotazioneService ps;
    private final PostazioneService pos;
    private final EdificioService es;

    public MyRunner(UtenteService us, PrenotazioneService ps, PostazioneService pos, EdificioService es) {
        this.us = us;
        this.ps = ps;
        this.pos = pos;
        this.es = es;
    }

    @Override
    public void run(String... args) throws Exception {

//        Edificio e1 = new Edificio("Studio", "Via Studio", "Padova");
//        Edificio e2 = new Edificio("Coworking", "Via Coworking", "Milano");
//        Edificio e3 = new Edificio("Ufficio", "Via Ufficio", "Cagliari");
//
//        es.saveEdificio(e1);
//        es.saveEdificio(e2);
//        es.saveEdificio(e3);
//
//        Postazione p1 = new Postazione(e1, 2, PostazioneTipo.OPENSPACE, "openspace");
//        Postazione p2 = new Postazione(e2, 4, PostazioneTipo.OPENSPACE, "openspace coworking");
//        Postazione p3 = new Postazione(e3, 1, PostazioneTipo.PRIVATO, "ufficio privato");
//
//        pos.savePostazione(p1);
//        pos.savePostazione(p2);
//        pos.savePostazione(p3);
//
//        Utente u1 = new Utente("giangiorgio", "Giangiorgio Giorgio", "gian@giorgio.it");
//        Utente u2 = new Utente("mario", "Mario Rossi", "mario@rossi.it");
//        Utente u3 = new Utente("dan", "Dan n", "dan@n.it");
//
//        us.saveUtente(u1);
//        us.saveUtente(u2);
//        us.saveUtente(u3);

//        ps.savePrenotazione(1L, 1L, LocalDate.now());
//        ps.savePrenotazione(2L, 2L, LocalDate.now());
//        ps.savePrenotazione(1L, 3L, LocalDate.now().plusDays(1));


        //ricerca per tipo postazione e città
        log.info(pos.getByTipoAndCitta(PostazioneTipo.OPENSPACE, "Padova").toString());


        //verifica prenotazione stesso giorno stesso utente
        try {
            ps.savePrenotazione(1L, 3L, LocalDate.now());
        } catch (ValidationException ex) {
            log.error(ex.getMessage());

        }


        //verifica prenotazione stessa postazione
        try {
            ps.savePrenotazione(2L, 3L, LocalDate.now().plusDays(1));
        } catch (ValidationException ex) {
            log.error(ex.getMessage());
        }


    }
}
