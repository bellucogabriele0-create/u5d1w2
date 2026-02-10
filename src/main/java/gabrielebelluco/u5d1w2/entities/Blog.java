package gabrielebelluco.u5d1w2.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Random;

@Getter
@Setter
@ToString
public class Blog {
    private long id;
    private String categoria;
    private String titolo;
    private String cover;
    private String contenuto;
    private int tempoDiLettura;

    public Blog(String categoria, String titolo, int tempoDiLettura, String contenuto, String cover) {
        this.categoria = categoria;
        this.titolo = titolo;
        this.tempoDiLettura = tempoDiLettura;
        this.contenuto = contenuto;
        this.cover = cover;
        Random rndm = new Random();
        this.id = rndm.nextInt(1, 100);
    }
}
