/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Principales;

import Enum.TipoUsuario;
import java.util.ArrayList;
import java.util.Scanner;
import ManejoArchivos.*;

/**
 * La clase Cliente hereda de la clase Usuario y representa a un cliente en el sistema.
 */
public class Cliente extends Usuario{

    private String tarjetaCredito;
    private ArrayList<Usuario> usuarios;
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
    public Cliente(String tarjetaCredito, String cedula, String celular, String nombre, String apellido, String user, String contraseña, TipoUsuario tipo, int edad) {
        super(cedula, celular, nombre, apellido, user, contraseña, tipo, edad);
        this.tarjetaCredito = tarjetaCredito;
    }

    public String getTarjetaCredito() {
        return tarjetaCredito;
    }

    public void setTarjetaCredito(String tarjetaCredito) {
        this.tarjetaCredito = tarjetaCredito;
    }
    
    public ArrayList<Servicio> getListaServicio() {
        return listaServicio;
    }    
    
    public void setListaServicio(Servicio servicio) {
        this.listaServicio.add(servicio);
    }
    
    
    @Override
    public String toString() {
        return super.toString() + "[ Edad: " + getEdad() + " N.Tarjeta: " + getTarjetaCredito() + "]";
    }
    

    public void ConsultarServicio() {
    Scanner sc = new Scanner(System.in);
    String validar;

    do {
        for (Servicio s : listaServicio) {
            if (s instanceof Taxi) {
                Taxi taxi = (Taxi) s;
                System.out.println("Servicio de Taxi\n" + taxi.toString() + "\n");
            }
            if (s instanceof Encomienda) {
                Encomienda enco = (Encomienda) s;
                System.out.println("Servicio de Encomienda\n" + enco.toString() + "\n");
            }
        }
        System.out.println("¿Solicitar otro Servicio? (si/no): ");
        validar = sc.nextLine();
    } while (validar.equalsIgnoreCase("si"));
}
    
    //Lee el archivo, varifica la cedula
    public static boolean validarcliente(String nombreArchivo, Usuario usuario) {
        ArrayList<String> lineas = ManejoArchivos.LeeFichero(nombreArchivo);
        for (String linea : lineas) {
        String[] datos = linea.split(",");
        String cedula = datos[0];
            if (cedula.equals(usuario.getCedula())) {
                return true;
            }     
        }
        return false;
    }
    
    //Agrega al cliente
    public static void registrarCliente(int edad, String numTarjeta, String cedula, String nombreArchivo) {
    String linea = cedula + "," + edad + "," + numTarjeta;
    ManejoArchivos.EscribirArchivo(nombreArchivo, linea);
   }
}