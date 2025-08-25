import dto.InventarioPesimista;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //Bloqueo pesimista
        InventarioPesimista inventario = new InventarioPesimista();

        //compra 1
        Thread compra1 = new Thread(
                () -> inventario.comprar(10)
        );

        //compra 2
        Thread compra2 = new Thread(
                () -> inventario.comprar(20)
        );

        //compra 3
        Thread compra3 = new Thread(
                () -> inventario.comprar(30)
        );

        //abastecer 1
        Thread abasteser1 = new Thread(
                () -> inventario.abastecer(15)
        );

        //abastecer 2
        Thread abasteser2 = new Thread(
                () -> inventario.abastecer(25)
        );

        //abastecer 3
        Thread abasteser3 = new Thread(
                () -> inventario.abastecer(35)
        );


        compra1.start();
        abasteser1.start();

        compra2.start();
        abasteser2.start();

        compra3.start();
        abasteser3.start();



        //bloqueo optimista


    }
}