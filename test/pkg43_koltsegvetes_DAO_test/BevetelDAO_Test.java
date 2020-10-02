package pkg43_koltsegvetes_DAO_test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import pkg43_koltsegvetes.dao.impl.BevetelDAO_JDBC;
import pkg43_koltsegvetes.dao.impl.PenztarcaDAO_JDBC;
import pkg43_koltsegvetes.exception.KoltsegvetesException;
import pkg43_koltsegvetes.model.Bevetel;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BevetelDAO_Test {

    Connection kapcsolat;
    BevetelDAO_JDBC bevetelIrany;
    PenztarcaDAO_JDBC penztarcaIrany;

    public BevetelDAO_Test() throws KoltsegvetesException, SQLException {
        kapcsolat = DriverManager.getConnection("jdbc:mysql://localhost:3306/koltsegvetes?useSSL=false", "root", "1234");
        this.penztarcaIrany = new PenztarcaDAO_JDBC(kapcsolat);
        this.bevetelIrany = new BevetelDAO_JDBC(kapcsolat, penztarcaIrany.osszesBetolt());
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /*A bevételek adatbázis tábla alap esetben két teszt bevételt tartalmaz.
    Hasonlóképpen, a pénztárcák adatbázis tábla két teszt pénztárcát tartalmaz alap esetben.
     */
    @Test
    public void test01_kapcsolatTeszt() {
        assertNotNull(kapcsolat);
    }

    @Test
    public void test02_osszesBetoltTeszt() throws KoltsegvetesException {
        assertEquals(2, bevetelIrany.osszesBetolt().size());
    }

    @Test
    public void test03_beillesztTeszt() throws KoltsegvetesException {
        bevetelIrany.elment(new Bevetel(null, LocalDate.of(2020, Month.AUGUST, 3), "Bevétel 3", penztarcaIrany.osszesBetolt().get(0), 100));
        assertEquals(3, bevetelIrany.osszesBetolt().size());

        Bevetel ujBeillesztettBevetel = bevetelIrany.osszesBetolt().get(utolsoBevetelIndex());

        assertEquals(Integer.valueOf(utolsoSorID()), ujBeillesztettBevetel.getId());
        assertEquals(LocalDate.of(2020, Month.AUGUST, 3), ujBeillesztettBevetel.getDatum());
        assertEquals("Bevétel 3", ujBeillesztettBevetel.getMegnevezes());
        assertEquals(penztarcaIrany.osszesBetolt().get(0).getId(), ujBeillesztettBevetel.getErintettPenztarca().getId());
        assertEquals(100, ujBeillesztettBevetel.getOsszeg());
    }

    @Test
    public void test04_felulirTeszt() throws KoltsegvetesException {
        bevetelIrany.elment(new Bevetel(utolsoSorID(), LocalDate.of(2019, Month.AUGUST, 30), "Bevétel 4", penztarcaIrany.osszesBetolt().get(1), 50));

        Bevetel modositottBevetel = bevetelIrany.osszesBetolt().get(utolsoBevetelIndex());

        assertEquals(Integer.valueOf(utolsoSorID()), modositottBevetel.getId());
        assertNotEquals(LocalDate.of(2020, Month.AUGUST, 3), modositottBevetel.getDatum());
        assertNotEquals("Bevétel 3", modositottBevetel.getMegnevezes());
        assertNotEquals(penztarcaIrany.osszesBetolt().get(0).getId(), modositottBevetel.getErintettPenztarca().getId());
        assertNotEquals(100, modositottBevetel.getOsszeg());

        assertEquals(LocalDate.of(2019, Month.AUGUST, 30), modositottBevetel.getDatum());
        assertEquals("Bevétel 4", modositottBevetel.getMegnevezes());
        assertEquals(penztarcaIrany.osszesBetolt().get(1).getId(), modositottBevetel.getErintettPenztarca().getId());
        assertEquals(50, modositottBevetel.getOsszeg());
    }

    @Test
    public void test05_torolTeszt() throws KoltsegvetesException {
        bevetelIrany.torol(utolsoSorID());
        assertEquals(2, bevetelIrany.osszesBetolt().size());
    }


    private int utolsoBevetelIndex() throws KoltsegvetesException {
        int utolsoBevetelIndex = -1;
        for (Bevetel bev : bevetelIrany.osszesBetolt()) {
            utolsoBevetelIndex++;
        }
        return utolsoBevetelIndex;
    }

    private int utolsoSorID() throws KoltsegvetesException {
        int utolsoSorId = -1;
        for (Bevetel bev : bevetelIrany.osszesBetolt()) {
            utolsoSorId = bev.getId();
        }
        return utolsoSorId;
    }

}
