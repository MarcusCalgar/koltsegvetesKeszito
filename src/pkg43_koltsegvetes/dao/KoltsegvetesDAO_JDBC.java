package pkg43_koltsegvetes.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pkg43_koltsegvetes.exception.KoltsegvetesException;
import pkg43_koltsegvetes.model.Penztarca;
import pkg43_koltsegvetes.model.Tranzakcio;

public abstract class KoltsegvetesDAO_JDBC<T> implements KoltsegvetesDAO<T> {

    /**
     * Betölti az összes keresett elemet az adatbázisból.
     */
    protected PreparedStatement osszesBetolt;
    /**
     * Új elemet illeszt az adatbázisba.
     */
    protected PreparedStatement beilleszt;
    /**
     * Meglévő elemet módosít az adatbázisban.
     */
    protected PreparedStatement felulir;
    /**
     * Elmenti a megadott elemet az adatbázisba. Valójában vagy a beilleszt,
     * vagy a felulir utasítást hajtja végre.
     */
    protected PreparedStatement elment;
    /**
     * Törli a megadott elemet az adatbázisból.
     */
    protected PreparedStatement torol;
    /**
     * Lezárja az adatbázis kapcsolat elemeit.
     */
    protected PreparedStatement lezar;
    /**
     * A programban szereplő Penztarca objektumok listája.
     */
    protected List<Penztarca> penztarcaLista;

    /**
     * A program által használt elemekből készít egy példányt.
     *
     *
     * @param rs az adatbázisból lekérdezett adatok eredménye
     * @return az elkészített példány
     * @throws pkg43_koltsegvetes.exception.KoltsegvetesException hiba esetén
     * KoltsegvetesException-t dob.
     */
    public abstract T peldanyKeszit(ResultSet rs) throws KoltsegvetesException;

    /**
     * Az adott új elem beillesztését oldja meg.
     *
     * @param elem az adatbázisba írandó új elem.
     * @throws pkg43_koltsegvetes.exception.KoltsegvetesException hiba esetén
     * KoltsegvetesException-t dob.
     */
    public abstract void elemBeilleszt(T elem) throws KoltsegvetesException;

    /**
     * Módosított elem adatbázisba írását oldja meg.
     *
     * @param elem az adatbázisban módosítandó elem
     * @throws pkg43_koltsegvetes.exception.KoltsegvetesException hiba esetén
     * KoltsegvetesException-t dob.
     */
    public abstract void elemFelulir(T elem) throws KoltsegvetesException;

    @Override
    public List<T> osszesBetolt() throws KoltsegvetesException {
        try {
            ResultSet osszes = this.osszesBetolt.executeQuery();
            List<T> ret = listaKeszit(osszes);
            osszes.close();
            return ret;
        } catch (SQLException ex) {
            throw new KoltsegvetesException(ex.getMessage());
        }
    }

    /**
     * Egy lekérdezés eredményéül kapott ResultSet tartalmát egy List-ben adja
     * vissza a további felhasználás céljára.
     *
     * @param rs a lekérdezés eredményét tartalmazó ResultSet objektum
     * @return a ResultSet tartalmát egy List-ben adja vissza
     * @throws pkg43_koltsegvetes.exception.KoltsegvetesException hiba esetén
     * KoltsegvetesException-t dob.
     */
    public List<T> listaKeszit(ResultSet rs) throws KoltsegvetesException {
        try {
            List<T> ret = new ArrayList<>();
            while (rs.next()) {
                ret.add(peldanyKeszit(rs));
            }
            rs.close();
            return ret;
        } catch (SQLException ex) {
            throw new KoltsegvetesException(ex.getMessage());
        }
    }

    /**
     * A Penztarcakat tartalmazó listából kikeresi a megadott nevű Penztarca-t
     * és visszaadja.
     *
     * @param nev a keresett Penztarca neve
     * @return a keresett Penztarca objektum
     */
    public Penztarca penztarcaKeres(String nev) {
        for (Penztarca tarca : penztarcaLista) {
            if (tarca.getNev().equals(nev)) {
                return tarca;
            }
        }
        return null;
    }

    @Override
    public void beilleszt(T elem) throws KoltsegvetesException {
        try {
            elemBeilleszt(elem);
        } catch (KoltsegvetesException ex) {
            throw ex;
        }
    }

    @Override
    public void felulir(T elem) throws KoltsegvetesException {
        try {
            elemFelulir(elem);
        } catch (KoltsegvetesException ex) {
            throw ex;
        }
    }

    @Override
    public void elment(T elem) throws KoltsegvetesException {
        if (elem instanceof Tranzakcio) {
            Tranzakcio tElem = (Tranzakcio) elem;
            if (tElem.getId() == null) {
                beilleszt(elem);
            } else {
                felulir(elem);
            }
        } else {
            Penztarca tarca = (Penztarca) elem;
            if (tarca.getId() == null) {
                beilleszt(elem);
            } else {
                felulir(elem);
            }
        }
    }

    @Override
    public void torol(int id) throws KoltsegvetesException {
        try {
            this.torol.setInt(1, id);
            this.torol.executeUpdate();
        } catch (SQLException ex) {
            throw new KoltsegvetesException(ex.getMessage());
        }
    }

    @Override
    public void lezar() throws KoltsegvetesException {
        try {
           if (osszesBetolt != null) this.osszesBetolt.close();
           if (beilleszt != null) this.beilleszt.close();
           if (felulir != null) this.felulir.close();
           if (elment != null) this.elment.close();
           if (torol != null) this.torol.close();
           if (lezar != null) this.lezar.close();
        } catch (SQLException ex) {
            throw new KoltsegvetesException(ex.getMessage());
        }
    }
}
