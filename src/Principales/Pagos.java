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

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    public void setDatePago(LocalDate datePago) {
        this.datePago = datePago;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * Obtiene el ID del pago.
     *
     * @return El ID del pago.
     */
    public int getIdPago() {
        return idPago;
    }

    /**
     * Obtiene la fecha del pago.
     *
     * @return La fecha del pago.
     */
    public LocalDate getDatePago() {
        return datePago;
    }

    public TipoPago getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(TipoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

    public double getValorPagar() {
        return valorPagar;
    }

    public void setValorPagar(double valorPagar) {
        this.valorPagar = valorPagar;
    }

    public static int getCodigo() {
        return codigo;
    }

    public static void setCodigo(int codigo) {
        Pagos.codigo = codigo;
    }

    /**
     * Obtiene el servicio asociado al pago.
     *
     * @return El servicio asociado al pago.
     */
    public Servicio getServicio() {
        return servicio;
    }

    /**
     * Obtiene el cliente que realizó el pago.
     *
     * @return El cliente que realizó el pago.
     */
    public Cliente getCliente() {
        return cliente;
    }

    @Override
    public String toString() {
        return "Pagos{" + "idPago=" + idPago + ", datePago=" + datePago + ", servicio=" + servicio + ", cliente=" + cliente + ", metodoPago=" + metodoPago + ", valorPagar=" + valorPagar + '}';
    }
}
