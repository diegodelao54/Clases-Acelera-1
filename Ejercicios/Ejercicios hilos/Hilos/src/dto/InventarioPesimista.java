package dto;


import java.util.concurrent.atomic.AtomicInteger;

public class InventarioPesimista {

    //no obtimista
    //private int stock;

    private AtomicInteger stock = new AtomicInteger(0);

    public void comprar(int cantidad){
        if(stock.get() < cantidad){
            System.out.println("La cantidad es mayor al stock");
            return;
        }
        this.stock.addAndGet(-cantidad);
        System.out.println("Se ha compado: "+ cantidad+ " unidades. Stock actualizado: " + stock);
    }

    public void abastecer(int cantidad){
        this.stock.addAndGet(+cantidad);
        System.out.println("Se ha abastecido: "+ cantidad + " unidades. Stock actualizado: " + stock);
    }
}
