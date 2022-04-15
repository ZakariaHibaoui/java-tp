import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class interfaceC {

	private JFrame frmInsertionClient;
	private JTextField txtcin;
	private JTextField txtnom;
	private JTextField txtadresse;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					interfaceC window = new interfaceC();
					window.getFrmInsertionClient().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public interfaceC() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrmInsertionClient(new JFrame());
		getFrmInsertionClient().setTitle("Insertion Client");// title
		getFrmInsertionClient().setBounds(100, 100, 500, 366);// position car layout est null
		getFrmInsertionClient().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrmInsertionClient().getContentPane().setLayout(null);

		// label CIN
		JLabel lblNewLabel = new JLabel("CIN");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel.setBounds(50, 29, 57, 31);
		getFrmInsertionClient().getContentPane().add(lblNewLabel);

		// label Nom
		JLabel lblNewLabel_1 = new JLabel("nom");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_1.setBounds(50, 65, 75, 59);
		getFrmInsertionClient().getContentPane().add(lblNewLabel_1);

		// label adresse
		JLabel lblNewLabel_2 = new JLabel("adresse");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_2.setBounds(50, 130, 87, 35);
		getFrmInsertionClient().getContentPane().add(lblNewLabel_2);

		// zone de texte pour inserer le cin
		txtcin = new JTextField();
		txtcin.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtcin.setBounds(149, 31, 225, 31);
		getFrmInsertionClient().getContentPane().add(txtcin);
		txtcin.setColumns(10);

		// zone de texte pour inserer le nom
		txtnom = new JTextField();
		txtnom.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtnom.setBounds(149, 75, 225, 31);
		getFrmInsertionClient().getContentPane().add(txtnom);
		txtnom.setColumns(10);

		// zone de texte pour inserer le adresse
		txtadresse = new JTextField();
		txtadresse.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtadresse.setBounds(149, 134, 225, 31);
		getFrmInsertionClient().getContentPane().add(txtadresse);
		txtadresse.setColumns(10);

		// button ajouter
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					// 1- requête sql qu'on va executer insert
					String sql = "INSERT INTO client" + "(cin, nom, adresse)" + " VALUES (?,?,?)";
					// 2- creation de la connexion
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/validation", "root", "");
					// 3- creation du statement
					PreparedStatement st = con.prepareStatement(sql);
					st.setString(1, txtcin.getText());
					st.setString(2, txtnom.getText());
					st.setString(3, txtadresse.getText());
					st.executeUpdate();
					// un message l'hors de l'ajout du client avec succes
					JOptionPane.showMessageDialog(btnAjouter, "Client Ajouté avec Succes");

				} catch (Exception erreur) {
					// exception erreur
					// un message l'hors d'une erreur
					JOptionPane.showMessageDialog(frmInsertionClient, "" + erreur.getMessage() + "", null,
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnAjouter.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		btnAjouter.setBounds(86, 242, 121, 41);
		getFrmInsertionClient().getContentPane().add(btnAjouter);

		// button pour retourner au principal interface (frmValidation)
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmInsertionClient.setVisible(false);
				application window = new application();
				window.getFrmValidation().setVisible(true);

			}
		});
		btnAnnuler.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		btnAnnuler.setBounds(241, 244, 115, 39);
		getFrmInsertionClient().getContentPane().add(btnAnnuler);
	}

	// declaration des geters et les seters

	public JFrame getFrmInsertionClient() {
		return frmInsertionClient;
	}

	public void setFrmInsertionClient(JFrame frmInsertionClient) {
		this.frmInsertionClient = frmInsertionClient;
	}
}
