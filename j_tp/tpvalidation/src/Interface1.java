import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Interface1 {
 private JTextArea text, area;
 public Interface1() {
 JFrame frame = new JFrame("affectation des matieres aux etudiants");
 frame.addWindowListener(new MyWindowListener());
 text = new JTextArea();
 text.setEditable(true);
 JWindow window = new JWindow(frame);
 JPanel panel = new JPanel(new BorderLayout());
 panel.add(text, BorderLayout.CENTER);
 JScrollPane scroll = new JScrollPane(panel);
 window.getContentPane().add(scroll);
 JPanel panel2 = new JPanel(new BorderLayout());
 area = new JTextArea();
 panel2.add(area, BorderLayout.CENTER);
 JPanel panel3 = new JPanel(new BorderLayout());
 JButton button = new JButton("send it");
 panel3.add(new JScrollPane(panel2), BorderLayout.CENTER);
 panel3.add(button, BorderLayout.SOUTH);
 button.addActionListener(new MyActionListener());
 frame.getContentPane().add(panel3);
 frame.setSize(200, 200);
 window.setSize(200, 200);
 frame.setLocation(0, 0);
 window.setLocation( 200, 0);
 frame.setVisible(true);
 window.setVisible(true);
 }

 private class MyWindowListener extends WindowAdapter {
 public void windowClosing(WindowEvent event) {
 System.exit(0);
 }
 }
 private class MyActionListener implements ActionListener {
 public void actionPerformed(ActionEvent event) {
 text.append(area.getText() + "\n" + "------------"+ "\n ");
 area.setText("");
 }
 }
 public static void main(String[] args) {
 new Interface1();
 }
 }
