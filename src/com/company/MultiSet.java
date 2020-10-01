package com.company;

import java.util.Arrays;
public class MultiSet implements IntMultiSet {
    protected int[] set;
    protected int[] set_cardinality;
    protected int size=0;
    private int current_position=0;

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
            //Caso particolare in cui l elemento non c'è e viene inserito n volte
            add(elem);//Lo aggiungo in fondo al Set, e in automatico viene incrementato il valore a 1 (avendo inserito un elemento)
            set_cardinality[current_position-1] += n-1;//Poi però la cardinalità di quell elemento deve essere decrementata di 1
            size += n-1;//Tolgo l elemento in più
        }
    }

    //System.arraycopy() utilizza il memcpy per copiare gli array, quindi, non dovendo ciclare su proprio tutti gli elementi,
    //lo rende più efficiente di un ciclo.
    @Override
    public boolean remove(int elem) {
        int index= getIndexOf(elem);
        if(index < 0){
            return false;
        }
        size--;
        int[] result= new int[set.length-1];

        System.arraycopy(set,0,result,0,index);
        System.arraycopy(set,index+1,result,index,set.length-index-1);
        set=result;

        result= new int[set_cardinality.length-1];
        System.arraycopy(set_cardinality,0,result,0,index);
        System.arraycopy(set_cardinality,index+1,result,index,set_cardinality.length-index-1);
        set_cardinality=result;

        return true;
    }

/*
    E' possibile inoltre fare un ciclo che skippa l elemento da rimuovere. Questo però ha costo maggiore.
    Non ho usato la tecnica del "sostituire" l elemento da cancellare con uno 0, perchè in termini di spazio, questo è uno spreco.
    inoltre, se io ho per esempio, un array con 100 elementi e ne cancello 50, ho metà array con 50 '0' e questo non è
    molto efficiente in termini di costo.
    @Override
    public boolean remove(int elem) {
        int[] set_temp= new int[set.length-1];
        int[] setc_temp= new int[set_cardinality.length-1];
        boolean trovato=false;
        int j=0;

        for (int i = 0; i < set.length; i++) {
            if(set[i]!=elem){
                set_temp[j] = set[i];
                setc_temp[j]= set_cardinality[i];
                j++;
            }else {
                size--;
                trovato=true;
            }
        }
        set = set_temp;
        set_cardinality=setc_temp;
        return trovato;
    }*/

    //Essendo la richiesta ambigua, ho optato per la scelta "Non so quanti elementi ci sono,
    //nel dubbio metto un numero sicuramente più grande, così lo elimino"
    @Override
    public boolean remove(int elem, int n) {
        int result = getIndexOf(elem);
        boolean trovato=false;
        if(result >= 0){
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

}
