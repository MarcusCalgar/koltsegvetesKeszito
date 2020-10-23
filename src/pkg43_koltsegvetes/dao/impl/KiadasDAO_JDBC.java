package pkg43_koltsegvetes.dao.impl;

import pkg43_koltsegvetes.dao.KoltsegvetesDAO_JDBC;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import pkg43_koltsegvetes.exception.KoltsegvetesException;
import pkg43_koltsegvetes.model.Kiadas;
import pkg43_koltsegvetes.model.Penztarca;

public class KiadasDAO_JDBC extends KoltsegvetesDAO_JDBC<Kiadas> {

    /**
     * Az osztály konstruktora. Beállítja a lekérdezésekért felelős
     * utasításokat.
     *
     * @param kapcsolat az adatbáziskapcsolatért felelős objektum
     * @param penztarcaLista a programban használt pénztárcák listája
     * @throws pkg43_koltsegvetes.exception.KoltsegvetesException hiba esetén
     * KoltsegvetesException-t dob.
     */
    public KiadasDAO_JDBC(Connection kapcsolat, List<Penztarca> penztarcaLista) throws KoltsegvetesException {
        try {
            this.penztarcaLista = penztarcaLista;
            this.osszesBetolt = kapcsolat.prepareStatement("SELECT * FROM koltsegvetes.kiadasok");
            this.beilleszt = kapcsolat.prepareStatement("INSERT INTO koltsegvetes.kiadasok (datum, erintettPenztarca, megnevezes, kategoria, kiadasHelye, osszeg) VALUES (?,?,?,?,?,?)");
            this.felulir = kapcsolat.prepareStatement("UPDATE koltsegvetes.kiadasok SET datum = ?, erintettPenztarca = ?, megnevezes = ?, kategoria = ?, kiadasHelye = ?, osszeg = ? WHERE id = ?");
            this.torol = kapcsolat.prepareStatement("DELETE FROM koltsegvetes.kiadasok WHERE id=?");
        } catch (SQLException ex) {
            throw new KoltsegvetesException(ex.getMessage());
        }
    }

    @Override
    public Kiadas peldanyKeszit(ResultSet rs) throws KoltsegvetesException {
        try {
            Kiadas kiadas = new Kiadas();
            kiadas.setId(rs.getInt("id"));
            kiadas.setDatum(rs.getDate("datum").toLocalDate());
            kiadas.setErintettPenztarca(penztarcaKeres(rs.getString("erintettPenztarca")));
            kiadas.setMegnevezes(rs.getString("megnevezes"));
            kiadas.setKategoria(rs.getString("kategoria"));
            kiadas.setKiadasHely(rs.getString("kiadasHelye"));
            kiadas.setOsszeg(rs.getInt("osszeg"));
            return kiadas;
        } catch (SQLException | NullPointerException ex) {
            throw new KoltsegvetesException(ex.getMessage());
        }
    }

    @Override
    public void elemBeilleszt(Kiadas kiadas) throws KoltsegvetesException {
        try {
            this.beilleszt.setObject(1, kiadas.getDatum());
            this.beilleszt.setString(2, kiadas.getErintettPenztarca().getNev());
            this.beilleszt.setString(3, kiadas.getMegnevezes());
            this.beilleszt.setString(4, kiadas.getKategoria());
            this.beilleszt.setString(5, kiadas.getKiadasHely());
            this.beilleszt.setInt(6, kiadas.getOsszeg());
            this.beilleszt.executeUpdate();
        } catch (SQLException ex) {
            throw new KoltsegvetesException(ex.getMessage());
        }
    }

    @Override
    public void elemFelulir(Kiadas kiadas) throws KoltsegvetesException {
        try {
            this.felulir.setObject(1, kiadas.getDatum());
            this.felulir.setString(2, kiadas.getErintettPenztarca().getNev());
            this.felulir.setString(3, kiadas.getMegnevezes());
            this.felulir.setString(4, kiadas.getKategoria());
            this.felulir.setString(5, kiadas.getKiadasHely());
            this.felulir.setInt(6, kiadas.getOsszeg());
            this.felulir.setInt(7, kiadas.getId());
            this.felulir.executeUpdate();
        } catch (SQLException ex) {
            throw new KoltsegvetesException(ex.getMessage());
        }
    }

}
