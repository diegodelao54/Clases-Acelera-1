package Ejercicio1Stack;

import java.util.Collection;

import java.util.List;
import java.util.Stack;

public class Ejercicio1<T> extends Stack<T> {


    // metodo de ingreso de datos
    public void pushAll(List<String> datos){

        System.out.println("datos a introducir :  " + datos.toString());
        this.push((T) datos);
    }

    // Metodo de eliminacion de pila
    public void popAll(){
        System.out.println("Registro a eliminar: " + this.pop());

    }



}
