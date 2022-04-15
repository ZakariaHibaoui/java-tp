import java.awt.event.*;

import javax.swing.*;  
class ex3  
{  
	JMenu menu, submenu;  
          JMenuItem i1, i2, i3, i4, i5;  
          ex3(){  
          JFrame f   = new JFrame("ex3");  
          JMenuBar mb=new JMenuBar();  
          menu       =new JMenu("File");  
          submenu    =new JMenu("Property");  
          i1         =new JMenuItem("New");  
          i2         =new JMenuItem("Open");  
          i3         =new JMenuItem("Save");  
          i4         =new JMenuItem("Big");  
          i5         =new JMenuItem("Small");  
          menu.add(i1); menu.add(i2); menu.add(i3);  
          submenu.add(i4); submenu.add(i5);  
          menu.add(submenu);  
          mb.add(menu);  
          f.setJMenuBar(mb);  
          f.setSize(400,400);  
          f.setLayout(null);  
          f.setVisible(true);  
          
       }  
         
public static void main(String args[])  
{  
new ex3();  
}}  
