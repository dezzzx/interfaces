package Ejercicio05;

import java.util.ArrayList;
import java.util.List;


interface Filtrable<T> {
    List<T> filtrar(List<T> datos, String criterio);
}


interface Ordenable<T> {
    List<T> ordenar(List<T> datos);
}

class Datos implements Filtrable<Datos>, Ordenable<Datos> {
    private int id;
    private String nombre;
    
    public Datos(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    
    // Constructor sin argumentos
    public Datos() {
        
        this.id = 0;
        this.nombre = "";
    }

    @Override
    public List<Datos> filtrar(List<Datos> datos, String criterio) {
        List<Datos> resultado = new ArrayList<>();
        for (Datos dato : datos) {
            if (dato.getNombre().startsWith(criterio)) {
                resultado.add(dato);
            }
        }
        return resultado;
    }

    @Override
    public List<Datos> ordenar(List<Datos> datos) {
        datos.sort((d1, d2) -> d1.getNombre().compareTo(d2.getNombre()));
        return datos;
    }
    
    public int getId() {
        return id;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    @Override
    public String toString() {
        return "Datos{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}

public class Biblioteca {
    public static void main(String[] args) {
      
        List<Datos> datos = new ArrayList<>();
        datos.add(new Datos(1, "Juan"));
        datos.add(new Datos(2, "Pedro"));
        datos.add(new Datos(3, "Ana"));
        
        // Filtrar datos que comienzan con "P"
        Filtrable<Datos> filtrable = new Datos();
        List<Datos> datosFiltrados = filtrable.filtrar(datos, "P");
        System.out.println("Datos filtrados:");
        for (Datos dato : datosFiltrados) {
            System.out.println(dato);
        }
        
        // Ordenar datos por nombre
        Ordenable<Datos> ordenable = new Datos();
        List<Datos> datosOrdenados = ordenable.ordenar(datos);
        System.out.println("\nDatos ordenados:");
        for (Datos dato : datosOrdenados) {
            System.out.println(dato);
        }
    }
}
