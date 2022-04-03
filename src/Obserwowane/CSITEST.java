package Obserwowane;
import Obserwowane.CSI;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CSITEST {

    CSI csiTestowany = null;

    @Before
    public void init() {
        csiTestowany = new CSI();
        csiTestowany.wykonajPomiaryWszystkie();
    }
    @Test
    public void testWykonywaniaPomiarow(){
        csiTestowany.wykonajPomiaryWszystkie();
        assertNotEquals(csiTestowany.wroclaw.getTemperatura(),0.0,0.0);
        assertNotEquals(csiTestowany.wroclaw.getCisnienie(),0);
        assertNotEquals(csiTestowany.wroclaw.getWilgotnosc(),0);
    }
}
