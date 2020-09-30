package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        MultiSet a = new MultiSet();
        int[] input_a = new int[]{1, 5, 3, 7, 5, 8, 8, 8};

        for (int j : input_a) {
            a.add(j);
        }

        System.out.println();
        a.remove(8, 2);

        a.add(3, 3);
        a.add(21, 2);
        System.out.println(a.size());
    }


}
