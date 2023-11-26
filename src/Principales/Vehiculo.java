/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Principales;
import Enum.TipoVehiculo;

/**
 *
 * @author sjpin
 */

public class Vehiculo {
    private String placa;
    private String modelo;
    private String marca;
    private TipoVehiculo tipoVehiculo;
    private int codigoVehiculo;

   
    public String mostrarDatos() {
    return "Marca: " + marca + "\n" +
           "Modelo: " + modelo + "\n" +
           "Placa: " + placa + "\n" +
           "Tipo de Vehiculo: " + tipoVehiculo + "\n" +
           "Código de Vehiculo: " + codigoVehiculo;
    }

}   