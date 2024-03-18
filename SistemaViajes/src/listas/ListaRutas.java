/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listas;

import java.util.ArrayList;
import modelos.Ruta;

/**
 *
 * @author Alejandro
 */
public class ListaRutas {
    static ArrayList<Ruta> rutas = new ArrayList<Ruta>();
    
    public static void printRutas() {
        for (int i = 0; i < rutas.size(); i++) {
            System.out.println("Inicio " + rutas.get(i).getPuntoInicio()+"Final " + rutas.get(i).getPuntoFinal()+ " id="+rutas.get(i).getId());
        }
    }
    
    public static ArrayList<String> getPuntos(){
        ArrayList<String> rutasPuntos = new ArrayList<String>();
        boolean encontradoPrimer = false;
        boolean encontradoSegundo = false;
        for (int i = 0; i < rutas.size(); i++) {

            for (int j = 0; j < rutasPuntos.size(); j++) {

                if(rutasPuntos.get(j).equals(rutas.get(i).getPuntoInicio())){
                    encontradoPrimer = true;
                    
                }
                if(rutasPuntos.get(j).equals(rutas.get(i).getPuntoFinal())){
                    encontradoSegundo = true;
                    
                }
            }
            if (!encontradoPrimer) {
                rutasPuntos.add(rutas.get(i).getPuntoInicio());
            }
            if (!encontradoSegundo) {
                rutasPuntos.add(rutas.get(i).getPuntoFinal());
            }
            encontradoPrimer = false;
            encontradoSegundo = false;

        }
        return rutasPuntos;
    }
    
    public static ArrayList<String> getPuntosRelacionados(String punto){
        ArrayList<String> rutasPuntos = new ArrayList<String>();
        boolean encontrado = false;
        for (int i = 0; i < rutas.size(); i++) {

            for (int j = 0; j < rutasPuntos.size(); j++) {

                if (rutasPuntos.get(j).equals(rutas.get(i).getPuntoInicio()) || rutasPuntos.get(j).equals(rutas.get(i).getPuntoFinal())) {
                    encontrado = true;
                }
            }
            if (!encontrado) {
                if (rutas.get(i).getPuntoInicio().equals(punto)) {
                    rutasPuntos.add(rutas.get(i).getPuntoFinal());
                } else if (rutas.get(i).getPuntoFinal().equals(punto)) {
                    rutasPuntos.add(rutas.get(i).getPuntoInicio());
                }
            }
            encontrado = false;
 
        }
        return rutasPuntos;
    }
    
    
    public static Ruta getRuta(int id){
        
        for (int i = 0; i < rutas.size(); i++) {
            if(rutas.get(i).getId() == id){
                return rutas.get(i);
            }
        }
        return null;
    }
    public static void eliminarRuta(int id){
        
        for (int i = 0; i < rutas.size(); i++) {
            if(rutas.get(i).getId() == id){
                rutas.remove(i);
                break;
            }
        }
    }
        public static void addRuta(Ruta rutaNueva) {
        rutaNueva.setId(generarId());
        rutas.add(rutaNueva);
    }
    
    public static void editRuta(Ruta rutaNueva, int id){
        for (int i = 0; i < rutas.size(); i++) {
            if(rutas.get(i).getId() == id){
                rutas.set(i, rutaNueva);
                break;
                
            }
        }
    }
    
    public static ArrayList<Ruta> getRutas(){
        return rutas;
    }
    
    
    
    
    static int generarId(){
        for (int i = 0; i < rutas.size(); i++) {
            if(rutas.get(i).getId() != (i+1)){
                System.out.println(i);
                return i;
            }
        }
        if(rutas.isEmpty()){
            return 1;
        }else{

            return rutas.getLast().getId()+1;
            
        }
        
        
    }
    
}
