/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listas;

import java.util.ArrayList;
import modelos.Viaje;

/**
 *
 * @author Alejandro
 */
public class ListaViajesActivos {
     static ArrayList<Viaje> viajesActivos = new ArrayList<Viaje>();
    
    public static void printViajesActivos() {
        for (int i = 0; i < viajesActivos.size(); i++) {
            System.out.println("inicio " + viajesActivos.get(i).getPuntoFinal()+"final " + viajesActivos.get(i).getPuntoFinal()+ " id="+viajesActivos.get(i).getId());
        }
    }
    
    public static void setLista(ArrayList<Viaje> listaAñadir){
        viajesActivos = listaAñadir;
    }
    
    public static int getTamaño(){
        return viajesActivos.size();
    }
    
    public static Viaje getViajeActivo(int id){
        
        for (int i = 0; i < viajesActivos.size(); i++) {
            if(viajesActivos.get(i).getId() == id){
                return viajesActivos.get(i);
            }
        }
        return null;
    }
    public static void eliminarViajeActivo(int id){
        
        for (int i = 0; i < viajesActivos.size(); i++) {
            if(viajesActivos.get(i).getId() == id){
                viajesActivos.remove(i);
                break;
            }
        }
    }
        public static void addViajeActivo(Viaje viajeActivo) {
        viajeActivo.setId(generarId());
        viajesActivos.add(viajeActivo);
    }
    
    public static void editViajeActivo(Viaje viajeActivo, int id){
        for (int i = 0; i < viajesActivos.size(); i++) {
            if(viajesActivos.get(i).getId() == id){
                viajesActivos.set(i, viajeActivo);
                break;
                
            }
        }
    }
    
    public static ArrayList<Viaje> getViajesActivo(){
        return viajesActivos;
    }
    
    
    static int generarId(){
        for (int i = 0; i < viajesActivos.size(); i++) {
            if(viajesActivos.get(i).getId() != (i+1)){
                System.out.println(i);
                return i;
            }
        }
        if(viajesActivos.isEmpty()){
            return 1;
        }else{

            return viajesActivos.getLast().getId()+1;
            
        }
        
        
    }
    
}
