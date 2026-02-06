package naderdeghaili.u5w1d5wp.services;

import lombok.extern.slf4j.Slf4j;
import naderdeghaili.u5w1d5wp.entities.Edificio;
import naderdeghaili.u5w1d5wp.exceptions.NotFoundException;
import naderdeghaili.u5w1d5wp.repositories.EdificioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class EdificioService {

    private final EdificioRepository er;


    public EdificioService(EdificioRepository er) {
        this.er = er;
    }

    public void saveEdificio(Edificio edificio) {
        er.save(edificio);
    }

    public Edificio findById(Long edificioId) {
        return er.findById(edificioId).orElseThrow(() -> new NotFoundException(edificioId));
    }

    public List<Edificio> findAll() {
        return er.findAll();
    }

}
