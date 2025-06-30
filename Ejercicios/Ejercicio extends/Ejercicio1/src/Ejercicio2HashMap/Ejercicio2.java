package Ejercicio2HashMap;

import java.util.HashMap;
import java.util.Objects;

public class Ejercicio2<K, V> extends HashMap<K, V> {

    @Override
    public V put(K key, V dato){
        Objects.requireNonNull(key, "-------------- Valor de key nullo --------------");
        Objects.requireNonNull(dato, "-------------- Valor dato nullo -----------------");
        return put(key, dato);
    }


}
