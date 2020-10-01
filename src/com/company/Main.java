package com.company;

public class Main {

    public static void main(String[] args) {
        MultiSetFull a = new MultiSetFull();
        int[] input_a = new int[]{1, 5, 3, 7, 5};
        MultiSetFull b = new MultiSetFull();
        int[] input_b = new int[]{5, 9, 5, 7, 7, 7, 8, 11};

        for (int i : input_a) {
            a.add(i);
        }

        for (int i : input_b) {
            b.add(i);
        }
        System.out.println("Input A: ");
        a.printSet();
        System.out.println("Input B: ");
        b.printSet();
        System.out.println();

        System.out.println("Aggiungo 3 volte 8 nell input A");
        a.add(8,3);
        a.printSet();
        System.out.println();

        System.out.println("Rimuovo l 11 dall Input B");
        b.remove(11);
        b.printSet();
        System.out.println();

        System.out.println("Rimuovo 1 volta il 7 dall Input B");
        b.remove(7, 1);
        b.printSet();
        System.out.println();

        System.out.println("Grandezza totale di A: "+ a.size());
        System.out.println("Grandezza totale di B: "+b.size());
        System.out.println();

        System.out.println("A intersecato B: ");
        a.printSet();
        b.printSet();
        System.out.println("------------------------------------------------------------");
        a.intersecato(b);
        a.printSet();

    }


}
