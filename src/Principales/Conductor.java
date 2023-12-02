/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Principales;
import Enum.EstadoConductor;
import Enum.TipoUsuario;
import java.util.ArrayList;
import java.util.Scanner;
import Enum.TipoVehiculo;
import ManejoArchivos.*;
/**
 * La clase Conductor hereda de la clase Usuario y representa a un conductor en el sistema.
 */
public class Conductor extends Usuario{
    private String numLicencia;
    private Vehiculo vehiculo;
    private EstadoConductor estadoConductor;
    private ArrayList<Servicio> serviciosAsignados = new ArrayList<>();
    private TipoVehiculo tipoVehiculo;
    /**
     * Constructor de la clase Conductor.
     *
     * @param numLicencia El número de licencia del conductor.
     * @param vehiculo El vehículo del conductor.
     * @param estadoConductor El estado del conductor.
     * @param cedula La cédula del conductor.
     * @param nombre El nombre del conductor.
     * @param apellido El apellido del conductor.
     * @param edad La edad del conductor.
     * @param user El nombre de usuario del conductor.
     * @param contraseña La contraseña del conductor.
     * @param numCelular El número de celular del conductor.
     */
    public Conductor(String numLicencia, Vehiculo vehiculo, EstadoConductor estadoConductor, String cedula, String celular, String nombre, String apellido, String user, String contraseña, TipoUsuario tipo) {
        super(cedula, celular, nombre, apellido, user, contraseña, tipo);
        this.numLicencia = numLicencia;
        this.vehiculo = vehiculo;
        this.estadoConductor = estadoConductor;
    }

    public String getNumLicencia() {
        return numLicencia;
    }

    public void setNumLicencia(String numLicencia) {
        this.numLicencia = numLicencia;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public EstadoConductor getEstadoConductor() {
        return estadoConductor;
    }

    public void setEstadoConductor(EstadoConductor estadoConductor) {
        this.estadoConductor = estadoConductor;
    }

    public TipoVehiculo getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(TipoVehiculo tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public ArrayList<Servicio> getServiciosAsignados() {
        return serviciosAsignados;
    }

    public void setServiciosAsignados(ArrayList<Servicio> serviciosAsignados) {
        this.serviciosAsignados = serviciosAsignados;
    }

    public static String tipo(String nombreArchivo, String code) {
        ArrayList<String> lineas = ManejoArchivos.LeeFichero(nombreArchivo);
        for (String linea : lineas) {
            String[] datos = linea.split(",");
            if (datos[0].equals(code)) {
                return datos[4];
            }
        }
        return "";
    }
    
    
    public int seleccionarOpcion() {
        int opcion = 0;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("SERVICIO ASIGNADO");
            System.out.println("1. Consultar Servicio");
            System.out.println("2. Datos Vehiculo");
            System.out.println("Por favor, elige una opción:");
            opcion = sc.nextInt();
        } while (opcion > 2 || opcion < 1);
        return opcion;
    }
    /**
     * Permite al conductor seleccionar una opción del menú.
     *
     * @return La opción seleccionada por el conductor.
     */    
    public void menuConductor() {
        int opcion = seleccionarOpcion();
        switch (opcion) {
            case 1:
                consultarServicio();
                break;
            case 2:
                mostrarDatosVehiculo();
                break;
            default:
                System.out.println("Opción no válida.");
                break;
        }
    }
}