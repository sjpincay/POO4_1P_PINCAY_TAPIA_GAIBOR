/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Principales;

/**
 *
 * @author sjpin
 */
public class Cliente extends Usuario{
    
    private String tarjetaCredito;
    
    /**
     *
     * @param cedula
     * @param nombre
     * @param apellido
     * @param user
     * @param edad
     * @param contraseña
     * @param numCelular
     * @param tarjetaCredito
     */
    public Cliente(String cedula,String nombre, String apellido,int edad,String user, String contraseña,String numCelular,String tarjetaCredito){
        super(cedula,nombre, apellido,edad, user,contraseña,numCelular);
        this.tarjetaCredito=tarjetaCredito;
    }
    @Override
    public void consultarServicio() {
        
    }
    
    
}
