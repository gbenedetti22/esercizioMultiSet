package com.company;

import java.util.Arrays;

public class MultiSet implements IntMultiSet {
    private int[] array;
    private int current_position=0;//memorizzo la posizione dell utimo elemento inserito, così evito un ciclo

    public MultiSet(){
        array = new int[2];//istanzio un array di base
    }

    @Override
    public int getCount(int elem) {
        int conta=0;
        for (int i = 0; i < array.length; i++) {
            if(array[i]==elem)
                conta++;
        }
        return conta;
    }
//parto ad aggiungere dall indice 0, e mano a mano incremento. Quando ho raggiunto il limite dell array, lo espando e ritento
    @Override
    public void add(int elem) {
        try {
            array[current_position]=elem;
            current_position++;
        }catch (ArrayIndexOutOfBoundsException e){
            expandArray(array);
            add(elem);
        }
    }

    private void expandArray(int[] a){
        array= new int[array.length+1];//ricreo l array ma con una dimensione più grande (così facendo perdo tutti gli elementi)
        for (int i = 0; i < a.length; i++) {
            array[i] = a[i];//ciclo e rimetto tutti gli elementi persi dentro l array originale
        }
    }

    @Override
    public void add(int elem, int n) {
        for (int i = 0; i < n; i++) {
            add(elem);
        }
    }

    @Override
    public boolean remove(int elem) {
        int[] temp= new int[array.length-1];//creo un array di dim -1 perchè sto togliendo un elemento
        boolean trovato=false;
        int j=0;

        for (int i = 0; i < array.length; i++) {
            if(array[i]!=elem || trovato){//butta dentro finchè non trovo l elemento
                temp[j] = array[i];
                j++;
            }else {
                trovato=true;//quando trovo l elemento, questo lo salto e non incremento j
            }
        }
        array=temp;
        return trovato;
    }

    @Override
    public boolean remove(int elem, int n) {
        boolean trovato = false;
        for (int i = 0; i < n; i++) {
            trovato= remove(elem);
        }
        return trovato;
    }

    @Override
    public int size() {
        return array.length;
    }
}
