package naderdeghaili.u5w1d5wp.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(Long id) {
        super("La risorsa con id: " + id + " non esiste");
    }
}
