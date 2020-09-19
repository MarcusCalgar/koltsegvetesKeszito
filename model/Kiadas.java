package pkg43_koltsegvetes.model;

import java.time.LocalDate;
import pkg43_koltsegvetes.exception.KoltsegvetesException;

public class Kiadas extends Tranzakcio {

    private String kategoria;
    private String kiadasHely;

    public Kiadas() {
    }

    public Kiadas(Integer id, LocalDate datum, String megnevezes, Penztarca erintettPenztarca, String kategoria, String kiadasHely, int osszeg) {
        super(id, datum, megnevezes, erintettPenztarca, osszeg);
        this.kategoria = kategoria;
        this.kiadasHely = kiadasHely;
    }

    public void setKategoria(String kategoria) {
        this.kategoria = kategoria;
    }

    public String getKategoria() {
        return kategoria;
    }

    public void setKiadasHely(String kiadasHely) {
        this.kiadasHely = kiadasHely;
    }

    public String getKiadasHely() {
        return kiadasHely;
    }

    public void kategoriaEllenorzo(String nev) throws KoltsegvetesException {
        if (!nev.matches("[a-zA-Z0-9 _áéíóöőúűÁÉÍÓÖŐÜŰ]+")) {
            throw new KoltsegvetesException("Kategória megadása kötelező. \n A kategória csak betűket, számokat, szóközt, és alulvonás jelet tartalmazhat!");
        }
    }

    public void kiadasHelyEllenorzo(String nev) throws KoltsegvetesException {
        if (!nev.matches("[a-zA-Z0-9 _áéíóöőúűÁÉÍÓÖŐÜŰ]+")) {
            throw new KoltsegvetesException("Kiadás helyének megadása kötelező. \n A kiadás helye csak betűket, számokat, szóközt, és alulvonás jelet tartalmazhat!");
        }
    }
}
