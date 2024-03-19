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
public class ControladorMoto extends Thread{
    MenuPrincipal menu;
    int id_Controlar;
    int posx_moto, posy_moto;
    private volatile boolean running = true;

    public ControladorMoto(MenuPrincipal menu, int id) {
        this.menu = menu;
        this.id_Controlar = id;
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
                switch (id_Controlar) {
                    case 0:
                        moverPrimerVehiculo();
                        break;
                    case 1:
                        moverSegundoVehiculo();
                        break;
                    case 2:
                        moverTercerVehiculo();
                        break;
                    default:
                        throw new AssertionError();
                }
                
                

                
                
            } catch (InterruptedException ex) {
                Logger.getLogger(ControladorMoto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
    
    
    public void moverPrimerVehiculo(){
        this.menu.vehiculoLabel_1.setLocation(posx_moto, posy_moto);
    }
    public void moverSegundoVehiculo(){
        this.menu.vehiculoLabel_2.setLocation(posx_moto, posy_moto);
    }
    public void moverTercerVehiculo(){
        this.menu.vehiculoLabel_3.setLocation(posx_moto, posy_moto);
    }
    
    public void stopThread() {
        running = false;
    }
}
