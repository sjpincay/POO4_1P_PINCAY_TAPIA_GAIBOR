/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ManejoArchivos;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/**
 *
 * @author Verónica
 */
public class ManejoArchivos {
    /**
     * 
     * @param nombrearchivo
     * @return 
     */
    public static ArrayList<String> LeeFichero(String nombrearchivo) {
        ArrayList<String> lineas = new ArrayList<>();
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File(nombrearchivo);
            fr = new FileReader(archivo,StandardCharsets.UTF_8);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
                lineas.add(linea);

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta 
            // una excepcion.
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return lineas;

    }
    /**
     * 
     * @param nombreArchivo
     * @param linea 
     */
    public static void EscribirArchivo(String nombreArchivo, String linea) {

        FileWriter fichero = null;
        BufferedWriter bw = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter(nombreArchivo,true);
            bw = new BufferedWriter(fichero);
            bw.write(linea+"\n");
            System.out.println("ksdsdlsd");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Nuevamente aprovechamos el finally para 
                // asegurarnos que se cierra el fichero.
                if (null != fichero) {
                    //fichero.close();
                    bw.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
    
    /**
     * En este método verificamos si para leer el archivo se debe saltar la primera linea o no
     * @param nombreArchivo
     * @param saltarPrimeraLinea
     * @return 
     */
    public static ArrayList<String[]> LeerValidar(String nombreArchivo, boolean saltarPrimeraLinea){
        ArrayList<String> lineas= ManejoArchivos.LeeFichero(nombreArchivo);
        ArrayList<String[]> datos= new ArrayList<>();
        int i;
        if(saltarPrimeraLinea){
            for(i=1; i<lineas.size(); i++){
                datos.add(lineas.get(i).split(","));              
            }
        }else{
            for(i=0; i<lineas.size(); i++){
                datos.add(lineas.get(i).split(","));
            }
        }
        return datos;
    }
    
}

