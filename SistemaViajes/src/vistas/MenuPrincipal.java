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

    public MenuPrincipal() {
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
        separador.setBounds(20, 90, 200, 10);
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
        inicioButton.addActionListener(this);
        inicioButton.setHorizontalAlignment(SwingConstants.LEFT);
        inicioButton.setIcon(Toolbox.adjustImage("../img/Inicio.png", 30, 30));
        inicioButton.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
        panelBotones.add(inicioButton);
        
        JButton rutasButton = new JButton("Rutas");
        rutasButton.setBounds(0,50,250,50);
        rutasButton.setBackground(Colores.principalBotonesSecundario);
        rutasButton.setBorder(null);
        rutasButton.setFont(Fuentes.getPrincipalFontSize(12, true));
        rutasButton.setForeground(Colores.white);
        rutasButton.addActionListener(this);
        rutasButton.setHorizontalAlignment(SwingConstants.LEFT);
        rutasButton.setIcon(Toolbox.adjustImage("../img/Rutas.png", 30, 30));
        rutasButton.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
        panelBotones.add(rutasButton);
        
        JButton viajesButton = new JButton("Viajes");
        viajesButton.setBounds(0,100,250,50);
        viajesButton.setBackground(Colores.principalBotonesSecundario);
        viajesButton.setBorder(null);
        viajesButton.setFont(Fuentes.getPrincipalFontSize(12, true));
        viajesButton.setForeground(Colores.white);
        viajesButton.addActionListener(this);
        viajesButton.setHorizontalAlignment(SwingConstants.LEFT);
        viajesButton.setIcon(Toolbox.adjustImage("../img/Viajes.png", 30, 30));
        viajesButton.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
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
    
    JPanel panelBienvenida(){
        JPanel panelBienvenida = new JPanel();
        panelBienvenida.setLayout(null);
        panelBienvenida.setBackground(Colores.background);
        return panelBienvenida;
     }
    
    JPanel panelRutas(){
        JPanel panelRutas = new JPanel();
        panelRutas.setLayout(null);
        panelRutas.setBackground(Colores.background);
        
                
        JButton cerrarSesionButton = new JButton("Hola Tilin");
        cerrarSesionButton.setBounds(10,10,150,50);
        cerrarSesionButton.setBackground(Colores.principalBotones);
        cerrarSesionButton.setFont(Fuentes.getPrincipalFontSize(12, true));
        cerrarSesionButton.setForeground(Colores.white);
        //cerrarSesionButton.addActionListener(this);
        panelRutas.add(cerrarSesionButton);
        return panelRutas;
    }
    
     JPanel panelViajes(){
        JPanel panelViajes = new JPanel();
        panelViajes.setLayout(null);
        panelViajes.setBackground(Colores.background);
        return panelViajes;
     }
 
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
    
}
