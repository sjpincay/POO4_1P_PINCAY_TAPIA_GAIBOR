
package Principales;

import java.time.LocalDate;
import java.util.Date;
import java.util.Random;

/**
 * La clase Servicio es una clase abstracta que representa un servicio en el sistema.
 * @author sjpin
 */

public abstract class  Servicio {
    /**
     * 
     * @return 
     */
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
    /**
     * 
     * @return 
     */
    public String getOrigen() {
        return origen;
    }
    /**
     * 
     * @param origen 
     */
    public void setOrigen(String origen) {
        this.origen = origen;
    }
    /**
     * 
     * @return 
     */
    public String getDestino() {
        return destino;
    }
    /**
     * 
     * @param destino 
     */
    public void setDestino(String destino) {
        this.destino = destino;
    }
    /**
     * 
     * @return 
     */
    public LocalDate getFecha() {
        return fecha;
    }
    /**
     * 
     * @param fecha 
     */
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    /**
     * 
     * @return 
     */
    public Conductor getConductorAsignado() {
        return conductorAsignado;
    }
    /**
     * 
     * @param conductorAsignado 
     */
    public void setConductorAsignado(Conductor conductorAsignado) {
        this.conductorAsignado = conductorAsignado;
    }
    /**
     * 
     * @return 
     */
    public double getValorAPagar() {
        return valorAPagar;
    }
    /**
     * 
     * @param valorAPagar 
     */
    public void setValorAPagar(double valorAPagar) {
        this.valorAPagar = valorAPagar;
    }
    /**
     * 
     * @return 
     */
    public String getID() {
        return ID;
    }
    /**
     * 
     * @param ID 
     */
    public void setID(String ID) {
        this.ID = ID;
    }
    /**
     * 
     * @return 
     */
    @Override
    public String toString() {
        return "Servicio{" + "ID=" + ID + ", origen=" + origen + ", destino=" + destino + ", fecha=" + fecha + ", conductorAsignado=" + conductorAsignado + ", valorAPagar=" + valorAPagar + '}';
    }

    /**
     * Método abstracto para calcular el valor a pagar por el servicio.
     * Este método debe ser implementado en las clases que hereden de Servicio.
     */ 
    public abstract void calcularValorAPagar();
    /**
     * metodo abstracto para mostrar la informacion
     */
    public abstract void mostrarInformacion();
}


