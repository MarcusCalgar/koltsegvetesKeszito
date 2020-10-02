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
import pkg43_koltsegvetes.model.Bevetel;
import pkg43_koltsegvetes.model.Penztarca;

public class BevetelTest {
    
    Bevetel testBevetel;
    Penztarca testPenztarca = new Penztarca();
    Penztarca testPenztarca2 = new Penztarca();
    
    public BevetelTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        testBevetel = new Bevetel(1, LocalDate.of(2020, Month.AUGUST, 15), "Teszt bevétel", testPenztarca, 100);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void kezdetiAllapotTeszt() {        
        assertEquals(testBevetel.getId(), new Integer(1));
        assertEquals(testBevetel.getDatum(), LocalDate.of(2020, Month.AUGUST, 15));
        assertEquals(testBevetel.getMegnevezes(), "Teszt bevétel");
        assertEquals(testBevetel.getErintettPenztarca().hashCode(), testPenztarca.hashCode());
        assertEquals(testBevetel.getOsszeg(), 100);
    }
    
    @Test
    public void modositasTeszt() {
        testBevetel.setId(2);
        testBevetel.setDatum(LocalDate.of(2020, Month.AUGUST, 16));
        testBevetel.setMegnevezes("Teszt bevétel 2");
        testBevetel.setErintettPenztarca(testPenztarca2);
        testBevetel.setOsszeg(50);
        assertEquals(testBevetel.getId(), new Integer(2));
        assertEquals(testBevetel.getDatum(), LocalDate.of(2020, Month.AUGUST, 16));
        assertEquals(testBevetel.getMegnevezes(), "Teszt bevétel 2");
        assertEquals(testBevetel.getErintettPenztarca().hashCode(), testPenztarca2.hashCode());
        assertEquals(testBevetel.getOsszeg(), 50);
    }
    
    @Test(expected = KoltsegvetesException.class)
    public void nevEllenorzoTeszt() throws KoltsegvetesException {
        testBevetel.megnevezesEllenorzo("%/");
    }
    
    @Test(expected = KoltsegvetesException.class)
    public void osszegEllenorzoTeszt() throws KoltsegvetesException {
        testBevetel.osszegEllenorzo("teszt");
    }
}
