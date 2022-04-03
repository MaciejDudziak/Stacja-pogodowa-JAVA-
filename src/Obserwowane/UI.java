package Obserwowane;

import java.util.ArrayList;
import java.util.Scanner;

public class UI {

    public static void main(String[] args) throws InterruptedException {
        CSI csi = new CSI();
        ArrayList<Czujnik> subskrybowaneMiasta = new ArrayList<>();
        csi.wykonajPomiaryWszystkie();
        System.out.println("Witaj w aplikacji, co chcesz zrobic?");
        int licznik = 1;
        while(true){
            if(licznik>1){
                System.out.println("Co chcesz zrobic teraz?");
            }
            licznik ++;
            Scanner mojObj = new Scanner(System.in);
            System.out.println("1) Wyswietl dostepne lokalizacje czujnikow:");
            System.out.println("2) Zarejestruj sie do nowej lokalizacji");
            System.out.println("3) Wyswietl aktualnie subskrybowane lokalizacje");
            System.out.println("4) Otrzymuj powiadomienia o pogodzie w aktualnie subskrybowanych lokalizacjach");
            System.out.println("5) Wyswietl szczegolowe dane o pogodzie w aktulanie subskrybowanych lokalizacjach");
            System.out.println("6) Anuluj subskrypcje danej lokalizacji");
            System.out.println("7) Wylaczyc aplikacje");
            int wyborUzytkownika = mojObj.nextInt();
            if(wyborUzytkownika == 1){
                csi.wypiszWszystkieLokalizacje();
            }
            if(wyborUzytkownika == 2){
                System.out.println("Wpisz numer przy miescie z listy: 1)Wroclaw 2)Legnica 3)Olawa 4)Jawor 5)Klodzko 6)Polkowice");
                int wybraneMiasto = mojObj.nextInt();
                if(wybraneMiasto == 1){
                    subskrybowaneMiasta.add(csi.wroclaw);
                }
                if(wybraneMiasto == 2){
                    subskrybowaneMiasta.add(csi.legnica);
                }
                if(wybraneMiasto == 3){
                    subskrybowaneMiasta.add(csi.olawa);
                }
                if(wybraneMiasto == 4){
                    subskrybowaneMiasta.add(csi.jawor);
                }
                if(wybraneMiasto == 5){
                    subskrybowaneMiasta.add(csi.klodzko);
                }
                if(wybraneMiasto == 6){
                    subskrybowaneMiasta.add(csi.polkowice);
                }
            }
            if(wyborUzytkownika == 3) {
                if(subskrybowaneMiasta.size() == 0){
                    System.out.println("Nie subskrybujesz zadnych miast");
                }
                else{
                for (Czujnik miasto : subskrybowaneMiasta) {
                    System.out.println(miasto.lokalizacja);
                }
                }
            }
            if(wyborUzytkownika == 4){
                while(true){
                csi.wykonajPomiaryWszystkie();
                csi.powiadom();
                for(Czujnik miasto : subskrybowaneMiasta) {
                    System.out.println(miasto.zwracana());
                }
                    Thread.sleep(5000);
                    System.out.println("Czy chcesz przerwac program i wrocic do menu? 1-tak 2-nie");
                    int czyPrzerwac = mojObj.nextInt();
                    if(czyPrzerwac == 1){
                        break;
                    }
                }
            }
            if(wyborUzytkownika == 5){
                for(Czujnik miasto : subskrybowaneMiasta) {
                    System.out.println(miasto.lokalizacja);
                    if(miasto.czyTemperatura){
                        double sumaTemperatur = 0;
                        int licznikTemperatur = 0;
                        double minimalnaTemperatura = miasto.getTemperatura();
                        double maksymalnaTemperatura = miasto.getTemperatura();
                        for(double temperatura : miasto.historiaTemperatur){
                            sumaTemperatur += temperatura;
                            licznikTemperatur ++;
                            if(temperatura<minimalnaTemperatura){
                                minimalnaTemperatura = temperatura;
                            }
                            if(temperatura>maksymalnaTemperatura){
                                maksymalnaTemperatura = temperatura;
                            }
                        }
                        System.out.println("Srednia temperatura to: " + sumaTemperatur/licznikTemperatur);
                        System.out.println("Minimalna temperatura to: " + minimalnaTemperatura + "°C");
                        System.out.println("Maksymalna temperatura to: " + maksymalnaTemperatura  + "°C");
                    }
                    if(miasto.czyWilgotnosc){
                        double sumaWilgotnosci = 0;
                        int licznikWilgotnosci = 0;
                        double minimalnaWilgotnosc = miasto.getWilgotnosc();
                        double maksymalnaWilgotnosc = miasto.getWilgotnosc();
                        for(double wilgotnosc : miasto.historiaWilgotnosci){
                            sumaWilgotnosci += wilgotnosc;
                            licznikWilgotnosci ++;
                            if(wilgotnosc<minimalnaWilgotnosc){
                                minimalnaWilgotnosc = wilgotnosc;
                            }
                            if(wilgotnosc>maksymalnaWilgotnosc){
                                maksymalnaWilgotnosc = wilgotnosc;
                            }
                        }
                        System.out.println("Srednia wilgotnosc to: " + sumaWilgotnosci/licznikWilgotnosci);
                        System.out.println("Minimalna wilgotnosc to: " + minimalnaWilgotnosc + "%");
                        System.out.println("Maksymalna wilgotnosc to: " + maksymalnaWilgotnosc  + "°%");
                    }
                    if(miasto.czyCisnienie){
                        double sumaCisnien = 0;
                        int licznikCisnienia = 0;
                        double minimalneCisnienie = miasto.getCisnienie();
                        double maksymalneCisnienie = miasto.getCisnienie();
                        for(double cisnienie : miasto.historiaCisnienia){
                            sumaCisnien += cisnienie;
                            licznikCisnienia ++;
                            if(cisnienie<minimalneCisnienie){
                                minimalneCisnienie = cisnienie;
                            }
                            if(cisnienie>maksymalneCisnienie){
                                maksymalneCisnienie = cisnienie;
                            }
                        }
                        System.out.println("Srednie cisnienie to: " + sumaCisnien/licznikCisnienia);
                        System.out.println("Minimalne cisnienie to: " + minimalneCisnienie + "hPa");
                        System.out.println("Maksymalne cisnienie to: " + maksymalneCisnienie  + "hPa");
                    }
                }
            }
            if(wyborUzytkownika == 6){
                System.out.println("Ktora subskrycpcje chcesz usunac?(Wpisz numer z listy)");
                int i = 1;
                for (Czujnik miasto : subskrybowaneMiasta) {
                    System.out.println(i + ") " + miasto.lokalizacja);
                    i++;
                }
                int ktoryUsunac = mojObj.nextInt();
                subskrybowaneMiasta.remove(ktoryUsunac-1);
            }
            if(wyborUzytkownika == 7){
                break;
            }
            }
    }
}
