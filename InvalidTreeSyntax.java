/*Jaden Russell
  Project 3
  4/22/23
  This program defines a checked exception that is throw when the syntax of a
  binary tree is invalid.
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project3_jaden_russell;

/**
 *
 * @author jaden
 */
import javax.swing.*;

public class InvalidTreeSyntax extends Exception{
    
    public InvalidTreeSyntax(String msg){
        super();
        JOptionPane.showMessageDialog(null, msg, "Error", 0);
    }
}
