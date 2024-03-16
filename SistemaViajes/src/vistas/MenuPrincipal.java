/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vistas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import utils.Colores;
import utils.Fuentes;
import utils.Toolbox;

/**
 *
 * @author reneb
 */
public class MenuPrincipal extends JFrame implements ActionListener{
    JTabbedPane tabbedPane;
    JPanel panelInicio;
    JPanel panelRutas;
    JPanel panelViajes;
    boolean inicioActive = false;
    boolean rutasActive = false;
    boolean viajesActive = false;
    
    public MenuPrincipal() {

        panelRutas();
        panelViajes();
        this.remove(panelRutas);
        this.remove(panelViajes);
        panelBienvenida();
        inicioActive = true;
        this.repaint();
        /*try{
            panelViajes();
            panelRutas();
            panelBienvenida();
            panelViajes.setVisible(false);
            panelRutas.setVisible(false);
        }
        catch (Exception ex) {

        }*/
        
        
        
        /*tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
        tabbedPane.setFont(Fuentes.getPrincipalFontSize(12, true));
        
        tabbedPane.add("",panelBienvenida());
        tabbedPane.setIconAt(0, Toolbox.adjustImage("../img/Inicio.png", 30, 30));
        tabbedPane.add("Rutas",panelRutas());
        tabbedPane.add("Viajes",panelViajes());
        
        
        tabbedPane.setBorder(null);
        tabbedPane.setBackground(Colores.white);
        tabbedPane.setBounds(10, 50, 1150, 600);
        this.add(tabbedPane);*/
        
        //---------------------------------Panel derecha
        JPanel panelPrincipalderecha = new JPanel();
        panelPrincipalderecha.setBounds(0,0,250,700);
        panelPrincipalderecha.setLayout(null);
        panelPrincipalderecha.setBackground(Colores.backgroundPanel);
        
        
        JLabel logoLabel = new JLabel(Toolbox.adjustImage("../img/ApertureWhite.png", 165, 45));
        logoLabel.setBounds(35, 30, 165, 45);
        panelPrincipalderecha.add(logoLabel);

        JSeparator separador = new JSeparator();
        separador.setBounds(25, 90, 200, 10);
        separador.setBackground(Colores.white);
        separador.setForeground(Colores.white);
        panelPrincipalderecha.add(separador);

        
        
        //-------------------------------------Botones
        JPanel panelBotones = new JPanel();
        panelBotones.setBounds(0,150,250,200);
        panelBotones.setBackground(null);
        panelBotones.setLayout(null);
        
        JButton inicioButton = new JButton("Inicio");
        inicioButton.setBounds(0,0,250,50);
        inicioButton.setBackground(Colores.principalBotonesSecundario);
        inicioButton.setBorder(null);
        inicioButton.setFont(Fuentes.getPrincipalFontSize(12, true));
        inicioButton.setForeground(Colores.white);
        inicioButton.setHorizontalAlignment(SwingConstants.LEFT);
        inicioButton.setIcon(Toolbox.adjustImage("../img/Inicio.png", 30, 30));
        inicioButton.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
        inicioButton.addActionListener(this);
        panelBotones.add(inicioButton);
        
        JButton rutasButton = new JButton("Rutas");
        rutasButton.setBounds(0,50,250,50);
        rutasButton.setBackground(Colores.principalBotonesSecundario);
        rutasButton.setBorder(null);
        rutasButton.setFont(Fuentes.getPrincipalFontSize(12, true));
        rutasButton.setForeground(Colores.white);
        rutasButton.setHorizontalAlignment(SwingConstants.LEFT);
        rutasButton.setIcon(Toolbox.adjustImage("../img/Rutas.png", 30, 30));
        rutasButton.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
        rutasButton.addActionListener(this);
        panelBotones.add(rutasButton);
        
        JButton viajesButton = new JButton("Viajes");
        viajesButton.setBounds(0,100,250,50);
        viajesButton.setBackground(Colores.principalBotonesSecundario);
        viajesButton.setBorder(null);
        viajesButton.setFont(Fuentes.getPrincipalFontSize(12, true));
        viajesButton.setForeground(Colores.white);
        viajesButton.setHorizontalAlignment(SwingConstants.LEFT);
        viajesButton.setIcon(Toolbox.adjustImage("../img/Viajes.png", 30, 30));
        viajesButton.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
        viajesButton.addActionListener(this);
        panelBotones.add(viajesButton);
        
        //-------------------------------------Fin Botones
        
        panelPrincipalderecha.add(panelBotones);
        this.add(panelPrincipalderecha);
        //---------------------------------Fin Panel derecha
        
        this.getContentPane().setBackground(Colores.background);
        this.setTitle("Panel de Gestiones");
        this.setSize(1200,700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
    void panelBienvenida(){
        if (!inicioActive) {
            inicioActive = true;
            rutasActive = false;
            viajesActive = false;

            panelInicio = new JPanel();
            panelInicio.setBounds(250, 0, 950, 700);
            panelInicio.setLayout(null);
            panelInicio.setBackground(Colores.background);
            
            
            //-------------------------Inicio Contendido
            
            
            JLabel tituloLabel = new JLabel("Bienvenido");
            tituloLabel.setBounds(20,20,400,30);
            tituloLabel.setForeground(Colores.tituloLetra);
            tituloLabel.setFont(Fuentes.getPrincipalFontSize(16, true));
            panelInicio.add(tituloLabel);
            
            
            
            
            //------------------------- Fin Contendido
            
            this.add(panelInicio);
            try {
                this.remove(panelViajes);
                this.remove(panelRutas);
                revalidate();

            } catch (Exception ex) {
            }

            this.repaint();
            
        }
     }
    
    void panelRutas(){
        if(!rutasActive){

            inicioActive = false;
            rutasActive = true;
            viajesActive = false;
            
            panelRutas = new JPanel();
            panelRutas.setBounds(250, 0, 950, 700);
            panelRutas.setLayout(null);
            panelRutas.setBackground(Colores.background);

            //-------------------------Inicio Contendido
            
            JButton cerrarSesionButton = new JButton("Boton Rutas");
            cerrarSesionButton.setBounds(250, 300, 250, 50);
            cerrarSesionButton.setBackground(Colores.principalBotones);
            cerrarSesionButton.setFont(Fuentes.getPrincipalFontSize(12, true));
            cerrarSesionButton.setForeground(Colores.white);
            panelRutas.add(cerrarSesionButton);

            
            //-------------------------Fin Contendido
            
            this.add(panelRutas);

            try {
                this.remove(panelViajes);
                this.remove(panelInicio);
                revalidate();
            } catch (Exception ex) {

            }

            this.repaint();

        }
    }
    
    void panelViajes(){
        if(!viajesActive) {
            inicioActive = false;
            rutasActive = false;
            viajesActive = true;
            
            panelViajes = new JPanel();
            panelViajes.setBounds(250, 0, 950, 700);
            panelViajes.setLayout(null);
            panelViajes.setBackground(Colores.background);

            //-------------------------Inicio Contendido
            
            JButton cerrarSesionButton = new JButton("Boton Viajes");
            cerrarSesionButton.setBounds(250, 500, 250, 50);
            cerrarSesionButton.setBackground(Colores.principalBotones);
            cerrarSesionButton.setFont(Fuentes.getPrincipalFontSize(12, true));
            cerrarSesionButton.setForeground(Colores.white);
            panelViajes.add(cerrarSesionButton);

            //-------------------------Inicio Contendido
            
            this.add(panelViajes);
            try {

                this.remove(panelRutas);
                this.remove(panelInicio);
                revalidate();

            } catch (Exception ex) {

            }

            this.repaint();
        }
     }
 
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getActionCommand().equals("Inicio")){
            panelBienvenida();
        }
        
        if(e.getActionCommand().equals("Rutas")){
            panelRutas();
        }
        if(e.getActionCommand().equals("Viajes")){
            panelViajes();
        }
    }
    
}
