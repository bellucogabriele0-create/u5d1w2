package gabrielebelluco.u5d1w2.services;

import gabrielebelluco.u5d1w2.entities.Autore;
import gabrielebelluco.u5d1w2.exception.NotFoundException;
import gabrielebelluco.u5d1w2.payload.NewAutorePayload;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class AutoreService {
    private List<Autore> autoriDB = new ArrayList<>();


    public List<Autore> findAll() {
        return this.autoriDB;
    }

    public Autore saveAutore(NewAutorePayload payload) {
        Autore newAutore = new Autore(payload.getNome(), payload.getCognome(), payload.getDataDiNascita(), payload.getEmail());
        this.autoriDB.add(newAutore);
        log.info("L'utente " + newAutore.getId() + " è stato aggiunto correttamente");
        return newAutore;
    }

    public Autore findById(long autoreId) {
        Autore found = null;
        for (Autore autore : this.autoriDB) {
            if (autore.getId() == autoreId) found = autore;
        }
        if (found == null) throw new NotFoundException(autoreId);
        return found;
    }

    public Autore findByIdAndUpdate(long autoreId, NewAutorePayload payload) {
        Autore found = null;
        for (Autore autore : this.autoriDB) {
            if (autore.getId() == autoreId) {
                found = autore;
                found.setNome(payload.getNome());
                found.setCognome(payload.getCognome());
                found.setDataDiNascita(payload.getDataDiNascita());
                found.setEmail(payload.getEmail());

            }
        }
        if (found == null) throw new NotFoundException(autoreId);
        return found;
    }

    public void findByIdAndDelete(long autoreId) {
        Autore found = null;
        for (Autore autore : this.autoriDB) {
            if (autore.getId() == autoreId) found = autore;
        }
        if (found == null) throw new NotFoundException(autoreId);
        this.autoriDB.remove(found);
    }
}
