
package Principales;

import java.util.Random;
    import Enum.TipoPago;
    import java.util.Scanner;


public class Taxi extends Servicio {
    
    private int cantidadPersonas;
    final private double COSTOKM = 0.50 ;
    
    
   
    
   
    
    
    
    public int valorAleatorio(){
        Random random = new Random();
        int valorAle = random.nextInt(41) + 5;
        return valorAle;
    }
    
    //override
     public double calcularValorAPagar(TipoPago tipoP){
          double total = 0.0;
          
          switch (tipoP) {
              case E:
                  total = valorAleatorio() * COSTOKM;
                  break;
              case TC:
                  total = valorAleatorio() * COSTOKM +(valorAleatorio() * COSTOKM) * 0.15;
                  break;
          }
          
        return total; 
    }
     
     
     public boolean confirmarViaje(){
         Scanner entrada = new Scanner(System.in);
         boolean confViaje = false;
       
         do {
            System.out.print("¿Desea confirmar su viaje? (Sí/No): ");
            String respuesta = entrada.nextLine().trim().toLowerCase();
            
            if (respuesta.equals("si") || respuesta.equals("sí")) {
                confViaje = true;
                
                } else if (respuesta.equals("no")) {
                confViaje = false;
                System.out.println("Se ha cancelado el viaje. Volviendo al menú inicial.");
                }
                } while (!confViaje);
         return confViaje;
     }
     
//     public void crearServicioTaxi(){
//         Conductor conductorSeleccionado = seleccionarConductorDisponible();
//          if (conductorSeleccionado != null) {
//              System.out.println("Servicio de taxi creado con el conductor: " + conductorSeleccionado.getNombre());
//          } else {
//            System.out.println("No hay conductores disponibles con autos en este momento.");
//        }
//     }
     
}

