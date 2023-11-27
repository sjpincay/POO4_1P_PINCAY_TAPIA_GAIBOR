
package Principales;
import Enum.TipoEncomienda;
import Enum.TipoVehiculo;
/**
 * La clase Encomienda hereda de la clase Servicio y representa un servicio de encomienda en el sistema.
 */
public class Encomienda extends Servicio {
    private int cantidadProducto;
    private double peso;
    private TipoEncomienda tipoEncomienda;
    /**
     * Constructor de la clase Encomienda.
     *
     * @param conductorAsignado El conductor asignado a la encomienda.
     */
    public Encomienda(Conductor conductorAsignado) {
        super(conductorAsignado);
    }
    
    
    
    
    
    /**
     * Calcula el valor a pagar por la encomienda.
     */    
    @Override
    public void calcularValorAPagar(){
        double total = 0.0;
        total = 1 + 4.0;
        System.out.println("el valor a pagar es:"+ total);
        
    }
    
    /**
     * Método para crear un servicio de encomienda
     * Este método está comentado actualmente.
     */ 
//         public void crearServicioEncomienda(){
//         Conductor conductorSeleccionado = seleccionarConductorDisponible();
//         Vehiculo vehiculog = esAutoOMoto();
//        if (vehiculog.equals(TipoVehiculo.M)){
//          if (conductorSeleccionado != null ) {
//              System.out.println("Servicio de taxi creado con el conductor: " + conductorSeleccionado.getNombre());
//          } else {
//            System.out.println("No hay conductores disponibles con autos en este momento.");
//        }
//     }
//    }
}
