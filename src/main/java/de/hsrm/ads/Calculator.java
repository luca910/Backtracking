package de.hsrm.ads;

public class Calculator {
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
}
