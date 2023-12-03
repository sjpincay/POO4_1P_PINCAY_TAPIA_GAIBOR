
package Principales;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Random;

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
        String conductor="";
        String nombrearchivo="conductor.txt";
        File archivo = null;
        FileReader FR = null;
        BufferedReader BR = null;

        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File(nombrearchivo);
            FR = new FileReader(archivo,StandardCharsets.UTF_8);
            BR = new BufferedReader(FR);

            // Lectura del fichero
            String linea;
            while ((linea = BR.readLine()) != null) {
                String[] datos=linea.split(",");
                if (datos[3].equals("D")){
                    String tipo = Conductor.tipo("vehiculo.txt", datos[4]);
                    if (tipo.equals(tipoVehiculo)){
                       conductor=datos[0]; 
                    }
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta 
            // una excepcion.
            try {
                if (null != FR) {
                    FR.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        
        
        this.conductor=conductor;
        return conductor;
    }
 
    @Override
    public String toString() {
        return "\nConductor: " + conductor + "\nFecha: " + datePago + "\nValor a pagar: " + valorP + "\nCodigo: " + codigo;
    }
     
}
