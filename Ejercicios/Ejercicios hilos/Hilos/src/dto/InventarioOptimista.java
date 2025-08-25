package dto;

public class InventarioOptimista {

    private static int stock;

    public void abastecer(int cantidad){
        stock = stock + cantidad;
        System.out.println("Se ha abastecido: "+ cantidad + " unidades. Stock actualizado: " + stock);
    }

    public void compra(int cantidad){

        if (stock < cantidad){
            System.out.println("la compra no se puede realizar, stock menor que cantidad");
        }
        stock = stock - cantidad;
        System.out.println("Se ha compado: "+ cantidad+ " unidades. Stock actualizado: " + stock);
    }
}
