/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Principales;

import Enum.TipoUsuario;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author sjpin
 */
public class Cliente extends Usuario{

    private int edad;
    private String tarjetaCredito;
    private ArrayList<Usuario> usuarios;
    private TipoUsuario tipoUsuario;
    
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
    
    public int getEdad() {
        return edad;
    }

    public String getTarjetaCredito() {
        return tarjetaCredito;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setTarjetaCredito(String tarjetaCredito) {
        this.tarjetaCredito = tarjetaCredito;
    }
    
    @Override
    public void consultarServicio() {
        for(Usuario user:usuarios ){
            System.out.println(user);
        }
    }
    
    public void mostrarDatos(){
        
    }
    
    public int seleccionarOpcion() {
        int opcion = 0;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("+++++++MENÚ+++++++");
            System.out.println("1. Consultar Servicio");
            System.out.println("2. Datos Vehiculo");
            System.out.println("Por favor, elige una opción:");
            opcion = sc.nextInt();
        } while (opcion > 2 || opcion < 1);
        return opcion;
    }
    
}
