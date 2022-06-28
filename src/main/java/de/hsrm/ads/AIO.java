package de.hsrm.ads;

/**
 * All in One Class zum ausführen der Main-Methode aller Aufgaben.
 * @see <a href="https://www.cs.hs-rm.de/~reith/resources/Lehre/ADS22/Test2.pdf">cs.hs-rm.de</a>
 * @author Luca Krawczyk
 * @author Paul Knoll
 *
 * @version 1.0
 *
 * Creates a new AIO object.
 */
class AIO{
    /**
     * Main-Methode zum Ausführen aller Aufgaben.
     * @param args Keine Argumente für die Main-Methode
     */
    public static void main(String[] args) {
        System.out.println("Aufgabe RucksackBacktracking Anfang");
        RucksackBacktracking.main(args);
        System.out.println("Aufgabe RucksackBacktracking Ende");

        System.out.println("Aufgabe RucksackGreedy Anfang");
        RucksackGreedy.main(args);
        System.out.println("Aufgabe RucksackGreedy Ende");

        System.out.println("Aufgabe Reverse Anfang");
        Reverse.main(args);
        System.out.println("Aufgabe Reverse Ende");

    }
}