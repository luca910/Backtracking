package de.hsrm.ads;

import java.util.Arrays;

public class RucksackGreedy {
    public static int guteLoesungGEW = 0;
    public static int guteLoesungWER = 0;
    public static int[] guteLoesung;

    public static int counter= 0;

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
            counter++;
            if (ausgewaehlt[i] == 0) {  //Wenn das Objekt noch nicht ausgewaehlt wurde
                ausgewaehlt[i] = 1; //Auswahl des Objekts
                if (gesamtGewicht(gewichte, werte, ausgewaehlt, restKapa) == -1) {  //Wenn das Gesamtgewicht noch im Rahmen ist
                    ausgewaehlt[i] = 0; //Rücksetzen der Auswahl
                }
            }
        }
        return gesamtWert(gewichte, werte, ausgewaehlt, restKapa);  //Rückgabe des besten Wertes
    }

    public static void run(int[] gewichte, int[] werte, int[] ausgewaehlt) {
        long ticks;
        long startTime;
        long stopTime;
        counter= 0;
        guteLoesung=new int[gewichte.length];
        guteLoesungWER = 0;
        startTime = System.nanoTime();
        System.out.print("Bester Wert: " + rucksack(ausgewaehlt, gewichte, werte, 30, 0));
        stopTime = System.nanoTime();
        ticks = (stopTime - startTime) / 1000;

        System.out.println("    |   Gesamtgewicht: " + gesamtGewicht(gewichte, werte, guteLoesung, 30));
        System.out.println("Loesung: " + Arrays.toString(guteLoesung));
        System.out.println("Zeit: " + (stopTime - startTime) + "ns ca.:" + String.format("%d.%02d", ticks / 1000, (ticks % 1000) / 10) + "ms");
        System.out.println("Laenge: " + guteLoesung.length);
        System.out.println("Anzahl der Iterationen: " + counter +"\n");
    }

    public static void main(String[] args) {
        int[] gewichte = {10, 5, 7, 11};
        int[] werte = {7, 6, 2, 1};
        int[] ausgewaehlt = {0, 0, 0, 0};

        int[] gewichte2 = {10, 5, 7, 11, 13, 1, 7, 11, 13, 19, 19, 9, 8, 2, 7};
        int[] werte2 = {7, 6, 1, 1, 1, 4, 11, 20, 3, 7, 8, 9, 16, 19, 100};
        int[] ausgewaehlt2 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        int[] bestG={31,31,31,31,31};
        int[] bestW={31,31,31,31,31};
        int[] bestA={0,0,0,0,0};

        int[] gewichte3 = {29,28,27,26,25,24,23,22,21,20,19,18,17,16,15,14,13,12,11,10,9,8,7,6,5,4,3,2,30};
        int[] werte3 = {29,28,27,26,25,24,23,22,21,20,19,18,17,16,15,14,13,12,11,10,9,8,7,6,5,4,3,2,30};
        int[] ausgewaehlt3 = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};

        int[] gewichte4 = {29,29,29,29,29,29,29,29,29,29,29,29,29,29,29,29,29,29};
        int[] werte4 = {30,29,29,29,29,29,29,29,29,29,29,29,29,29,29,29,29,29};
        int[] ausgewaehlt4 = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};

        int[] gewichte5 = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        int[] werte5 = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        int[] ausgewaehlt5 = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};


        run(gewichte, werte, ausgewaehlt);
        run(gewichte2, werte2, ausgewaehlt2);
        run(bestG, bestW, bestA);
        run(gewichte3, werte3, ausgewaehlt3);
        run(gewichte4, werte4, ausgewaehlt4);
        run(gewichte5, werte5, ausgewaehlt5);


    }
}
