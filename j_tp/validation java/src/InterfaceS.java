import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;



public class InterfaceS {

	private JFrame Somme;
	private final JScrollPane scrollPane = new JScrollPane();
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceS window = new InterfaceS();
					window.getSomme().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InterfaceS() {
		initialize();
		//remplir_table();
		affichage();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setSomme(new JFrame());
		getSomme().setBounds(100, 100, 500, 366);
		getSomme().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Somme.getContentPane().setLayout(null);
		scrollPane.setBounds(0, 49, 486, 280);
		Somme.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("Table produit avec somme des prix");
		lblNewLabel.setBounds(116, 10, 250, 29);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		Somme.getContentPane().add(lblNewLabel);
	}

	public JFrame getSomme() {
		return Somme;
	}

	public void setSomme(JFrame somme) {
		Somme = somme;
		Somme.setTitle("table produit avec la somme");
	}
	/*public void remplir_table() {
		try {

			String sql = "SELECT * FROM produit" ;
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/validation", "root", "");
			PreparedStatement st = con.prepareStatement(sql);
		    ResultSet rs=st.executeQuery();
		    table.setModel(DbUtils.resultSetToTableModel(rs));
			

		} catch (Exception erreur) {
			JOptionPane.showMessageDialog(Somme,"" + erreur.getMessage() + "",
				    null, JOptionPane.ERROR_MESSAGE);
		}
	}*/
	
	public void affichage() {
		//creation de la table d'ou on va stocker nos donnees exportées 
		//attribution de la structure de la table
		DefaultTableModel model =new DefaultTableModel();
		model.addColumn("id");
		model.addColumn("nom");
		model.addColumn("somme des prix");
		
		
		
		try {
			//requete sql
			String sql = "select * from produit";
			//creation de la connexion
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/validation","root","");
			//cration du statement
			PreparedStatement st =con.prepareStatement(sql);
			//declaration des resultat car la requete est select 
			ResultSet rs =st.executeQuery();
			//parcours du resultat
			while(rs.next()) {
				//attribution de nos données dans la table qu'on a crée
				model.addRow(new Object[] {
						rs.getString("id"),
						rs.getString("nom"),
						rs.getString("prix")
				});
			}
			table.setModel(model);
			table.setAutoResizeMode(0);
			table.getColumnModel().getColumn(0).setPreferredWidth(120);//precision de la taille de notre colonne1(id)
			table.getColumnModel().getColumn(1).setPreferredWidth(180);//precision de la taille de notre colonne2(nom)
			table.getColumnModel().getColumn(2).setPreferredWidth(180);//precision de la taille de notre colonne3(somme)
		}catch(Exception erreur) {}
	}
	
		
	}
	

