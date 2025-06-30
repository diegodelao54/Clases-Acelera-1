package Ejercicio1Stack;

import java.util.ArrayList;
import java.util.Collection;

import java.util.List;
import java.util.Stack;

public class Ejercicio1<T> extends Stack<T> {


    // metodo de ingreso de datos
    //Cambio tambien el uso de String por clase generica, wildCard extend de T, con esto toma lo que sea
    public void pushAll(List<? extends T> datos){

        System.out.println("datos a introducir :  " + datos.toString());

        //Si utilizo el for seria, String cadena : datos
        for (T t : datos){
            //Almacena lo obtenido en el arreglo datos
            super.push(t);
        }

        //Corrigiendo codigo por logica docente en forma de for y no utilizando this, no me hace loop
        //this.push((T) datos);
    }

    // Metodo de eliminacion de pila
    public List<T> popAll(){
        // con esta forma solo elimino el ultimo agregado, al no reccorrer el arreglo
        //System.out.println("Registro a eliminar: " + this.pop());

        //Arreglo para imprimir lo que hay en la pila antes de eliminar
        List<T> outPut = new ArrayList<>();

        //Se ocupa el WHILE ya que se comprueba que el objeto este vacio
        while(!this.isEmpty()) {
            T t = super.pop();
            outPut.add(t);
            System.out.println(outPut.size() + " Dato eliminado : " + outPut);
        }

        return outPut;
    }



}
