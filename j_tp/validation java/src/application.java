import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class application {

	private JFrame frmValidation;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					application window = new application();
					window.getFrmValidation().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public application() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrmValidation(new JFrame());
		getFrmValidation().setTitle("Validation JAVA ASR_ZAKARIA_HIBAOUI");
		getFrmValidation().setBounds(100, 100, 500, 366);
		getFrmValidation().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrmValidation().getContentPane().setLayout(null);

		// Button client

		JButton btnClient = new JButton("Client");
		btnClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmValidation.setVisible(false);
				interfaceC window = new interfaceC();
				window.getFrmInsertionClient().setVisible(true);
			}
		});
		btnClient.setBounds(56, 122, 115, 47);
		btnClient.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		getFrmValidation().getContentPane().add(btnClient);

		// Button Produit

		JButton btnProduit = new JButton("Produit");
		btnProduit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmValidation.setVisible(false);
				interfaceP window = new interfaceP();
				window.getFrmInsertionProduit().setVisible(true);
			}
		});
		btnProduit.setBounds(181, 122, 117, 47);
		btnProduit.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		getFrmValidation().getContentPane().add(btnProduit);

		// Button Commande
		JButton btnCommande = new JButton("Commande");
		btnCommande.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmValidation.setVisible(false);
				interfaceCO window = new interfaceCO();
				window.getAttributionPC().setVisible(true);
			}
		});
		btnCommande.setBounds(308, 122, 134, 47);
		btnCommande.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		getFrmValidation().getContentPane().add(btnCommande);

		// Button Somme

		JButton btnSomme = new JButton("Somme");
		btnSomme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmValidation.setVisible(false);
				InterfaceS window = new InterfaceS();
				window.getSomme().setVisible(true);

			}
		});
		btnSomme.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		btnSomme.setBounds(167, 193, 141, 41);
		getFrmValidation().getContentPane().add(btnSomme);
	}

	// geters and seters

	/**
	 * @return the frmValidation
	 */
	public JFrame getFrmValidation() {
		return frmValidation;
	}

	/**
	 * @param frmValidation the frmValidation to set
	 */
	public void setFrmValidation(JFrame frmValidation) {
		this.frmValidation = frmValidation;
	}

}
