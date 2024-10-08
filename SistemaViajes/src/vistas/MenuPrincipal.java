/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vistas;

import controladores.ControladorMoto;
import controladores.ControladorVehiculo_1;
import controladores.ControladorVehiculo_2;
import controladores.ControladorVehiculo_3;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.ItemSelectable;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.LookAndFeel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.basic.BasicScrollBarUI;
import listas.ListaRutas;
import listas.ListaVehiculos;
import listas.ListaViajesActivos;
import listas.ListaViajesTerminados;
import modelos.Ruta;
import modelos.Vehiculo;
import modelos.Viaje;
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
    JPanel panelHistorial;
    boolean inicioActive = false;
    boolean rutasActive = false;
    boolean viajesActive = false;
    boolean historialActive = false;
    
    JTextField idField;
    JTextField distanciaField;
    JComboBox puntoInicialCombo;
    JComboBox puntoFinalCombo;
    JComboBox tipoCarroCombo;
    
    public JPanel panel_Vehiculo_1;
    public JPanel panel_Vehiculo_2;
    public JPanel panel_Vehiculo_3;
    
    public JLabel vehiculoLabel_1;
    public JLabel vehiculoLabel_2;
    public JLabel vehiculoLabel_3;
    
    public JLabel mensaje_1;
    public JLabel mensaje_2;
    public JLabel mensaje_3;
    
    public boolean moviendo_1 = false;
    public boolean moviendo_2 = false;
    public boolean moviendo_3 = false;
    
    public Rectangle moto_rect1;
    public Rectangle moto_rect2;
    public Rectangle moto_rect3;
    
    public Viaje viaje_1;
    public Viaje viaje_2;
    public Viaje viaje_3;
    
    public int recorrido_1 =0;
    public int recorrido_2 =0;
    public int recorrido_3 =0;
    
    public int gasolina_1 =0;
    public int gasolina_2 =0;
    public int gasolina_3 =0;
    
    public JButton gasolina_1Button;
    public JButton gasolina_2Button;
    public JButton gasolina_3Button;
    
    public JButton retorno_1Button;
    public JButton retorno_2Button;
    public JButton retorno_3Button;
    
    public JButton finalizar_1Button;
    public JButton finalizar_2Button;
    public JButton finalizar_3Button;
    
    public boolean finalizar_1;
    public boolean finalizar_2;
    public boolean finalizar_3;
    
    public boolean volver_1;
    public boolean volver_2;
    public boolean volver_3;
    
    public boolean gasolinaDisponible_1 = false;
    public boolean gasolinaDisponible_2 = false;
    public boolean gasolinaDisponible_3 = false;
    
    public JLabel infoLabel_1;
    public JLabel infoLabel_2;
    public JLabel infoLabel_3;
    
    public Rectangle metaFinal;
    public Rectangle metaInicial;
        
    public MenuPrincipal() {
        panelBienvenida();
        panelRutas();
        panelViajes();
        panelHistorial();
        this.remove(panelInicio);
        this.remove(panelRutas);
        this.remove(panelViajes);
        this.remove(panelHistorial);
        botonSeleccionado(0);
        this.repaint();
        
        //---------------------------------Panel derecha
        JPanel panelPrincipalderecha = new JPanel();
        panelPrincipalderecha.setBounds(0,0,250,700);
        panelPrincipalderecha.setLayout(null);
        panelPrincipalderecha.setBackground(Colores.backgroundPanel);
        
        
        JLabel logoLabel = new JLabel(Toolbox.adjustImage("/img/ApertureWhite.png", 165, 45));
        logoLabel.setBounds(35, 20, 165, 45);
        panelPrincipalderecha.add(logoLabel);

        JSeparator separador = new JSeparator();
        //separador.setBounds(25, 90, 200, 10);
        separador.setBounds(0, 90, 250, 10);
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
        inicioButton.setIcon(Toolbox.adjustImage("/img/Inicio.png", 30, 30));
        inicioButton.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
        inicioButton.setFocusPainted(false);
        inicioButton.addActionListener(this);
        panelBotones.add(inicioButton);
        
        JButton rutasButton = new JButton("Rutas");
        rutasButton.setBounds(0,50,250,50);
        rutasButton.setBackground(Colores.principalBotonesSecundario);
        rutasButton.setBorder(null);
        rutasButton.setFont(Fuentes.getPrincipalFontSize(12, true));
        rutasButton.setForeground(Colores.white);
        rutasButton.setHorizontalAlignment(SwingConstants.LEFT);
        rutasButton.setIcon(Toolbox.adjustImage("/img/Rutas.png", 30, 30));
        rutasButton.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
        rutasButton.setFocusPainted(false);
        rutasButton.addActionListener(this);
        panelBotones.add(rutasButton);
        
        JButton viajesButton = new JButton("Viajes");
        viajesButton.setBounds(0,100,250,50);
        viajesButton.setBackground(Colores.principalBotonesSecundario);
        viajesButton.setBorder(null);
        viajesButton.setFont(Fuentes.getPrincipalFontSize(12, true));
        viajesButton.setForeground(Colores.white);
        viajesButton.setHorizontalAlignment(SwingConstants.LEFT);
        viajesButton.setIcon(Toolbox.adjustImage("/img/Viajes.png", 30, 30));
        viajesButton.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
        viajesButton.setFocusPainted(false);
        viajesButton.addActionListener(this);
        panelBotones.add(viajesButton);
        
        JButton historialButton = new JButton("Historial");
        historialButton.setBounds(0,150,250,50);
        historialButton.setBackground(Colores.principalBotonesSecundario);
        historialButton.setBorder(null);
        historialButton.setFont(Fuentes.getPrincipalFontSize(12, true));
        historialButton.setForeground(Colores.white);
        historialButton.setHorizontalAlignment(SwingConstants.LEFT);
        historialButton.setIcon(Toolbox.adjustImage("/img/Historial.png", 30, 30));
        historialButton.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
        historialButton.setFocusPainted(false);
        historialButton.addActionListener(this);
        panelBotones.add(historialButton);
         
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
            historialActive = false;
            viajesActive = false;

            panelInicio = new JPanel();
            panelInicio.setBounds(250, 0, 950, 700);
            panelInicio.setLayout(null);
            panelInicio.setBackground(Colores.background);
            
            
            //-------------------------Inicio Contendido
            
            
            JLabel tituloLabel = new JLabel("BIENVENIDO");
            tituloLabel.setBounds(20,30,400,30);
            tituloLabel.setForeground(Colores.tituloLetra);
            tituloLabel.setFont(Fuentes.getPrincipalFontSize(16, true));
            panelInicio.add(tituloLabel);
            
            
            JSeparator separador = new JSeparator();
            separador.setBounds(0, 90, 950, 10);
            separador.setBackground(Colores.backgroundPanel);
            separador.setForeground(Colores.backgroundPanel);
            panelInicio.add(separador);
            
            
            JPanel panelInfo = new JPanel();
            panelInfo.setBounds(100, 120, 700, 500);
            panelInfo.setLayout(null);
            panelInfo.setBackground(Colores.backgroundPanel);
            
            JLabel fondoLabel = new JLabel(Toolbox.adjustImage("/img/background.png", 640, 360));
            fondoLabel.setBounds(30, 20, 640, 360);
            panelInfo.add(fondoLabel);
            
                    
            JLabel logoTransportLabel = new JLabel(Toolbox.adjustImage("/img/ApertureWhite.png", 165, 45));
            logoTransportLabel.setBounds(20, 420, 165, 45);
            panelInfo.add(logoTransportLabel);

            JLabel mediaFraseLabel = new JLabel("<html>LA SOLUCIÓN AL TRANSPORTE DE PRIMERA CLASE, GRACIAS A</html>");
            mediaFraseLabel.setBounds(200,410,300,60);
            mediaFraseLabel.setForeground(Colores.white);
            mediaFraseLabel.setFont(Fuentes.getPrincipalFontSize(16, true));
            panelInfo.add(mediaFraseLabel);
            
            JLabel logoApertureLabel = new JLabel(Toolbox.adjustImage("/img/LogoCompletoWhite.png", 165, 45));
            logoApertureLabel.setBounds(500, 420, 165, 45);
            panelInfo.add(logoApertureLabel);
            
            panelInicio.add(panelInfo);
            
            
            //------------------------- Fin Contendido
            
            this.add(panelInicio);
            try {
                this.remove(panelViajes);
                this.remove(panelRutas);
                this.remove(panelHistorial);
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
            historialActive = false;
            viajesActive = false;
            
            panelRutas = new JPanel();
            panelRutas.setBounds(250, 0, 950, 700);
            panelRutas.setLayout(null);
            panelRutas.setBackground(Colores.background);

            //-------------------------Inicio Contendido
            
            JLabel tituloLabel = new JLabel("RUTAS EN EL SISTEMA");
            tituloLabel.setBounds(20,30,400,30);
            tituloLabel.setForeground(Colores.tituloLetra);
            tituloLabel.setFont(Fuentes.getPrincipalFontSize(16, true));
            panelRutas.add(tituloLabel);

            JSeparator separador = new JSeparator();
            separador.setBounds(0, 90, 950, 10);
            separador.setBackground(Colores.backgroundPanel);
            separador.setForeground(Colores.backgroundPanel);
            panelRutas.add(separador);
            
            JButton cargarRutasButton= new JButton("Cargar Rutas (.csv)");
            cargarRutasButton.setBounds(20,120,200,40);
            cargarRutasButton.setBackground(Colores.principalBotones);
            cargarRutasButton.setFont(Fuentes.getPrincipalFontSize(12, true));
            cargarRutasButton.setForeground(Colores.white);
            cargarRutasButton.addActionListener(this);
            cargarRutasButton.setFocusPainted(false);
            panelRutas.add(cargarRutasButton);
            
            JButton editarDistanciaButton= new JButton("Editar Distancia");
            editarDistanciaButton.setBounds(700,120,200,40);
            editarDistanciaButton.setBackground(Colores.principalBotones);
            editarDistanciaButton.setFont(Fuentes.getPrincipalFontSize(12, true));
            editarDistanciaButton.setForeground(Colores.white);
            editarDistanciaButton.addActionListener(this);
            editarDistanciaButton.setFocusPainted(false);
            panelRutas.add(editarDistanciaButton);
            
            //----------------------------------Inicio Tabla Rutas
            
            JLabel tituloCodigoLabel = new JLabel("Codigo");
            tituloCodigoLabel.setBounds(25, 180, 200, 30);
            tituloCodigoLabel.setFont(Fuentes.getPrincipalFontSize(14, true));
            panelRutas.add(tituloCodigoLabel);

            JLabel tituloNombreLabel = new JLabel("Punto Inicio");
            tituloNombreLabel.setBounds(120, 180, 200, 30);
            tituloNombreLabel.setFont(Fuentes.getPrincipalFontSize(14, true));
            panelRutas.add(tituloNombreLabel);

            JLabel tituloCantidadLabel = new JLabel("Punto Final");
            tituloCantidadLabel.setBounds(430, 180, 200, 30);
            tituloCantidadLabel.setFont(Fuentes.getPrincipalFontSize(14, true));
            panelRutas.add(tituloCantidadLabel);

            JLabel tituloDescripcionLabel = new JLabel("Distancia (km)");
            tituloDescripcionLabel.setBounds(750, 180, 200, 30);
            tituloDescripcionLabel.setFont(Fuentes.getPrincipalFontSize(14, true));
            panelRutas.add(tituloDescripcionLabel);
            
            
            JPanel principal = new JPanel();
            principal.setLayout(new GridBagLayout());
            principal.setBackground(Colores.background);

            ArrayList<Ruta> rutas = ListaRutas.getRutas();

            for (int i = 0; i < rutas.size(); i++) {
                JPanel smallPanel = new JPanel();
                smallPanel.setBackground(Colores.backgroundSecundario);
                smallPanel.setBorder(BorderFactory.createLineBorder(Colores.principalBotones));
                smallPanel.setBounds(10, 10, 200, 200);
                //smallPanel.setLayout(new GridBagLayout());
                smallPanel.setLayout(null);

                GridBagConstraints gbc = new GridBagConstraints();
                gbc.gridx = 0;
                //gbc.gridy = principal.getComponentCount(); 
                gbc.fill = GridBagConstraints.HORIZONTAL;
                //gbc.anchor = GridBagConstraints.PAGE_START;
                gbc.ipady = 130;
                gbc.insets = new Insets(2, 0, 2, 0);
                gbc.weightx = 1.0;

                JLabel codigoProdLabel = new JLabel(Integer.toString(rutas.get(i).getId()));
                codigoProdLabel.setBounds(20, 50, 200, 30);
                codigoProdLabel.setFont(Fuentes.getPrincipalFontSize(14, true));
                smallPanel.add(codigoProdLabel);

                JLabel nombreProdLabel = new JLabel(rutas.get(i).getPuntoInicio());
                nombreProdLabel.setBounds(100, 50, 270, 30);
                nombreProdLabel.setFont(Fuentes.getPrincipalFontSize(14, true));
                smallPanel.add(nombreProdLabel);

                JLabel cantidadProdLabel = new JLabel(rutas.get(i).getPuntoFinal());
                cantidadProdLabel.setBounds(410, 50, 200, 30);
                cantidadProdLabel.setFont(Fuentes.getPrincipalFontSize(14, true));
                smallPanel.add(cantidadProdLabel);

                JLabel descripcionProdLabel = new JLabel(Integer.toString( rutas.get(i).getDistancia()));
                descripcionProdLabel.setBounds(750, 50, 360, 30);
                descripcionProdLabel.setFont(Fuentes.getPrincipalFontSize(14, true));
                smallPanel.add(descripcionProdLabel);
                
                principal.add(smallPanel, gbc);

            }

            JScrollPane scrollPane = new JScrollPane(principal);
            scrollPane.getVerticalScrollBar().setBackground(Colores.background);
            scrollPane.getHorizontalScrollBar().setBackground(Colores.background);
            scrollPane.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
                @Override
                protected void configureScrollBarColors() {
                    this.thumbColor = Colores.backgroundPanel;
                }
            });
            scrollPane.setBorder(null);
            scrollPane.setBounds(20, 220, 880, 400);
            panelRutas.add(scrollPane);
            //----------------------------------Fin Tabla Rutas
            

            
            //-------------------------Fin Contendido
            
            this.add(panelRutas);

            try {
                this.remove(panelViajes);
                this.remove(panelInicio);
                this.remove(panelHistorial);
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
            historialActive = false;
            viajesActive = true;
            
            panelViajes = new JPanel();
            panelViajes.setBounds(250, 0, 950, 700);
            panelViajes.setLayout(null);
            panelViajes.setBackground(Colores.background);

            //-------------------------Inicio Contendido
            
            JLabel tituloLabel = new JLabel("VIAJES");
            tituloLabel.setBounds(20,30,400,30);
            tituloLabel.setForeground(Colores.tituloLetra);
            tituloLabel.setFont(Fuentes.getPrincipalFontSize(16, true));
            panelViajes.add(tituloLabel);

            JSeparator separador = new JSeparator();
            separador.setBounds(0, 90, 950, 10);
            separador.setBackground(Colores.backgroundPanel);
            separador.setForeground(Colores.backgroundPanel);
            panelViajes.add(separador);
            
            JButton crearViajeButton= new JButton("Crear Viaje");
            crearViajeButton.setBounds(20,120,200,40);
            crearViajeButton.setBackground(Colores.principalBotones);
            crearViajeButton.setFont(Fuentes.getPrincipalFontSize(12, true));
            crearViajeButton.setForeground(Colores.white);
            crearViajeButton.addActionListener(this);
            crearViajeButton.setFocusPainted(false);
            panelViajes.add(crearViajeButton);
            
            JButton iniciarViajeButton= new JButton("Iniciar Viajes");
            iniciarViajeButton.setBounds(700,120,200,40);
            iniciarViajeButton.setBackground(Colores.principalBotones);
            iniciarViajeButton.setFont(Fuentes.getPrincipalFontSize(12, true));
            iniciarViajeButton.setForeground(Colores.white);
            iniciarViajeButton.addActionListener(new ActionListener() { 
                    public void actionPerformed(ActionEvent e) {
                        ArrayList<Viaje> viajes = ListaViajesActivos.getViajesActivo();
                        for (int i = 0; i < viajes.size(); i++) {
                            switch (i) {
                                
                                case 0:
                                    if (!moviendo_1) {
                                        moviendo_1 = true;
                                        ControladorVehiculo_1 controlador1 = new ControladorVehiculo_1(MenuPrincipal.this);
                                        controlador1.start();
                                    }
                                break;
                                
                                case 1:
                                    if (!moviendo_2) {
                                        moviendo_2 = true;
                                        ControladorVehiculo_2 controlador2 = new ControladorVehiculo_2(MenuPrincipal.this);
                                        controlador2.start();
                                    }
                                break;
                                
                                case 2:
                                    if (!moviendo_3) {
                                        moviendo_3 = true;
                                        ControladorVehiculo_3 controlador3 = new ControladorVehiculo_3(MenuPrincipal.this);
                                        controlador3.start();
                                    }
                                break;
                                default:
                                    throw new AssertionError();
                            }
                        }
                        
                    }
                });
            iniciarViajeButton.setFocusPainted(false);
            panelViajes.add(iniciarViajeButton);

            
            //----------------------------------Inicio Tabla Viajes
            JPanel principal = new JPanel();
            principal.setLayout(new GridBagLayout());
            principal.setBackground(Colores.background);

            ArrayList<Viaje> viajes = ListaViajesActivos.getViajesActivo();

            for (int i = 0; i < viajes.size(); i++) {
                JPanel smallPanel = new JPanel();
                smallPanel.setBackground(Colores.backgroundSecundario);
                smallPanel.setBorder(BorderFactory.createLineBorder(Colores.principalBotones));
                smallPanel.setBounds(10, 10, 400, 200);
                smallPanel.setLayout(null);

                GridBagConstraints gbc = new GridBagConstraints();
                gbc.gridx = 0;
                //gbc.gridy = principal.getComponentCount(); 
                gbc.fill = GridBagConstraints.HORIZONTAL;
                //gbc.anchor = GridBagConstraints.PAGE_START;
                gbc.ipady = 200;//Tamaño en y
                gbc.insets = new Insets(2, 0, 2, 0);
                gbc.weightx = 1.0;
                
                

                JLabel izquierdaLabel = new JLabel("<html>"+viajes.get(i).getVehiculo().getTipo()+"<br>"+"Distancia: "+viajes.get(i).getDistancia()+"<br>"+"Inicio: "+viajes.get(i).getPuntoInicio()+"</html>");
                izquierdaLabel.setBounds(20, 10, 400, 190);
                izquierdaLabel.setVerticalAlignment(JLabel.TOP);
                izquierdaLabel.setVerticalTextPosition(JLabel.TOP);
                izquierdaLabel.setAlignmentY(TOP_ALIGNMENT);
                izquierdaLabel.setFont(Fuentes.getPrincipalFontSize(14, true));
                smallPanel.add(izquierdaLabel);
                
                JLabel derechaLabel = new JLabel("<html>"+"Destino: "+viajes.get(i).getPuntoFinal()+"</html>");
                derechaLabel.setBounds(600, 10, 200, 190);
                derechaLabel.setVerticalAlignment(JLabel.TOP);
                derechaLabel.setVerticalTextPosition(JLabel.TOP);
                derechaLabel.setAlignmentY(TOP_ALIGNMENT);
                derechaLabel.setFont(Fuentes.getPrincipalFontSize(14, true));
                smallPanel.add(derechaLabel);

                JButton iniciarViajeSingularButton = new JButton("Iniciar");
                iniciarViajeSingularButton.setBounds(20, 150, 100, 40);
                iniciarViajeSingularButton.setBackground(Colores.principalBotones);
                iniciarViajeSingularButton.setFont(Fuentes.getPrincipalFontSize(12, true));
                iniciarViajeSingularButton.setForeground(Colores.white);
                int i_here = i;
                iniciarViajeSingularButton.addActionListener(new ActionListener() { 
                    public void actionPerformed(ActionEvent e) {
                        crearViajeButton.setEnabled(false);
                        iniciarViajeSingularButton.setEnabled(false);
                        int i_here_2 = i_here;
                        switch (i_here_2) {
                            case 0:
                                moviendo_1 = true;
                                ControladorVehiculo_1 controlador1 = new ControladorVehiculo_1(MenuPrincipal.this);
                                controlador1.start();
                                break;
                            case 1:
                                ControladorVehiculo_2 controlador2 = new ControladorVehiculo_2(MenuPrincipal.this);
                                controlador2.start();
                                moviendo_2 = true;
                                break;
                            case 2:
                                ControladorVehiculo_3 controlador3 = new ControladorVehiculo_3(MenuPrincipal.this);
                                controlador3.start();
                                moviendo_3 = true;
                                break;
                            default:
                                throw new AssertionError();
                        }
                        
                    }
                });
                iniciarViajeSingularButton.setFocusPainted(false);
                smallPanel.add(iniciarViajeSingularButton);

                JSeparator separadorCamino = new JSeparator();
                separadorCamino.setBounds(140, 185, 700, 10);
                separadorCamino.setBackground(Colores.backgroundPanel);
                separadorCamino.setForeground(Colores.backgroundPanel);
                smallPanel.add(separadorCamino);
                
                Border borde = BorderFactory.createLineBorder(Colores.red, 2);
                switch (i) {
                    case 0:
                        viaje_1 = viajes.get(i_here);
                        
                        panel_Vehiculo_1 = new JPanel();
                        panel_Vehiculo_1.setBounds(130, 70, 190, 50);
                        panel_Vehiculo_1.setBackground(null);
                        panel_Vehiculo_1.setLayout(null);
                        
                        gasolina_1Button = new JButton();
                        gasolina_1Button.setBounds(0, 0, 50, 40);
                        gasolina_1Button.setBackground(Colores.principalBotones);
                        gasolina_1Button.setFont(Fuentes.getPrincipalFontSize(12, true));
                        gasolina_1Button.setForeground(Colores.white);
                        gasolina_1Button.setIcon(Toolbox.adjustImage("/img/Gasolina.png", 30, 30));
                        gasolina_1Button.setFocusPainted(false);
                        gasolina_1Button.setEnabled(false);
                        gasolina_1Button.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                gasolinaDisponible_1 = true;
                                gasolina_1Button.setEnabled(false);
                            }
                        });
                        panel_Vehiculo_1.add(gasolina_1Button);
                        
                        retorno_1Button = new JButton();
                        retorno_1Button.setBounds(820, 140, 50, 40);
                        retorno_1Button.setBackground(Colores.principalBotones);
                        retorno_1Button.setFont(Fuentes.getPrincipalFontSize(12, true));
                        retorno_1Button.setForeground(Colores.white);
                        retorno_1Button.setIcon(Toolbox.adjustImage("/img/Volver.png", 30, 30));
                        retorno_1Button.setFocusPainted(false);
                        retorno_1Button.setEnabled(false);
                        retorno_1Button.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                volver_1 = true;
                                retorno_1Button.setEnabled(false);
                            }
                        });
                        smallPanel.add(retorno_1Button);
                        
                        finalizar_1Button = new JButton();
                        finalizar_1Button.setBounds(820, 10, 50, 40);
                        finalizar_1Button.setBackground(Colores.principalBotones);
                        finalizar_1Button.setFont(Fuentes.getPrincipalFontSize(12, true));
                        finalizar_1Button.setForeground(Colores.white);
                        finalizar_1Button.setIcon(Toolbox.adjustImage("/img/Guardar.png", 30, 30));
                        finalizar_1Button.setFocusPainted(false);
                        finalizar_1Button.setEnabled(false);
                        finalizar_1Button.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                finalizar_1 = true;
                                finalizar_1Button.setEnabled(false);
                            }
                        });
                        smallPanel.add(finalizar_1Button);

                        
                        mensaje_1 = new JLabel();                   
                        mensaje_1.setBounds(250, 10, 200, 190);
                        mensaje_1.setVerticalAlignment(JLabel.TOP);
                        mensaje_1.setVerticalTextPosition(JLabel.TOP);
                        mensaje_1.setForeground(Colores.red);
                        mensaje_1.setAlignmentY(TOP_ALIGNMENT);
                        mensaje_1.setFont(Fuentes.getPrincipalFontSize(14, true));
                        smallPanel.add(mensaje_1);
                        
                        infoLabel_1 = new JLabel("<html>" + "Recorrido: " + recorrido_1 +"<br>"+"Gasolina Actual: "+gasolina_1+ "</html>");
                        infoLabel_1.setBounds(60, 0, 200, 190);
                        infoLabel_1.setVerticalAlignment(JLabel.TOP);
                        infoLabel_1.setVerticalTextPosition(JLabel.TOP);
                        infoLabel_1.setAlignmentY(TOP_ALIGNMENT);
                        infoLabel_1.setFont(Fuentes.getPrincipalFontSize(14, true));
                        panel_Vehiculo_1.add(infoLabel_1);
                        
                        smallPanel.add(panel_Vehiculo_1);
                        
                        vehiculoLabel_1 = new JLabel(Toolbox.adjustImage(viajes.get(i).getVehiculo().getIconoRuta(), 115, 66));
                        vehiculoLabel_1.setBounds(130, 120, 115, 66);
                        vehiculoLabel_1.setBorder(borde);
                        smallPanel.add(vehiculoLabel_1);
                        
                        moto_rect1 = vehiculoLabel_1.getBounds();
                        
                        
                        break;
                    case 1:
                        viaje_2 = viajes.get(i_here);

                        panel_Vehiculo_2 = new JPanel();
                        panel_Vehiculo_2.setBounds(130, 70, 190, 50);
                        panel_Vehiculo_2.setBackground(null);
                        panel_Vehiculo_2.setLayout(null);

                        gasolina_2Button = new JButton();
                        gasolina_2Button.setBounds(0, 0, 50, 40);
                        gasolina_2Button.setBackground(Colores.principalBotones);
                        gasolina_2Button.setFont(Fuentes.getPrincipalFontSize(12, true));
                        gasolina_2Button.setForeground(Colores.white);
                        gasolina_2Button.setIcon(Toolbox.adjustImage("/img/Gasolina.png", 30, 30));
                        gasolina_2Button.setFocusPainted(false);
                        gasolina_2Button.setEnabled(false);
                        gasolina_2Button.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                gasolinaDisponible_2 = true;
                                gasolina_2Button.setEnabled(false);
                            }
                        });
                        panel_Vehiculo_2.add(gasolina_2Button);

                        retorno_2Button = new JButton();
                        retorno_2Button.setBounds(820, 140, 50, 40);
                        retorno_2Button.setBackground(Colores.principalBotones);
                        retorno_2Button.setFont(Fuentes.getPrincipalFontSize(12, true));
                        retorno_2Button.setForeground(Colores.white);
                        retorno_2Button.setIcon(Toolbox.adjustImage("/img/Volver.png", 30, 30));
                        retorno_2Button.setFocusPainted(false);
                        retorno_2Button.setEnabled(false);
                        retorno_2Button.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                volver_2 = true;
                                retorno_2Button.setEnabled(false);
                            }
                        });
                        smallPanel.add(retorno_2Button);

                        finalizar_2Button = new JButton();
                        finalizar_2Button.setBounds(820, 10, 50, 40);
                        finalizar_2Button.setBackground(Colores.principalBotones);
                        finalizar_2Button.setFont(Fuentes.getPrincipalFontSize(12, true));
                        finalizar_2Button.setForeground(Colores.white);
                        finalizar_2Button.setIcon(Toolbox.adjustImage("/img/Guardar.png", 30, 30));
                        finalizar_2Button.setFocusPainted(false);
                        finalizar_2Button.setEnabled(false);
                        finalizar_2Button.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                finalizar_2 = true;
                                finalizar_2Button.setEnabled(false);
                            }
                        });
                        smallPanel.add(finalizar_2Button);

                        mensaje_2 = new JLabel();
                        mensaje_2.setBounds(250, 10, 200, 190);
                        mensaje_2.setVerticalAlignment(JLabel.TOP);
                        mensaje_2.setVerticalTextPosition(JLabel.TOP);
                        mensaje_2.setForeground(Colores.red);
                        mensaje_2.setAlignmentY(TOP_ALIGNMENT);
                        mensaje_2.setFont(Fuentes.getPrincipalFontSize(14, true));
                        smallPanel.add(mensaje_2);

                        infoLabel_2 = new JLabel("<html>" + "Recorrido: " + recorrido_1 + "<br>" + "Gasolina Actual: " + gasolina_2 + "</html>");
                        infoLabel_2.setBounds(60, 0, 200, 190);
                        infoLabel_2.setVerticalAlignment(JLabel.TOP);
                        infoLabel_2.setVerticalTextPosition(JLabel.TOP);
                        infoLabel_2.setAlignmentY(TOP_ALIGNMENT);
                        infoLabel_2.setFont(Fuentes.getPrincipalFontSize(14, true));
                        panel_Vehiculo_2.add(infoLabel_2);

                        smallPanel.add(panel_Vehiculo_2);

                        vehiculoLabel_2 = new JLabel(Toolbox.adjustImage(viajes.get(i).getVehiculo().getIconoRuta(), 115, 66));
                        vehiculoLabel_2.setBounds(130, 120, 115, 66);
                        vehiculoLabel_2.setBorder(borde);
                        smallPanel.add(vehiculoLabel_2);

                        moto_rect2 = vehiculoLabel_2.getBounds();


                        
                        break;
                    case 2:
                        viaje_3 = viajes.get(i_here);

                        panel_Vehiculo_3 = new JPanel();
                        panel_Vehiculo_3.setBounds(130, 70, 190, 50);
                        panel_Vehiculo_3.setBackground(null);
                        panel_Vehiculo_3.setLayout(null);

                        gasolina_3Button = new JButton();
                        gasolina_3Button.setBounds(0, 0, 50, 40);
                        gasolina_3Button.setBackground(Colores.principalBotones);
                        gasolina_3Button.setFont(Fuentes.getPrincipalFontSize(12, true));
                        gasolina_3Button.setForeground(Colores.white);
                        gasolina_3Button.setIcon(Toolbox.adjustImage("/img/Gasolina.png", 30, 30));
                        gasolina_3Button.setFocusPainted(false);
                        gasolina_3Button.setEnabled(false);
                        gasolina_3Button.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                gasolinaDisponible_3 = true;
                                gasolina_3Button.setEnabled(false);
                            }
                        });
                        panel_Vehiculo_3.add(gasolina_3Button);

                        retorno_3Button = new JButton();
                        retorno_3Button.setBounds(820, 140, 50, 40);
                        retorno_3Button.setBackground(Colores.principalBotones);
                        retorno_3Button.setFont(Fuentes.getPrincipalFontSize(12, true));
                        retorno_3Button.setForeground(Colores.white);
                        retorno_3Button.setIcon(Toolbox.adjustImage("/img/Volver.png", 30, 30));
                        retorno_3Button.setFocusPainted(false);
                        retorno_3Button.setEnabled(false);
                        retorno_3Button.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                volver_3 = true;
                                retorno_3Button.setEnabled(false);
                            }
                        });
                        smallPanel.add(retorno_3Button);

                        finalizar_3Button = new JButton();
                        finalizar_3Button.setBounds(820, 10, 50, 40);
                        finalizar_3Button.setBackground(Colores.principalBotones);
                        finalizar_3Button.setFont(Fuentes.getPrincipalFontSize(12, true));
                        finalizar_3Button.setForeground(Colores.white);
                        finalizar_3Button.setIcon(Toolbox.adjustImage("/img/Guardar.png", 30, 30));
                        finalizar_3Button.setFocusPainted(false);
                        finalizar_3Button.setEnabled(false);
                        finalizar_3Button.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                finalizar_3 = true;
                                finalizar_3Button.setEnabled(false);
                            }
                        });
                        smallPanel.add(finalizar_3Button);

                        mensaje_3 = new JLabel();
                        mensaje_3.setBounds(250, 10, 200, 190);
                        mensaje_3.setVerticalAlignment(JLabel.TOP);
                        mensaje_3.setVerticalTextPosition(JLabel.TOP);
                        mensaje_3.setForeground(Colores.red);
                        mensaje_3.setAlignmentY(TOP_ALIGNMENT);
                        mensaje_3.setFont(Fuentes.getPrincipalFontSize(14, true));
                        smallPanel.add(mensaje_3);

                        infoLabel_3 = new JLabel("<html>" + "Recorrido: " + recorrido_1 + "<br>" + "Gasolina Actual: " + gasolina_3 + "</html>");
                        infoLabel_3.setBounds(60, 0, 200, 190);
                        infoLabel_3.setVerticalAlignment(JLabel.TOP);
                        infoLabel_3.setVerticalTextPosition(JLabel.TOP);
                        infoLabel_3.setAlignmentY(TOP_ALIGNMENT);
                        infoLabel_3.setFont(Fuentes.getPrincipalFontSize(14, true));
                        panel_Vehiculo_3.add(infoLabel_3);

                        smallPanel.add(panel_Vehiculo_3);

                        vehiculoLabel_3 = new JLabel(Toolbox.adjustImage(viajes.get(i).getVehiculo().getIconoRuta(), 115, 66));
                        vehiculoLabel_3.setBounds(130, 120, 115, 66);
                        vehiculoLabel_3.setBorder(borde);
                        smallPanel.add(vehiculoLabel_3);

                        moto_rect3 = vehiculoLabel_3.getBounds();


                        
                        break;
                    default:
                        throw new AssertionError();
                }

                


                
                JLabel inicioLabel = new JLabel();
                inicioLabel.setBounds(100, 150, 30, 30);
                //inicioLabel.setBorder(borde);
                metaInicial = inicioLabel.getBounds();
                
                JLabel finalLabel = new JLabel();
                finalLabel.setBounds(800, 150, 30, 30);
                //finalLabel.setBorder(borde);
                metaFinal = finalLabel.getBounds();
                
                
                
                principal.add(smallPanel, gbc);

            }

            JScrollPane scrollPane = new JScrollPane(principal);
            scrollPane.getVerticalScrollBar().setBackground(Colores.background);
            scrollPane.getHorizontalScrollBar().setBackground(Colores.background);
            scrollPane.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
                @Override
                protected void configureScrollBarColors() {
                    this.thumbColor = Colores.backgroundPanel;
                }
            });
            scrollPane.setBorder(null);
            scrollPane.setBounds(20, 180, 880, 450);
            panelViajes.add(scrollPane);
            
            //-------------------------Fin Tabla Viajes
            
            //-------------------------Fin Contendido
            
            this.add(panelViajes);
            try {

                this.remove(panelRutas);
                this.remove(panelInicio);
                this.remove(panelHistorial);
                revalidate();

            } catch (Exception ex) {

            }

            this.repaint();
        }
     }
    
    void panelHistorial(){
        if (!historialActive) {
            inicioActive = false;
            rutasActive = false;
            viajesActive = false;
            historialActive = true;
        
            panelHistorial = new JPanel();
            panelHistorial.setBounds(250, 0, 950, 700);
            panelHistorial.setLayout(null);
            panelHistorial.setBackground(Colores.background);

            //-------------------------Inicio Contendido
            JLabel tituloLabel = new JLabel("HISTORIAL");
            tituloLabel.setBounds(20, 30, 400, 30);
            tituloLabel.setForeground(Colores.tituloLetra);
            tituloLabel.setFont(Fuentes.getPrincipalFontSize(16, true));
            panelHistorial.add(tituloLabel);

            JSeparator separador = new JSeparator();
            separador.setBounds(0, 90, 950, 10);
            separador.setBackground(Colores.backgroundPanel);
            separador.setForeground(Colores.backgroundPanel);
            panelHistorial.add(separador);
            
            //----------------------------------Inicio Tabla Rutas
            JLabel tituloCodigoLabel = new JLabel("Codigo");
            tituloCodigoLabel.setBounds(25, 100, 200, 30);
            tituloCodigoLabel.setFont(Fuentes.getPrincipalFontSize(14, true));
            panelHistorial.add(tituloCodigoLabel);

            JLabel tituloNombreLabel = new JLabel("Fecha Inicio");
            tituloNombreLabel.setBounds(120, 100, 200, 30);
            tituloNombreLabel.setFont(Fuentes.getPrincipalFontSize(14, true));
            panelHistorial.add(tituloNombreLabel);

            JLabel tituloCantidadLabel = new JLabel("Fecha Final");
            tituloCantidadLabel.setBounds(290, 100, 200, 30);
            tituloCantidadLabel.setFont(Fuentes.getPrincipalFontSize(14, true));
            panelHistorial.add(tituloCantidadLabel);

            JLabel tituloDescripcionLabel = new JLabel("Distancia (km)");
            tituloDescripcionLabel.setBounds(440, 100, 200, 30);
            tituloDescripcionLabel.setFont(Fuentes.getPrincipalFontSize(14, true));
            panelHistorial.add(tituloDescripcionLabel);

            JLabel tipoLabel = new JLabel("Tipo");
            tipoLabel.setBounds(600, 100, 200, 30);
            tipoLabel.setFont(Fuentes.getPrincipalFontSize(14, true));
            panelHistorial.add(tipoLabel);
            
            JLabel GasolinaLabel = new JLabel("Gasolina Consumida");
            GasolinaLabel.setBounds(700, 100, 200, 30);
            GasolinaLabel.setFont(Fuentes.getPrincipalFontSize(14, true));
            panelHistorial.add(GasolinaLabel);

            JPanel principal = new JPanel();
            principal.setLayout(new GridBagLayout());
            principal.setBackground(Colores.background);

            ArrayList<Viaje> viajes = ListaViajesTerminados.getViajesTerminados();

            for (int i = 0; i < viajes.size(); i++) {
                JPanel smallPanel = new JPanel();
                smallPanel.setBackground(Colores.backgroundSecundario);
                smallPanel.setBorder(BorderFactory.createLineBorder(Colores.principalBotones));
                smallPanel.setBounds(10, 10, 200, 200);
                //smallPanel.setLayout(new GridBagLayout());
                smallPanel.setLayout(null);

                GridBagConstraints gbc = new GridBagConstraints();
                gbc.gridx = 0;
                //gbc.gridy = principal.getComponentCount(); 
                gbc.fill = GridBagConstraints.HORIZONTAL;
                //gbc.anchor = GridBagConstraints.PAGE_START;
                gbc.ipady = 130;
                gbc.insets = new Insets(2, 0, 2, 0);
                gbc.weightx = 1.0;

                JLabel codigoLabel = new JLabel(Integer.toString(viajes.get(i).getId()));
                codigoLabel.setBounds(20, 50, 200, 30);
                codigoLabel.setFont(Fuentes.getPrincipalFontSize(14, true));
                smallPanel.add(codigoLabel);

                JLabel fechaInicioLabel = new JLabel(Integer.toString(viajes.get(i).getFechaInicio().getDayOfWeek().getValue())+"/"+Integer.toString(viajes.get(i).getFechaInicio().getMonth().getValue())+"/"+Integer.toString(viajes.get(i).getFechaInicio().getYear())+" "+Integer.toString(viajes.get(i).getFechaInicio().getHour())+":"+Integer.toString(viajes.get(i).getFechaInicio().getMinute()));
                fechaInicioLabel.setBounds(100, 50, 270, 30);
                fechaInicioLabel.setFont(Fuentes.getPrincipalFontSize(14, true));
                smallPanel.add(fechaInicioLabel);
                
                JLabel fechaFinalLabel = new JLabel(Integer.toString(viajes.get(i).getFechaFinal().getDayOfWeek().getValue())+"/"+Integer.toString(viajes.get(i).getFechaFinal().getMonth().getValue())+"/"+Integer.toString(viajes.get(i).getFechaFinal().getYear())+" "+Integer.toString(viajes.get(i).getFechaFinal().getHour())+":"+Integer.toString(viajes.get(i).getFechaFinal().getMinute()));
                fechaFinalLabel.setBounds(270, 50, 270, 30);
                fechaFinalLabel.setFont(Fuentes.getPrincipalFontSize(14, true));
                smallPanel.add(fechaFinalLabel);

                JLabel distanciaLabel = new JLabel(Integer.toString(viajes.get(i).getDistancia()));
                distanciaLabel.setBounds(460, 50, 200, 30);
                distanciaLabel.setFont(Fuentes.getPrincipalFontSize(14, true));
                smallPanel.add(distanciaLabel);

                JLabel vehiculoLabel = new JLabel(viajes.get(i).getVehiculo().getTipo());
                vehiculoLabel.setBounds(550, 50, 200, 30);
                vehiculoLabel.setFont(Fuentes.getPrincipalFontSize(14, true));
                smallPanel.add(vehiculoLabel);

                JLabel gasConsumidaProdLabel = new JLabel(String.valueOf( viajes.get(i).getGasolinaConsumida()));
                gasConsumidaProdLabel.setBounds(750, 50, 360, 30);
                gasConsumidaProdLabel.setFont(Fuentes.getPrincipalFontSize(14, true));
                smallPanel.add(gasConsumidaProdLabel);

                principal.add(smallPanel, gbc);

            }

            JScrollPane scrollPane = new JScrollPane(principal);
            scrollPane.getVerticalScrollBar().setBackground(Colores.background);
            scrollPane.getHorizontalScrollBar().setBackground(Colores.background);
            scrollPane.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
                @Override
                protected void configureScrollBarColors() {
                    this.thumbColor = Colores.backgroundPanel;
                }
            });
            scrollPane.setBorder(null);
            scrollPane.setBounds(20, 140, 880, 480);
            panelHistorial.add(scrollPane);
            //----------------------------------Fin Tabla Productos
            //-------------------------Fin Contendido

            this.add(panelHistorial);
            try {

                this.remove(panelRutas);
                this.remove(panelInicio);
                this.remove(panelViajes);
                revalidate();

            } catch (Exception ex) {

            }

            this.repaint();
        }
        
    }
 
    void botonSeleccionado(int num){
        switch (num) {
            case 0:
                panelBienvenida();
                inicioActive = true;
            break;
            case 1:
                panelRutas();
                rutasActive = true;
            break;
            case 2:
                panelViajes();
                viajesActive = true;
            break;
            case 3:
                panelHistorial();
                historialActive = true;
            break;
            default:
                throw new AssertionError();
        }
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        JDialog dialogo = new JDialog(this);
        
        if(e.getActionCommand().equals("Inicio")){
            panelBienvenida();
        }
        
        if(e.getActionCommand().equals("Rutas")){
            panelRutas();
        }
        if(e.getActionCommand().equals("Viajes")){
            panelViajes();
        }
        
        if(e.getActionCommand().equals("Historial")){
            panelHistorial();
        }
        
        if(e.getActionCommand().equals("Cargar Rutas (.csv)")){
            JFileChooser fileChooser = new JFileChooser();
            LookAndFeel previousLF = UIManager.getLookAndFeel();
            
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                fileChooser = new JFileChooser();
                UIManager.setLookAndFeel(previousLF);
            }catch (Exception ex) {
                
            }
            FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos CSV", "csv");
            fileChooser.setFileFilter(filtro);
            fileChooser.setDialogTitle("Seleccione un Archivo");
            int seleccion =  fileChooser.showOpenDialog(this);
            if (seleccion == JFileChooser.APPROVE_OPTION) {
                File archivo = fileChooser.getSelectedFile();
                Toolbox.lecturaCSV(archivo);
                MenuPrincipal menu = new MenuPrincipal();
                menu.botonSeleccionado(1);
                this.setVisible(false);
                this.dispose();
            }else{
                
            }
        }
        
        if(e.getActionCommand().equals("Editar Distancia")){
            JPanel panelSuperior = new JPanel();
            panelSuperior.setBounds(0, 0, 800, 80);
            panelSuperior.setLayout(null);
            panelSuperior.setBackground(Colores.backgroundPanel);
            
            JLabel imageLabel = new JLabel(Toolbox.adjustImage("/img/EditarWhite.png", 40, 40));
            imageLabel.setBounds(15, 20, 40, 40);
            panelSuperior.add(imageLabel);
                        
            JLabel editarLabel = new JLabel("EDITAR DISTANCIA");
            editarLabel.setBounds(70,25,250,30);
            editarLabel.setForeground(Colores.white);
            editarLabel.setFont(Fuentes.getPrincipalFontSize(16, true));
            panelSuperior.add(editarLabel);
            
            JLabel logoTransportLabel = new JLabel(Toolbox.adjustImage("/img/ApertureWhite.png", 165, 45));
            logoTransportLabel.setBounds(600, 17, 165, 45);
            panelSuperior.add(logoTransportLabel);
            
            dialogo.add(panelSuperior);
            
            JLabel idLabel = new JLabel("Id");
            idLabel.setBounds(150,120,250,30);
            idLabel.setForeground(Colores.black);
            idLabel.setFont(Fuentes.getPrincipalFontSize(16, true));
            dialogo.add(idLabel);
            
            idField = new JTextField();
            idField.setBounds(190,120,200,30);
            idField.setText("");
            dialogo.add(idField);
            
            JButton buscarRutaButton= new JButton("Buscar Ruta");
            buscarRutaButton.setBounds(420,120,200,30);
            buscarRutaButton.setBackground(Colores.principalBotones);
            buscarRutaButton.setFont(Fuentes.getPrincipalFontSize(12, true));
            buscarRutaButton.setForeground(Colores.white);
            buscarRutaButton.addActionListener(this);
            buscarRutaButton.setFocusPainted(false);
            dialogo.add(buscarRutaButton);
            
            JLabel distanciaLabel = new JLabel("Distancia");
            distanciaLabel.setBounds(250,220,250,30);
            distanciaLabel.setForeground(Colores.black);
            distanciaLabel.setFont(Fuentes.getPrincipalFontSize(16, true));
            dialogo.add(distanciaLabel);

            distanciaField = new JTextField();
            distanciaField.setBounds(350,220,200,30);
            distanciaField.setText("");
            distanciaField.setEnabled(false);
            dialogo.add(distanciaField);
            
            JButton guardarDistanciaButton= new JButton("Guardar Distancia");
            guardarDistanciaButton.setBounds(300,300,200,30);
            guardarDistanciaButton.setBackground(Colores.principalBotones);
            guardarDistanciaButton.setFont(Fuentes.getPrincipalFontSize(12, true));
            guardarDistanciaButton.setForeground(Colores.white);
            guardarDistanciaButton.addActionListener(this);
            guardarDistanciaButton.setFocusPainted(false);
            dialogo.add(guardarDistanciaButton);
            
            
            
                    
            dialogo.setTitle("Editar Distancia");
            dialogo.setSize(800,400);
            dialogo.setLayout(null);
            dialogo.setResizable(false);
            dialogo.setLocationRelativeTo(null);
            dialogo.getContentPane().setBackground(Colores.background);
            dialogo.setVisible(true);
            
        }
        
        if(e.getActionCommand().equals("Buscar Ruta")){
            boolean fallo = false;
            int id;
            try{
                id = Integer.parseInt(idField.getText());
            }catch (Exception ex) {
                fallo = true;
                id = 0;
            }
            if(!fallo){
                Ruta rutaObtenida = ListaRutas.getRuta(id);
                if(rutaObtenida != null){
                    idField.setEnabled(false);
                    distanciaField.setEnabled(true);
                    distanciaField.setText(Integer.toString(rutaObtenida.getDistancia()));
                }else{
                    Alerta alerta = new Alerta("No existe la ruta ingresada", false);
                }
            }else{
                Alerta alerta = new Alerta("Ingrese un id correcto", false);
            }
            
        }
       
        
        if(e.getActionCommand().equals("Guardar Distancia")){
            boolean fallo = false;
            int distancia;
            try{
                distancia = Integer.parseInt(distanciaField.getText());
            }catch (Exception ex) {
                fallo = true;
                distancia = 0;
            }
            if(!fallo){
                Ruta rutaObtenida = ListaRutas.getRuta(Integer.parseInt(idField.getText()));
                if(rutaObtenida != null){
                    rutaObtenida.setDistancia(distancia);
                    ListaRutas.editRuta(rutaObtenida, rutaObtenida.getId());
                    Alerta alerta = new Alerta("Ruta Guardada Exitosamente", true);
                    MenuPrincipal menu = new MenuPrincipal();
                    menu.botonSeleccionado(1);
                    this.setVisible(false);
                    this.dispose();
                }else{
                    Alerta alerta = new Alerta("Error al guardar la distancia", false);
                }
            }else{
                Alerta alerta = new Alerta("Ingrese una distancia correcta", false);
            }
        }
    
        if(e.getActionCommand().equals("Crear Viaje")){
            
            JPanel panelSuperior = new JPanel();
            panelSuperior.setBounds(0, 0, 800, 80);
            panelSuperior.setLayout(null);
            panelSuperior.setBackground(Colores.backgroundPanel);
            
            JLabel imageLabel = new JLabel(Toolbox.adjustImage("/img/CrearWhite.png", 40, 40));
            imageLabel.setBounds(15, 20, 40, 40);
            panelSuperior.add(imageLabel);
                        
            JLabel editarLabel = new JLabel("CREAR VIAJE");
            editarLabel.setBounds(70,25,250,30);
            editarLabel.setForeground(Colores.white);
            editarLabel.setFont(Fuentes.getPrincipalFontSize(16, true));
            panelSuperior.add(editarLabel);
            
            JLabel logoTransportLabel = new JLabel(Toolbox.adjustImage("/img/ApertureWhite.png", 165, 45));
            logoTransportLabel.setBounds(600, 17, 165, 45);
            panelSuperior.add(logoTransportLabel);
            
            dialogo.add(panelSuperior);
            

            JLabel puntoInicialLabel = new JLabel("Punto de Inicio");
            puntoInicialLabel.setBounds(20,120,250,30);
            puntoInicialLabel.setForeground(Colores.black);
            puntoInicialLabel.setFont(Fuentes.getPrincipalFontSize(16, true));
            dialogo.add(puntoInicialLabel);
            
            
            ArrayList<String> arrayPuntos = ListaRutas.getPuntos();
            arrayPuntos.addFirst("Seleccione una opción");
            String[] listaInicial = new String[arrayPuntos.size()];
            for (int i = 0; i < arrayPuntos.size(); i++) {
                listaInicial[i] = arrayPuntos.get(i);
            }
            
            puntoInicialCombo = new JComboBox();
            LookAndFeel previousLF = UIManager.getLookAndFeel();
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                puntoInicialCombo = new JComboBox(listaInicial);
                UIManager.setLookAndFeel(previousLF);
            }catch (Exception ex) {
                
            }
            puntoInicialCombo.setFocusable(false);
            puntoInicialCombo.setBounds(170, 120, 200, 30);
            puntoInicialCombo.setFont(Fuentes.getPrincipalFontSize(12, true));
            puntoInicialCombo.addItemListener(new ItemListener() {
                public void itemStateChanged(ItemEvent itemEvent) {
                    int state = itemEvent.getStateChange();
                    if(state == ItemEvent.SELECTED){
                        ArrayList<String> arrayPuntosRelacionados = ListaRutas.getPuntosRelacionados( itemEvent.getItem().toString());
                        arrayPuntosRelacionados.addFirst("Seleccione una opción");
                        String[] listaPuntosRelacionados = new String[arrayPuntosRelacionados.size()];
                        for (int i = 0; i < arrayPuntosRelacionados.size(); i++) {
                            listaPuntosRelacionados[i] = arrayPuntosRelacionados.get(i);
                        }
                        puntoFinalCombo.setEnabled(true);
                        puntoFinalCombo.setModel(new DefaultComboBoxModel<>( listaPuntosRelacionados ));
                    }    
                    /*System.out.println((state == ItemEvent.SELECTED) ? "Selected" : "Deselected");
                    System.out.println("Item: " + itemEvent.getItem());*/

                    //System.out.println(", Selected: " + selectedString(is));
                }
            }
            );
            
            dialogo.add(puntoInicialCombo);
            
            
            
            
            
            JLabel puntoFinalLabel = new JLabel("Punto Final");
            puntoFinalLabel.setBounds(430,120,250,30);
            puntoFinalLabel.setForeground(Colores.black);
            puntoFinalLabel.setFont(Fuentes.getPrincipalFontSize(16, true));
            dialogo.add(puntoFinalLabel);
            
            puntoFinalCombo = new JComboBox();
            previousLF = UIManager.getLookAndFeel();
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                puntoFinalCombo = new JComboBox();
                UIManager.setLookAndFeel(previousLF);
            }catch (Exception ex) {
                
            }
            puntoFinalCombo.setFocusable(false);
            puntoFinalCombo.setBounds(540, 120, 200, 30);
            puntoFinalCombo.setFont(Fuentes.getPrincipalFontSize(12, true));
            puntoFinalCombo.setEnabled(false);
            dialogo.add(puntoFinalCombo);

            JLabel tipoCarroLabel = new JLabel("Tipo Carro");
            tipoCarroLabel.setBounds(20,180,250,30);
            tipoCarroLabel.setForeground(Colores.black);
            tipoCarroLabel.setFont(Fuentes.getPrincipalFontSize(16, true));
            dialogo.add(tipoCarroLabel);
            
            ArrayList<Vehiculo> arrayCarros = ListaVehiculos.getVehiculosActivos();
            arrayPuntos.addFirst("Seleccione una opción");
            String[] listaCarrosInicial = new String[arrayCarros.size()];
            for (int i = 0; i < arrayCarros.size(); i++) {
                listaCarrosInicial[i] = arrayCarros.get(i).getTipo();
            }

            tipoCarroCombo = new JComboBox();
            previousLF = UIManager.getLookAndFeel();
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                tipoCarroCombo = new JComboBox(listaCarrosInicial);
                UIManager.setLookAndFeel(previousLF);
            }catch (Exception ex) {
                
            }
            tipoCarroCombo.setFocusable(false);
            tipoCarroCombo.setBounds(170, 180, 200, 30);
            tipoCarroCombo.setFont(Fuentes.getPrincipalFontSize(12, true));
            dialogo.add(tipoCarroCombo);
            


            

            JButton guardarDistanciaButton= new JButton("Guardar Viaje");
            guardarDistanciaButton.setBounds(300,300,200,30);
            guardarDistanciaButton.setBackground(Colores.principalBotones);
            guardarDistanciaButton.setFont(Fuentes.getPrincipalFontSize(12, true));
            guardarDistanciaButton.setForeground(Colores.white);
            guardarDistanciaButton.addActionListener(this);
            guardarDistanciaButton.setFocusPainted(false);
            if (ListaViajesActivos.getTamaño() == 3) {
                guardarDistanciaButton.setEnabled(false);
                JLabel limiteLabel = new JLabel("Limite de Viajes Alcanzado");
                limiteLabel.setBounds(20, 300, 250, 30);
                limiteLabel.setForeground(Colores.red);
                limiteLabel.setFont(Fuentes.getPrincipalFontSize(16, true));
                dialogo.add(limiteLabel);
            }
            dialogo.add(guardarDistanciaButton);
            
            
            
            
            dialogo.setTitle("Crear Viaje");
            dialogo.setSize(800,400);
            dialogo.setLayout(null);
            dialogo.setResizable(false);
            dialogo.setLocationRelativeTo(null);
            dialogo.getContentPane().setBackground(Colores.background);
            dialogo.setVisible(true);
        }
    
        if(e.getActionCommand().equals("Guardar Viaje")){
            String puntoInicio = puntoInicialCombo.getSelectedItem().toString();
            String puntoFinal = puntoFinalCombo.getSelectedItem().toString();
            String tipoCarro = tipoCarroCombo.getSelectedItem().toString();
            
            if (ListaViajesActivos.getTamaño() < 3) {

                Ruta rutaActual = ListaRutas.searchRuta(puntoInicio, puntoFinal);
                if (rutaActual != null) {
                    Vehiculo carrito = ListaVehiculos.getVehiculoByTipo(tipoCarro);
                    if (carrito != null) {
                        if (!carrito.isEnUso()) {
                            ListaViajesActivos.addViajeActivo(new Viaje(rutaActual.getPuntoInicio(), rutaActual.getPuntoFinal(), carrito, rutaActual.getDistancia(), LocalDateTime.now()));
                            ListaVehiculos.setActivoByTipo(tipoCarro, true);

                            Alerta alerta = new Alerta("El viaje fue guardado con exito", true);
                            MenuPrincipal menu = new MenuPrincipal();
                            menu.botonSeleccionado(2);
                            this.setVisible(false);
                            this.dispose();
                        } else {
                            Alerta alerta = new Alerta("El vehiculo esta en uso", false);
                        }
                    } else {
                        Alerta alerta = new Alerta("El vehiculo no existe", false);
                    }

                } else {
                    Alerta alerta = new Alerta("Ingrese una ruta correcta", false);
                }
            }else{
                Alerta alerta = new Alerta("Limite de Viajes alcanzado", false);
            }

        }
    }
    
}
