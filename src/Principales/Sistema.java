/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Principales;
import java.util.Scanner;
/**
 *
 * @author sjpin
 */
public class Sistema {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /*
        MOstramos la bienvenida al Usuario al sistema
        para obtener los datos(user y contraseña)
        */
        System.out.println("********************************");
        System.out.println("    BIENVENIDO AL SISTEMA    ");
        System.out.println("********************************");
        System.out.print("USUARIO: ");
        String usuario = sc.nextLine();
        System.out.print("CONTRASEÑA: ");
        String contraseña = sc.nextLine();
    }
    
}
