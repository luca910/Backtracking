package de.hsrm.ads;

import java.util.Arrays;

public class Reverse {
    /**
     * Kehrt den Übergebenen String um.
     *
     * @param s
     *          String to reverse
     * @return
     *          reversed string
     */
    public String reverseRecursive(String s) {
        if (s.length() == 0) {
            return s;
        }
        return reverseRecursive(s.substring(1)) + s.charAt(0);
    }

    /**
     * Kehrt den Übergebenen String um prüft zuvor ob es sich um einen Palindrom handelt.
     *
     * @param s
     *          String to reverse
     * @return
     *          reversed string
     */

    public String reverseRecursivePalindrome(String s) {
        if(isPalindrome(s)){
            return s;
        }
        if (s.length() == 0) {
            return s;
        }
        return reverseRecursivePalindrome(s.substring(1)) + s.charAt(0);
    }

    /**
     * Prüft ob ein String ein Palindrom ist.
     *
     * @param s
     *          String to check
     * @return
     *          true if string is palindrome
     */

    public boolean isPalindrome(String s) {
        if (s.length() == 0) {
            return true;
        }
        else{
            for(int i=0;i<s.length()/2; i++){
                if(s.charAt(i) != s.charAt(s.length()-i-1)){
                    return false;
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
        long ticks;
        long startTime= System.nanoTime();
        long stopTime= System.nanoTime();

        Reverse r = new Reverse();

        startTime = System.nanoTime();
        System.out.print(r.reverseRecursive("leohortetrohoel"));
        stopTime = System.nanoTime();
        System.out.println(" (Warmup-run)");
        ticks = (stopTime - startTime)/1000;
        System.out.println("Zeit: "+(stopTime - startTime)+"ns ≈" +String.format("%d.%02d", ticks / 1000, (ticks % 1000) / 10)+"ms\n");

        startTime = System.nanoTime();
        System.out.print(r.reverseRecursivePalindrome("leohortetrohoel"));
        stopTime = System.nanoTime();
        System.out.println(" (Palindrom-Check)");
        ticks = (stopTime - startTime)/1000;
        System.out.println("Zeit: "+(stopTime - startTime)+"ns ≈" +String.format("%d.%02d", ticks / 1000, (ticks % 1000) / 10)+"ms\n");

        startTime = System.nanoTime();
        System.out.println(r.reverseRecursive("leohortetrohoel"));
        stopTime = System.nanoTime();
        ticks = (stopTime - startTime)/1000;
        System.out.println("Zeit: "+(stopTime - startTime)+"ns ≈" +String.format("%d.%02d", ticks / 1000, (ticks % 1000) / 10)+"ms\n");


    }
}