package pkg43_koltsegvetes.model;

import java.time.LocalDate;
import pkg43_koltsegvetes.exception.KoltsegvetesException;

public abstract class Tranzakcio {

    private Integer id;
    private LocalDate datum;
    private Penztarca erintettPenztarca;
    private String megnevezes;
    private int osszeg;

    public Tranzakcio() {
    }

    public Tranzakcio(Integer id, LocalDate datum, String megnevezes, Penztarca erintettPenztarca, int osszeg) throws IllegalArgumentException {
        this.id = id;
        this.datum = datum;
        this.megnevezes = megnevezes;
        this.erintettPenztarca = erintettPenztarca;
        this.osszeg = osszeg;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public void setErintettPenztarca(Penztarca erintettPenztarca) {
        this.erintettPenztarca = erintettPenztarca;
    }

    public Penztarca getErintettPenztarca() {
        return erintettPenztarca;
    }

    public String getMegnevezes() {
        return megnevezes;
    }

    public void setMegnevezes(String megnevezes) {
        this.megnevezes = megnevezes;
    }

    public void setOsszeg(int osszeg) {
        this.osszeg = osszeg;
    }

    public int getOsszeg() {
        return osszeg;
    }

    public void megnevezesEllenorzo(String nev) throws KoltsegvetesException {
        if (!nev.matches("[a-zA-Z0-9 _áéíóúöőüűÁÉÍÓÚÖŐÜŰ]+")) {
            throw new KoltsegvetesException("Megnevezés megadása kötelező.\nA megnevezés csak betűket, számokat, szóközt, és alulvonás jelet tartalmazhat!");
        }        
    }

    public void osszegEllenorzo(String osszeg) throws KoltsegvetesException {
        if (!osszeg.matches("[0-9]+")) {
            throw new KoltsegvetesException("Kérlek adj meg egy összeget.\nA megadott összeg csak egész számokat tartalmazhat!");
        }
    }
}
