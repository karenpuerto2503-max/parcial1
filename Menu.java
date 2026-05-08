package Vista;

import Modelo.Cliente;
import Modelo.Colabanco;

import java.time.LocalTime;
import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Colabanco banco = new Colabanco();

        banco.cargarCola("clientes.dat");

        int opcion;

        do {

            System.out.println("\n====== BANCO POPULAR ======");
            System.out.println("1. Agregar cliente");
            System.out.println("2. Atender cliente");
            System.out.println("3. Ver siguiente cliente");
            System.out.println("4. Mostrar fila");
            System.out.println("5. Cantidad de clientes");
            System.out.println("6. Vaciar cola");
            System.out.println("7. Salir");

            System.out.print("Seleccione una opción: ");

            while (!sc.hasNextInt()) {
                System.out.println("Ingrese un número válido.");
                sc.next();
            }

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1:

                    try {

                        System.out.print("Nombre: ");
                        String nombre = sc.nextLine();

                        System.out.print("Identificación: ");
                        String identificacion = sc.nextLine();

                        System.out.print("Tipo de transacción: ");
                        String tipo = sc.nextLine();

                        System.out.print("¿Tiene prioridad? (true/false): ");
                        boolean prioridad = sc.nextBoolean();
                        sc.nextLine();

                        Cliente cliente = new Cliente(
                                nombre,
                                identificacion,
                                tipo,
                                LocalTime.now(),
                                prioridad
                        );

                        banco.agregarCliente(cliente);

                        System.out.println("Cliente agregado correctamente.");

                    } catch (IllegalArgumentException e) {

                        System.out.println("Error: " + e.getMessage());
                    }

                    break;

                case 2:

                    Cliente atendido = banco.atenderCliente();

                    if (atendido == null) {
                        System.out.println("La cola está vacía.");
                    } else {
                        System.out.println("\nCliente atendido:");
                        System.out.println(atendido);
                    }

                    break;

                case 3:

                    Cliente siguiente = banco.verSiguienteCliente();

                    if (siguiente == null) {
                        System.out.println("No hay clientes en espera.");
                    } else {
                        System.out.println("\nSiguiente cliente:");
                        System.out.println(siguiente);
                    }

                    break;

                case 4:

                    banco.mostrarFila();

                    break;

                case 5:

                    System.out.println("Clientes en espera: "
                            + banco.cantidadClientes());

                    break;

                case 6:

                    banco.vaciarCola();

                    System.out.println("La cola fue vaciada.");

                    break;

                case 7:

                    banco.guardarCola("clientes.dat");

                    System.out.println("Saliendo del sistema...");

                    break;

                default:

                    System.out.println("Opción inválida.");
            }

        } while (opcion != 7);

        sc.close();
    }
}