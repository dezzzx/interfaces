package Ejercicio03;




interface Notificable {
 void enviarNotificacion();
}


class CorreoElectronico implements Notificable {
 @Override
 public void enviarNotificacion() {
     System.out.println("Enviando notificación por correo electrónico");

 }
}


class SMS implements Notificable {
 @Override
 public void enviarNotificacion() {
     System.out.println("Enviando notificación por SMS");

 }
}


class MensajeApp implements Notificable {
 @Override
 public void enviarNotificacion() {
     System.out.println("Enviando notificación por mensaje en aplicación");

 }
}

public class sistemademensajes {
 public static void main(String[] args) {

     Notificable notificacion1 = new CorreoElectronico();
     Notificable notificacion2 = new SMS();
     Notificable notificacion3 = new MensajeApp();
     notificacion1.enviarNotificacion();
     notificacion2.enviarNotificacion();
     notificacion3.enviarNotificacion();
 }
}
