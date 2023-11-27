/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Principales;
import java.text.SimpleDateFormat;
import java.util.Date;
import Enum.TipoPago;
/**
 *
 * @author sjpin
 */
public class Pagos {
    private int idPago;
    private Date datePago;
    private Servicio servicio;
    private Cliente cliente;
    private TipoPago metodoPago;
    private String valorPagar;
    private static int codigo = 0;

    public Pagos( Servicio servicio, Cliente cliente,TipoPago metodoPago,String valorPagar,Date datePago) {
        this.idPago = codigo++;
        this.servicio = servicio;
        this.cliente = cliente;
        this.metodoPago = metodoPago;
        this.valorPagar = valorPagar;
        this.datePago = datePago;
    }
    
    public int getIdPago() {
        return idPago;
    }

    public Date getDatePago() {
        return datePago;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public Cliente getCliente() {
        return cliente;
    }
    
    public void calcularTotal() {
        String total = null;
        for (Servicio servicio : servicio.getServicios()) {
            total += servicio.calcularValorAPagar();
        }
        this.valorPagar = total;
    }

    @Override
    public String toString() {
        String factura = "Factura de Pago\n" +
                     "-------------------------------------------------\n" +
                     "ID de Pago: " + idPago + "\n" +
                     "Fecha de Pago: " + datePago + "\n" +
                     "Servicio: " + servicio + "\n" +
                     "Cliente: " + cliente + "\n" +
                     "Método de Pago: " + metodoPago + "\n" +
                     "Valor cancelado: " + valorPagar + "\n" +
                     "-------------------------------------------------\n";
        return factura;
    }
}

