package de.hsrm.ads;

import java.util.Arrays;

public class RucksackGreedy {
    public static int guteLoesungGEW = 0;
    public static int guteLoesungWER = 0;
    public static int[] guteLoesung;

    /**
     * Berechnet das Gesamtgewicht der aktuellen Loesung.
     * Ist das Ergebnis groeßer als maxGewicht, wird -1 zurückgegeben.
     *
     * @param gewicht    Liste der Gewichte
     * @param werte      Liste der Werte der Gewichte
     * @param res        Liste der aktuellen Loesung (auswahl von Gewichten)
     * @param maxGewicht Maximaler Gewichtsgrenzwert
     * @return Gesamtgewicht der aktuellen Loesung oder -1, wenn das Gesamtgewicht groeßer als maxGewicht ist
     */
    static int gesamtGewicht(int[] gewicht, int[] werte, int[] res, int maxGewicht) {
        int result = 0;
        for (int i = 0; i < res.length; i++) {
            if (res[i] > 0) {
                result += gewicht[i];
            }
        }
        if (result > maxGewicht) {
            return -1;
        }
        return result;
    }

    /**
     * Berechnet das Gesamtwert der aktuellen Loesung.
     * Ist das Gewicht der aktuellen Loesung zu groß wird -1 zurückgegeben.
     *
     * @param werte      Liste der Werte
     * @param res        Liste der aktuellen Loesung (auswahl von Gewichten)
     * @param maxGewicht Maximaler Wertsgrenzwert
     * @param gewicht    Liste der Gewichte
     * @return Gesamtwert der aktuellen Loesung
     * oder -1, wenn das Gesamtgewicht groeßer als maxGewicht ist
     */
    static int gesamtWert(int[] gewicht, int[] werte, int[] res, int maxGewicht) {
        int result = 0;
        if (gesamtGewicht(gewicht, werte, res, maxGewicht) == -1) {
            return -1;
        }
        for (int i = 0; i < res.length; i++) {
            if (res[i] > 0) {
                result += werte[i];
            }
        }
        return result;
    }

    /**
     * Loest das Problem mit Backtracking.
     *
     * @param ausgewaehlt Liste der aktuellen Loesung (auswahl von Gewichten)
     * @param gewichte    Liste der Gewichte
     * @param werte       Liste der Werte der Gewichte
     * @param restKapa    Restkapazitaet
     * @param objIndex    Index des Objekts, das gerade bearbeitet wird
     * @return Wert der besten Loesung
     */
    static int rucksack(int[] ausgewaehlt, int[] gewichte, int[] werte, int restKapa, int objIndex) {
        for (int i = 0; i < ausgewaehlt.length; i++) {
            if (ausgewaehlt[i] == 0) {  //Wenn das Objekt noch nicht ausgewaehlt wurde
                ausgewaehlt[i] = 1; //Auswahl des Objekts
                if (gesamtGewicht(gewichte, werte, ausgewaehlt, restKapa) == -1) {  //Wenn das Gesamtgewicht noch im Rahmen ist
                    ausgewaehlt[i] = 0; //Rücksetzen der Auswahl
                }
            }
        }
        return gesamtWert(gewichte, werte, ausgewaehlt, restKapa);  //Rückgabe des besten Wertes
    }

    public static void main(String[] args) {
        long ticks;
        long startTime;
        long stopTime;

        int[] gewichte = {10, 5, 7, 11};
        int[] werte = {7, 6, 2, 1};
        int[] ausgewaehlt = {0, 0, 0, 0};

        int[] gewicht2 = {10, 5, 7, 11, 13, 1, 7, 11, 13, 19, 19, 9, 8, 2, 7};
        int[] werte2 = {7, 6, 1, 1, 1, 4, 11, 20, 3, 7, 8, 9, 16, 19, 100};
        int[] ausgewaehlt2 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};


        startTime = System.nanoTime();
        System.out.print("Bester Wert: " + rucksack(ausgewaehlt, gewichte, werte, 30, 0));
        stopTime = System.nanoTime();
        ticks = (stopTime - startTime) / 1000;

        System.out.println("    |   Gesamtgewicht: " + gesamtGewicht(gewichte, werte, ausgewaehlt, 30));
        System.out.println("Loesung: " + Arrays.toString(ausgewaehlt));
        System.out.println("Zeit: " + (stopTime - startTime) + "ns ca.:" + String.format("%d.%02d", ticks / 1000, (ticks % 1000) / 10) + "ms\n");


        startTime = System.nanoTime();
        System.out.print("Bester Wert: " + rucksack(ausgewaehlt2, gewicht2, werte2, 30, 0));
        stopTime = System.nanoTime();
        ticks = (stopTime - startTime) / 1000;

        System.out.println("    |   Gesamtgewicht: " + gesamtGewicht(gewicht2, werte2, ausgewaehlt2, 30));
        System.out.println("Loesung: " + Arrays.toString(ausgewaehlt2));
        System.out.println("Zeit: " + (stopTime - startTime) + "ns ca.:" + String.format("%d.%02d", ticks / 1000, (ticks % 1000) / 10) + "ms\n");
    }

}
