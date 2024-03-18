/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sistemaviajes;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import listas.ListaRutas;
import modelos.Ruta;
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
        

        /*ListaRutas.addRuta(new Ruta("Guatemala","Jutiapa",105));
        ListaRutas.addRuta(new Ruta("Guatemala","Palin",130));
        ListaRutas.addRuta(new Ruta("Guatemala","Escuintla",145));
        ListaRutas.addRuta(new Ruta("Peten","Guatemala",210));
        ListaRutas.addRuta(new Ruta("Zona 18","Usac",30));
        ListaRutas.addRuta(new Ruta("Guatemala","El Salvador",160));*/
        
        
        MenuPrincipal menu = new MenuPrincipal();

    }
    
}
