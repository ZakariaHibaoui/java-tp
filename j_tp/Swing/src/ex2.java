

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ex2 implements ActionListener 
{
  // Compte le nombre de clics
  private int i = 0;
  
  // L'�tiquette pour afficher la valeur du compteur
  private JLabel label;

  // Bouton qui incr�mente quand on clique dessus
  private JButton plus;

  // Bouton qui d�cr�mente lorsqu'on clique dessus
  private JButton moins;
  
  public JPanel getPanel() {
    // Cr�ez le panneau
    JPanel panel = new JPanel();
    
    // Ajoutez le bouton qui incr�mente
    plus = new JButton("plus");
    plus.addActionListener(this);
    panel.add(plus);
    
    // Ajoutez le bouton qui d�cr�mente
    moins = new JButton("moins");
    moins.addActionListener(this);
    panel.add(moins);
    
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
    else {
      i--;
      label.setText("" + i);
    }
  }

  public static void main(String[] args) {
    JFrame frame = new JFrame();
    frame.setTitle("ex2");
    frame.setSize(new Dimension(250, 80));
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    // Cr�ez le panneau � afficher
    ex2 CompteurDeClic = new ex2();
    JPanel CompteurDeClicPanel = CompteurDeClic.getPanel(); 
      
    // Ajoutez le panneau au centre de la fen�tre
    Container content = frame.getContentPane();
    content.add(CompteurDeClicPanel, BorderLayout.CENTER);
    
    // Afficher la fen�tre
    frame.setVisible(true);
  }
}