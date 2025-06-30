import Ejercicio1Stack.Ejercicio1;
import Ejercicio2HashMap.Ejercicio2;
import Utility.Utilitaria;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main{

    public static void main(String[] args) {
        System.out.println("===============================================");
        System.out.println("=============    Diego De La O    =============");
        System.out.println("===============================================");
        System.out.println("=============     Ejercicio 1     =============");
        System.out.println("===============================================");

        //llamada de insertar datos
        Ejercicio1<String> myStack = new Ejercicio1<>();

        //Creando arreglo
        List<String> datosEntrada = new ArrayList<>();

        // llenado de arrayList
        datosEntrada.add("Diego");
        datosEntrada.add("Jose");
        datosEntrada.add("Carlos");

        //llamado de insertar datos
        myStack.pushAll(datosEntrada);

        //salida de datos
        myStack.popAll();

        System.out.println("Datos de pila eliminados? " + myStack.isEmpty());
        System.out.println(" ------------- Fin del proceso --------------");

// -----------------------------------------  Ejercicio 2  -----------------------------------------

        System.out.println("===============================================");
        System.out.println("=============     Ejercicio 2     =============");
        System.out.println("===============================================");

        try {
            Ejercicio2<String, String> datosMap = new Ejercicio2<>();

            //datos correctamente
//            datosMap.put("1", "Diego");

            //key nullos
//            datosMap.put(null, "diego");

            //datos nullos
            datosMap.put("1", null);
            System.out.println("Valor almacenado : " + datosMap.get("1"));

        }
        catch (Exception ex){
            System.out.println("Error valor vacio : " + ex.getMessage());
        }

// -----------------------------------------  Ejercicio 3  -----------------------------------------

        System.out.println("===============================================");
        System.out.println("=============     Ejercicio 3     =============");
        System.out.println("===============================================");

        Utilitaria util = new Utilitaria();

        List<String> datosGenerales = new ArrayList<>();
        datosGenerales.add("1");
        datosGenerales.add("2");
        datosGenerales.add("3");
        datosGenerales.add("4");
        datosGenerales.add("5");
        datosGenerales.add("6");

        util.addOddElements(datosGenerales);
        
    }
}