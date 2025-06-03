import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RegistroClientees {

    public static void main(String[] args) {
        List<Cliente> clientes = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int contadorId = 1;

        System.out.println("=== SISTEMA DE REGISTRO DE CLIENTES ===");

        // Bucle principal de registro
        while (true) {
            System.out.println("\n--- Nuevo Cliente ---");

            // Entrada de datos
            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();

            System.out.print("Apellido: ");
            String apellido = scanner.nextLine();

            System.out.print("Email: ");
            String email = scanner.nextLine();

            System.out.print("Teléfono: ");
            String telefono = scanner.nextLine();

            // Generación automática de código
            String codigo = generarCodigoCliente(nombre, apellido, random);

            // Creación y almacenamiento del cliente
            Cliente nuevoCliente = new Cliente(
                    contadorId++,
                    codigo,
                    nombre,
                    apellido,
                    email,
                    telefono
            );

            clientes.add(nuevoCliente);
            System.out.println(" Cliente registrado con código: " + codigo);

            // Control de flujo
            System.out.print("\n¿Registrar otro cliente? (s/n): ");
            if (!scanner.nextLine().equalsIgnoreCase("s")) {
                break;
            }
        }

        // Mostrar resultados usando Iterator
        System.out.println("\n=== CLIENTES REGISTRADOS (" + clientes.size() + ") ===");
        Iterator<Cliente> iterador = clientes.iterator();
        int contador = 1;

        while (iterador.hasNext()) {
            System.out.println("\nCliente #" + contador++);
            System.out.println(iterador.next());
        }

        System.out.println("\nRegistro completado. ¡Adiós!");
        scanner.close();
    }

    // Generador de códigos de cliente
    private static String generarCodigoCliente(String nombre, String apellido, Random random) {
        // Extraer componentes del código
        String inicioApellido = apellido.substring(0, Math.min(apellido.length(), 2));
        String inicioNombre = nombre.substring(0, Math.min(nombre.length(), 2));
        String numero = String.format("%03d", random.nextInt(1000));

        // Combinar y formatear
        return (inicioApellido + inicioNombre + numero).toUpperCase();
    }
}