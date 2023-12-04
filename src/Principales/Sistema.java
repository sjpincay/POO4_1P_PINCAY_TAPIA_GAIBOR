/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Principales;


import Enum.*;
import static Enum.TipoUsuario.C;
import static Enum.TipoUsuario.R;
import ManejoArchivos.ManejoArchivos;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author sjpin
 */
public class Sistema {
    
    /**
     * Lista de usuarios registrados en el sistema 
     */
    static ArrayList<Usuario> listUsuarios = new ArrayList<>();
    /**
     * Lista de vehiculos registrados en el sistema
     */
    static ArrayList<Vehiculo> listVehiculos = new ArrayList<>();
    /**
     * 
     * @param archivoUsuarios
     * @param archivoClientes
     * @param archivoConductores
     * @param archivoVehiculos 
     */
    public static void crearListaU(String archivoUsuarios, String archivoClientes, String archivoConductores, String archivoVehiculos) {
        //Creamos las listas en formato String con los datos a utilizar para la lista de Usuarios(Pueden ser Clientes o Conductores). Removemos la primera linea que no nos interesa.
        ArrayList<String> usuariosString = ManejoArchivos.LeeFichero(archivoUsuarios);
        usuariosString.remove(0);
        ArrayList<String> clientesString = ManejoArchivos.LeeFichero(archivoClientes);
        clientesString.remove(0);
        ArrayList<String> conductoresString = ManejoArchivos.LeeFichero(archivoConductores);
        conductoresString.remove(0);
        ArrayList<String> vehiculosString = ManejoArchivos.LeeFichero(archivoVehiculos);
        vehiculosString.remove(0);
        //Recorremos la lista de Usuarios para crear las instancias de la clase Usuario y agregarlas a la lista estatica de la clase.
        for (String linea : usuariosString) {
            //Realizamos un split a cada linea y nos devuelve un array de String con los datos del Usuario
            String datosUsuario[] = linea.split(",");
            String cedula = datosUsuario[0];
            //Verificamos si el Usuario es Cliente(C) o Conductor(D)
            if (datosUsuario[datosUsuario.length - 1].equals("C")) {
                //Recorremos la lista de clientes para verificar que sea la misma cedula que el usuario
                for (String l : clientesString) {
                    //Obtenemos los datos del cliente con un split a cada String de la lista de clientes para obtener los datos del cliente
                    String datosCliente[] = l.split(",");
                    if (datosCliente[0].equals(cedula)) {
                        //Creamos la instancia de Cliente
                        Cliente c = new Cliente(cedula, datosUsuario[1], datosUsuario[2], datosUsuario[3], datosUsuario[4], datosUsuario[5], Integer.parseInt(datosCliente[1]), datosCliente[1]);
                        c.setTipoUsuario(TipoUsuario.C);
                        listUsuarios.add(c);
                    }
                }
                //Caso en el que el usuario sea un Conductor
            } else {
                //El conductor tiene un vehiculo asignado por lo que debemos crear la lista de Vehiculos
                ArrayList<String[]> vehiculosDatos = new ArrayList<>();
                for (String l : vehiculosString) {
                    vehiculosDatos.add(l.split(","));
                }
                //Recorremos la lista de Conductores y separamos los datos con split
                for (String l : conductoresString) {
                    String datosConductor[] = l.split(",");
                    //Obtenemos el codigo del vehiculo asignado al conductor
                    String codigoVehiculo = datosConductor[datosConductor.length - 1];
                    //Creamos la instancia del vehiculo asignado al coductor
                    Vehiculo vehiculoAsg = null;
                    for (String[] v : vehiculosDatos) {
                        //Verificamos que tenga el mismo codigo que en el archivo del conductor
                        if (codigoVehiculo.equals(v[0])) {
                            //Verificamos si es Auto o Moto
                            if (v[4].equals("A")) {
                                //Creamos la instacia de Vehiculo
                                vehiculoAsg = new Vehiculo(v[1], v[2], v[3], TipoVehiculo.A, Integer.parseInt(codigoVehiculo));
                            } else {
                                vehiculoAsg = new Vehiculo(v[1], v[2], v[3], TipoVehiculo.M, Integer.parseInt(codigoVehiculo));
                            }
                        }
                    }
                    //Verificamos que la cedula del Usuario sea igual al del conductor
                    if (datosConductor[0].equals(cedula)) {
                        //Creamos la instancia del conductor depoendiendo de su estado y la agregamos a la lista estatica de Conductores
                        if (datosConductor[2].equals("O")) {
                            Conductor r = new Conductor(datosConductor[1], vehiculoAsg, EstadoConductor.O, cedula, datosUsuario[1], datosUsuario[2], datosUsuario[3], datosUsuario[4], datosUsuario[5]);
                            r.setTipoUsuario(TipoUsuario.R);
                            listUsuarios.add(r);
                        } else {
                            Conductor r = new Conductor(datosConductor[1], vehiculoAsg, EstadoConductor.D, cedula, datosUsuario[1], datosUsuario[2], datosUsuario[3], datosUsuario[4], datosUsuario[5]);
                            r.setTipoUsuario(TipoUsuario.R);
                            listUsuarios.add(r);
                        }
                    }
                }
            }
        }

    }
    /**
     * 
     * @param archivoVehiculos 
     */
    public static void crearListaV(String archivoVehiculos) {
        ArrayList<String> vehiculosString = ManejoArchivos.LeeFichero(archivoVehiculos);
        vehiculosString.remove(0);
        for (String v : vehiculosString) {
            String vehiculo[] = v.split(",");
            if (vehiculo[4].equals("A")) {
                listVehiculos.add(new Vehiculo(vehiculo[1], vehiculo[2], vehiculo[3], TipoVehiculo.A, Integer.parseInt(vehiculo[0])));
            } else {
                listVehiculos.add(new Vehiculo(vehiculo[1], vehiculo[2], vehiculo[3], TipoVehiculo.M, Integer.parseInt(vehiculo[0])));
            }

        }
    }
    /**
     * Inicializamos el sistema creando las listas de Usuarios y Vehiculos.
     * @param archivoUsuarios
     * @param archivoClientes
     * @param archivoConductores
     * @param archivoVehiculos 
     */
   
    public static void inicializar(String archivoUsuarios, String archivoClientes, String archivoConductores, String archivoVehiculos) {
        crearListaU(archivoUsuarios, archivoClientes, archivoConductores, archivoVehiculos);
        crearListaV(archivoVehiculos);
    }
    /**
     * Mostramos la bienvenida al usuario y solicitamos la autenticacion.
     * Iniciamos un bucle infinito para permitir intentos de inicio de sesión.
     * SI la autenticación es exitosa, redirigimos al usuario 
     * @param args 
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String pathUsuarios = "usuarios.txt";
        String pathClientes = "cliente.txt";
        String pathConductores = "conductor.txt";
        String pathVehiculos = "vehiculos.txt";
        inicializar(pathUsuarios, pathClientes, pathConductores, pathVehiculos);
        while (true) {
            System.out.println();
            System.out.println("********************************");
            System.out.println("    BIENVENIDO AL SISTEMA    ");
            System.out.println("********************************");
            System.out.print("USUARIO: ");
            String usuario = sc.nextLine();
            System.out.print("CONTRASEÑA: ");
            String contraseña = sc.nextLine();
            boolean found = false;
            //Verificamos los datos ingresados por el usuario si corresponden a un usuario registrado
            for (Usuario u : listUsuarios) {
                //Verificamos username
                if (u.getUser().equals(usuario) && u.getContraseña().equals(contraseña)) {
                    found = true;
                    switch (u.getTipoUsuario()) {
                        case C -> {
                            Cliente c = (Cliente) u;
                            c.seleccionarOpcion();
                        }
                        case R -> {
                            Conductor r = (Conductor) u;
                            r.seleccionarOpcion();
                        }
                    }
                    break;
                }
            }
            if (found == false){
                System.out.println("Usuario o Contrasena incorrecta. Vuelva a intentarlo.");
            }
        }

    }

}
