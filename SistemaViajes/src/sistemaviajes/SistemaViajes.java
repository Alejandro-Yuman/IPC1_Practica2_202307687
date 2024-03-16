/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sistemaviajes;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
        
        MenuPrincipal menu = new MenuPrincipal();

    }
    
}
