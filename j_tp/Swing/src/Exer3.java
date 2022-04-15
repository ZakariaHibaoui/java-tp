import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Exer3 {
 private JMenuItem item1, item2, item3, item4, item5;
 private JTextArea text;
 //private JLabel label;
 public Exer3() {
 JFrame frame = new JFrame("exercice3");
 frame.addWindowListener(new MyWindowListener());
 JMenuBar menuBar = new JMenuBar();
 JMenu menu = new JMenu("File");
 JMenu submenu = new JMenu("Property");
 item1 = new JMenuItem("New");
 item2 = new JMenuItem("Open");
 item3 = new JMenuItem("Save");
 item4 = new JMenuItem("Big");
 item5 = new JMenuItem("Small");
 MyActionListener listener = new MyActionListener();
 item1.addActionListener(listener);
 item2.addActionListener(listener);
 item3.addActionListener(listener);
 item4.addActionListener(listener);
 item5.addActionListener(listener);
 menu.add(item1);
 menu.add(item2);
 menu.add(item3);
 menu.add(new JSeparator());
 menu.add(submenu);
 submenu.add(item4);
 submenu.add(item5);
 menuBar.add(menu);

//declaration d'une zone de  texte
 text = new JTextArea();
 //label = new JLabel("hhhhhhhhh");
 frame.setJMenuBar(menuBar);
 frame.getContentPane().add(text);
 frame.setVisible(true);
 }
 private class MyWindowListener extends WindowAdapter {
 public void windowClosing(WindowEvent event) {
 System.exit(0);
 }
 }
 
 //on declare la methode action listener qui recupere l'historique de la selection des items
 //dans une zone texte 
 private class MyActionListener implements ActionListener {
	 public void actionPerformed(ActionEvent event) {
	 text.append(((JMenuItem)event.getSource()).getText() + "\n");
	 }
 }
 public static void main(String[] args) {
 new Exer3();
 }
}