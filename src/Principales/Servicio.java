
package Principales;

import java.util.ArrayList;


public abstract class  Servicio {
    private Conductor conductorAsignado;
    private ArrayList<Servicio> servicios;

    public Servicio(Conductor conductorAsignado) {
        this.conductorAsignado = conductorAsignado;
        this.servicios = new ArrayList<>();
    }
    
    
    
    
    public abstract void calcularValorAPagar();

    public ArrayList<Servicio> getServicios() {
        return servicios;
    }
        
    
     
}
