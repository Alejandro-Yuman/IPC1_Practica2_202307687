/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sistemaviajes;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.UIManager;
import listas.ListaRutas;
import listas.ListaVehiculos;
import listas.ListaViajesActivos;
import listas.ListaViajesTerminados;
import modelos.Ruta;
import modelos.Vehiculo;
import modelos.Viaje;
import utils.Toolbox;
import vistas.MenuPrincipal;

/**
 *
 * @author reneb
 */
public class SistemaViajes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {


        /*ListaRutas.addRuta(new Ruta("Guatemala","Jutiapa",105));
        ListaRutas.addRuta(new Ruta("Guatemala","Palin",130));
        ListaRutas.addRuta(new Ruta("Guatemala","Escuintla",145));
        ListaRutas.addRuta(new Ruta("Peten","Guatemala",210));
        ListaRutas.addRuta(new Ruta("Zona 18","Usac",30));
        ListaRutas.addRuta(new Ruta("Guatemala","El Salvador",160));*/
        
        ListaViajesTerminados.setLista(Toolbox.DeserializarTerminados());
        if (ListaViajesTerminados.getViajesTerminados() != null) {
            System.out.println("Hay Datos");
        }else{
            System.out.println("No hay datos");
            ListaViajesTerminados.setLista(new ArrayList<Viaje>());
        }
        
        ListaViajesActivos.setLista(Toolbox.DeserializarActivos());
        if (ListaViajesActivos.getViajesActivo()!= null) {
            System.out.println("Hay Datos");
        }else{
            System.out.println("No hay datos");
            ListaViajesActivos.setLista(new ArrayList<Viaje>());
        }
        
        ListaVehiculos.setLista(Toolbox.DeserializarVehiculos());
        if (ListaVehiculos.getVehiculos()!= null) {
            System.out.println("Hay Datos");
        }else{
            System.out.println("No hay datos");
            ListaVehiculos.setLista(new ArrayList<Vehiculo>());
                    
            ListaVehiculos.addVehiculo(new Vehiculo(0.1f, 6, "Motocicleta 1", "/img/Moto1.png"));
            ListaVehiculos.addVehiculo(new Vehiculo(0.1f, 6, "Motocicleta 2", "/img/Moto2.png"));
            ListaVehiculos.addVehiculo(new Vehiculo(0.1f, 6, "Motocicleta 3", "/img/Moto3.png"));
            ListaVehiculos.addVehiculo(new Vehiculo(0.3f, 10, "Vehículo estándar 1", "/img/CarroEstandar1.png"));
            ListaVehiculos.addVehiculo(new Vehiculo(0.3f, 10, "Vehículo estándar 2", "/img/CarroEstandar2.png"));
            ListaVehiculos.addVehiculo(new Vehiculo(0.3f, 10, "Vehículo estándar 3", "/img/CarroEstandar3.png"));
            ListaVehiculos.addVehiculo(new Vehiculo(0.45f, 12, "Vehículo premium 1", "/img/CarroPremium1.png"));
            ListaVehiculos.addVehiculo(new Vehiculo(0.45f, 12, "Vehículo premium 2", "/img/CarroPremium2.png"));
            ListaVehiculos.addVehiculo(new Vehiculo(0.45f, 12, "Vehículo premium 3", "/img/CarroPremium3.png"));


        }
        
        
        
        MenuPrincipal menu = new MenuPrincipal();

    }
    
}
