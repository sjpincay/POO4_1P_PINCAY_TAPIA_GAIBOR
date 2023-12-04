

package Principales;
import Enum.TipoVehiculo;

/**
 * La clase Vehiculo representa un vehículo en el sistema.
 */
public class Vehiculo {
    /**
     * declaracion de variables
     */
    private String placa;
    private String modelo;
    private String marca;
    private TipoVehiculo tipoVehiculo;
    private int codigoVehiculo;
    /**
     * Constructores de la clase Vehiculo
     * @param placa
     * @param modelo
     * @param marca
     * @param tipoVehiculo
     * @param codigoVehiculo 
     */
    public Vehiculo(String placa, String modelo, String marca, TipoVehiculo tipoVehiculo, int codigoVehiculo) {
        this.placa = placa;
        this.modelo = modelo;
        this.marca = marca;
        this.tipoVehiculo = tipoVehiculo;
        this.codigoVehiculo = codigoVehiculo;
    }

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
     * @return La placa del vehículo.
     */
    public String getPlaca() {
        return placa;
    }
    /**
     * @return El modelo del vehículo.
     */
    public String getModelo() {
        return modelo;
    }
    /**
     * @return La marca del vehículo.
     */
    public String getMarca() {
        return marca;
    }
    /**
     * @return El tipo de vehículo.
     */
    public TipoVehiculo getTipoVehiculo() {
        return tipoVehiculo;
    }
    /**
     * @return El código del vehículo.
     */
    public int getCodigoVehiculo() {
        return codigoVehiculo;
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "placa=" + placa + ", modelo=" + modelo + ", marca=" + marca + ", tipoVehiculo=" + tipoVehiculo + ", codigoVehiculo=" + codigoVehiculo + '}';
    }
    
}   