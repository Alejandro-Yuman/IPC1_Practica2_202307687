/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.awt.Font;

/**
 *
 * @author reneb
 */
public class Fuentes {
    public static Font getPrincipalFontSize(int size, boolean bold){
        if(bold){
            return new Font("Verdana",Font.BOLD,size);
        }else{
            return new Font("Verdana",Font.PLAIN,size);
        }
        
    }
    
}
