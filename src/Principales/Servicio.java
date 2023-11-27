
package Principales;

import java.util.ArrayList;

/**
 * La clase Servicio es una clase abstracta que representa un servicio en el sistema.
 */
public abstract class  Servicio {
    private Conductor conductorAsignado;
    private ArrayList<Servicio> servicios;
    /**
     * Constructor de la clase Servicio.
     *
     * @param conductorAsignado El conductor asignado al servicio.
     */
    public Servicio(Conductor conductorAsignado) {
        this.conductorAsignado = conductorAsignado;
        this.servicios = new ArrayList<>();
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
    public ArrayList<Servicio> getServicios() {
        return servicios;
    }
        
    
     
}
