package Ejercicio01;

import java.util.ArrayList;
import java.util.Scanner;
interface Inventariable {
    int obtenerStock();
    void actualizarStock(int nuevoStock);
}

class Producto implements Inventariable {
    private String nombre;
    private int stock;

    public Producto(String nombre, int stock) {
        this.nombre = nombre;
        this.stock = stock;
    }

    @Override
    public int obtenerStock() {
        return stock;
    }

    @Override
    public void actualizarStock(int nuevoStock) {
        this.stock = nuevoStock;
    }

    public String getNombre() {
        return nombre;
    }
}

public class Stock {
    private ArrayList<Producto> inventario;
    private Scanner scanner;

    public Stock() {
        inventario = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void agregarProducto() {
        System.out.println("Ingrese el nombre del producto:");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese el stock del producto:");
        int stock = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        Producto producto = new Producto(nombre, stock);
        inventario.add(producto);
        System.out.println("Producto agregado correctamente.");
    }

    public void editarProducto() {
        listarProductos();
        System.out.println("Ingrese el número del producto que desea editar:");
        int indice = scanner.nextInt();
        scanner.nextLine();
        if (indice >= 0 && indice < inventario.size()) {
            Producto producto = inventario.get(indice);
            System.out.println("Ingrese el nuevo stock para " + producto.getNombre() + ":");
            int nuevoStock = scanner.nextInt();
            scanner.nextLine();

            producto.actualizarStock(nuevoStock);
            System.out.println("Stock actualizado correctamente.");
        } else {
            System.out.println("Índice de producto no válido.");
        }
    }

    public void eliminarProducto() {
        listarProductos();
        System.out.println("Ingrese el número del producto que desea eliminar:");
        int indice = scanner.nextInt();
        scanner.nextLine(); 

        if (indice >= 0 && indice < inventario.size()) {
            inventario.remove(indice);
            System.out.println("Producto eliminado correctamente.");
        } else {
            System.out.println("Índice de producto no válido.");
        }
    }

    public void listarProductos() {
        System.out.println("Lista de productos:");
        for (int i = 0; i < inventario.size(); i++) {
            Producto producto = inventario.get(i);
            System.out.println(i + ". " + producto.getNombre() + " - Stock: " + producto.obtenerStock());
        }
    }

    public static void main(String[] args) {
        Stock gestor = new Stock();
        Scanner scanner = new Scanner(System.in);

        int opcion;
        do {
            System.out.println("\nMenú:");
            System.out.println("1. Agregar producto");
            System.out.println("2. Editar producto");
            System.out.println("3. Eliminar producto");
            System.out.println("4. Listar productos");
            System.out.println("5. Salir");
            System.out.println("Ingrese una opción:");

            opcion = scanner.nextInt();
            scanner.nextLine(); 
            switch (opcion) {
                case 1:
                    gestor.agregarProducto();
                    break;
                case 2:
                    gestor.editarProducto();
                    break;
                case 3:
                    gestor.eliminarProducto();
                    break;
                case 4:
                    gestor.listarProductos();
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } while (opcion != 5);
        
        scanner.close();
    }
}
