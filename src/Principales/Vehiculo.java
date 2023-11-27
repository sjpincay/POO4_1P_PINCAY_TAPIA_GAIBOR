/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Principales;
import Enum.TipoVehiculo;

/**
 * La clase Vehiculo representa un vehículo en el sistema.
 */
public class Vehiculo {
    private String placa;
    private String modelo;
    private String marca;
    private TipoVehiculo tipoVehiculo;
    private int codigoVehiculo;


    /**
     * Muestra los datos del vehículo.
     *
     * @return Una cadena que representa los datos del vehículo.
     */  
    public String mostrarDatos() {
    return "Marca: " + marca + "\n" +
           "Modelo: " + modelo + "\n" +
           "Placa: " + placa + "\n" +
           "Tipo de Vehiculo: " + tipoVehiculo + "\n" +
           "Código de Vehiculo: " + codigoVehiculo;
    }
    /**
     * Obtiene la placa del vehículo.
     *
     * @return La placa del vehículo.
     */
    public String getPlaca() {
        return placa;
    }
    /**
     * Obtiene el modelo del vehículo.
     *
     * @return El modelo del vehículo.
     */
    public String getModelo() {
        return modelo;
    }
    /**
     * Obtiene la marca del vehículo.
     *
     * @return La marca del vehículo.
     */
    public String getMarca() {
        return marca;
    }
    /**
     * Obtiene el tipo de vehículo.
     *
     * @return El tipo de vehículo.
     */
    public TipoVehiculo getTipoVehiculo() {
        return tipoVehiculo;
    }
    /**
     * Obtiene el código del vehículo.
     *
     * @return El código del vehículo.
     */
    public int getCodigoVehiculo() {
        return codigoVehiculo;
    }

}   