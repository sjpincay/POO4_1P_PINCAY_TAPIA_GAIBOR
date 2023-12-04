package Principales;

import Enum.*;
import ManejoArchivos.ManejoArchivos;
import java.time.LocalDate;
import java.util.Scanner;

/**
 * La clase Encomienda hereda de la clase Servicio y representa un servicio de
 * encomienda en el sistema.
 *
 * @author sjpin
 */
public class Encomienda extends Servicio {
    /**
     * declaración de las variables
     */
    private int cantidadProducto;
    private double peso;
    private int hora;
    private TipoEncomienda tipoEncomienda;
    
    /**
     * Constructor de la clase Encomienda
     * @param cantidadProducto
     * @param peso
     * @param hora
     * @param tipoEncomienda
     * @param origen
     * @param destino
     * @param fecha
     * @param conductorAsignado 
     */
    public Encomienda(int cantidadProducto, double peso, int hora, TipoEncomienda tipoEncomienda, String origen, String destino, LocalDate fecha, Conductor conductorAsignado) {
        super(origen, destino, fecha, conductorAsignado);
        this.cantidadProducto = cantidadProducto;
        this.peso = peso;
        this.hora = hora;
        this.tipoEncomienda = tipoEncomienda;
    }
    /**
     * 
     * @return 
     */
    public int getHora() {
        return hora;
    }
    /**
     * 
     * @param hora 
     */
    public void setHora(int hora) {
        this.hora = hora;
    }
    /**
     * 
     * @return 
     */
    public int getCantidadProducto() {
        return cantidadProducto;
    }
    /**
     * 
     * @param cantidadProducto 
     */
    public void setCantidadProducto(int cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }
    /**
     * 
     * @return 
     */
    public double getPeso() {
        return peso;
    }
    /**
     * 
     * @param peso 
     */
    public void setPeso(double peso) {
        this.peso = peso;
    }
    /**
     * 
     * @return 
     */
    public TipoEncomienda getTipoEncomienda() {
        return tipoEncomienda;
    }
    /**
     * 
     * @param tipoEncomienda 
     */
    public void setTipoEncomienda(TipoEncomienda tipoEncomienda) {
        this.tipoEncomienda = tipoEncomienda;
    }
    /**
     * Calcula el valor a pagar por la encomienda.
     */
    @Override
    public void calcularValorAPagar() {
        double total;
        total = (1 * this.getCantidadProducto()) + 4.0;
        this.setValorAPagar(total);
    }
    /**
     * Calcula el valor a pagar por la encomienda
     * @param t es el tipo de pago
     */
    public void calcularValorAPagar(TipoPago t) {
        if (t == TipoPago.TC) {
            double total;
            total = (1 * this.getCantidadProducto()) + 4.0;
            double recargo = total * 0.15;
            total += recargo;
            this.setValorAPagar(total);
        } else {
            double total;
            total = (1 * this.getCantidadProducto()) + 4.0;
            this.setValorAPagar(total);
        }
    }
    /**
     * Confirma la encomienda con la opcion cancelar
     * @return verdadero si la encomineda está confirmada, y falso si se cancela
     */
    public boolean confirmarEncomienda(){
        Scanner entrada = new Scanner(System.in);
        boolean confEncomienda = false;
        String respuesta;
        do {
            System.out.print("¿Desea confirmar encomienda? (s/n): ");
            respuesta = entrada.next();
            entrada.nextLine();
            if (respuesta.equals("s")) {
                confEncomienda = true;

            } else{
                confEncomienda = false;
                System.out.println("Se ha cancelado el pedido. Volviendo al menú inicial.");
            }
        } while (!(respuesta.equals("s")) && !(respuesta.equals("n")));
        return confEncomienda;
    }
    /**
     * metodo escribirArchivoEncomienda escribe la información de la encomienda en el archivo encomiendas.txt
     */
    public void escribirArchivoEncomienda(){
        String lineaAEscribir = this.getID() + "," + this.getTipoEncomienda() + "," + Integer.toString(this.getCantidadProducto()) + "," + Double.toString(this.getPeso()) + "," + Double.toString(this.getValorAPagar());
        ManejoArchivos.EscribirArchivo("encomiendas.txt", lineaAEscribir);
    }
    
    /**
     * metodo que muestra la información de la encomienda
     */
    @Override
    public void mostrarInformacion() {
        System.out.println();
        System.out.println("/**************************************/");
        System.out.println("Tipo: Encomienda");
        System.out.println("Tipo encomienda: " + this.getTipoEncomienda());
        System.out.println("Cantidad: " + Integer.toString(this.getCantidadProducto()));
        System.out.println("Fecha: " + this.getFecha());
        System.out.println("Hora: " + Integer.toString(this.getHora()));
        System.out.println("Desde: " + this.getOrigen());
        System.out.println("Hasta: " + this.getDestino());
        System.out.println("Valor a pagar: " + Double.toString(this.getValorAPagar()));
        System.out.println();
    }
}
