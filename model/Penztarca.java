package pkg43_koltsegvetes.model;

import pkg43_koltsegvetes.exception.KoltsegvetesException;

public class Penztarca {

    private Integer id;
    private String nev;
    private String tipus;
    private int osszeg;

    public Penztarca() {
    }

    public Penztarca(Integer id, String nev, String tipus, int osszeg) {
        this.id = id;
        this.nev = nev;
        this.tipus = tipus;
        this.osszeg = osszeg;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public String getNev() {
        return nev;
    }

    public void setTipus(String tipus) {
        this.tipus = tipus;
    }

    public String getTipus() {
        return tipus;
    }

    public void setOsszeg(int osszeg) {
        this.osszeg = osszeg;
    }

    public int getOsszeg() {
        return osszeg;
    }

    public void nevEllenorzo(String nev) throws KoltsegvetesException {
        if (!nev.matches("[a-zA-Z0-9 _áéíóöőúűÁÉÍÓÖŐÜŰ]+")) {
            throw new KoltsegvetesException("Megnevezés megadása kötelező. \n A megnevezés csak betűket, számokat, szóközt, és alulvonás jelet tartalmazhat!");
        }
    }

    public void osszegEllenorzo(String osszeg) throws KoltsegvetesException {
        if (!osszeg.matches("[0-9]+")) {
            throw new KoltsegvetesException("Kérlek adj meg egy összeget.\nA megadott összeg csak egész számokat tartalmazhat!");
        }
    }
}
