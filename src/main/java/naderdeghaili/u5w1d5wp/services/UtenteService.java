package naderdeghaili.u5w1d5wp.services;


import lombok.extern.slf4j.Slf4j;
import naderdeghaili.u5w1d5wp.entities.Utente;
import naderdeghaili.u5w1d5wp.exceptions.NotFoundException;
import naderdeghaili.u5w1d5wp.exceptions.ValidationException;
import naderdeghaili.u5w1d5wp.repositories.UtenteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UtenteService {

    private final UtenteRepository ur;

    public UtenteService(UtenteRepository ur) {
        this.ur = ur;
    }

    public void saveUtente(Utente newUtente) {
        if (ur.existsByEmail(newUtente.getEmail()))
            throw new ValidationException("Email: " + newUtente.getEmail() + "già esistente");
        if (newUtente.getNomeCognome().length() < 4)
            throw new ValidationException("Nome e cognome devono avere almeno 4 caratteri");
        this.ur.save(newUtente);
        log.info("L'utente: " + newUtente.getNomeCognome() + " è  stato salvato con la mail: " + newUtente.getEmail() + " e username: " + newUtente.getUsername());
    }

    public List<Utente> findAll() {
        return ur.findAll();
    }

    public Utente findById(Long utenteId) {
        return ur.findById(utenteId).orElseThrow(() -> new NotFoundException(utenteId));
    }
}
