package org.reactor;

import org.reactor.subscriptor.UtilSubscriptor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.function.Consumer;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        UtilSubscriptor utilSubscriptor = new UtilSubscriptor();

        Consumer<Integer> onNext = n -> System.out.println("ON NEXT -> " + n);
        Consumer<Throwable> onError = error -> System.out.println("ERROR -> " + error);
        Runnable onComplete = () -> System.out.println("ON COMPLETE");

//        //emitiendo numero
//        emitirNumero().subscribe(
//                onNext,
//                onError,
//                onComplete
//        );
//
//
//        emitirSaludo().subscribe(
//                str -> System.out.println("ON NEXT -> " + str),
//                null,
//                () -> System.out.println("Termino la subscripcion")
//        );


//        Mono<String> publicadorSaludo = emitirSaludo();
//
//        publicadorSaludo.subscribe();





    }

    public static Mono<String> emitirSaludo(){
        return Mono.just("Hola Mundo");
    }

    public static Flux<Integer> emitirNumero(){
        return Flux.just(1,2,3,4,5);
    }
}