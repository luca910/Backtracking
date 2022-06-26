package de.hsrm.ads;

public class Reverse {
    public String reverserecursive(String s) {
        if (s.length() == 0) {
            return s;
        }
        return reverserecursive(s.substring(1)) + s.charAt(0);
    }

    public static void main(String[] args) {
        Reverse r = new Reverse();
        System.out.println(r.reverserecursive("Hallo"));
        System.out.println(r.reverserecursive("leohortetrohoel"));
    }
}