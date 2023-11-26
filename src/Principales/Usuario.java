/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Principales;

/**
 *
 * @author sjpin
 */
public abstract class Usuario {

    private  String cedula;
    private String nombre;
    private String apellido;
    private int edad;
    private String user;
    private String contraseña;
    private String numCelular;
    
    public Usuario(String cedula,String nombre, String apellido,int edad,String user, String contraseña,String numCelular){
        this.cedula= cedula;
        this.nombre= nombre;
        this.apellido=apellido;
        this.edad=edad;
        this.user=user;
        this.contraseña=contraseña;
        this.numCelular=numCelular;
    }

    public String getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getUser() {
        return user;
    }

    public String getContraseña() {
        return contraseña;
    }

    public String getNumCelular() {
        return numCelular;
    }
    
    public void setCedula(String cedula) {
    this.cedula = cedula;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public void setNumCelular(String numCelular) {
        this.numCelular = numCelular;
    }
    /*
    metodo consultarServicio que es abstracto 
    */
    public abstract void consultarServicio();
    
    
}
