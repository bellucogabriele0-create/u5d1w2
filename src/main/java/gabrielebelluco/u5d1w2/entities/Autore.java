package gabrielebelluco.u5d1w2.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Random;

@Getter
@Setter
@ToString
public class Autore {
    private long id;
    private String nome;
    private String cognome;
    private String email;
    private LocalDate dataDiNascita;

    public Autore(String nome, String cognome, LocalDate dataDiNascita, String email) {
        this.nome = nome;
        this.cognome = cognome;
        this.dataDiNascita = dataDiNascita;
        this.email = email;
        Random rndm = new Random();
        this.id = rndm.nextInt(1, 100);
    }
}
