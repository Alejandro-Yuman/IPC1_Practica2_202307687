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
    int posx_panel, posy_panel;
    private volatile boolean running = true;
    
    int velocidad;
    double cambioDistancia;
    
    boolean moverDerecha = false;
    boolean moverIzquierda = false;
    public ControladorVehiculo_1(MenuPrincipal menu) {
        this.menu = menu;
        this.posx_moto = this.menu.vehiculoLabel_1.getX();
        this.posy_moto = this.menu.vehiculoLabel_1.getY();
        this.posx_panel = this.menu.panel_Vehiculo_1.getX();
        this.posy_panel = this.menu.panel_Vehiculo_1.getY();
        //velocidad =100- this.menu.viaje_1.getDistancia() ;
        velocidad =555/this.menu.viaje_1.getDistancia();
        if(velocidad <0){
            velocidad = velocidad * (-1);
        }       
        cambioDistancia =(double)this.menu.viaje_1.getDistancia()/(double)555;
        System.out.println(velocidad);
        System.out.println(cambioDistancia);
        moverDerecha = true;
    }

    @Override
    public void run(){
        while (running) {
            try {
                // El hilo se duerme por 1 segundo
                Thread.sleep(100);
                if (moverDerecha) {

                    posx_moto += velocidad;
                    this.menu.vehiculoLabel_1.setLocation(posx_moto, posy_moto);
                    posx_panel += velocidad;
                    this.menu.panel_Vehiculo_1.setLocation(posx_panel, posy_panel);
                    this.menu.moto_rect1 = this.menu.vehiculoLabel_1.getBounds();
                    
                    
                    
                    this.menu.recorrido_1 = Math.round((this.menu.vehiculoLabel_1.getX()-130)*cambioDistancia*100)/100;
                    this.menu.infoLabel_1.setText("<html>" + "Recorrido: " + String.valueOf(this.menu.recorrido_1) +"<br>"+"Gasolina Actual: "+"gasolina_1"+ "</html>");
                    
                    
                    System.out.println("Carro :" + this.menu.panel_Vehiculo_1.getBounds() + "Rec: " + this.menu.moto_rect1);
                    System.out.println("Meta :" + this.menu.metaFinal);
                    System.out.println(" ");
                    if (this.menu.moto_rect1.intersects(this.menu.metaFinal)) {
                        moverDerecha = false;
                    }
                }else if(moverIzquierda){
                
                }else{
                    
                }

                
            } catch (InterruptedException ex) {
                Logger.getLogger(ControladorMoto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
    
    
}
