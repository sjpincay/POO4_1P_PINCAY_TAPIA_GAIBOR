/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Principales;
import Enum.EstadoConductor;
import java.util.ArrayList;
import java.util.Scanner;
import Enum.TipoVehiculo;
/**
 * La clase Conductor hereda de la clase Usuario y representa a un conductor en el sistema.
 */
public class Conductor extends Usuario{
    private int edad;
    private String numLicencia;
    private Vehiculo vehiculo;
    private EstadoConductor estadoConductor;
    private ArrayList<Servicio> serviciosAsignados;
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
    public Conductor(String numLicencia, Vehiculo vehiculo, EstadoConductor estadoConductor, String cedula, String nombre, String apellido, int edad, String user, String contraseña, String numCelular) {
    super(cedula, nombre, apellido, user, contraseña, numCelular);
    this.edad=edad;
    this.numLicencia = numLicencia;
    this.vehiculo = vehiculo;
    this.estadoConductor = estadoConductor;
    this.serviciosAsignados = new ArrayList<>();  
}
    /**
     * Obtiene el vehículo del conductor.
     *
     * @return El vehículo del conductor.
     */
    public Vehiculo getVehiculo() {
        return vehiculo;
    }
    /**
     * Obtiene el número de licencia del conductor.
     *
     * @return El número de licencia del conductor.
     */    
    public String getNumLicencia() {
        return numLicencia;
    }
    /**
     * Establece el número de licencia del conductor.
     *
     * @param numLicencia El nuevo número de licencia del conductor.
     */
    public void setNumLicencia(String numLicencia) {
        this.numLicencia = numLicencia;
    }
    /**
     * Obtiene el estado del conductor.
     *
     * @return El estado del conductor.
     */
    public EstadoConductor getEstadoConductor() {
        return estadoConductor;
    }
    
    /**
     * Consulta los servicios asignados al conductor.
     */   
    @Override
    public void consultarServicio() {
        // mostrar los servicios asignados al conductor
        // recorrerla e imprimir cada servicio
        for (Servicio servicio : serviciosAsignados) {
            System.out.println(servicio);
        }
    }
    
    /**
     * Muestra los datos del vehículo del conductor.
     */
    public void mostrarDatosVehiculo() {
        //mostrar los datos del vehículo del conductor
        System.out.println(vehiculo.mostrarDatos());
    }
    /**
     * Permite al conductor seleccionar una opción del menú.
     *
     * @return La opción seleccionada por el conductor.
     */
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
    /**
     * Verifica si el conductor está disponible.
     *
     * @return Verdadero si el conductor está disponible, falso en caso contrario.
     */    
    public boolean estadoDisponible(){
        return estadoConductor == EstadoConductor.D; //Retorna  true si esta disponible 
    }
    /**
     * Verifica si el vehículo del conductor es un auto o una moto.
     *
     * @return El tipo de vehículo del conductor.
     */    
    public TipoVehiculo esAutOMoto(){
        return vehiculo.getTipoVehiculo();// Este método verifica si el vehículo del conductor es un auto o una moto
    }
    
}