/*Jaden Russell
  Project 3
  4/22/23
  This program creates a GUI that takes a input from the user and creates a binary tree,
  then creates multiple functions in the GUI that use the binary tree.
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package project3_jaden_russell;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author jaden
 */
public class Main implements ActionListener {

    /**
     * @param args the command line arguments
     */
    static BinaryTree tree;

    public static void main(String[] args) {
        JFrame f = new JFrame("Binary Tree Catagorizer");
        JPanel p = new JPanel();
        JLabel l1 = new JLabel("Enter Tree:");
        JLabel l2 = new JLabel("Output:");
        JTextField t1 = new JTextField(30);
        JTextField t2 = new JTextField(30);
        JButton b1 = new JButton("Make Tree");
        JButton b2 = new JButton("Is Balanced?");
        JButton b3 = new JButton("Is Full?");
        JButton b4 = new JButton("Is Proper?");
        JButton b5 = new JButton("Height");
        JButton b6 = new JButton("Nodes");
        JButton b7 = new JButton("Inorder");

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        p.add(l1);
        p.add(t1);
        p.add(b1);
        p.add(b2);
        p.add(b3);
        p.add(b4);
        p.add(b5);
        p.add(b6);
        p.add(b7);
        p.add(l2);
        p.add(t2);
        f.add(p);
        f.setSize(370, 190);
        f.setVisible(true);

        b1.addActionListener((ActionEvent e) -> {
            Boolean error = false;
            try {
                tree = new BinaryTree(t1.getText());
            } catch (StringIndexOutOfBoundsException ex) {
                error = true;
                JOptionPane.showMessageDialog(null, "You have not entered an input.",
                        "Error", JOptionPane.ERROR_MESSAGE);
            } catch (InvalidTreeSyntax ex) {
                error = true;
                JOptionPane.showMessageDialog(null, "A tree could not be created.",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
            if (!error) {
                JOptionPane.showMessageDialog(null, "A binary tree has been created.",
                        "Message", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        b2.addActionListener((ActionEvent e) -> {
            try {
                if (tree.isBalanced(tree.root)) {
                    t2.setText("The tree is balanced");
                } else {
                    t2.setText("The tree is not balanced");
                }
            } catch (NullPointerException ex) {
                JOptionPane.showMessageDialog(null, "You have not created a tree to check.",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        b3.addActionListener((ActionEvent e) -> {
            try {
                if (tree.isFull(tree.root)) {
                    t2.setText("The tree is full");
                } else {
                    t2.setText("The tree is not full");
                }
            } catch (NullPointerException ex) {
                JOptionPane.showMessageDialog(null, "You have not created a tree to check.",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        b4.addActionListener((ActionEvent e) -> {
            try {
                if (tree.isProper(tree.root)) {
                    t2.setText("The tree is proper");
                } else {
                    t2.setText("The tree is not proper");
                }
            } catch (NullPointerException ex) {
                JOptionPane.showMessageDialog(null, "You have not created a tree to check.",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        b5.addActionListener((ActionEvent e) -> {
            try {
                int treeHeight = tree.getHeight(tree.root) - 1;
                t2.setText("The tree's height is " + treeHeight);

            } catch (NullPointerException ex) {
                JOptionPane.showMessageDialog(null, "You have not created a tree to check.",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        
        b6.addActionListener((ActionEvent e) -> {
            try {
                t2.setText("The total number of nodes in the tree is " + tree.totalNodes(tree.root));

            } catch (NullPointerException ex) {
                JOptionPane.showMessageDialog(null, "You have not created a tree to check.",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        
        b7.addActionListener((ActionEvent e) -> {
            try {
                t2.setText(tree.Inorder(tree.root));

            } catch (NullPointerException ex) {
                JOptionPane.showMessageDialog(null, "You have not created a tree to check.",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}
