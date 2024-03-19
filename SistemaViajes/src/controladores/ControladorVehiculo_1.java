/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import java.util.logging.Level;
import java.util.logging.Logger;
import vistas.MenuPrincipal;

/**
 *
 * @author Alejandro
 */
public class ControladorVehiculo_1 extends Thread{
    MenuPrincipal menu;
    int posx_moto, posy_moto;
    private volatile boolean running = true;

    public ControladorVehiculo_1(MenuPrincipal menu) {
        this.menu = menu;
        this.posx_moto = this.menu.vehiculoLabel_1.getX();
        this.posy_moto = this.menu.vehiculoLabel_1.getY();
                        
    }

    @Override
    public void run(){
        while (running) {
            try {
                // El hilo se duerme por 1 segundo
                Thread.sleep(2000);
                posx_moto += 10;
                this.menu.vehiculoLabel_1.setLocation(posx_moto, posy_moto);
                
            } catch (InterruptedException ex) {
                Logger.getLogger(ControladorMoto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
    
    
}
