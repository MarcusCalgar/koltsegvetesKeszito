package pkg43_koltsegvetes.model;

import java.time.LocalDate;

public class Bevetel extends Tranzakcio {

    public Bevetel() {
    }

    public Bevetel(Integer id, LocalDate datum, String megnevezes, Penztarca erintettPenztarca, int osszeg) {
        super(id, datum, megnevezes, erintettPenztarca, osszeg);
    }
}
