/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listas;

import java.util.ArrayList;
import modelos.Vehiculo;

/**
 *
 * @author Alejandro
 */
public class ListaVehiculos {
    static ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
    
    public static void printRutas() {
        for (int i = 0; i < vehiculos.size(); i++) {
            System.out.println("id " + vehiculos.get(i).getId()+"tipo " + vehiculos.get(i).getTipo()+ " consumo="+vehiculos.get(i).getConsumo());
        }
    }
    
    public static Vehiculo getVehiculo(int id){
        
        for (int i = 0; i < vehiculos.size(); i++) {
            if(vehiculos.get(i).getId() == id){
                return vehiculos.get(i);
            }
        }
        return null;
    }
    
    public static Vehiculo getVehiculoByTipo(String tipo){
        for (int i = 0; i < vehiculos.size(); i++) {
            if(vehiculos.get(i).getTipo()== tipo){
                return vehiculos.get(i);
            }
        }
        return null;
    }
    
    public static void setActivoByTipo(String tipo, boolean estado){
        for (int i = 0; i < vehiculos.size(); i++) {
            if (vehiculos.get(i).getTipo().equals(tipo)) {
                vehiculos.get(i).setEnUso(estado);
            }
        }
        
    }
    public static void eliminarVehiculo(int id){
        
        for (int i = 0; i < vehiculos.size(); i++) {
            if(vehiculos.get(i).getId() == id){
                vehiculos.remove(i);
                break;
            }
        }
    }
        public static void addVehiculo(Vehiculo vehiculoNuevo) {
        vehiculoNuevo.setId(generarId());
        vehiculos.add(vehiculoNuevo);
    }
    
    public static void editVehiculo(Vehiculo vehiculoNuevo, int id){
        for (int i = 0; i < vehiculos.size(); i++) {
            if(vehiculos.get(i).getId() == id){
                vehiculos.set(i, vehiculoNuevo);
                break;
                
            }
        }
    }
    
    public static ArrayList<Vehiculo> getVehiculos(){
        return vehiculos;
    }
    
    public static ArrayList<Vehiculo> getVehiculosActivos(){
        ArrayList<Vehiculo> vehiculosActivos = new ArrayList<Vehiculo>();
        for (int i = 0; i < vehiculos.size(); i++) {
            if (!vehiculos.get(i).isEnUso()) {
                vehiculosActivos.add(vehiculos.get(i));
            }
        }
        return vehiculosActivos;
    }
    
    
    
    
    static int generarId(){
        for (int i = 0; i < vehiculos.size(); i++) {
            if(vehiculos.get(i).getId() != (i+1)){
                System.out.println(i);
                return i;
            }
        }
        if(vehiculos.isEmpty()){
            return 1;
        }else{

            return vehiculos.getLast().getId()+1;
            
        }
        
        
    }
}
