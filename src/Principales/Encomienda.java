
package Principales;
import Enum.TipoEncomienda;
import Enum.TipoVehiculo;
import java.util.Scanner;
import ManejoArchivos.*;

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



    public Encomienda( String Pinicio, String Pfin, String datePago,int cantidadProducto,TipoEncomienda tipoEncomienda) {
        super(Pinicio, Pfin, datePago);
        this.cantidadProducto = cantidadProducto;
        this.tipoEncomienda = tipoEncomienda;
    }

    public int getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(int cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public TipoEncomienda getTipoEncomienda() {
        return tipoEncomienda;
    }

    public void setTipoEncomienda(TipoEncomienda tipoEncomienda) {
        this.tipoEncomienda = tipoEncomienda;
    }

    @Override
    public String toString() {
        return super.toString() + "\nCantidad de productos: " + cantidadProducto + "\nTipo de encomienda: " + tipoEncomienda;
    }
    
    private static TipoEncomienda tipoEncomienda() {
        Scanner sc = new Scanner(System.in);
        int ingreso = 5;
        TipoEncomienda tipo = TipoEncomienda.MEDICAMENTO;
        while (ingreso != 0) {
            System.out.println("Seleccione una opcion\n1.Medicamentos\n2.Documentos\nIngrese una opcion:");
            int opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    ingreso = 0;
                    return tipo = TipoEncomienda.MEDICAMENTO;
                    
                case 2:
                    ingreso = 0;
                    return tipo = TipoEncomienda.DOCUMENTOS;
                default:
                    System.out.println("Opcion no permitida. Intentelo de nuevo\n");
                    ingreso = 5;
                    break;
            }
        }
        return tipo;
    }
        
        
public static void crearSvEncomienda(Cliente cliente) {
    Scanner sc = new Scanner(System.in);
    int validar;
    do {
        System.out.println("Ingrese ubicacion:");
        String ubicacion = sc.nextLine();
        System.out.println("Ingrese destino:");
        String destino = sc.nextLine();
        System.out.println("Ingrese fecha(dd/mm/aaaa):");
        String fecha = sc.nextLine();
        System.out.println("Ingrese hora(hh:mm):");
        String hora = sc.nextLine();
        TipoEncomienda tipo = tipoEncomienda();
        System.out.println("Ingrese la cantidad:");
        int cantidad = sc.nextInt();
        sc.nextLine();
        String metodo = Servicio.metodoPago();//AGREGAR METODO PAGO A SERVICIO
        System.out.println("¿Generar el servicio? (si/no)");
        String confirmacion = sc.nextLine();
        String confirmado = confirmacion.toLowerCase();
        if (confirmado.equals("si")) {
            Servicio encomienda = new Encomienda(ubicacion,destino,fecha, cantidad, tipo);
            String tipoVehiculo = "M";
            String conductor = encomienda.asignarConductor(tipoVehiculo); //AGREGAR METODO ASIGNARCONDUCTOR
            String linea = encomienda.getCodigo() + "," + cliente.getNombre() + "," + conductor + "," + encomienda.getPinicio() + "," + encomienda.getPfin() + "," + encomienda.getDatePago() + "," + hora + ","+tipo+","+cantidad+","+ metodo + "," + encomienda.getValorP();
            ManejoArchivos.EscribirArchivo("encomiendas.txt", linea);
            System.out.println("**=============Factura=============**\n" + encomienda.toString() + "\n\n");
            Servicio enco = (Servicio) encomienda;
            cliente.setListaServicio(enco);
            System.out.println("¿Solicitar otro Servicio? (si/no): ");
            String validacion = sc.nextLine();
            String comprobar = validacion.toLowerCase();
            if (comprobar.equals("si")) {
                validar = 1;
            } else {
                validar = 0;
            }
        } else {
            validar = 1;
        }
    } while (validar == 1);
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
    
}
