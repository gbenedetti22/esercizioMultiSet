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
    int get(int index);
    Object clone() throws CloneNotSupportedException;

    //Unione e intersezione
    default MultiSet unito(MultiSet set) {
        MultiSet temp = new MultiSet();
        try {
            temp = (MultiSet) this.clone();
        }catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
        for (int i = 0; i < set.size(); i++) {
            temp.add(set.get(i));
        }
        return temp;
    }
    default MultiSet intersecato(MultiSet set){
        MultiSet temp = new MultiSet();
        for (int i = 0; i < size(); i++) {
            for (int j = 0; j < set.size(); j++) {
                if(get(i) == set.get(j)){
                    temp.add(set.get(j));
                }
            }
        }

        return temp;
    }

}
