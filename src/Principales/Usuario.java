/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Principales;
import Enum.TipoUsuario;

/**
 *
 * @author sjpin
 */

public class Usuario {
    protected String cedula, celular;
    protected String nombre, apellido; 
    protected String user, contraseña;
    protected TipoUsuario tipo;
    protected int edad;

    public Usuario(String cedula, String celular, String nombre, String apellido, String user, String contraseña, TipoUsuario tipo, int edad){
        this.cedula = cedula;
        this.celular = celular;
        this.nombre = nombre;
        this.apellido = apellido;
        this.user = user;
        this.contraseña = contraseña;
        this.tipo = tipo;
        this.edad = edad;
    }

    public Usuario(String cedula, String celular, String nombre, String apellido, String user, String contraseña, TipoUsuario tipo) {
        this.cedula = cedula;
        this.celular = celular;
        this.nombre = nombre;
        this.apellido = apellido;
        this.user = user;
        this.contraseña = contraseña;
        this.tipo = tipo;
    }

    public Usuario() {
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public TipoUsuario getTipo() {
        return tipo;
    }

    public void setTipo(TipoUsuario tipo) {
        this.tipo = tipo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    public void mostrarMenu(){
        System.out.println("/********MENÚ********/");
        System.out.println("/*                  */");
        System.out.println("/********************/");
    }
     
    public int consultarServicio(){
        return 1;
    }
    
    @Override
   public String toString(){
       return "[Nombre: "+getNombre()+" "+getApellido()+" Usuario: "+getUser()+" Nro.Cedula: "+getCedula()+" Celular: "+getCelular()+"]";
   }
    
    
}

    

