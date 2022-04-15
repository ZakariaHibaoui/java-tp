import java.util.Scanner;

// ex 2
public class produit {
	private int prix_unitaire;
	private int quantite;
	
	produit(int prix_unitaire, int quantite) {
		this.prix_unitaire = prix_unitaire;
		this.quantite = quantite;
	}
	
	public static void main (String[] args){
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Prix unitaire: ");
	    int prix_unitaire = scanner.nextInt();
	    System.out.println("Quantité: ");
	    int quantite = scanner.nextInt();
	    
		produit produit = new produit(prix_unitaire, quantite);
		System.out.print(produit.montant() + " DHS");
	}
	
	public int montant() {
		return this.prix_unitaire * this.quantite;
	}
}
