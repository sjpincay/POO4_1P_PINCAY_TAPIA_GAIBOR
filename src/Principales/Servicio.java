
package Principales;

import ManejoArchivos.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * La clase Servicio es una clase abstracta que representa un servicio en el sistema.
 */
public class  Servicio {
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
    
    //para pagar con efectivo
    public static double calcularValorPagar(double valorP){
        double preciof = valorP;
        return preciof;
    }
    
    //para pagar con tarjeta
    public static double calcularValorPagar(double valorP, double impuesto){
        double total = impuesto * valorP;
        return total;
    }
    
    public static String metodoPago(){
        String metodo="";
        double valor=0;
        int validar=1;
        Scanner sc =new Scanner(System.in);
        while (validar!=0){
            System.out.println("Elija una opción de pago:\n1.Pago en efectivo\n2.Pago con tarjeta\nIngrese una opcion:");
            int op =sc.nextInt();
            sc.nextLine();
            switch (op){
                case 1:
                    valor = calcularValorPagar(valorP);
                    validar=0;
                    metodo= "Pago en efectivo";
                    break;
                case 2:
                    double incremento = 0.50;
                    valor = calcularValorPagar(valorP,incremento);
                    validar=0;
                    metodo="Pago con trajeta";
                    break;
                default:
                    System.out.println("Opcion Incorrecta. Vuelva a elegir\n");
                    validar=1;
            }
        }
        valorP=valor;
    return metodo;
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
    
    public String asignarConductor(String tipoVehiculo){
        String conductor = "";
        String nombreArchivo = "conductor.txt";

        ArrayList<String> lineas = ManejoArchivos.LeeFichero(nombreArchivo);
        for (String linea : lineas) {
            String[] datos = linea.split(",");
            if (datos[3].equals("D")) {
                String tipo = Conductor.tipo("vehiculo.txt", datos[4]);
                if (tipo.equals(tipoVehiculo)) {
                    conductor = datos[0];
                }
            }
        }
        return conductor;
    }
 
    @Override
    public String toString() {
        return "\nConductor: " + conductor + "\nFecha: " + datePago + "\nValor a pagar: " + valorP + "\nCodigo: " + codigo;
    }
     
}
