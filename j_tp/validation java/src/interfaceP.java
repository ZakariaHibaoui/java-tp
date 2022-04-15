import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class interfaceP {

	private JFrame frmInsertionProduit;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField txtid;
	private JTextField txtnom;
	private JTextField txtprix;
	private JButton btnAjouterP;
	private JButton btnAnnulerP;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					interfaceP window = new interfaceP();
					window.getFrmInsertionProduit().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public interfaceP() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrmInsertionProduit(new JFrame());
		getFrmInsertionProduit().setTitle("Insertion Produit");
		getFrmInsertionProduit().setBounds(100, 100, 500, 366);
		getFrmInsertionProduit().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrmInsertionProduit().getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel.setBounds(72, 43, 125, 31);
		getFrmInsertionProduit().getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("prix");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_1.setBounds(72, 113, 75, 59);
		getFrmInsertionProduit().getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("nom");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_2.setBounds(72, 84, 87, 35);
		getFrmInsertionProduit().getContentPane().add(lblNewLabel_2);

		//buton ajouter
		JButton btnAjouterP;
		btnAjouterP = new JButton("Ajouter");
		btnAjouterP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					//requete sql d'insertion
					String sql = "INSERT INTO produit" + "(id, nom, prix)" + " VALUES (?,?,?)";
					//creation de la connexion
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/validation",
							"root", "");
					//creation du statement
					PreparedStatement st = con.prepareStatement(sql);
					st.setString(1, txtid.getText());
					st.setString(2, txtnom.getText());
					st.setString(3, txtprix.getText());
					st.executeUpdate();
					// un message l'hors de l'ajout du produit avec succes
					JOptionPane.showMessageDialog(btnAjouterP, "le produit est Ajouté avec Succes");

				} catch (Exception erreur) {
					//exception erreur
					//message pour indiquer l'erreur
					JOptionPane.showMessageDialog(frmInsertionProduit,"" + erreur.getMessage() + "",
						    null, JOptionPane.ERROR_MESSAGE);
				}
			}

		});
		btnAjouterP.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		btnAjouterP.setBounds(86, 242, 121, 41);
		getFrmInsertionProduit().getContentPane().add(btnAjouterP);

		//button annuler pour retourner au principal page (frmValidation)
		JButton btnAnnulerP;
		btnAnnulerP = new JButton("Annuler");
		btnAnnulerP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmInsertionProduit.setVisible(false);
				application window = new application();
				window.getFrmValidation().setVisible(true);

			}
		});
		btnAnnulerP.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		btnAnnulerP.setBounds(241, 244, 115, 39);
		getFrmInsertionProduit().getContentPane().add(btnAnnulerP);

		//zone de texte pour l'id du produit
		txtid = new JTextField();
		txtid.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtid.setBounds(204, 43, 209, 34);
		getFrmInsertionProduit().getContentPane().add(txtid);
		txtid.setColumns(10);

		//zone de texte pour le nom du produit
		txtnom = new JTextField();
		txtnom.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtnom.setColumns(10);
		txtnom.setBounds(204, 87, 209, 31);
		getFrmInsertionProduit().getContentPane().add(txtnom);

		//zone de texte pour le prix du produit
		txtprix = new JTextField();
		txtprix.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtprix.setColumns(10);
		txtprix.setBounds(204, 129, 209, 31);
		getFrmInsertionProduit().getContentPane().add(txtprix);

	}

	//declaration des geters et les seters 
	public JFrame getFrmInsertionProduit() {
		return frmInsertionProduit;
	}

	public void setFrmInsertionProduit(JFrame frmInsertionProduit) {
		this.frmInsertionProduit = frmInsertionProduit;
	}

}
