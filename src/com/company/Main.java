package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	    MultiSet a = new MultiSet();
        int[] input= {1,5,9,9,4,7,8,8,8,11};
        System.out.println("Input: "+ Arrays.toString(input));

        for (int i = 0; i < input.length; i++) {
            a.add(input[i]);
        }

        System.out.println("8 compare: "+a.getCount(8)+" volte");

        System.out.println("Aggiungo 3 4 volte");
        a.add(3,4);

        System.out.println("Rimuovo il 3 4 volte");
        a.remove(3,4);

        System.out.println("La lunghezza del MultiSet è di: "+ a.size());

    }
}
