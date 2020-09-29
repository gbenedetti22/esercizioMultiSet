package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	    MultiSet a = new MultiSet();
	    MultiSet b = new MultiSet();
        int[] input_a= {1,2,3};
        int[] input_b= {2,3,6,7};

        for (int i = 0; i < input_a.length; i++) {
            a.add(input_a[i]);
        }
        for (int i = 0; i < input_b.length; i++) {
            b.add(input_b[i]);
        }

        MultiSet unione=a.unito(b);
        MultiSet intersezione=a.intersecato(b);

        System.out.print("Unione: ");
        printSet(unione);

        System.out.print("Intersezione: ");
        printSet(intersezione);

    }

    private static void printSet(MultiSet a){
        for (int i = 0; i < a.size(); i++) {
            System.out.print(a.get(i));
        }
        System.out.println();
    }
}
