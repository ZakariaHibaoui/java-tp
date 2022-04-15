import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class interfaceCO {

	private JFrame AttributionPC;
	private JTextField txtcin;
	private JTextField txtid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					interfaceCO window = new interfaceCO();
					window.getAttributionPC().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public interfaceCO() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setAttributionPC(new JFrame());
		getAttributionPC().setTitle("Attribution Commande");
		getAttributionPC().setBounds(100, 100, 500, 366);
		getAttributionPC().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getAttributionPC().getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CIN");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel.setBounds(73, 87, 96, 32);
		getAttributionPC().getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_1.setBounds(73, 139, 66, 32);
		getAttributionPC().getContentPane().add(lblNewLabel_1);
		
		txtcin = new JTextField();
		txtcin.setBounds(149, 90, 231, 32);
		getAttributionPC().getContentPane().add(txtcin);
		txtcin.setColumns(10);
		
		txtid = new JTextField();
		txtid.setBounds(149, 142, 231, 32);
		getAttributionPC().getContentPane().add(txtid);
		txtid.setColumns(10);
		
		JButton btnAttribuer;
		btnAttribuer = new JButton("Attribuer");
		btnAttribuer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					//requete sql
					String sql = "INSERT INTO commande"
							+ "(cin, id)" + " VALUES (?,?)";
					//creation de connexion
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/validation"
							,"root","");
					//creation du statement
					PreparedStatement st = con.prepareStatement(sql);
					st.setString(1, txtcin.getText());
					st.setString(2, txtid.getText());
					
					st.executeUpdate();
					// un message l'hors de l'attribution est affectée  avec succes
					JOptionPane.showMessageDialog(btnAttribuer, "commande Ajouté avec Succes");

				} catch (Exception erreur) {
					
					JOptionPane.showMessageDialog(AttributionPC,""+ erreur.getMessage()+ "",
						    null, JOptionPane.ERROR_MESSAGE);
				}
			}
			
		});
		btnAttribuer.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		btnAttribuer.setBounds(121, 242, 121, 41);
		getAttributionPC().getContentPane().add(btnAttribuer);
		
		//button annuler pour retourner a la page principale
		JButton btnAnnulerP;
		btnAnnulerP = new JButton("Annuler");
		btnAnnulerP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AttributionPC.setVisible(false);
				application window = new application();
				window.getFrmValidation().setVisible(true);
			}
		});
		btnAnnulerP.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		btnAnnulerP.setBounds(286, 243, 115, 39);
		getAttributionPC().getContentPane().add(btnAnnulerP);
	}

	//les geters et les seters
	public JFrame getAttributionPC() {
		return AttributionPC;
	}

	public void setAttributionPC(JFrame attributionPC) {
		AttributionPC = attributionPC;
	}

}
