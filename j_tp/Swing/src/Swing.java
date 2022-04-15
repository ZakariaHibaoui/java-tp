

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Swing implements ActionListener 
{
  // Compte le nombre de clics
  private int i = 0;
  
  // L'�tiquette pour afficher la valeur du compteur
  private JLabel label;

  // Bouton qui incr�mente quand on clique dessus
  private JButton plus;

  
  
  public JPanel getPanel() {
    // Cr�ez le panneau
    JPanel panel = new JPanel();
    
    // Ajoutez le bouton qui incr�mente
    plus = new JButton("+");
    plus.addActionListener(this);
    panel.add(plus);
    
   
     // Ajouter le compteur � afficher
    label = new JLabel("" + i);
    panel.add(label);
    
    return panel;
  }
  
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == plus) {
      i++;
      label.setText("" + i);
    }
    
  }

  public static void main(String[] args) {
    JFrame frame = new JFrame();
    frame.setTitle("ex1");
    frame.setSize(new Dimension(250, 80));
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    // Cr�ez le panneau � afficher
    Swing CompteurDeClic = new Swing();
    JPanel CompteurDeClicPanel = CompteurDeClic.getPanel(); 
      
    // Ajoutez le panneau au centre de la fen�tre
    Container content = frame.getContentPane();
    content.add(CompteurDeClicPanel, BorderLayout.CENTER);
    
    // Afficher la fen�tre
    frame.setVisible(true);
  }
}