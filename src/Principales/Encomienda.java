
package Principales;
import Enum.TipoEncomienda;
import Enum.TipoVehiculo;

public class Encomienda extends Servicio {
    private int cantidadProducto;
    private double peso;
    private TipoEncomienda tipoEncomienda;

    public Encomienda(Conductor conductorAsignado) {
        super(conductorAsignado);
    }
    
    
    
    
    
    
    @Override
    public void calcularValorAPagar(){
        double total = 0.0;
        total = 1 + 4.0;
        System.out.println("el valor a pagar es:"+ total);
        
    }
    
    
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
