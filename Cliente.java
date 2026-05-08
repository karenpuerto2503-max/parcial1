package Modelo;

import java.io.Serializable;
import java.time.LocalTime;

public class Cliente implements Serializable {

    private String nombre;
    private String identificacion;
    private String tipoTransaccion;
    private LocalTime horaLlegada;
    private boolean prioridad;

    public Cliente(String nombre, String identificacion,
                   String tipoTransaccion,
                   LocalTime horaLlegada,
                   boolean prioridad) {

        setNombre(nombre);
        setIdentificacion(identificacion);
        setTipoTransaccion(tipoTransaccion);

        this.horaLlegada = horaLlegada;
        this.prioridad = prioridad;
    }

    // VALIDACIONES

    public void setNombre(String nombre) {

        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }

        this.nombre = nombre;
    }

    public void setIdentificacion(String identificacion) {

        if (!identificacion.matches("\\d+")) {
            throw new IllegalArgumentException("La identificación debe tener solo números");
        }

        this.identificacion = identificacion;
    }

    public void setTipoTransaccion(String tipoTransaccion) {

        if (!tipoTransaccion.equalsIgnoreCase("Depósito") &&
            !tipoTransaccion.equalsIgnoreCase("Retiro") &&
            !tipoTransaccion.equalsIgnoreCase("Consulta") &&
            !tipoTransaccion.equalsIgnoreCase("Pago")) {

            throw new IllegalArgumentException("Tipo de transacción inválido");
        }

        this.tipoTransaccion = tipoTransaccion;
    }

    // GETTERS

    public String getNombre() {
        return nombre;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public String getTipoTransaccion() {
        return tipoTransaccion;
    }

    public LocalTime getHoraLlegada() {
        return horaLlegada;
    }

    public boolean isPrioridad() {
        return prioridad;
    }

    @Override
    public String toString() {

        return "\nNombre: " + nombre +
               "\nIdentificación: " + identificacion +
               "\nTransacción: " + tipoTransaccion +
               "\nHora llegada: " + horaLlegada +
               "\nPrioridad: " + prioridad +
               "\n---------------------------";
    }
}