package service;

public class SmsService {

    public boolean sendSms(){
        System.out.println("Mensaje de texto se va a enviar");

        //SIMULAR QUE EL SERVICIO DE SMS REAL DEMORA 2 SEGUNDOS
        try{Thread.sleep(2000);} catch (InterruptedException ex){}

        System.out.println("Mensaje de texto enviado");
        return true;
    }

}
