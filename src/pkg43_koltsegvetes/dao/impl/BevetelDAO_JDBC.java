package pkg43_koltsegvetes.dao.impl;

import pkg43_koltsegvetes.dao.KoltsegvetesDAO_JDBC;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import pkg43_koltsegvetes.exception.KoltsegvetesException;
import pkg43_koltsegvetes.model.Bevetel;
import pkg43_koltsegvetes.model.Penztarca;

public class BevetelDAO_JDBC extends KoltsegvetesDAO_JDBC<Bevetel> {

    /**
     * Az osztály konstruktora. Beállítja a lekérdezésekért felelős
     * utasításokat.
     *
     * @param kapcsolat az adatbáziskapcsolatért felelős objektum
     * @param penztarcaLista a program által használt pénztárcák listája
     * @throws pkg43_koltsegvetes.exception.KoltsegvetesException hiba esetén
     * KoltsegvetesException-t dob.
     */
    public BevetelDAO_JDBC(Connection kapcsolat, List<Penztarca> penztarcaLista) throws KoltsegvetesException {
        try {
            this.penztarcaLista = penztarcaLista;
            this.osszesBetolt = kapcsolat.prepareStatement("SELECT * FROM koltsegvetes_test.bevetelek");
            this.beilleszt = kapcsolat.prepareStatement("INSERT INTO koltsegvetes_test.bevetelek (datum, erintettPenztarca, megnevezes, osszeg) VALUES (?,?,?,?)");
            this.felulir = kapcsolat.prepareStatement("UPDATE koltsegvetes_test.bevetelek SET datum = ?, erintettPenztarca = ?, megnevezes = ?, osszeg = ? WHERE id = ?");
            this.torol = kapcsolat.prepareStatement("DELETE FROM koltsegvetes_test.bevetelek WHERE id=?");
        } catch (SQLException ex) {
            throw new KoltsegvetesException(ex.getMessage());
        }
    }

    @Override
    public Bevetel peldanyKeszit(ResultSet rs) throws KoltsegvetesException {
        try {
            Bevetel bevetel = new Bevetel();
            bevetel.setId(rs.getInt("id"));
            bevetel.setDatum(rs.getDate("datum").toLocalDate());
            bevetel.setErintettPenztarca(penztarcaKeres(rs.getString("erintettPenztarca")));
            bevetel.setMegnevezes(rs.getString("megnevezes"));
            bevetel.setOsszeg(rs.getInt("osszeg"));
            return bevetel;
        } catch (SQLException | NullPointerException ex) {
            throw new KoltsegvetesException(ex.getMessage());
        }
    }

    @Override
    public void elemBeilleszt(Bevetel bevetel) throws KoltsegvetesException {
        try {
            this.beilleszt.setObject(1, bevetel.getDatum());
            this.beilleszt.setString(2, bevetel.getErintettPenztarca().getNev());
            this.beilleszt.setString(3, bevetel.getMegnevezes());
            this.beilleszt.setInt(4, bevetel.getOsszeg());
            this.beilleszt.executeUpdate();
        } catch (SQLException ex) {
            throw new KoltsegvetesException(ex.getMessage());
        }
    }

    @Override
    public void elemFelulir(Bevetel bevetel) throws KoltsegvetesException {
        try {
            this.felulir.setObject(1, bevetel.getDatum());
            this.felulir.setString(2, bevetel.getErintettPenztarca().getNev());
            this.felulir.setString(3, bevetel.getMegnevezes());
            this.felulir.setInt(4, bevetel.getOsszeg());
            this.felulir.setInt(5, bevetel.getId());
            this.felulir.executeUpdate();
        } catch (SQLException ex) {
            throw new KoltsegvetesException(ex.getMessage());
        }
    }
}
