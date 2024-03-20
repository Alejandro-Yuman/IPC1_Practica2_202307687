/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import java.io.Serializable;

/**
 *
 * @author reneb
 */
public class Vehiculo implements Serializable {
    private int id;
    private float consumo;
    private int capacidad;
    private String tipo;
    
    private String iconoRuta;
    private boolean enUso;
    public Vehiculo(float consumo, int capacidad, String tipo, String iconoRuta) {
        this.id = id;
        this.consumo = consumo;
        this.capacidad = capacidad;
        this.tipo = tipo;
        this.iconoRuta = iconoRuta;
        this.enUso = false;
    }

    public boolean isEnUso() {
        return enUso;
    }

    public void setEnUso(boolean enUso) {
        this.enUso = enUso;
    }


    

    public String getIconoRuta() {
        return iconoRuta;
    }

    public void setIconoRuta(String iconoRuta) {
        this.iconoRuta = iconoRuta;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getConsumo() {
        return consumo;
    }

    public void setConsumo(int consumo) {
        this.consumo = consumo;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
}
