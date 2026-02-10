package gabrielebelluco.u5d1w2.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException(long id) {
        super("l'id : " + id + " non è stato trovato");
    }
}
