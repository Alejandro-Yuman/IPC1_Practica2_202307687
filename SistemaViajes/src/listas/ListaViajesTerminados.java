/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listas;

import java.util.ArrayList;
import modelos.Viaje;
import utils.Toolbox;

/**
 *
 * @author Alejandro
 */
public class ListaViajesTerminados {
    static ArrayList<Viaje> viajesTerminados = new ArrayList<Viaje>();
    
    public static void printViajesTerminados() {
        for (int i = 0; i < viajesTerminados.size(); i++) {
            System.out.println("inicio " + viajesTerminados.get(i).getPuntoFinal()+"final " + viajesTerminados.get(i).getPuntoFinal()+ " id="+viajesTerminados.get(i).getId());
        }
    }
    
    public static void setLista(ArrayList<Viaje> listaAñadir){
        viajesTerminados = listaAñadir;
    }
    
    public static Viaje getViajeTerminado(int id){
        
        for (int i = 0; i < viajesTerminados.size(); i++) {
            if(viajesTerminados.get(i).getId() == id){
                return viajesTerminados.get(i);
            }
        }
        return null;
    }
    public static void eliminarViajeTerminado(int id){
        
        for (int i = 0; i < viajesTerminados.size(); i++) {
            if(viajesTerminados.get(i).getId() == id){
                viajesTerminados.remove(i);
                mandarSerializar();
                break;
            }
        }
        
    }
        public static void addViajeTerminados(Viaje viajeTerminados) {
        viajeTerminados.setId(generarId());
        viajesTerminados.add(viajeTerminados);
        mandarSerializar();
    }
    
    public static void editViajeTerminados(Viaje viajeTerminados, int id){
        for (int i = 0; i < viajesTerminados.size(); i++) {
            if(viajesTerminados.get(i).getId() == id){
                viajesTerminados.set(i, viajeTerminados);
                mandarSerializar();
                break;
                
            }
        }
        
    }
    
    public static ArrayList<Viaje> getViajesTerminados(){
        return viajesTerminados;
    }
    
    
    static int generarId(){
        for (int i = 0; i < viajesTerminados.size(); i++) {
            if(viajesTerminados.get(i).getId() != (i+1)){
                System.out.println(i);
                return i;
            }
        }
        if(viajesTerminados.isEmpty()){
            return 1;
        }else{

            return viajesTerminados.getLast().getId()+1;
            
        }
        
        
    }
    
    private static void mandarSerializar(){
        Toolbox.SerializarTerminados();
    }
}
