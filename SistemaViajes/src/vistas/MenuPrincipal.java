/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vistas;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.ItemSelectable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
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
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.basic.BasicScrollBarUI;
import listas.ListaRutas;
import modelos.Ruta;
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
        
        
        JLabel logoLabel = new JLabel(Toolbox.adjustImage("../img/ApertureWhite.png", 165, 45));
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
        inicioButton.setIcon(Toolbox.adjustImage("../img/Inicio.png", 30, 30));
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
        rutasButton.setIcon(Toolbox.adjustImage("../img/Rutas.png", 30, 30));
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
        viajesButton.setIcon(Toolbox.adjustImage("../img/Viajes.png", 30, 30));
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
        historialButton.setIcon(Toolbox.adjustImage("../img/Historial.png", 30, 30));
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
            
            JLabel fondoLabel = new JLabel(Toolbox.adjustImage("../img/background.png", 640, 360));
            fondoLabel.setBounds(30, 20, 640, 360);
            panelInfo.add(fondoLabel);
            
                    
            JLabel logoTransportLabel = new JLabel(Toolbox.adjustImage("../img/ApertureWhite.png", 165, 45));
            logoTransportLabel.setBounds(20, 420, 165, 45);
            panelInfo.add(logoTransportLabel);

            JLabel mediaFraseLabel = new JLabel("<html>LA SOLUCIÓN AL TRANSPORTE DE PRIMERA CLASE, GRACIAS A</html>");
            mediaFraseLabel.setBounds(200,410,300,60);
            mediaFraseLabel.setForeground(Colores.white);
            mediaFraseLabel.setFont(Fuentes.getPrincipalFontSize(16, true));
            panelInfo.add(mediaFraseLabel);
            
            JLabel logoApertureLabel = new JLabel(Toolbox.adjustImage("../img/LogoCompletoWhite.png", 165, 45));
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
            
            //----------------------------------Inicio Tabla Productos
            
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
            //----------------------------------Fin Tabla Productos
            

            
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
            iniciarViajeButton.addActionListener(this);
            iniciarViajeButton.setFocusPainted(false);
            panelViajes.add(iniciarViajeButton);
            //-------------------------Inicio Contendido
            
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
            //-------------------------Inicio Contendido

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
            FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos CSV", "csv");
            fileChooser.setFileFilter(filtro);
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
            
            JLabel imageLabel = new JLabel(Toolbox.adjustImage("../img/EditarWhite.png", 40, 40));
            imageLabel.setBounds(15, 20, 40, 40);
            panelSuperior.add(imageLabel);
                        
            JLabel editarLabel = new JLabel("EDITAR DISTANCIA");
            editarLabel.setBounds(70,25,250,30);
            editarLabel.setForeground(Colores.white);
            editarLabel.setFont(Fuentes.getPrincipalFontSize(16, true));
            panelSuperior.add(editarLabel);
            
            JLabel logoTransportLabel = new JLabel(Toolbox.adjustImage("../img/ApertureWhite.png", 165, 45));
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
            
            JLabel imageLabel = new JLabel(Toolbox.adjustImage("../img/Crear.png", 40, 40));
            imageLabel.setBounds(15, 20, 40, 40);
            panelSuperior.add(imageLabel);
                        
            JLabel editarLabel = new JLabel("CREAR VIAJE");
            editarLabel.setBounds(70,25,250,30);
            editarLabel.setForeground(Colores.white);
            editarLabel.setFont(Fuentes.getPrincipalFontSize(16, true));
            panelSuperior.add(editarLabel);
            
            JLabel logoTransportLabel = new JLabel(Toolbox.adjustImage("../img/ApertureWhite.png", 165, 45));
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
            
            puntoInicialCombo = new JComboBox(listaInicial);
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
            
            String[] listaFinal = {"Seleccione una opción"};
            puntoFinalCombo = new JComboBox();
            puntoFinalCombo.setBounds(540, 120, 200, 30);
            puntoFinalCombo.setFont(Fuentes.getPrincipalFontSize(12, true));
            puntoFinalCombo.setEnabled(false);
            dialogo.add(puntoFinalCombo);

            JLabel tipoCarroLabel = new JLabel("Tipo Carro");
            tipoCarroLabel.setBounds(20,180,250,30);
            tipoCarroLabel.setForeground(Colores.black);
            tipoCarroLabel.setFont(Fuentes.getPrincipalFontSize(16, true));
            dialogo.add(tipoCarroLabel);
            
            String[] listaCarro = {"Seleccione una opción","Hombre","Mujer"};
            tipoCarroCombo = new JComboBox(listaCarro);
            tipoCarroCombo.setBounds(170, 180, 200, 30);
            tipoCarroCombo.setFont(Fuentes.getPrincipalFontSize(12, true));
            dialogo.add(tipoCarroCombo);
            



            JButton guardarDistanciaButton= new JButton("Guardar Distancia");
            guardarDistanciaButton.setBounds(300,300,200,30);
            guardarDistanciaButton.setBackground(Colores.principalBotones);
            guardarDistanciaButton.setFont(Fuentes.getPrincipalFontSize(12, true));
            guardarDistanciaButton.setForeground(Colores.white);
            guardarDistanciaButton.addActionListener(this);
            guardarDistanciaButton.setFocusPainted(false);
            dialogo.add(guardarDistanciaButton);
            
            
            
            
            dialogo.setTitle("Crear Viaje");
            dialogo.setSize(800,400);
            dialogo.setLayout(null);
            dialogo.setResizable(false);
            dialogo.setLocationRelativeTo(null);
            dialogo.getContentPane().setBackground(Colores.background);
            dialogo.setVisible(true);
        }
    
    
    }
    
}
