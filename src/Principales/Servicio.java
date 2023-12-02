
package Principales;

import java.util.ArrayList;
import java.util.Random;

/**
 * La clase Servicio es una clase abstracta que representa un servicio en el sistema.
 */
public abstract class  Servicio {
    protected String codigo;
    protected String conductor;
    protected String Pinicio,Pfin,datePago;
    protected static double valorP;
    Random r = new Random();
    /**
     * Constructor de la clase Servicio.
     *
     * @param conductorAsignado El conductor asignado al servicio.
     */ 
    public Servicio(String Pinicio, String Pfin ,String datePago) {
        this.Pinicio = Pinicio;
        this.Pfin = Pfin;
        this.datePago= datePago;
        this.valorP = r.nextDouble(41)+5;
        this.codigo=String.valueOf((int)(Math.random()*10000));
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getConductor() {
        return conductor;
    }

    public void setConductor(String conductor) {
        this.conductor = conductor;
    }

    public String getPinicio() {
        return Pinicio;
    }

    public void setPinicio(String Pinicio) {
        this.Pinicio = Pinicio;
    }

    public String getPfin() {
        return Pfin;
    }

    public void setPfin(String Pfin) {
        this.Pfin = Pfin;
    }

    public String getDatePago() {
        return datePago;
    }

    public void setDatePago(String datePago) {
        this.datePago = datePago;
    }

    
    
    /**
     * Método abstracto para calcular el valor a pagar por el servicio.
     * Este método debe ser implementado en las clases que hereden de Servicio.
     */ 
    public abstract void calcularValorAPagar();
    /**
     * Obtiene la lista de servicios.
     *
     * @return La lista de servicios.
     */

        
    @Override
    public String toString() {
        return "\nConductor: " + conductor + "\nFecha: " + datePago + "\nValor a pagar: " + valorP + "\nCodigo: " + codigo;
    }
     
}
