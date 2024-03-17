/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vistas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import utils.Colores;
import utils.Fuentes;
import utils.Toolbox;

/**
 *
 * @author Alejandro
 */
public class Alerta extends JFrame implements ActionListener{
    
    public  Alerta(String mensajeMostrar, boolean success){
        JDialog dialogo = new JDialog(this);
        
        if(!success){
            JLabel imageLabel = new JLabel(Toolbox.adjustImage("../img/AlertaIcon.png", 30, 30));
            imageLabel.setBounds(10, 15, 30, 30);
            dialogo.add(imageLabel);
        }else{
            JLabel imageLabel = new JLabel(Toolbox.adjustImage("../img/CorrectoIcon.png", 30, 30));
            imageLabel.setBounds(10, 15, 30, 30);
            dialogo.add(imageLabel);
        }

        
        JLabel mensajeLabel = new JLabel("<html>" + mensajeMostrar + "</html>");
        mensajeLabel.setFont(Fuentes.getPrincipalFontSize(12, true));
        mensajeLabel.setVerticalAlignment(SwingConstants.TOP);
        mensajeLabel.setBounds(50, 20, 300, 100);
        dialogo.add(mensajeLabel);
        
        


        JButton aceptarButton = new JButton("Aceptar");
        aceptarButton.setBounds(125, 100, 150, 50);
        aceptarButton.setBackground(Colores.principalBotones);
        aceptarButton.setForeground(Colores.white);
        aceptarButton.addActionListener(this);
        dialogo.add(aceptarButton);
        
        
        dialogo.getContentPane().setBackground(Colores.background);
        dialogo.setTitle("Alerta");
        dialogo.setSize(400,200);
        dialogo.setLayout(null);
        dialogo.setResizable(false);
        dialogo.setLocationRelativeTo(null);
        dialogo.setAlwaysOnTop(true);
        dialogo.setVisible(true);
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Aceptar")){
            this.setVisible(false);
            this.dispose();
            
        }
    }
    
    
}
