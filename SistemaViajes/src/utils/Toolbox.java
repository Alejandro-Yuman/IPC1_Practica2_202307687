/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.awt.Image;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.ImageIcon;
import listas.ListaRutas;
import modelos.Ruta;

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
    
}
