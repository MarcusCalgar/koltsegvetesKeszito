package pkg43_koltsegvetes_model_test;

import java.time.LocalDate;
import java.time.Month;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pkg43_koltsegvetes.exception.KoltsegvetesException;
import pkg43_koltsegvetes.model.Kiadas;
import pkg43_koltsegvetes.model.Penztarca;

public class KiadasTest {

    Kiadas testKiadas;
    Penztarca testPenztarca = new Penztarca();
    Penztarca testPenztarca2 = new Penztarca();

    public KiadasTest() {
    }

    @BeforeClass
    public static void setUpClass() {

    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        testKiadas = new Kiadas(1, LocalDate.of(2020, Month.AUGUST, 15), "Teszt kiadás", testPenztarca, "Élelmiszer", "Spar", 100);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void kezdetiAllapotTeszt() {
        assertEquals(testKiadas.getId(), new Integer(1));
        assertEquals(testKiadas.getDatum(), LocalDate.of(2020, Month.AUGUST, 15));
        assertEquals(testKiadas.getMegnevezes(), "Teszt kiadás");
        assertEquals(testKiadas.getErintettPenztarca().hashCode(), testPenztarca.hashCode());
        assertEquals(testKiadas.getKategoria(), "Élelmiszer");
        assertEquals(testKiadas.getKiadasHely(), "Spar");
        assertEquals(testKiadas.getOsszeg(), 100);
    }

    @Test
    public void modositasTeszt() {
        testKiadas.setId(2);
        testKiadas.setDatum(LocalDate.of(2020, Month.AUGUST, 16));
        testKiadas.setMegnevezes("Teszt kiadás 2");
        testKiadas.setErintettPenztarca(testPenztarca2);
        testKiadas.setKategoria("Rezsi");
        testKiadas.setKiadasHely("Lidl");
        testKiadas.setOsszeg(50);
        assertEquals(testKiadas.getId(), new Integer(2));
        assertEquals(testKiadas.getDatum(), LocalDate.of(2020, Month.AUGUST, 16));
        assertEquals(testKiadas.getMegnevezes(), "Teszt kiadás 2");
        assertEquals(testKiadas.getErintettPenztarca().hashCode(), testPenztarca2.hashCode());
        assertEquals(testKiadas.getKategoria(), "Rezsi");
        assertEquals(testKiadas.getKiadasHely(), "Lidl");
        assertEquals(testKiadas.getOsszeg(), 50);
    }

    @Test(expected = KoltsegvetesException.class)
    public void nevEllenorzoTeszt() throws KoltsegvetesException {
        testKiadas.megnevezesEllenorzo("%/");
    }

    @Test(expected = KoltsegvetesException.class)
    public void osszegEllenorzoTeszt() throws KoltsegvetesException {
        testKiadas.osszegEllenorzo("teszt");
    }

}
