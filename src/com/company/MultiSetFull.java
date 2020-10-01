package com.company;

import java.util.Arrays;

public class MultiSetFull extends MultiSet{
    public MultiSetFull() {
        super();
    }

    public void unito(MultiSet set_array){
        for (int i = 0; i < set_array.set.length; i++) {
            add(set_array.set[i], set_array.set_cardinality[i]);
        }
    }
    public void intersecato(MultiSet set_array){
        MultiSetFull set_temp = new MultiSetFull();

        for (int i = 0; i < set.length; i++) {
            for (int j = 0; j < set_array.set.length; j++) {
                if (set[i] == set_array.set[j]) {
                    set_temp.add(set[i]);
                    if(set_cardinality[i]>=set_array.set_cardinality[j]){
                        set_temp.add(set[i], set_array.set_cardinality[j]-1);
                        set_temp.size += set_array.set_cardinality[j]-1;
                    }else {
                        set_temp.add(set[i], set_cardinality[i]-1);
                        set_temp.size += set_cardinality[i]-1;
                    }
                }
            }
        }
        set=set_temp.set;
        size=set_temp.size;
        set_cardinality=set_temp.set_cardinality;
    }

    public void printSet(){//Metodo non richiesto, ma necessario per dimostrare il corretto funzionamento dell esercizio
        System.out.println(" - "+Arrays.toString(set));
        System.out.println("   "+Arrays.toString(set_cardinality));
    }

}
