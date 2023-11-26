/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Principales;
import Enum.EstadoConductor;
/**
 *
 * @author sjpin
 */
public class Conductor extends Usuario{
    private String numLicencia;
    private Vehiculo vehiculo;
    private EstadoConductor estadoConductor;

    public Conductor(String numLicencia, Vehiculo vehiculo, EstadoConductor estadoConductor, String cedula, String nombre, String apellido, int edad, String user, String contraseña, String numCelular) {
        super(cedula, nombre, apellido, edad, user, contraseña, numCelular);
        this.numLicencia = numLicencia;
        this.vehiculo = vehiculo;
        this.estadoConductor = estadoConductor;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }
    
    public String getNumLicencia() {
        return numLicencia;
    }

    public void setNumLicencia(String numLicencia) {
        this.numLicencia = numLicencia;
    }

    public EstadoConductor getEstadoConductor() {
        return estadoConductor;
    }
    
    @Override
    public void consultarServicio() {
    }
    
}