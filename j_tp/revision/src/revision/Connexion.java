package revision;
import java.sql.*;

public class Connexion {

	public static void main(String[] args) {
		try{
			//charger le driver
			Class.forName("com.mysql.jdbc.Driver");
			//craete connexion
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelproject","root","");
			//create statement
			Statement st =con.createStatement();
			//Resultat
			ResultSet rs =st.executeQuery("select * from signup");
			while(rs.next()) {
				System.out.println("Nom :"+rs.getString(1));
				System.out.println("prenom :"+rs.getString(2));
				System.out.println("cin :"+rs.getString(3));
				System.out.println("numero :"+rs.getString(4));
			}
			
		}
		catch(Exception e) {
				System.out.println("exception"+e);
		}

	}

}
