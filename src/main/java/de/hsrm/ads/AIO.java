package de.hsrm.ads;

import de.hsrm.ads.RucksackBacktracking;

class AIO{
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