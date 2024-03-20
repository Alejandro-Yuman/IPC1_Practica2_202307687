/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import java.time.LocalDateTime;

/**
 *
 * @author reneb
 */
public class Viaje {
    private int id;
    private String puntoInicio;
    private String puntoFinal;
    private Vehiculo vehiculo;
    private int distancia;
    private float gasolinaConsumida;
    private LocalDateTime  fechaInicio;
    private LocalDateTime  fechaFinal;
    private boolean activo;
    
    
    public Viaje( String puntoInicio, String puntoFinal, Vehiculo vehiculo, int distancia, LocalDateTime fechaInicio) {
        this.puntoInicio = puntoInicio;
        this.puntoFinal = puntoFinal;
        this.vehiculo = vehiculo;
        this.distancia = distancia;
        this.fechaInicio = fechaInicio;
        activo = true;
    }
    
    public void setDatosFinalizar(LocalDateTime fecha, float gas ,int distancia){
        this.gasolinaConsumida = gas;
        this.fechaFinal = fecha;
        this.distancia = distancia;
        activo = false;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPuntoInicio() {
        return puntoInicio;
    }

    public void setPuntoInicio(String puntoInicio) {
        this.puntoInicio = puntoInicio;
    }

    public String getPuntoFinal() {
        return puntoFinal;
    }

    public void setPuntoFinal(String puntoFinal) {
        this.puntoFinal = puntoFinal;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public float getGasolinaConsumida() {
        return gasolinaConsumida;
    }

    public void setGasolinaConsumida(int gasolinaConsumida) {
        this.gasolinaConsumida = gasolinaConsumida;
    }

    public LocalDateTime getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDateTime fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDateTime getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(LocalDateTime fechaFinal) {
        this.fechaFinal = fechaFinal;
    }
    
    
}
