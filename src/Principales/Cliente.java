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
    private int edad;
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
    public Cliente(String cedula,String nombre, String apellido,String user, String contraseña,String numCelular,int edad,String tarjetaCredito){
        super(cedula,nombre,apellido, user,contraseña,numCelular);
        this.edad=edad;
        this.tarjetaCredito=tarjetaCredito;
    }
    @Override
    public void consultarServicio() {
        
    }
    
    
}
