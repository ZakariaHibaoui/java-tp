

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ex2 implements ActionListener 
{
  // Compte le nombre de clics
  private int i = 0;
  
  // L'étiquette pour afficher la valeur du compteur
  private JLabel label;

  // Bouton qui incrémente quand on clique dessus
  private JButton plus;

  // Bouton qui décrémente lorsqu'on clique dessus
  private JButton moins;
  
  public JPanel getPanel() {
    // Créez le panneau
    JPanel panel = new JPanel();
    
    // Ajoutez le bouton qui incrémente
    plus = new JButton("plus");
    plus.addActionListener(this);
    panel.add(plus);
    
    // Ajoutez le bouton qui décrémente
    moins = new JButton("moins");
    moins.addActionListener(this);
    panel.add(moins);
    
    // Ajouter le compteur à afficher
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
    
    // Créez le panneau à afficher
    ex2 CompteurDeClic = new ex2();
    JPanel CompteurDeClicPanel = CompteurDeClic.getPanel(); 
      
    // Ajoutez le panneau au centre de la fenêtre
    Container content = frame.getContentPane();
    content.add(CompteurDeClicPanel, BorderLayout.CENTER);
    
    // Afficher la fenêtre
    frame.setVisible(true);
  }
}