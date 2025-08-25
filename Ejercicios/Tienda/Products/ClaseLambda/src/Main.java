import dto.Personas;
import lambdacomparador.IComparador;
import lambdaconvertidor.IConvertidor;
import lambdainteger.IOperador;
import lambdastring.ISaludar;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Stream;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //uso del STREAM

        List<String> nombre = Arrays.asList("diego","Monica","lu","juan","ana");
        nombre.stream()
               .filter(name -> name.length() > 4)
               .forEach(name -> System.out.println(name.toUpperCase()));


        //segundo ejercicio
        Personas p1 = new Personas("Jose", 30);
        Personas p2 = new Personas("Carlos", 40);
        Personas p3 = new Personas("Marcela", 16);

        List<Personas> listadoPersonas = Arrays.asList(p1,p2,p3);

        OptionalDouble promedio = listadoPersonas.stream()
                        .filter(p -> p.getEdad() > 17)
                        .mapToInt(Personas::getEdad)
                        .average();

        System.out.println("promedio : "+ promedio);






//  ============= como utilizar interfaces funcionales



//
//        //Saludo
//
//        ISaludar saludo = () -> System.out.println("!Hola Mundo!");
//
//        saludo.saludar();
//
//
//        //Comparar
//        IComparador<Integer> comparar = (Integer x, Integer y) -> {
//            return x == y;
//        };
//
//        boolean valor = comparar.comparar(5,10);
//
//        if (valor){
//            System.out.println("El valor es igual: " + valor);
//        }
//        System.out.println("El valor es igual: " + valor);
//
//        //Operador
//        IOperador operar = Integer::sum;
//
//        IOperador resta = (x, y) -> x-y;
//
//        System.out.println("la suma es: "+ operar.operar(5,4));
//
//        //convertidor aca se usa el simplificador
//        IConvertidor<String, Integer> convertir = String::length;
//
//        Integer cant = convertir.convertir("Diego");
//        System.out.println("Cantidad de caracteres: " + cant);

    }
}