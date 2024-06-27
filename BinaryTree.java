/*Jaden Russell
  Project 3
  4/22/23
  This program creates the Node class to hold a character and the node's children, and
  defines the BinaryTree class to create a tree of nodes.
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
import java.util.*;

public class BinaryTree {

    Node root;

    public BinaryTree(String s) throws InvalidTreeSyntax {
        if (!Character.isDigit(s.charAt(0)) && !Character.isAlphabetic(s.charAt(0))) {
            throw new InvalidTreeSyntax("The root of the tree should be a number or a letter.");
        }
        root = new Node(s.charAt(0));
        Stack<Node> stk = new Stack<>();
        int pCount = 0;

        for (int i = 1; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '(':
                    stk.push(root);
                    pCount++;
                    break;
                case ')':
                    root = stk.peek();
                    stk.pop();
                    pCount--;
                    break;
                default:
                    if (!Character.isDigit(s.charAt(i)) && !Character.isAlphabetic(s.charAt(i))) {
                        throw new InvalidTreeSyntax("The tree should contain numbers or letters only.");
                    } else if (root.left == null) {

                        Node left = new Node(s.charAt(i));
                        root.left = left;
                        root = root.left;
                    } else if (root.right == null) {

                        Node right = new Node(s.charAt(i));
                        root.right = right;
                        root = root.right;
                    }
                    break;
            }
        }
        if (pCount > 0) {
            throw new InvalidTreeSyntax("Every parentheses should be closed.");
        }
    }

    public int getHeight(Node n) {
        if (n == null) {
            return 0;
        }

        return 1
                + Math.max(getHeight(n.left),
                        getHeight(n.right));
    }

    boolean isBalanced(Node n) {

        if (n == null) {
            return true;
        }
        return Math.abs(getHeight(n.left) - getHeight(n.right)) <= 1 && isBalanced(n.left)
                && isBalanced(n.right);
    }

    public boolean isFull(Node n) {
        int level = 1;
        int height = this.getHeight(root);
        return isFull(n, level, height);
    }

    private boolean isFull(Node n, int level, int treeHeight) {
        if ((n.left == null && n.right == null) && level == treeHeight) {
            return true;
        } else if (n.left != null && n.right != null) {
            return (isFull(n.left, level + 1, treeHeight) && isFull(n.right, level + 1, treeHeight));
        }
        return false;
    }

    public boolean isProper(Node n) {

        if (n == null) {
            return true;
        } else if (n.left == null && n.right == null) {
            return true;
        } else if (n.left != null && n.right != null) {
            return (isProper(n.left) && isProper(n.right));
        }

        return false;
    }

    public int totalNodes(Node n) {

        if (n == null) {
            return 0;
        }
        return 1 + totalNodes(n.left) + totalNodes(n.right);
    }

    public String Inorder(Node n) {

        String str = "";

        if (n == null) {
            return "";
        }
        str += "(";
        str += Inorder(n.left);

        str += " " + n.data + " ";
        str += Inorder(n.right);
        str += ")";

        return str;
    }

    static class Node {

        char data;
        Node left;
        Node right;

        Node(char s) {
            data = s;
            left = null;
            right = null;
        }
    }
}
