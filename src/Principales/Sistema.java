/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Principales;
//import static ManejoArchivos.ManejoArchivos.LeeFichero;
import Enum.*;
import ManejoArchivos.ManejoArchivos;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author sjpin
 */
public class Sistema {

    /**
     * @param args the command line arguments
     */
    static ArrayList<Usuario>listUsuarios= new ArrayList<>();
    static ArrayList<Servicio>listServicios= new ArrayList<>();
    static ArrayList<Vehiculo>listVehiculos= new ArrayList<>();
    
    /*
    Método que muestra el menú del conductor
    */
    public static void mostrarMenuConductor(){
        System.out.println("1. Consultar Servicio Asignado\n2. Datos de su vehículo");
    }
    /*
    Método que muestra el menú del cliente
    */
    public static void mostrarMenuCliente(){
        System.out.println("1. Solicitar servicio de taxi\n2. Solicitar comida a domicilio\n3. Solicitar entrega encomienda\n4. Consultar servicios");
    }
    /*
    Método que lee el archivo "usuarios.txt" y crea objetos de Usuario
    luego de que se lean los daots, los objetos se agregan a l lista de Usuarios
    */
    public static void cargarUsuarios(){
        //ArrayList<String[]> datosUsuarios = 
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /*
        MOstramos la bienvenida al Usuario al sistema
        para obtener los datos(user y contraseña)
        */
        System.out.println("********************************");
        System.out.println("    BIENVENIDO AL SISTEMA    ");
        System.out.println("********************************");
        System.out.print("USUARIO: ");
        String usuario = sc.nextLine();
        System.out.print("CONTRASEÑA: ");
        String contraseña = sc.nextLine();
    }
    
}
