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
    private ArrayList<String> serviciosAsignados = new ArrayList<>();
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

    public ArrayList<String> getServiciosAsignados() {
        return serviciosAsignados;
    }

    public void setServiciosAsignados(ArrayList<String> serviciosAsignados) {
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
    
    @Override
    public void mostrarMenu(){
        super.mostrarMenu();
        System.out.println("1. Consultar servicio asignado");
        
    }
    
    @Override
    public String toString() {
        return super.toString() + "[ Licencia: " + getNumLicencia() + " Estado: " + getEstadoConductor() + " Vehiculo: " + getVehiculo() + "]";
    }
    
    
    private void leerArchServicio() {
        String[] servicios = {"viajes.txt", "encomiendas.txt"};

        for (String nombreArchivo : servicios) {
            ArrayList<String> lineas = ManejoArchivos.LeeFichero(nombreArchivo);
            for (String linea : lineas) {
                String[] datos = linea.split(",");
                if (datos[0].equals(this.nombre)) {
                    String s;
                    switch (nombreArchivo) {
                        case "viajes.txt":
                            s = "Usted tiene asignado el Servicio Taxi\nDesde: " + datos[3] + "\nHasta: " + datos[4] + "\nFecha: " + datos[5] + "\nHora: " + datos[6] + "\nCantidad de personas: " + datos[7] + "\n\n";
                            break;
                        case "encomiendas.txt":
                            s = "Usted Tiene asignado el servicio de encomienda: \nTipo de encomienda: "+datos[7]+"\nCantidad: "+datos[8]+"\nFecha: "+datos[5]+"\nHora "+datos[6]+"\nDesde: "+datos[3]+"\nHasta: "+datos[4];
                            break;
                        default:
                            s = "";
                            break;
                    }
                    serviciosAsignados.add(s);
                }
            }
        }
    }

    public static String EstadoLicencia(String nombreArchivo, String nombre) {
        ArrayList<String> lineas = ManejoArchivos.LeeFichero(nombreArchivo);
        for (String linea : lineas) {
            String[] datos = linea.split(",");
            if (datos[0].equals(nombre)) {
                return datos[2] + "," + datos[3] + "," + datos[4];
            }
        }
        return "";
    }
    
    public void ConsultarServAsignado() {
        Scanner sc = new Scanner(System.in);
        String validar;

        do {
            leerArchServicio();
            if (serviciosAsignados.isEmpty()) {
                System.out.println("Conductor sin servicios, se está trabajando");
            } else {
                for (String servicio : serviciosAsignados) {
                    System.out.println(servicio);
                }
            }
            System.out.println("¿Desea Solicitar otro Servicio? (si/no): ");
            validar = sc.nextLine();
        } while (validar.equalsIgnoreCase("si"));
    }

}