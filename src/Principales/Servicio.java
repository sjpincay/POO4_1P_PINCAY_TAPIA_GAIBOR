
package Principales;

import java.time.LocalDate;
import java.util.Date;
import java.util.Random;

/**
 * La clase Servicio es una clase abstracta que representa un servicio en el sistema.
 */

public abstract class  Servicio {
    
    public static String generateRandomId() {
        StringBuilder idBuilder = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            // Asegurar el primer digito no es cero
            if (i == 0) {
                idBuilder.append(random.nextInt(9) + 1);
            } else {
                idBuilder.append(random.nextInt(10));
            }
        }

        return idBuilder.toString();
    }
    
    private String ID;
    private String origen;
    private String destino;
    private LocalDate fecha;
    private Conductor conductorAsignado;
    private double valorAPagar;
    /**
     * Constructor de la clase Servicio.
     *
     * @param origen
     * @param destino
     * @param fecha
     * @param conductorAsignado El conductor asignado al servicio.
     * @param valorAPagar
     */ 
    public Servicio(String origen, String destino, LocalDate fecha, Conductor conductorAsignado) {
        this.ID = generateRandomId();
        this.origen = origen;
        this.destino = destino;
        this.fecha = fecha;
        this.conductorAsignado = conductorAsignado;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Conductor getConductorAsignado() {
        return conductorAsignado;
    }

    public void setConductorAsignado(Conductor conductorAsignado) {
        this.conductorAsignado = conductorAsignado;
    }

    public double getValorAPagar() {
        return valorAPagar;
    }

    public void setValorAPagar(double valorAPagar) {
        this.valorAPagar = valorAPagar;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    @Override
    public String toString() {
        return "Servicio{" + "ID=" + ID + ", origen=" + origen + ", destino=" + destino + ", fecha=" + fecha + ", conductorAsignado=" + conductorAsignado + ", valorAPagar=" + valorAPagar + '}';
    }

    /**
     * Método abstracto para calcular el valor a pagar por el servicio.
     * Este método debe ser implementado en las clases que hereden de Servicio.
     */ 
    public abstract void calcularValorAPagar();
    
    public abstract void mostrarInformacion();
}


