package Obserwowane;

import Obserwatorzy.Obserwator;

import java.util.ArrayList;
import java.util.Random;

public class Czujnik implements Runnable, Obserwator {
    final ArrayList<Double> historiaTemperatur = new ArrayList<>();
    final ArrayList<Integer> historiaWilgotnosci = new ArrayList<>();
    final ArrayList<Integer> historiaCisnienia= new ArrayList<>();
    private double temperatura;
    private int wilgotnosc;
    private int cisnienie;
    final String lokalizacja;
    final boolean czyTemperatura;
    final boolean czyWilgotnosc;
    final boolean czyCisnienie;
    Random random = new Random();

    public Czujnik(String lokalizacja, boolean czyTemperatura, boolean czyWilgotnosc, boolean czyCisnienie){
        this.lokalizacja = lokalizacja;
        this.czyTemperatura = czyTemperatura;
        this.czyWilgotnosc = czyWilgotnosc;
        this.czyCisnienie = czyCisnienie;
    }

    public double getTemperatura(){
        return temperatura;
    }

    public int getWilgotnosc(){
        return wilgotnosc;
    }

    public int getCisnienie(){
        return cisnienie;
    }

    public String getLokalizacja(){
        return lokalizacja;
    }

    @Override
    public void zauktualizuj() {
        if(czyTemperatura) {
            this.temperatura = random.nextDouble() * (40 + 25) + -25;
            historiaTemperatur.add(this.temperatura);
        }
        if(czyWilgotnosc) {
            this.wilgotnosc = random.nextInt(101);
            historiaWilgotnosci.add(this.wilgotnosc);
        }
        if(czyCisnienie){
            this.cisnienie = random.nextInt(231) + 870;
            historiaCisnienia.add(this.cisnienie);
        }
    }

    @Override
    public void run() {
        zauktualizuj();
    }

    public String toString(){
        if(czyTemperatura & czyWilgotnosc & czyCisnienie){
            return lokalizacja + " " + "(temperatura/wilgotnosc/cisnienie)";
        }
        else if(czyWilgotnosc & czyCisnienie){
            return lokalizacja + " " + "(wilgotnosc/cisnienie)";
        }
        else if(czyTemperatura & czyCisnienie){
            return lokalizacja + " " + "(temperatura/cisnienie)";
        }
        else if(czyWilgotnosc & czyTemperatura){
            return lokalizacja + " " + "(temperatura/wilgotnosc)";
        }
        else if(czyTemperatura){
            return lokalizacja + " " + "(temperatura)";
        }
        else if(czyWilgotnosc){
            return lokalizacja + " " + "(wilgotnosc)";
        }
        else if(czyCisnienie){
            return lokalizacja + " " + "(cisnienie)";
        }
        return lokalizacja + " Czujnik nie ma zadnej funkcjonalnosci";
    }

    public String zwracana(){
        if(czyTemperatura & czyWilgotnosc & czyCisnienie){
            return lokalizacja + " temperatura: " + temperatura + "°C wilgotnosc: " + wilgotnosc + "% cisnienie: " + cisnienie + "hPa";
        }
        else if(czyWilgotnosc & czyCisnienie){
            return lokalizacja + " temperatura: niedostepne "  + "wilgotnosc: " + wilgotnosc + "% cisnienie: " + cisnienie + "hPa";
        }
        else if(czyTemperatura & czyCisnienie){
            return lokalizacja + " temperatura: " + temperatura + "°C wilgotnosc: niedostepne " + "cisnienie: " + cisnienie + "hPa";
        }
        else if(czyWilgotnosc & czyTemperatura){
            return lokalizacja + " temperatura: " + temperatura + "°C wilgotnosc: " + wilgotnosc + "% cisnienie: niedostepne";
        }
        else if(czyTemperatura){
            return lokalizacja + " temperatura: " + temperatura + "°C wilgotnosc: niedostepne cisnienie: niedostepne";
        }
        else if(czyWilgotnosc){
            return lokalizacja + " temperatura: niedostepne " + "wilgotnosc: " + wilgotnosc + "% cisnienie: niedostepne";
        }
        else if(czyCisnienie){
            return lokalizacja + " temperatura: niedostepne " + "wilgotnosc: niedostepne" + " cisnienie: " + cisnienie + "hPa";
        }
        return lokalizacja + " Czujnik nie ma zadnej funcjonalnosci";
    }
}
