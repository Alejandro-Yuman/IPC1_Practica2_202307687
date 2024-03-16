/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vistas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import utils.Colores;

/**
 *
 * @author reneb
 */
public class MenuPrincipal extends JFrame implements ActionListener{

    public MenuPrincipal() {
        this.getContentPane().setBackground(Colores.background);
        this.setTitle("Panel de Gestiones");
        this.setSize(670,500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
    
 
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
    
}
