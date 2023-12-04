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
 * La clase Conductor hereda de la clase Usuario y representa a un conductor en
 * el sistema.
 */
public class Conductor extends Usuario {
    /**
     * declaración de las variables
     */
    private String numLicencia;
    private Vehiculo vehiculo;
    private EstadoConductor estadoConductor;
    private ArrayList<Servicio> serviciosAsignados;

    /**
     * Constructor de la clase Conductor.
     *
     * @param numLicencia El número de licencia del conductor.
     * @param vehiculo El vehículo del conductor.
     * @param estadoConductor El estado del conductor.
     * @param cedula La cédula del conductor.
     * @param nombre El nombre del conductor.
     * @param apellido El apellido del conductor.
     * @param user El nombre de usuario del conductor.
     * @param contraseña La contraseña del conductor.
     * @param numCelular El número de celular del conductor.
     */
    public Conductor(String numLicencia, Vehiculo vehiculo, EstadoConductor estadoConductor, String cedula, String nombre, String apellido, String user, String contraseña, String numCelular) {
        super(cedula, nombre, apellido, user, contraseña, numCelular);
        this.numLicencia = numLicencia;
        this.vehiculo = vehiculo;
        this.estadoConductor = estadoConductor;
        this.serviciosAsignados = new ArrayList<>();
    }
    /**
     * 
     * @return 
     */
    public ArrayList<Servicio> getServiciosAsignados() {
        return serviciosAsignados;
    }
    /**
     * 
     * @param serviciosAsignados 
     */
    public void setServiciosAsignados(ArrayList<Servicio> serviciosAsignados) {
        this.serviciosAsignados = serviciosAsignados;
    }
    
    /**
     * @return El vehículo del conductor.
     */
    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    /**
     * @return obtiene el número de licencia del conductor.
     */
    public String getNumLicencia() {
        return numLicencia;
    }

    /**
     * @param numLicencia Establece el nuevo número de licencia del conductor.
     */
    public void setNumLicencia(String numLicencia) {
        this.numLicencia = numLicencia;
    }

    /**
     * @return Obtiene el estado del conductor.
     */
    public EstadoConductor getEstadoConductor() {
        return estadoConductor;
    }

    /**
     * Consulta los servicios asignados al conductor.
     */
    @Override
    public void consultarServicio() {
        System.out.println();
        ArrayList<Servicio> servicios = this.getServiciosAsignados();
        if(servicios.isEmpty()){
            System.out.println("NO HAY INFORMACION PARA MOSTRAR");
            System.out.println();
        }else{
            for (Servicio i : servicios) {
            i.mostrarInformacion();
            System.out.println();
        }
        }
    }

    /**
     * Muestra los datos del vehículo del conductor.
     */
    public void mostrarDatosVehiculo() {
        //mostrar los datos del vehículo del conductor
        System.out.println();
        System.out.println(vehiculo.mostrarDatos());
        System.out.println();
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
            System.out.println("+++++++MENU CONDUCTOR++++++");
            System.out.println("1. Consultar Servicio");
            System.out.println("2. Datos Vehiculo");
            System.out.println("3. Salir");
            System.out.println("Por favor, elige una opción:");
            opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1 -> {
                    this.consultarServicio();
                }
                case 2 ->{
                    this.mostrarDatosVehiculo();
                }
                case 3 ->{
                    break;
                }
                default ->{
                    System.out.println("Opción incorrecta. Vuelva a intentarlo.");
                }
            }
        } while (opcion != 3);
        return opcion;
    }
}
