package vista;

import modelo.Producto;
import java.util.List;
import java.util.Scanner;

public class DirectorioVista {
    private Scanner scanner;

    public DirectorioVista() {
        this.scanner = new Scanner(System.in);
    }

    public int mostrarMenu() {
        System.out.println("\n--- MENÚ INVENTARIO ---");
        System.out.println("1. Agregar nuevo producto");
        System.out.println("2. Buscar producto por SKU");
        System.out.println("3. Mostrar todos los productos");
        System.out.println("4. Eliminar producto por SKU");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción: ");
        int opcion = -1;
        try {
            opcion = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            opcion = -1;
        }
        return opcion;
    }

    public Producto pedirDatosUsuario() {
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine().trim();

        System.out.print("SKU: ");
        String sku = scanner.nextLine().trim();

        int cantidad = 0;
        while (true) {
            try {
                System.out.print("Cantidad: ");
                cantidad = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Cantidad inválida, intente de nuevo.");
            }
        }

        double precio = 0;
        while (true) {
            try {
                System.out.print("Precio unitario: ");
                precio = Double.parseDouble(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Precio inválido, intente de nuevo.");
            }
        }

        return new Producto(nombre, sku, cantidad, precio);
    }

    public String pedirSku() {
        System.out.print("Ingrese el SKU: ");
        return scanner.nextLine().trim();
    }

    public void mostrarProducto(Producto producto) {
        if (producto != null) {
            System.out.println(producto.toString());
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    public void mostrarProductos(List<Producto> productos) {
        if (productos == null || productos.isEmpty()) {
            System.out.println("No hay productos registrados.");
        } else {
            System.out.println("\n--- Lista de Productos ---");
            for (Producto p : productos) {
                System.out.println(p.toString());
            }
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
