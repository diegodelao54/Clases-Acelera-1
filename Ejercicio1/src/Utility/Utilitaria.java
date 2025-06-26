package Utility;

import java.util.ArrayList;
import java.util.List;

public class Utilitaria {

    public <T> void addOddElements(List<T> entrada){
        List<T> destino = new ArrayList<>();

        System.out.println("datos entrada: " + entrada);

        for (int i = 1; i < entrada.toArray().length; i += 2){

            destino.add(entrada.get(i));
        }
        System.out.println("datos destinos: " + destino);
        System.out.println("-------------------------------------------------------");

    }

}
