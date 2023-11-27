/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Principales;
import Enum.EstadoConductor;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author sjpin
 */
public class Conductor extends Usuario{
    private String numLicencia;
    private Vehiculo vehiculo;
    private EstadoConductor estadoConductor;
    private ArrayList<Servicio> serviciosAsignados;

    public Conductor(String numLicencia, Vehiculo vehiculo, EstadoConductor estadoConductor, ArrayList<Servicio> serviciosAsignados, String cedula, int edad, String nombre, String apellido, String user, String contraseña, String numCelular) {
        super(cedula, edad, nombre, apellido, user, contraseña, numCelular);
        this.numLicencia = numLicencia;
        this.vehiculo = vehiculo;
        this.estadoConductor = estadoConductor;
        this.serviciosAsignados = serviciosAsignados;
    }  

    public Vehiculo getVehiculo() {
        return vehiculo;
    }
    
    public String getNumLicencia() {
        return numLicencia;
    }

    public void setNumLicencia(String numLicencia) {
        this.numLicencia = numLicencia;
    }

    public EstadoConductor getEstadoConductor() {
        return estadoConductor;
    }
    
    
    @Override
    public void consultarServicio() {
        // mostrar los servicios asignados al conductor
        // recorrerla e imprimir cada servicio
        for (Servicio servicio : serviciosAsignados) {
            System.out.println(servicio);
        }
    }

    public void mostrarDatosVehiculo() {
        //mostrar los datos del vehículo del conductor
        System.out.println(vehiculo.mostrarDatos());
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