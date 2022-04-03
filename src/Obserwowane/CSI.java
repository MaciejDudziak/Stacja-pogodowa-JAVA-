package Obserwowane;

import Obserwatorzy.Obserwator;

import java.util.ArrayList;

public class CSI implements Obserwowane {
    Czujnik wroclaw = new Czujnik("wroclaw", true, true, true);
    Czujnik legnica = new Czujnik("legnica", true, false, true);
    Czujnik olawa = new Czujnik("olawa", true, true, false);
    Czujnik jawor = new Czujnik("jawor", true, false, false);
    Czujnik klodzko = new Czujnik("klodzko", false, false, true);
    Czujnik polkowice = new Czujnik("polkowice", false, true, false);

    public void powiadom() {
        System.out.println("Zauktualizowano informacje");
    }

    public void wykonajPomiaryWszystkie() {
        Thread watekWroclaw = new Thread(wroclaw);
        Thread watekLegnica = new Thread(legnica);
        Thread watekOlawa = new Thread(olawa);
        Thread watekJawor = new Thread(jawor);
        Thread watekKlodzko = new Thread(klodzko);
        Thread watekPolkowice = new Thread(polkowice);
        watekWroclaw.start();
        watekLegnica.start();
        watekOlawa.start();
        watekJawor.start();
        watekKlodzko.start();
        watekPolkowice.start();
    }

    public void wypiszWszystkieLokalizacje() {
        System.out.println(wroclaw.toString());
        System.out.println(legnica.toString());
        System.out.println(olawa.toString());
        System.out.println(jawor.toString());
        System.out.println(klodzko.toString());
        System.out.println(polkowice.toString());
    }
}

