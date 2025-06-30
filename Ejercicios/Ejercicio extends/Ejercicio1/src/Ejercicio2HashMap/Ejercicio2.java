package Ejercicio2HashMap;

import java.util.HashMap;
import java.util.Objects;

public class Ejercicio2<K, V> extends HashMap<K, V> {

    // Mi logica
//    @Override
//    public V put(K key, V dato){
//        Objects.requireNonNull(key, "-------------- Valor de key nullo --------------");
//        Objects.requireNonNull(dato, "-------------- Valor dato nullo -----------------");
//        return put(key, dato);
//    }

    // Agregando logica de programacion de Docente
    // ------------- PUT ----------------
    public V put(K key, V value){

        if(value == null){
            throw new RuntimeException("Valor a almacenar es nullo");
        }

        // si queda sin super, queda en loop
        return super.put(key, value);
    }

    // demostracion de como funciona el get nulo
    // ------------- GET ----------------
    public V get(Object key){

        if(super.get(key) == null){
            throw new RuntimeException("El valor key es nullo");
        }
        return super.get(key);
    }

}
