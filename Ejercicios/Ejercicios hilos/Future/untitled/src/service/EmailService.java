package service;

public class EmailService {

    public boolean sendEmail(){
        System.out.println("Empecé a enviar el correo");

        //SIMULAR QUE EL SERVICIO DE EMAIL REAL DEMORA 3 SEGUNDOS
        try{Thread.sleep(3000);} catch (InterruptedException ex){}

        System.out.println("Correo enviado");
        return true;
    }

}
