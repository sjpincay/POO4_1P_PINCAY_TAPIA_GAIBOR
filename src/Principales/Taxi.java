
package Principales;

import java.util.Random;
    import Enum.TipoPago;
    import java.util.Scanner;
import ManejoArchivos.ManejoArchivos;


public class Taxi extends Servicio {
    Random rd = new Random();
    private int cantidadPersonas;
    final private double COSTOKM = 0.50 ;
    private int valorAle = rd.nextInt(41)+5;
    private double total = valorAle * COSTOKM;

    public Taxi(Conductor conductorAsignado, int cantidadPersonas) {
        super(conductorAsignado);
        this.cantidadPersonas = cantidadPersonas;
    }

    public int getCantidadPersonas() {
        return cantidadPersonas;
    }

    public void setCantidadPersonas(int cantidadPersonas) {
        this.cantidadPersonas = cantidadPersonas;
    }

    public int getValorAle() {
        return valorAle;
    }

    public void setValorAle(int valorAle) {
        this.valorAle = valorAle;
    }

    @Override
    public String toString() {
        return "Taxi{" + "cantidadPersonas=" + cantidadPersonas + '}';
    }
   
    
    
    
    
    
    
    @Override
     public void calcularValorAPagar(){
          double total = valorAle * COSTOKM;
          System.out.println("el valor a pagar es:"+total);
     }
          
           public void calcularValorAPagar(TipoPago tarjeta){
               double total = valorAle * COSTOKM +(valorAle * COSTOKM) * 0.15;
               System.out.println("el valor a pagar con tarjeta es:"+total);
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
     
     
     public void guardarEnArchivo(){
        String datosServicio = "numero de pasajeros" + cantidadPersonas + "distanciaKM"+valorAle+"subtotal"+total;
        ManejoArchivos.EscribirArchivo("viajes.txt", datosServicio);
     }
}

