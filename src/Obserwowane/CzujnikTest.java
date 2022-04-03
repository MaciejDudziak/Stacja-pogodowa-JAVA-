package Obserwowane;

import Obserwowane.Czujnik;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class CzujnikTest {

    Czujnik testowany = null;

    @Before
    public void init() {
        testowany = new Czujnik("miastoTestowe", true, true, true);
    }

    @Test
    public void TestGetWilgotnoscDziala() {
        assertEquals(testowany.getWilgotnosc(), 0);
    }

    @Test
    public void TestGetWilgotnoscDzialaGdyNiePuste() {
        Czujnik testowanyMock = mock(Czujnik.class);
        when(testowanyMock.getWilgotnosc()).thenReturn(50);
        assertEquals(testowanyMock.getWilgotnosc(), 50);
    }

    @Test
    public void TestGetCisnienieDziala() {
        assertEquals(testowany.getCisnienie(), 0);
    }

    @Test
    public void TestGetCisnienieDzialaGdyNiePuste() {
        Czujnik testowanyMock = mock(Czujnik.class);
        when(testowanyMock.getCisnienie()).thenReturn(1020);
        assertEquals(testowanyMock.getCisnienie(), 1020);
    }

    @Test
    public void TestGetLokalizacjaDziala() {
        assertEquals(testowany.getLokalizacja(), "miastoTestowe");
    }

    @Test
    public void TestGetTemperaturaDziala() {
        assertEquals(testowany.getTemperatura(), 0.0, 0.0);
    }

    @Test
    public void TestGetTemperaturaDzialaGdyNiePuste() {
        Czujnik testowanyMock = mock(Czujnik.class);
        when(testowanyMock.getTemperatura()).thenReturn(22.15);
        assertEquals(testowanyMock.getTemperatura(), 22.15,0.05);
    }

    @Test
    public void TestAktualizowanieDanych(){
        testowany.zauktualizuj();
        assertNotEquals(testowany.getTemperatura(),0.0,0.05);
        assertNotEquals(testowany.getWilgotnosc(),0.);
        assertNotEquals(testowany.getCisnienie(),0);
    }

    @Test
    public void TestMetodaRun(){
        testowany.run();
        assertNotEquals(testowany.getTemperatura(),0.0,0.05);
        assertNotEquals(testowany.getWilgotnosc(),0.);
        assertNotEquals(testowany.getCisnienie(),0);
    }

    @Test
    public void TestToStringDlaWszystkichDanych(){
        assertEquals(testowany.toString(), "miastoTestowe (temperatura/wilgotnosc/cisnienie)");
    }

    @Test
    public void TestToStringDlaNiepelnychDanych(){
        Czujnik niepelnyTestowy = new Czujnik("braki",true,true,false);
        Czujnik pusty = new Czujnik("pusty", false, false, false);
        assertEquals(niepelnyTestowy.toString(), "braki (temperatura/wilgotnosc)");
        assertEquals(pusty.toString(),"pusty Czujnik nie ma zadnej funkcjonalnosci");
    }

    @Test
    public void TestZwracanaDlaWszystkichDanych(){
        assertEquals(testowany.zwracana(), "miastoTestowe temperatura: 0.0°C wilgotnosc: 0% cisnienie: 0hPa");
    }
    @Test
    public void TestZwracanaDlaNiepelnychDanych(){
        Czujnik niepelnyTestowy = new Czujnik("braki",true,true,false);
        Czujnik pusty = new Czujnik("pusty", false, false, false);
        assertEquals(niepelnyTestowy.zwracana(), "braki temperatura: 0.0°C wilgotnosc: 0% cisnienie: niedostepne");
        assertEquals(pusty.toString(),"pusty Czujnik nie ma zadnej funkcjonalnosci");
    }
}
