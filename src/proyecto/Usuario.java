/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto;

/**
 *
 * @author sjpin
 */
public class Usuario {
    private String cedula;
    private String nombre;
    private String apellido;
    private String user;
    private String contraseña;
    private TipoUsuario tipo;
    
    public Usuario(String cedula,String nombre,String apellido , String user,String contraseña,TipoUsuario tipo ){
        this.cedula= cedula;
        this.nombre= nombre;
        this.apellido= apellido;
        this.user= user;
        this.contraseña= contraseña;
        this.tipo= tipo;
    }
    public String getCedula(){
       return cedula; 
    }
    public String getNombre(){
        return nombre;
    }
    public String getApellido(){
       return apellido; 
    }
    public String getUser(){
        return user;
    }
    public String getContraseña(){
        return contraseña;
    }
    public TipoUsuario getTipo(){
        return tipo;
    }

    public void setCedula(){
       this.cedula= cedula; 
    }
    public void setNombre(){
        this.nombre= nombre;
    }
    public void setApellido(){
       this.apellido= apellido; 
    }
    public void setUser(){
        this.user= user;
    }
    public void setContraseña(){
        this.contraseña= contraseña;
    }
    public void setTipo(){
        this.tipo= tipo;
    }
}
