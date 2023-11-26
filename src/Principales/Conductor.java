/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Principales;

/**
 *
 * @author sjpin
 */
public class Conductor extends Usuario{
    private String numLicencia;
    private Vehiculo vehiculo;
    
    public Conductor(String cedula,String nombre, String apellido,int edad,String user, String contraseña,String numCelular,String numLicencia,Vehiculo vehiculo){
       super(cedula,nombre, apellido,edad, user,contraseña,numCelular);
       this.numLicencia= numLicencia;
       this.vehiculo= vehiculo;
    }
    public String getNumLicencia() {
        return numLicencia;
    }

    public void setNumLicencia(String numLicencia) {
        this.numLicencia = numLicencia;
    }

    @Override
    public void consultarServicio() {
    }
    
}
