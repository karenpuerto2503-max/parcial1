package Modelo;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Colabanco {

    private Queue<Cliente> cola;

    public Colabanco() {
        cola = new LinkedList<>();
    }

    // AGREGAR CLIENTE

    public void agregarCliente(Cliente cliente) {
        cola.offer(cliente);
    }

    // ATENDER CLIENTE

    public Cliente atenderCliente() {
        return cola.poll();
    }

    // VER SIGUIENTE CLIENTE

    public Cliente verSiguienteCliente() {
        return cola.peek();
    }

    // MOSTRAR FILA

    public void mostrarFila() {

        if (cola.isEmpty()) {
            System.out.println("No hay clientes en espera.");
            return;
        }

        System.out.println("\n===== CLIENTES EN ESPERA =====");

        for (Cliente cliente : cola) {
            System.out.println(cliente);
        }
    }

    // CANTIDAD DE CLIENTES

    public int cantidadClientes() {
        return cola.size();
    }

    // VACIAR COLA

    public void vaciarCola() {
        cola.clear();
    }

    // VERIFICAR SI ESTÁ VACÍA

    public boolean estaVacia() {
        return cola.isEmpty();
    }

    // GUARDAR COLA

    public void guardarCola(String archivo) {

        try (ObjectOutputStream salida =
                     new ObjectOutputStream(new FileOutputStream(archivo))) {

            salida.writeObject(new LinkedList<>(cola));

            System.out.println("Datos guardados correctamente.");

        } catch (IOException e) {
            System.out.println("Error al guardar la cola.");
        }
    }

    // CARGAR COLA

    @SuppressWarnings("unchecked")
    public void cargarCola(String archivo) {

        File file = new File(archivo);

        if (!file.exists()) {
            return;
        }

        try (ObjectInputStream entrada =
                     new ObjectInputStream(new FileInputStream(archivo))) {

            cola = (Queue<Cliente>) entrada.readObject();

            System.out.println("Cola cargada correctamente.");

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar la cola.");
        }
    }
}