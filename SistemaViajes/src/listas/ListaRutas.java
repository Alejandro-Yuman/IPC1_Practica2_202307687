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
