package pkg43_koltsegvetes_model_test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pkg43_koltsegvetes.exception.KoltsegvetesException;
import pkg43_koltsegvetes.model.Penztarca;

public class PenztarcaTest {
    
    private Penztarca testPenztarca;
    
    public PenztarcaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        testPenztarca = new Penztarca(1, "Teszt tárca", "Készpénz", 100);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test    
    public void kezdetiAllapotTeszt() {
        assertEquals(testPenztarca.getId(), new Integer(1));
        assertEquals(testPenztarca.getNev(), "Teszt tárca");
        assertEquals(testPenztarca.getTipus(), "Készpénz");
        assertEquals(testPenztarca.getOsszeg(), 100);        
    }
    
    @Test    
    public void modositasAllapotTeszt() {
        testPenztarca.setId(2);
        testPenztarca.setNev("Teszt tárca 2");
        testPenztarca.setTipus("Rezsi");
        testPenztarca.setOsszeg(50);
        assertEquals(testPenztarca.getId(), new Integer(2));
        assertEquals(testPenztarca.getNev(), "Teszt tárca 2");
        assertEquals(testPenztarca.getTipus(), "Rezsi");
        assertEquals(testPenztarca.getOsszeg(), 50);        
    }
    
    @Test(expected = KoltsegvetesException.class)
    public void nevEllenorzoTeszt() throws KoltsegvetesException {
        testPenztarca.nevEllenorzo("%/");
    }

    @Test(expected = KoltsegvetesException.class)
    public void osszegEllenorzoTeszt() throws KoltsegvetesException {
        testPenztarca.osszegEllenorzo("teszt");
    }
    
    
}
