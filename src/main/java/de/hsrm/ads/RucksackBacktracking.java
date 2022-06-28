package de.hsrm.ads;

import java.util.Arrays;

/**
 * Loesung des Rucksack Problems mit Backtracking
 * @see <a href="https://www.cs.hs-rm.de/~reith/resources/Lehre/ADS22/Test2.pdf">cs.hs-rm.de</a>
 * @author Luca Krawczyk
 * @author Paul Knoll
 *
 * @version 1.0
 *
 * Creates a new RucksackBacktracking object.
 */
public class RucksackBacktracking {
    /**
     * Loescht alle Elemente aus der Liste.
     *
     * @param list Liste, die geleert werden soll
     */
    /**
     * Globele Variable mit dem Wert der aktuellen Loesung
     */
    public static int guteLoesungWER = 0;
    /**
     * Globele Variable mit dem Array der aktuellen Loesung
     *                    (0 = nicht ausgewaehlt, 1 = ausgewaehlt)
     */
    public static int[] guteLoesung;
    /**
     * Globaler Counter zur Ueberpruefung der Loesungen
     */
    public static int counter;

    /**
     * Berechnet das Gesamtgewicht der aktuellen Loesung.
     * Ist das Ergebnis groeßer als maxGewicht, wird -1 zurückgegeben.
     *
     * @param gewicht    Liste der Gewichte
     * @param werte      Liste der Werte der Gewichte
     * @param res        Liste der aktuellen Loesung (auswahl von Gewichten)
     * @param maxGewicht Maximaler Gewichtsgrenzwert
     * @return Gesamtgewicht der aktuellen Loesung oder -1, wenn das Gesamtgewicht groeßer als maxGewicht ist
     *
     */
    static int gesamtGewicht(int[] gewicht, int[] werte, int[] res, int maxGewicht) {
        /**
         * @param result - Ergebnis der Berechnung
         */
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
        /**
         * @param result - Ergebnis der Berechnung
         */
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
     * Diese Backtracking Implementierung beginnt bei der ersten Loesung und geht dann in alle moeglichen weiteren Loesungen vor.
     * Hierbei wird das ausgewaehlt array von hinten aus verändert.
     * Somit werden nach und nach Lösungen ausgeschlossen, die ungültig sind.
     *
     * @param ausgewaehlt Liste der aktuellen Loesung (auswahl von Gewichten)
     * @param gewichte    Liste der Gewichte
     * @param werte       Liste der Werte der Gewichte
     * @param restKapa    Restkapazitaet
     * @param objIndex    Index des Objekts, das gerade bearbeitet wird
     * @return Wert der besten Loesung
     * @throws IndexOutOfBoundsException   - Wenn die Anzahl der Objekte nicht gleich der Anzahl der Gewichte ist
     * @throws IndexOutOfBoundsException   - Wenn die Anzahl der Objekte nicht gleich der Anzahl der Werte ist
     * @throws IndexOutOfBoundsException   - Wenn die Anzahl der Objekte nicht gleich der Anzahl der aktuellen Loesung ist
     */
    static int rucksack(int[] ausgewaehlt, int[] gewichte, int[] werte, int restKapa, int objIndex) {
        for (int i = objIndex; i < ausgewaehlt.length; i++) {
            if (ausgewaehlt[ausgewaehlt.length - 1 - i] == 0) {    //Wenn das Objekt noch nicht ausgewaehlt wurde
                ausgewaehlt[ausgewaehlt.length - 1 - i] = 1;    //Auswahl des Objekts
                counter++;
                if (gesamtGewicht(gewichte, werte, ausgewaehlt, restKapa) != -1) {    //Wenn das Gesamtgewicht noch im Rahmen ist
                    int gw = gesamtWert(gewichte, werte, ausgewaehlt, restKapa);    //Berechnung des Gesamtwertes
                    if (guteLoesungWER < gw) {    //Wenn das Gesamtwert besser ist

                        guteLoesung = ausgewaehlt.clone();    //Beste Loesung speichern
                        guteLoesungWER = gw;    //Besten Wert speichern
                    }
                    rucksack(ausgewaehlt, gewichte, werte, restKapa, i + 1);    //Rekursiver aufruf
                }
                ausgewaehlt[ausgewaehlt.length - 1 - i] = 0;    //Rücksetzen der Auswahl
            }
        }
        return guteLoesungWER;    //Rückgabe des besten Wertes
    }

    /**
     * Hauptmethode zum Starten des Backtracking Algorithmus.
     *
     * @param gewichte Liste der Gewichte
     * @param werte Liste der Werte der Gewichte
     * @param ausgewaehlt Liste der aktuellen Loesung (auswahl von Gewichten)
     */

    public static void run(int[] gewichte, int[] werte, int[] ausgewaehlt) {
        long ticks;
        long startTime;
        long stopTime;
        counter= 0;
        guteLoesung=new int[gewichte.length];
        guteLoesungWER = 0;
        startTime = System.nanoTime();
        System.out.print("    Bester Wert: " + rucksack(ausgewaehlt, gewichte, werte, 30, 0));
        stopTime = System.nanoTime();
        ticks = (stopTime - startTime) / 1000;

        System.out.println("    |   Gesamtgewicht: " + gesamtGewicht(gewichte, werte, guteLoesung, 30));
        System.out.println("    Loesung: " + Arrays.toString(guteLoesung));
        System.out.println("    Zeit: " + (stopTime - startTime) + "ns ca.:" + String.format("%d.%02d", ticks / 1000, (ticks % 1000) / 10) + "ms");
        System.out.println("    Laenge: " + guteLoesung.length);
        System.out.println("    Anzahl der Iterationen: " + counter +"\n");
    }

    /**
     * Hauptmethode zum Starten des Backtracking Algorithmus.
     * @param args - keine Argumente
     */
    public static void main(String[] args) {

        int[] gewichte = {10, 5, 7, 11};
        int[] werte = {7, 6, 2, 1};
        int[] ausgewaehlt = {0, 0, 0, 0};

        int[] gewichte2 = {10, 5, 7, 11, 13, 1, 7, 11, 13, 19, 19, 9, 8, 2, 7, 31};
        int[] werte2 = {7, 6, 1, 1, 1, 4, 11, 20, 3, 7, 8, 9, 16, 19, 100, 3};
        int[] ausgewaehlt2 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

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

        System.out.println("Random Beispiel, da Laufzeit beim ersten Test immer höher: ");
        run(gewichte4, werte4, ausgewaehlt4);

        System.out.println("Beispeil 1: ");
        run(gewichte, werte, ausgewaehlt);

        System.out.println("Beispiel 2: ");
        run(gewichte2, werte2, ausgewaehlt2);

        System.out.println("Best Case (n): ");
        run(bestG, bestW, bestA);

        System.out.println("Worst Case (2^n): ");
        run(gewichte5, werte5, ausgewaehlt5);

    }
}
