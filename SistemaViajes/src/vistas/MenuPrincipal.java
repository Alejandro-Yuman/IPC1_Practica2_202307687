/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vistas;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
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
    boolean inicioActive = false;
    boolean rutasActive = false;
    boolean viajesActive = false;
    
    JTextField idField;
    JTextField distanciaField;
    
    public MenuPrincipal() {
        panelBienvenida();
        panelRutas();
        panelViajes();
        this.remove(panelInicio);
        this.remove(panelRutas);
        this.remove(panelViajes);
        botonSeleccionado(0);
        this.repaint();
        
        //---------------------------------Panel derecha
        JPanel panelPrincipalderecha = new JPanel();
        panelPrincipalderecha.setBounds(0,0,250,700);
        panelPrincipalderecha.setLayout(null);
        panelPrincipalderecha.setBackground(Colores.backgroundPanel);
        
        
        JLabel logoLabel = new JLabel(Toolbox.adjustImage("../img/ApertureWhiteTransport.png", 165, 45));
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

            JLabel logoTransportLabel = new JLabel(Toolbox.adjustImage("../img/ApertureBlackTransport.png", 165, 45));
            logoTransportLabel.setBounds(60, 250, 165, 45);
            panelInicio.add(logoTransportLabel);

            JLabel mediaFraseLabel = new JLabel("<html>LA SOLUCIÓN AL TRANSPORTE DE PRIMERA CLASE, GRACIAS A</html>");
            mediaFraseLabel.setBounds(20,270,300,200);
            mediaFraseLabel.setForeground(Colores.black);
            mediaFraseLabel.setFont(Fuentes.getPrincipalFontSize(16, true));
            panelInicio.add(mediaFraseLabel);
            
            JLabel logoApertureLabel = new JLabel(Toolbox.adjustImage("../img/LogoCompleto.png", 165, 45));
            logoApertureLabel.setBounds(60, 440, 165, 45);
            panelInicio.add(logoApertureLabel);
            
            
            
            
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
            
            JLabel tituloLabel = new JLabel("VIAJES");
            tituloLabel.setBounds(20,20,400,30);
            tituloLabel.setForeground(Colores.tituloLetra);
            tituloLabel.setFont(Fuentes.getPrincipalFontSize(16, true));
            panelViajes.add(tituloLabel);

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
            
            JLabel logoTransportLabel = new JLabel(Toolbox.adjustImage("../img/ApertureWhiteTransport.png", 165, 45));
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
    }
    
}
