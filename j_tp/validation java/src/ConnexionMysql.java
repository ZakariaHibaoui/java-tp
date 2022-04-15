import java.sql.*;
import javax.swing.*;
/**
 * 
 */

/**
 * @author zakar
 *
 */
public class ConnexionMysql {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			//charger le driver
			Class.forName("com.mysql.jdbc.Driver");
			//creer la connexion
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/validationjava","root","");
			//creer statement
			Statement st =conn.createStatement();
			//resultat
			ResultSet rs = st.executeQuery("select * from client");
			//parcours de rs
			while(rs.next()) {
				System.out.println("Nom :"+rs.getString(1));
				System.out.println("prenom :"+rs.getString(2));
				System.out.println("cin :"+rs.getString(3));
				System.out.println("numero :"+rs.getInt(4));
				
			}
		}catch(Exception e) {
			System.out.println("exception"+e);
			
			
		}

	}

}
