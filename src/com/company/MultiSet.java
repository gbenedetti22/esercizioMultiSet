package com.company;

import java.util.Arrays;

public class MultiSet implements IntMultiSet {
    private int[] set;
    private int[] set_cardinality;
    private int current_position=0;
    private int size=0;

    public MultiSet(){
        set = new int[1];
        set_cardinality = new int[1];
    }

    @Override
    public int getCount(int elem) {
        int result=getIndexOf(elem);
        return set_cardinality[result];
    }

    @Override
    public void add(int elem) {
        size++;
        int result=getIndexOf(elem);
        if (result >= 0){
            set_cardinality[result]++;
            return;
        }

        boolean inserito=false;
        while (!inserito) {
            try {
                set[current_position] = elem;
                set_cardinality[current_position]++;
                current_position++;
                inserito= true;
            } catch (ArrayIndexOutOfBoundsException e) {
                set = expandArray(set);
                set_cardinality = expandArray(set_cardinality);
            }
        }
    }

    private static int[] expandArray(int[] array){
        int[] new_array= new int[array.length+1];

        System.arraycopy(array, 0, new_array, 0, array.length);

        return new_array;
    }

    @Override
    public void add(int elem, int n) {
        int result=getIndexOf(elem);
        if(result >= 0){
            set_cardinality[result] += n;
            size += n;
        }else {
            add(elem);
        }
    }

    @Override
    public boolean remove(int elem) {
        int[] set_temp= new int[set.length-1];
        int[] setc_temp= new int[set_cardinality.length-1];
        boolean trovato=false;
        int j=0;

        for (int i = 0; i < set.length; i++) {
            if(set[i]!=elem){
                set_temp[j] = set[i];
                setc_temp[j]= set_cardinality[j];
                j++;
            }else {
                size--;
                trovato=true;
            }
        }
        set = set_temp;
        set_cardinality=setc_temp;
        return trovato;
    }

    @Override
    public boolean remove(int elem, int n) {
        int result = getIndexOf(elem);
        boolean trovato=false;
        if(result > 0){
            trovato=true;
            if(set_cardinality[result] > n){
                set_cardinality[result] -= n;
                size -= n;
            }else {
                remove(elem);
            }
        }

        return trovato;
    }

    @Override
    public int size() {
        return size;
    }
    private int getIndexOf(int elem){
        for (int i = 0; i < set.length; i++) {
            if(set[i]==elem)
                return i;
        }
        return -1;
    }

    public void printSet(){
        System.out.println(Arrays.toString(set));
        System.out.println(Arrays.toString(set_cardinality));
    }

}
