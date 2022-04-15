
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;

import com.mysql.jdbc.Statement;

public class JDBC {

	public static void main(String[] args) {
		
		System.out.println("entrer l'id de la filliere");
		Scanner scanner = new Scanner (System.in);
		int id = scanner.nextInt();
		try {
			//chargemment de driver
			Class.forName("con.mysql.cj.jdbc.Driver");
			//conn a la base de donnée
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","")	;
			//Creation du statement 
			java.sql.Statement stmt = con.createStatement();
			//Resultat 
			ResultSet rs =stmt.executeQuery("select nom ,prenom where etudiant.idfill = filliere.idfill");
			//parcours du resultat 
			while(rs.next()) {
				String nf = rs.getString("nomfill");
				String name = rs.getString("nom");
				String prenom = rs.getString("prenom");
				}
			
			//insertion
			String str = "INSERT INTO `etudiant`(`id`, `nom`, `prenom`, `idfill`) VALUES (2,'chaimae','alami',1)";
			con.close();
			
		}catch(Exception e) {
			System.out.println(e);		}
		

	}

}
