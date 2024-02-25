package Ejercicio02;


import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class Pago {
    private String titularTarjeta;
    private String numeroTarjeta;
    private String codigoReferencia;

    public Pago(String titularTarjeta, String numeroTarjeta, String codigoReferencia) {
        this.titularTarjeta = titularTarjeta;
        this.numeroTarjeta = numeroTarjeta;
        this.codigoReferencia = codigoReferencia;
    }

    public String getTitularTarjeta() {
        return titularTarjeta;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public String getCodigoReferencia() {
        return codigoReferencia;
    }
}

public class pagos {
    private static ArrayList<Pago> pagos = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        while (true) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Realizar pago");
            System.out.println("2. Reembolsar");
            System.out.println("3. Salir");

            int opcion = scanner.nextInt();
            scanner.nextLine();  

            switch (opcion) {
                case 1:
                    System.out.println("Introduzca el titular de la tarjeta:");
                    String titularTarjeta = scanner.nextLine();
                    System.out.println("Introduzca el número de la tarjeta:");
                    String numeroTarjeta = scanner.nextLine();

                    
                    if (numeroTarjeta.length() != 16) {
                        System.out.println("El número de tarjeta debe tener 16 dígitos.");
                        break;
                    }

                    
                    StringBuilder codigoReferencia = new StringBuilder();
                    String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
                    for (int i = 0; i < 5; i++) {
                        codigoReferencia.append(caracteres.charAt(random.nextInt(caracteres.length())));
                    }

                    Pago pago = new Pago(titularTarjeta, numeroTarjeta, codigoReferencia.toString());
                    pagos.add(pago);
                    System.out.println("Pago realizado con éxito. Código de referencia: " + pago.getCodigoReferencia());
                    break;

                case 2:
                    System.out.println("Introduzca el código de referencia del pago a reembolsar:");
                    String codigoReembolso = scanner.nextLine();
                    System.out.println("Introduzca el número de la tarjeta a reembolsar:");
                    String numeroTarjetaReembolso = scanner.nextLine();
                    scanner.nextLine(); 

                    
                    Pago pagoReembolso = null;
                    for (Pago p : pagos) {
                        if (p.getCodigoReferencia().equals(codigoReembolso)) {
                            pagoReembolso = p;
                            break;
                        }
                    }

                    if (pagoReembolso != null) {
                       
                        System.out.println("Reembolso realizado en la tarjeta " + numeroTarjetaReembolso );
                        pagos.remove(pagoReembolso);
                    } else {
                        System.out.println("No se encontró ningún pago con el código de referencia proporcionado.");
                    }
                    break;

                case 3:
                    System.out.println("¡Hasta luego!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opción inválida. Por favor, seleccione nuevamente.");
            }
            scanner.close();
        }
    }
}
