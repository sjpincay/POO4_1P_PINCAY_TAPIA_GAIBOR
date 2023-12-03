/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Principales;

import Enum.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import java.time.LocalDate;
import ManejoArchivos.ManejoArchivos;

/**
 * La clase Cliente hereda de la clase Usuario y representa a un cliente en el
 * sistema.
 */
public class Cliente extends Usuario {

    private int edad;
    private String tarjetaCredito;
    private ArrayList<Servicio> serviciosSolicitados;
    private ArrayList<Pagos> pagosRealizados;
    private TipoUsuario tipoUsuario;

    /**
     * Constructor de la clase Cliente.
     *
     * @param cedula La cédula del cliente.
     * @param nombre El nombre del cliente.
     * @param apellido El apellido del cliente.
     * @param user El nombre de usuario del cliente.
     * @param edad La edad del cliente.
     * @param contraseña La contraseña del cliente.
     * @param numCelular El número de celular del cliente.
     * @param tarjetaCredito El número de la tarjeta de crédito del cliente.
     */
    public Cliente(String cedula, String nombre, String apellido, String user, String contraseña, String numCelular, int edad, String tarjetaCredito) {
        super(cedula, nombre, apellido, user, contraseña, numCelular);
        this.edad = edad;
        this.tarjetaCredito = tarjetaCredito;
        this.serviciosSolicitados = new ArrayList<>();
        this.pagosRealizados = new ArrayList<>();
    }

    public ArrayList<Pagos> getPagosRealizados() {
        return pagosRealizados;
    }

    public void setPagosRealizados(ArrayList<Pagos> pagosRealizados) {
        this.pagosRealizados = pagosRealizados;
    }

    public ArrayList<Servicio> getServiciosSolicitados() {
        return serviciosSolicitados;
    }

    public void setServiciosSolicitados(ArrayList<Servicio> serviciosSolicitados) {
        this.serviciosSolicitados = serviciosSolicitados;
    }

    /**
     * Obtiene la edad del cliente.
     *
     * @return La edad del cliente.
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Obtiene el número de la tarjeta de crédito del cliente.
     *
     * @return El número de la tarjeta de crédito del cliente.
     */
    public String getTarjetaCredito() {
        return tarjetaCredito;
    }

    /**
     * Establece la edad del cliente.
     *
     * @param edad La nueva edad del cliente.
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * Establece el número de la tarjeta de crédito del cliente.
     *
     * @param tarjetaCredito El nuevo número de la tarjeta de crédito del
     * cliente.
     */
    public void setTarjetaCredito(String tarjetaCredito) {
        this.tarjetaCredito = tarjetaCredito;
    }

    /**
     * Consulta los servicios disponibles para el cliente.
     */
    @Override
    public void consultarServicio() {
        System.out.println();
        ArrayList<Servicio> servicios = this.getServiciosSolicitados();
        if (servicios.isEmpty()) {
            System.out.println("NO HAY INFORMACION PARA MOSTRAR");
            System.out.println();
        } else {
            for (Servicio i : servicios) {
                i.mostrarInformacion();
                System.out.println();
            }
        }
    }

    /**
     * Permite al cliente seleccionar una opción del menú.
     *
     */
    public void seleccionarOpcion() {
        int opcion = 0;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println();
            System.out.println("+++++++MENÚ+++++++");
            System.out.println("1. Solicitar servicio de taxi");
            System.out.println("2. Solicitar entrega encomienda");
            System.out.println("3. Consultar servicios");
            System.out.println("4. Salir");
            System.out.println("Por favor, elige una opción:");
            opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1 -> {
                    this.solicitarTaxi();
                }
                case 2 -> {
                    this.solicitarEncomienda();
                }
                case 3 -> {
                    this.consultarServicio();
                }
                case 4 -> {
                    break;
                }
                default -> {
                    System.out.println("Opcion no valida. Vuelva a intentar.");
                }
            }
        } while (opcion != 4);
    }

    public void solicitarTaxi() {
        //Verificamos los conductores disponibles
        ArrayList<Conductor> conductoresDisponible = new ArrayList<>();
        Conductor cAsig;
        for (Usuario u : Sistema.listUsuarios) {
            if (u.getTipoUsuario() == TipoUsuario.R) {
                Conductor cDisponible = (Conductor) u; //<<<<--------
                if ((cDisponible.getEstadoConductor() == EstadoConductor.D) && (cDisponible.getVehiculo().getTipoVehiculo() == TipoVehiculo.A)) {
                    conductoresDisponible.add(cDisponible);
                }
            }
        }

        int numCondDisponibles = conductoresDisponible.size();
        if (conductoresDisponible.isEmpty()) {
            System.out.println();
            System.out.println("NO HAY CONDUCTORES DISPONIBLES");
            System.out.println();
        } else {
            Random rd = new Random();
            int indexCond = rd.nextInt(numCondDisponibles);
            cAsig = conductoresDisponible.get(indexCond);
            //Pedimos los datos del servicio de taxi al usuario
            Scanner sc = new Scanner(System.in);
            System.out.print("Ingrese la direccion de origen: ");
            String origen = sc.nextLine();
            System.out.print("Ingrese la direccion de destino: ");
            String destino = sc.nextLine();
            LocalDate currentDate = LocalDate.now();
            System.out.print("Ingrese la hora del viaje(formato 00:00): ");
            String horaString = sc.nextLine();
            String datosHora[] = horaString.split(":");
            int hora = Integer.parseInt(datosHora[0]);
            int minutos = Integer.parseInt(datosHora[1]);
            System.out.print("Indique el numero de personas: ");
            int numPersonas = sc.nextInt();
            sc.nextLine();
            System.out.print("Ingrese el metodo de pago(TC/E): ");
            String metPago = sc.nextLine();
            TipoPago tPago;
            Taxi t;
            switch (metPago) {
                case "TC" -> {
                    tPago = TipoPago.TC;
                    t = new Taxi(origen, destino, currentDate, cAsig, numPersonas, hora, tPago);
                    t.calcularValorAPagar(TipoPago.TC);
                }
                case "tc" -> {
                    tPago = TipoPago.TC;
                    t = new Taxi(origen, destino, currentDate, cAsig, numPersonas, hora, tPago);
                    t.calcularValorAPagar(TipoPago.TC);
                }
                case "E" -> {
                    tPago = TipoPago.E;
                    t = new Taxi(origen, destino, currentDate, cAsig, numPersonas, hora, tPago);
                    t.calcularValorAPagar();
                }
                case "e" -> {
                    tPago = TipoPago.E;
                    t = new Taxi(origen, destino, currentDate, cAsig, numPersonas, hora, tPago);
                    t.calcularValorAPagar();
                }
                default -> {
                    tPago = TipoPago.E;
                    t = new Taxi(origen, destino, currentDate, cAsig, numPersonas, hora, tPago);
                    t.calcularValorAPagar();
                }
            }
            boolean confirmacion = t.confirmarViaje();
            if (confirmacion) {
                this.getServiciosSolicitados().add(t);
                t.getConductorAsignado().getServiciosAsignados().add(t);
                String lineaAEscribir = t.getID() + ",T," + this.getCedula() + "," + t.getConductorAsignado().getNombre() + "," + t.getOrigen() + "," + t.getDestino() + "," + t.getFecha().toString() + "," + Integer.toString(t.getHora()) + ":" + Integer.toString(minutos);
                ManejoArchivos.EscribirArchivo("servicios.txt", lineaAEscribir);
                this.generarPago(t, tPago);
                t.escribirArchivoViaje();
                t.mostrarInformacion();
            }
        }

    }

    public void solicitarEncomienda() {
        //Verificamos los conductores disponibles
        ArrayList<Conductor> conductoresDisponible = new ArrayList<>();
        Conductor cAsig;
        for (Usuario u : Sistema.listUsuarios) {
            if (u.getTipoUsuario() == TipoUsuario.R) {
                Conductor cDisponible = (Conductor) u;
                if ((cDisponible.getEstadoConductor() == EstadoConductor.D) && (cDisponible.getVehiculo().getTipoVehiculo() == TipoVehiculo.M)) {
                    conductoresDisponible.add(cDisponible);
                }
            }
        }

        int numCondDisponibles = conductoresDisponible.size();
        if (conductoresDisponible.isEmpty()) {
            System.out.println();
            System.out.println("NO HAY CONDUCTORES DISPONIBLES");
            System.out.println();
        } else {
            Random rd = new Random();
            int indexCond = rd.nextInt(numCondDisponibles);
            cAsig = conductoresDisponible.get(indexCond);
            //Pedimos los datos del servicio de taxi al usuario
            Scanner sc = new Scanner(System.in);
            System.out.print("Ingrese la direccion de origen: ");
            String origen = sc.nextLine();
            System.out.print("Ingrese la direccion de destino: ");
            String destino = sc.nextLine();
            System.out.print("Ingrese el tipo Medicamento/Documento/Ropa (M/D/R): ");
            String tEncomienda = sc.nextLine();
            TipoEncomienda TE;
            switch (tEncomienda) {
                case "M" -> {
                    TE = TipoEncomienda.MEDICAMENTO;
                }
                case "D" -> {
                    TE = TipoEncomienda.DOCUMENTOS;
                }
                
                default -> {
                    TE = TipoEncomienda.DOCUMENTOS;
                }
            }
            LocalDate currentDate = LocalDate.now();
            System.out.print("Ingrese la hora de la entrega(formato 00:00): ");
            String horaString = sc.nextLine();
            String datosHora[] = horaString.split(":");
            int hora = Integer.parseInt(datosHora[0]);
            int minutos = Integer.parseInt(datosHora[1]);
            System.out.print("Ingrese la cantidad de productos: ");
            int cantidad = sc.nextInt();
            sc.nextLine();
            System.out.print("Ingrese el peso total(Kg): ");
            double peso = sc.nextDouble();
            sc.nextLine();
            System.out.print("Ingrese el metodo de pago(TC/E): ");
            String metPago = sc.nextLine();
            TipoPago tPago;
            Encomienda e;
            switch (metPago) {
                case "TC" -> {
                    tPago = TipoPago.TC;
                    e = new Encomienda(cantidad, peso, hora, TE, origen, destino, currentDate, cAsig);
                    e.calcularValorAPagar(TipoPago.TC);
                }
                case "tc" -> {
                    tPago = TipoPago.TC;
                    e = new Encomienda(cantidad, peso, hora, TE, origen, destino, currentDate, cAsig);
                    e.calcularValorAPagar(TipoPago.TC);
                }
                case "E" -> {
                    tPago = TipoPago.E;
                    e = new Encomienda(cantidad, peso, hora, TE, origen, destino, currentDate, cAsig);
                    e.calcularValorAPagar();
                }
                case "e" -> {
                    tPago = TipoPago.E;
                    e = new Encomienda(cantidad, peso, hora, TE, origen, destino, currentDate, cAsig);
                    e.calcularValorAPagar();

                }
                default -> {
                    tPago = TipoPago.E;
                    e = new Encomienda(cantidad, peso, hora, TE, origen, destino, currentDate, cAsig);
                    e.calcularValorAPagar();
                }
            }
            boolean confirmacion = e.confirmarEncomienda();
            if (confirmacion) {
                this.getServiciosSolicitados().add(e);
                e.getConductorAsignado().getServiciosAsignados().add(e);
                String lineaAEscribir = e.getID() + ",E," + this.getCedula() + "," + e.getConductorAsignado().getNombre() + "," + e.getOrigen() + "," + e.getDestino() + "," + e.getFecha().toString() + "," + Integer.toString(e.getHora()) + ":" + Integer.toString(minutos);
                ManejoArchivos.EscribirArchivo("servicios.txt", lineaAEscribir);
                this.generarPago(e, tPago);
                e.escribirArchivoEncomienda();
                e.mostrarInformacion();
            }
        }

    }

    public void generarPago(Servicio s, TipoPago t) {
        String fechaPago = s.getFecha().toString();
        String numServicio = s.getID();
        String formaPago = null;
        switch (t) {
            case TC -> {
                formaPago = "TC";
            }
            case E -> {
                formaPago = "E";
            }
        }
        String subtotal = Double.toString(s.getValorAPagar());
        String total = Double.toString(s.getValorAPagar());
        Pagos p = new Pagos(s, this, t, s.getValorAPagar(), s.getFecha());
        this.getPagosRealizados().add(p);
        String lineaEscribir = Integer.toString(p.getIdPago()) + "," + fechaPago + "," + numServicio + "," + formaPago + "," + this.getCedula() + "," + subtotal + "," + total;
        ManejoArchivos.EscribirArchivo("pagos.txt", lineaEscribir);
    }
}
