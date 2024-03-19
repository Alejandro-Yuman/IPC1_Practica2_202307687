/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sistemaviajes;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.UIManager;
import listas.ListaRutas;
import listas.ListaVehiculos;
import modelos.Ruta;
import modelos.Vehiculo;
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
          
        LocalDateTime hora = LocalDateTime.now();
        LocalDateTime hora2 = LocalDateTime.of(2005, 6, 10, 12, 20);
        System.out.println(hora2.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));
        
        ListaVehiculos.addVehiculo(new Vehiculo(0.1f,6,"Motocicleta 1","../img/Moto1.png"));
        ListaVehiculos.addVehiculo(new Vehiculo(0.1f,6,"Motocicleta 2","../img/Moto2.png"));
        ListaVehiculos.addVehiculo(new Vehiculo(0.1f,6,"Motocicleta 3","../img/Moto3.png"));
        ListaVehiculos.addVehiculo(new Vehiculo(0.3f,10,"Vehículo estándar 1","../img/CarroEstandar1.png"));
        ListaVehiculos.addVehiculo(new Vehiculo(0.3f,10,"Vehículo estándar 2","../img/CarroEstandar2.png"));
        ListaVehiculos.addVehiculo(new Vehiculo(0.3f,10,"Vehículo estándar 3","../img/CarroEstandar3.png"));
        ListaVehiculos.addVehiculo(new Vehiculo(0.45f,12,"Vehículo premium 1","../img/CarroPremium1.png"));
        ListaVehiculos.addVehiculo(new Vehiculo(0.45f,12,"Vehículo premium 2","../img/CarroPremium2.png"));
        ListaVehiculos.addVehiculo(new Vehiculo(0.45f,12,"Vehículo premium 3","../img/CarroPremium3.png"));
        
        
        
        ListaRutas.addRuta(new Ruta("Guatemala","Jutiapa",105));
        ListaRutas.addRuta(new Ruta("Guatemala","Palin",130));
        ListaRutas.addRuta(new Ruta("Guatemala","Escuintla",145));
        ListaRutas.addRuta(new Ruta("Peten","Guatemala",210));
        ListaRutas.addRuta(new Ruta("Zona 18","Usac",30));
        ListaRutas.addRuta(new Ruta("Guatemala","El Salvador",160));
        
        
        MenuPrincipal menu = new MenuPrincipal();

    }
    
}
