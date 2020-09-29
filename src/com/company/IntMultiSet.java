package com.company;

public interface IntMultiSet
{
    /**
     * Restitusice il numero delle occorrence dell’intero elem nel multi-insieme.
     * A elem non appartimene al multiinsieme restituisce 0
     **/
    int getCount(int elem);
    /**
     * Aggiunge al multi-insieme una occorrenza di elem
     * */
    void add(int elem);
    /**
     * Aggiunge n copie di elem al multi-insieme
     **/
    void add(int elem, int n);
    /**
     * Rimuove tutte le occorrenze di elem dal multi-insieme.
     * Restituisce false se elem non e’ presente
     */
    boolean remove(int elem);
    /**
     * Rimuove n copie of di elem dal multi-insieme
     * Restituisce false se elem non e’ presente
     * */
    boolean remove(int elem, int n);
    /**
     * Restuisce il numero degli elementi del multi-insieme.
     **/
    int size();
}
