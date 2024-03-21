/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import listas.ListaVehiculos;
import listas.ListaViajesActivos;
import modelos.Viaje;
import vistas.MenuPrincipal;
import listas.ListaViajesTerminados;
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
    boolean puedeAvanzar;
    
    float capacidadMax;
    float tanqueGastado;
    float gasto;
    
    int recorridoActual;
    int recorridoRelativo;
    int recorridoTotal;
    int recorridoAcumulado;
    
    float galConsumidos= 0;
    public ControladorVehiculo_1(MenuPrincipal menu) {

        

        //Obtener menu y posiciones inciales
        this.menu = menu;
        this.posx_moto = this.menu.vehiculoLabel_1.getX();
        this.posy_moto = this.menu.vehiculoLabel_1.getY();
        this.posx_panel = this.menu.panel_Vehiculo_1.getX();
        this.posy_panel = this.menu.panel_Vehiculo_1.getY();
        
        //Obtener datos de la gasolina
        capacidadMax = this.menu.viaje_1.getVehiculo().getCapacidad();
        gasto = this.menu.viaje_1.getVehiculo().getConsumo();
        tanqueGastado = capacidadMax+gasto;
        
        System.out.println(gasto);
        this.menu.infoLabel_1.setText("<html>" + "Recorrido: " + "0" + "<br>" + "Gasolina: " + tanqueGastado + "</html>");
        //velocidad =100- this.menu.viaje_1.getDistancia() ;
        
        
        //Calculo de la velocidad
        velocidad =555/this.menu.viaje_1.getDistancia();
        if(velocidad <0){
            velocidad = velocidad * (-1);
        }       
        
        //Calculo del cambio de distancia
        cambioDistancia =(double)this.menu.viaje_1.getDistancia()/(double)555;
        
        
        moverDerecha = true;
        puedeAvanzar = true;
        
    }

    @Override
    public void run(){
        while (running) {
            try {
                Thread.sleep(100);
                if (puedeAvanzar) {
                    if (moverDerecha) {
                        moverDerecha();
                    } else if (moverIzquierda) {
                         moverIzquierda();
                    } else {

                    }
                }else{
                    if (this.menu.gasolinaDisponible_1) {
                        this.menu.gasolinaDisponible_1 = false;
                        puedeAvanzar = true;
                        tanqueGastado = 0;
                        this.menu.gasolina_1Button.setEnabled(false);
                        recorridoRelativo = recorridoActual;
                        galConsumidos++;
                    }
                    if (this.menu.volver_1) {
                        this.menu.mensaje_1.setText("");
                        this.menu.volver_1 = false;
                        puedeAvanzar = true;
                        moverIzquierda = true;
                        recorridoAcumulado = recorridoActual;
                        this.menu.finalizar_1Button.setEnabled(false);
                        this.menu.vehiculoLabel_1.setSize(1*(this.menu.vehiculoLabel_1.getWidth()),this.menu.vehiculoLabel_1.getHeight());
                    }
                    if (this.menu.finalizar_1) {
                        finalizar();
                        
                    }
                }



                
            } catch (InterruptedException ex) {
                Logger.getLogger(ControladorMoto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public void kill() {
        running = false;
    }
    
    void moverDerecha(){
        //Cambiar la posicion del label y panel dependiendo de la velocidad
        posx_moto += velocidad;
        this.menu.vehiculoLabel_1.setLocation(posx_moto, posy_moto);
        posx_panel += velocidad;
        this.menu.panel_Vehiculo_1.setLocation(posx_panel, posy_panel);
        this.menu.moto_rect1 = this.menu.vehiculoLabel_1.getBounds();
        
        
        //Calculo del recorrido
        recorridoActual = (int) Math.round((this.menu.vehiculoLabel_1.getX() - 130) * cambioDistancia * 100) / 100;
        this.menu.recorrido_1 = recorridoActual;
        
        
        
        tanqueGastado = gasto*(recorridoActual-recorridoRelativo);
        if (tanqueGastado >= capacidadMax) {
            puedeAvanzar = false;
            tanqueGastado = capacidadMax;
            this.menu.gasolina_1Button.setEnabled(true);
        }

        
        this.menu.infoLabel_1.setText("<html>" + "Recorrido: " + String.valueOf(this.menu.recorrido_1) + "<br>" + "Gasolina: " +  (float) Math.round((capacidadMax - tanqueGastado) * 100) / 100 + "</html>");


        //Si llega al final
        if (this.menu.moto_rect1.intersects(this.menu.metaFinal)) {
            moverDerecha = false;
            puedeAvanzar = false;
            this.menu.retorno_1Button.setEnabled(true);
            this.menu.finalizar_1Button.setEnabled(true);
            recorridoTotal = recorridoActual;
            this.menu.mensaje_1.setText("Llegaste a tu destino");
        }
       

    }
    
    void moverIzquierda(){
        //Cambiar la posicion del label y panel dependiendo de la velocidad

        posx_moto -= velocidad;
        this.menu.vehiculoLabel_1.setLocation(posx_moto, posy_moto);
        posx_panel -= velocidad;
        this.menu.panel_Vehiculo_1.setLocation(posx_panel, posy_panel);
        this.menu.moto_rect1 = this.menu.vehiculoLabel_1.getBounds();
        
        
        //Calculo del recorrido
        recorridoActual = (int) (Math.round((555-(this.menu.vehiculoLabel_1.getX() - 130)) * cambioDistancia * 100) / 100)+recorridoAcumulado;
        this.menu.recorrido_1 = recorridoActual;
        
        
        
        tanqueGastado = gasto*(recorridoActual-recorridoRelativo);
        if (tanqueGastado >= capacidadMax) {
            puedeAvanzar = false;
            tanqueGastado = capacidadMax;
            this.menu.gasolina_1Button.setEnabled(true);
        }

        
        this.menu.infoLabel_1.setText("<html>" + "Recorrido: " + String.valueOf(this.menu.recorrido_1) + "<br>" + "Gasolina: " +  (float) Math.round((capacidadMax - tanqueGastado) * 100) / 100 + "</html>");


        //Si llega al final
        if (this.menu.moto_rect1.intersects(this.menu.metaInicial)) {
            moverDerecha = false;
            puedeAvanzar = false;
            this.menu.gasolina_1Button.setEnabled(false);
            this.menu.retorno_1Button.setEnabled(false);
            this.menu.finalizar_1Button.setEnabled(true);
            recorridoTotal = recorridoActual;
            this.menu.mensaje_1.setText("Llegaste a tu destino");
        }
       

    }
    
    void finalizar(){
        this.menu.moviendo_1 = false;
        ListaViajesActivos.eliminarViajeActivo(this.menu.viaje_1.getId());
        Viaje viajeTemp = this.menu.viaje_1;
        viajeTemp.setDatosFinalizar(LocalDateTime.now(), (galConsumidos*capacidadMax)+tanqueGastado, recorridoTotal);
        ListaViajesTerminados.addViajeTerminados(viajeTemp);
        this.menu.gasolina_1Button.setEnabled(false);
        this.menu.retorno_1Button.setEnabled(false);
        ListaVehiculos.setActivoByTipo( this.menu.viaje_1.getVehiculo().getTipo(), false);
        this.kill();
    }
  
}
