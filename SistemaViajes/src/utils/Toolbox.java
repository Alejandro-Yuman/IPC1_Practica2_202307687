/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import javax.sound.sampled.AudioInputStream;
import javax.swing.ImageIcon;
import listas.ListaRutas;
import listas.ListaViajesActivos;
import listas.ListaViajesTerminados;
import modelos.Ruta;
import modelos.Viaje;

/**
 *
 * @author reneb
 */
public class Toolbox {
    public static ImageIcon adjustImage(String url, int ancho, int alto ){
        ImageIcon imgLogo = new ImageIcon(Toolbox.class.getResource(url));
        Image imageDimension = imgLogo.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
        return  new ImageIcon(imageDimension);
    }
    
    public static ImageIcon ImageIconSinDimensiones(String url){
        return new ImageIcon(Toolbox.class.getResource(url));
    }
    
    public static void lecturaCSV(File archivoCSV){
        try{
            Scanner lector = new Scanner(archivoCSV);
            boolean encabezado = true;
            
            while (lector.hasNextLine()) {
                String linea = lector.nextLine();
                
                if(!encabezado){
                    String[] datos = linea.split(",");
                    Ruta ruta = new Ruta(datos[0],datos[1],Integer.parseInt(datos[2]));
                    ListaRutas.addRuta(ruta);
                }
                encabezado = false;
            }
        }catch(FileNotFoundException ex){
            ex.printStackTrace();
        }
    }
    
    
    public static void SerializarTerminados(){
        try{
            String directionFile ="./datos/Info_Terminados.bin";
            ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(directionFile));
            salida.writeObject(ListaViajesTerminados.getViajesTerminados());
            salida.close();
            System.out.println("Serializcion Exitosamente");
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static ArrayList<Viaje> DeserializarTerminados(){
        try{
            String directionFile ="./datos/Info_Terminados.bin";
            ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(directionFile));
            
            ArrayList<Viaje> viajesEntrada = (ArrayList<Viaje>)entrada.readObject();
            entrada.close();
            System.out.println("Datos Deserializados Exitosamente");
            return viajesEntrada;
        }catch (Exception ex) {
            return null;
        }
    }

    
    public static void SerializarActivos(){
        try{
            String directionFile ="./datos/Info_Activos.bin";
            ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(directionFile));
            salida.writeObject(ListaViajesActivos.getViajesActivo());
            salida.close();
            System.out.println("Serializcion Exitosamente");
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static ArrayList<Viaje> DeserializarActivos(){
        try{
            String directionFile ="./datos/Info_Activos.bin";
            ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(directionFile));
            
            ArrayList<Viaje> viajesEntrada = (ArrayList<Viaje>)entrada.readObject();
            entrada.close();
            System.out.println("Datos Deserializados Exitosamente");
            return viajesEntrada;
        }catch (Exception ex) {
            return null;
        }
    }


}
