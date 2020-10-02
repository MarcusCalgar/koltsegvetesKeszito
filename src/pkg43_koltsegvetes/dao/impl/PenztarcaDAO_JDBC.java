package pkg43_koltsegvetes.dao.impl;

import pkg43_koltsegvetes.dao.KoltsegvetesDAO_JDBC;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import pkg43_koltsegvetes.exception.KoltsegvetesException;
import pkg43_koltsegvetes.model.Penztarca;

/**
 * Ez az osztály felelős azért, hogy a felhasználó által módosított pénztárcák
 * az adatbázisba kerüljenek. Az osztály a KoltsegvetesDAO_JDBC absztrakt
 * osztályt valósítja meg.
 */
public class PenztarcaDAO_JDBC extends KoltsegvetesDAO_JDBC<Penztarca> {

    /**
     * Az osztály konstruktora. Beállítja a lekérdezésekért felelős
     * utasításokat.
     *
     * @param kapcsolat az adatbáziskapcsolatért felelős objektum
     * @throws pkg43_koltsegvetes.exception.KoltsegvetesException hiba esetén
     * KoltsegvetesException-t dob.
     */
    public PenztarcaDAO_JDBC(Connection kapcsolat) throws KoltsegvetesException {
        try {
            this.osszesBetolt = kapcsolat.prepareStatement("SELECT * FROM koltsegvetes.penztarcak");
            this.beilleszt = kapcsolat.prepareStatement("INSERT INTO koltsegvetes.penztarcak (nev, tipus, osszeg) VALUES (?,?,?)");
            this.felulir = kapcsolat.prepareStatement("UPDATE koltsegvetes.penztarcak SET nev = ?, tipus = ?, osszeg = ? WHERE id = ?");
        } catch (SQLException ex) {
            throw new KoltsegvetesException(ex.getMessage());
        }
    }

    @Override
    public Penztarca peldanyKeszit(ResultSet rs) throws KoltsegvetesException {
        try {
            Penztarca penztarca = new Penztarca();
            penztarca.setId(rs.getInt("id"));
            penztarca.setNev(rs.getString("nev"));
            penztarca.setTipus(rs.getString("tipus"));
            penztarca.setOsszeg(rs.getInt("osszeg"));
            return penztarca;
        } catch (SQLException | NullPointerException ex) {
            throw new KoltsegvetesException(ex.getMessage());
        }
    }

    @Override
    public void elemBeilleszt(Penztarca tarca) throws KoltsegvetesException {
        try {
            this.beilleszt.setString(1, tarca.getNev());
            this.beilleszt.setString(2, tarca.getTipus());
            this.beilleszt.setInt(3, tarca.getOsszeg());
            this.beilleszt.executeUpdate();
        } catch (SQLException ex) {
            throw new KoltsegvetesException(ex.getMessage());
        }
    }

    @Override
    public void elemFelulir(Penztarca tarca) throws KoltsegvetesException {
        try {
            this.felulir.setString(1, tarca.getNev());
            this.felulir.setString(2, tarca.getTipus());
            this.felulir.setInt(3, tarca.getOsszeg());
            this.felulir.setInt(4, tarca.getId());
            this.felulir.executeUpdate();
        } catch (SQLException ex) {
            throw new KoltsegvetesException(ex.getMessage());
        }
    }
}
