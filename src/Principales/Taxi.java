
package Principales;

import java.util.Random;
import Enum.TipoPago;
import java.util.Scanner;
import java.time.LocalDate;
import ManejoArchivos.ManejoArchivos;
/**
 * 
 * @author sjpin
 * 
 * La clase Taxi representa el vehiculo donde van hay especificaciones 
 * de pasajeros, hora, forma de pago y recorrido
 */
public class Taxi extends Servicio {
    /**
     * declaracion de varibales
     */
    private int cantidadPersonas;
    private int hora;
    private TipoPago formaPago;
    private int valorAleKM;
    final private double COSTOKM;
    /**
     * Constructor de la clase Taxi
     * @param origen
     * @param destino
     * @param fecha
     * @param conductorAsignado
     * @param cantidadPersonas
     * @param hora
     * @param formaPago 
     */
    public Taxi(String origen, String destino, LocalDate fecha, Conductor conductorAsignado, int cantidadPersonas, int hora, TipoPago formaPago) {
        super(origen, destino, fecha, conductorAsignado);
        this.cantidadPersonas = cantidadPersonas;
        this.hora = hora;
        this.formaPago = formaPago;
        Random rd = new Random();
        this.valorAleKM = rd.nextInt(41) + 5;
        this.COSTOKM = 0.50;
    }
    /**
     * 
     * @return 
     */
    public int getCantidadPersonas() {
        return cantidadPersonas;
    }
    /**
     * 
     * @param cantidadPersonas 
     */
    public void setCantidadPersonas(int cantidadPersonas) {
        this.cantidadPersonas = cantidadPersonas;
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
    public TipoPago getFormaPago() {
        return formaPago;
    }
    /**
     * 
     * @param formaPago 
     */
    public void setFormaPago(TipoPago formaPago) {
        this.formaPago = formaPago;
    }
    /**
     * 
     * @return 
     */
    public int getValorAleKM() {
        return valorAleKM;
    }
    /**
     * 
     * @param valorAleKM 
     */
    public void setValorAleKM(int valorAleKM) {
        this.valorAleKM = valorAleKM;
    }
    /**
     * 
     * @return 
     */
    @Override
    public String toString() {
        return "Taxi{" + "cantidadPersonas=" + cantidadPersonas + ", hora=" + hora + ", formaPago=" + formaPago + ", COSTOKM=" + COSTOKM + '}';
    }
    /**
     * metodo que calcula el valor a pagar por km
     */
    @Override
    public void calcularValorAPagar() {
        double total = this.getValorAleKM() * COSTOKM;
        this.setValorAPagar(total);
    }
    /**
     * 
     * @param tipo 
     */
    public void calcularValorAPagar(TipoPago tipo) {
        if (tipo == TipoPago.E) {
            double total = this.getValorAleKM() * COSTOKM;
            this.setValorAPagar(total);
        }else {
            double total = this.getValorAleKM() * COSTOKM + (this.getValorAleKM() * COSTOKM) * 0.15;
            this.setValorAPagar(total);
        }
    }
    /**
     * 
     * @return 
     */
    public boolean confirmarViaje() {
        Scanner entrada = new Scanner(System.in);
        boolean confViaje = false;
        String respuesta;
        do {
            System.out.print("¿Desea confirmar su viaje? (s/n): ");
            respuesta = entrada.next();
            entrada.nextLine();
            if (respuesta.equals("s")) {
                confViaje = true;

            } else{
                confViaje = false;
                System.out.println("Se ha cancelado el viaje. Volviendo al menú inicial.");
            }
        } while (!(respuesta.equals("s")) && !(respuesta.equals("n")));
        return confViaje;
    }
    /**
     * Este metodo guarda los viajes ingresados por el usuario
     */
    public void escribirArchivoViaje() {
        String lineaAEscribir = this.getID() + "," + this.getCantidadPersonas() + "," + this.getValorAleKM() + "," + this.getValorAPagar();
        ManejoArchivos.EscribirArchivo("viajes.txt", lineaAEscribir);
    }
    /**
     * muestra la información del viaje
     */
    @Override
    public void mostrarInformacion(){
        System.out.println();
        System.out.println("/**************************************/");
        System.out.println("Tipo: Viaje");
        System.out.println("Pasajeros: " + Integer.toString(this.getCantidadPersonas()));
        System.out.println("Fecha: " + this.getFecha().toString());
        System.out.println("Hora: " + Integer.toString(this.getHora()) + ":00");
        System.out.println("Origen: " + this.getOrigen());
        System.out.println("Destino: " + this.getDestino());
        System.out.println("Valor a Pagar: " + Double.toString(this.getValorAPagar()));
        System.out.println();
    }
}