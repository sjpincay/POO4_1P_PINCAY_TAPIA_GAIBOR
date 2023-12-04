/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Principales;

import Enum.TipoPago;
import java.time.LocalDate;

/**
 * La clase Pagos representa un pago en el sistema.
 */
public class Pagos {
    /**
     * declaracion de las variables
     */
    private int idPago;
    private LocalDate datePago;
    private Servicio servicio;
    private Cliente cliente;
    private TipoPago metodoPago;
    private double valorPagar;
    public static int codigo = 0;

    /**
     * Constructor de la clase Pagos.
     *
     * @param servicio El servicio asociado al pago.
     * @param cliente El cliente que realiza el pago.
     * @param metodoPago El método de pago utilizado.
     * @param valorPagar El valor a pagar.
     * @param datePago La fecha del pago.
     */
    public Pagos(Servicio servicio, Cliente cliente, TipoPago metodoPago, double valorPagar, LocalDate datePago) {
        Pagos.codigo++;
        this.idPago = Pagos.codigo;
        this.servicio = servicio;
        this.cliente = cliente;
        this.metodoPago = metodoPago;
        this.valorPagar = valorPagar;
        this.datePago = datePago;
    }
    /**
     * 
     * @param idPago 
     */
    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }
    /**
     * 
     * @param datePago 
     */
    public void setDatePago(LocalDate datePago) {
        this.datePago = datePago;
    }
    /**
     * 
     * @param servicio 
     */
    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }
    /**
     * 
     * @param cliente 
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * @return El ID del pago.
     */
    public int getIdPago() {
        return idPago;
    }

    /**
     * @return La fecha del pago.
     */
    public LocalDate getDatePago() {
        return datePago;
    }
    /**
     * 
     * @return 
     */
    public TipoPago getMetodoPago() {
        return metodoPago;
    }
    /**
     * 
     * @param metodoPago 
     */
    public void setMetodoPago(TipoPago metodoPago) {
        this.metodoPago = metodoPago;
    }
    /**
     * 
     * @return 
     */
    public double getValorPagar() {
        return valorPagar;
    }
    /**
     * 
     * @param valorPagar 
     */
    public void setValorPagar(double valorPagar) {
        this.valorPagar = valorPagar;
    }
    /**
     * 
     * @return 
     */
    public static int getCodigo() {
        return codigo;
    }
    /**
     * 
     * @param codigo 
     */
    public static void setCodigo(int codigo) {
        Pagos.codigo = codigo;
    }

    /**
     * @return El servicio asociado al pago.
     */
    public Servicio getServicio() {
        return servicio;
    }

    /**
     * @return El cliente que realizó el pago.
     */
    public Cliente getCliente() {
        return cliente;
    }
    /**
     * 
     * @return 
     */
    @Override
    public String toString() {
        return "Pagos{" + "idPago=" + idPago + ", datePago=" + datePago + ", servicio=" + servicio + ", cliente=" + cliente + ", metodoPago=" + metodoPago + ", valorPagar=" + valorPagar + '}';
    }
}
