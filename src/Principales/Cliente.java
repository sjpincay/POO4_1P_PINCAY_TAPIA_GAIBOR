/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Principales;
import java.util.ArrayList;

/**
 *
 * @author sjpin
 */
public class Cliente extends Usuario{

    private String tarjetaCredito;
    private ArrayList<Servicio> servicios;

    public Cliente(String cedula, int edad, String nombre, String apellido, String user, String contraseña, String numCelular) {
        super(cedula, edad, nombre, apellido, user, contraseña, numCelular);
        this.tarjetaCredito= tarjetaCredito;
    }
    
    public String getTarjetaCredito() {
        return tarjetaCredito;
    }

    public ArrayList<Servicio> getServicios() {
        return servicios;
    }

    public void setTarjetaCredito(String tarjetaCredito) {
        this.tarjetaCredito = tarjetaCredito;
    }

    public void setServicios(ArrayList<Servicio> servicios) {
        this.servicios = servicios;
    }

    @Override
    public void consultarServicio() {
        
    }
}
    