/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Principales;

import Enum.TipoUsuario;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * La clase Cliente hereda de la clase Usuario y representa a un cliente en el sistema.
 */
public class Cliente extends Usuario{

    private int edad;
    private String tarjetaCredito;
    private ArrayList<Usuario> usuarios;
    private TipoUsuario tipoUsuario;
    private ArrayList<Servicio> listaServicio = new ArrayList();
    
    
    /**
     * Constructor de la clase Cliente.
     *
     * @param cedula La cédula del cliente.
     * @param nombre El nombre del cliente.
     * @param apellido El apellido del cliente.
     * @param user El nombre de usuario del cliente.
     * @param edad La edad del cliente.
     * @param contraseña La contraseña del cliente.
     * @param numCelular El número de celular del cliente.
     * @param tarjetaCredito El número de la tarjeta de crédito del cliente.
     */
    public Cliente(String cedula,String nombre, String apellido,String user, String contraseña,String numCelular,int edad,String tarjetaCredito){
        super(cedula,nombre,apellido, user,contraseña,numCelular);
        this.edad=edad;
        this.tarjetaCredito=tarjetaCredito;
    }
    
    /**
     * Obtiene la edad del cliente.
     *
     * @return La edad del cliente.
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Obtiene el número de la tarjeta de crédito del cliente.
     *
     * @return El número de la tarjeta de crédito del cliente.
     */
    public String getTarjetaCredito() {
        return tarjetaCredito;
    }
    /**
     * Establece la edad del cliente.
     *
     * @param edad La nueva edad del cliente.
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }
    /**
     * Establece el número de la tarjeta de crédito del cliente.
     *
     * @param tarjetaCredito El nuevo número de la tarjeta de crédito del cliente.
     */
    public void setTarjetaCredito(String tarjetaCredito) {
        this.tarjetaCredito = tarjetaCredito;
    }
    /**
     * Consulta los servicios disponibles para el cliente.
     */    
    @Override
    public void consultarServicio() {
        for(Usuario user:usuarios ){
            System.out.println(user);
        }
    }
    
    public void mostrarDatos(){
        System.out.println();
    }
    
    
    public ArrayList<Servicio> getListaServicio() {
        return listaServicio;
    }    
    
    public void setListaServicio(Servicio servicio) {
        this.listaServicio.add(servicio);
    }
    
    /**
     * Permite al cliente seleccionar una opción del menú.
     *
     * @return La opción seleccionada por el cliente.
     */    
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
