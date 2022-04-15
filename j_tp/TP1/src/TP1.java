import java.util.Scanner;  // Import the Scanner class

public class TP1 {
	public static void main (String[] args){
		Scanner scanner = new Scanner(System.in);  // Create a Scanner object
		// ex 1
		/*
	    System.out.println("Nombre 1");
	    int a = scanner.nextInt();
	    System.out.println("Nombre 2");
	    int b = scanner.nextInt();
	    	    
	    System.out.print("Somme = " + (a+b));
	    */
	    // ex 3
		/*
	    System.out.println("Nombre 1");
	    int x = scanner.nextInt();
	    System.out.println("Nombre 2");
	    int y = scanner.nextInt();
	    System.out.println("Nombre 3");
	    int z = scanner.nextInt();
	    	    	    
	    System.out.println("Somme = " + (x+y+z));
	    System.out.println("Produit = " + (x*y*z));
	    System.out.println("Moyenne = " + ((x+y+z)/3));
	  	
		*/
		// ex 4
		/*
		System.out.println("Nombre reel");
	    float x = scanner.nextFloat();
	    if (x > 0)
	    	System.out.println("nombre est positive");
	    else if (x < 0)
	    	System.out.println("nombre est negative");
	    else
	    	System.out.println("nombre est nul");
	    	*/
		
		// ex5
		/*
		System.out.println("Nombre reel 1");
	    float x = scanner.nextFloat();
	    System.out.println("Nombre reel 2");
	    float y = scanner.nextFloat();
	    
	    if (x > y)
	    	System.out.println("nombre max est " + x);
	    else if (x < y)
	    	System.out.println("nombre max est " + y);
	    else
	    	System.out.println("nombres sont egaux");
	    	
		*/
		// ex6
		/*
		System.out.println("Var 1");
	    String x = scanner.nextLine();
	    System.out.println("Var 2");
	    String y = scanner.nextLine();
	    
	    System.out.println("x = " + x + " y = " + y);
	    
	    String z = x;
	    x = y;
	    y = z;
	    
	    System.out.println("Nouveaux valeurs:  ");
	    System.out.println("x = " + x + " y = " + y);
	    
		*/
		// ex7
		/*
		System.out.println("Val de a");
	    float a = scanner.nextFloat();
	    System.out.println("Val de b");
	    float b = scanner.nextFloat();
	    
	    if (a == 0)
	    	System.out.println("il y'a des solutions infinis");
	    else
	    	System.out.println("x = " + -(b/a));
	    	*/
		
		// ex8
		/*
		System.out.println("Val de a");
	    float a = scanner.nextFloat();
	    System.out.println("Val de b");
	    float b = scanner.nextFloat();
	    System.out.println("Val de c");
	    float c = scanner.nextFloat();
	    
	    float delta = b*b - 4*a*c;
	    if (delta < 0)
	    	System.out.println("Pas de solution réelle");
	    else if (delta == 0)
	    	System.out.println("x0 = " + -(b/2*a));
	    else
	    	System.out.println("x1 = " + ((-b-Math.sqrt(delta))/(2*a)) + " et x2 = " + ((-b+Math.sqrt(delta))/(2*a)));
		
		*/
		// ex9
		/*
		System.out.println("Montant");
	    float M = scanner.nextFloat();
	    float t;
	    if (M < 5000)
	    	t = 5;
	    else if (M >= 8000)
	    	t = 10;
	    else
	    	t = 8;
	    
    	System.out.println("M = " + (M - (1 - t/100)));
    	*/
		
		// ex10
		/*
		for (int i = 0; i < 100; i++)
			System.out.println("bonjour");
			*/
		
		// ex11
		/*
		int S = 1;
		for (int i = 1; i < 30; i++)
			S += (i+1);
		System.out.println(S);
			*/
		
		// ex12
		/*
		int S = 1;
		System.out.println("n: ");
	    int n = scanner.nextInt();
	    
		for (int i = 1; i < n; i++)
			S *= (i+1);
		System.out.println(S);
	*/
		
		// ex 13
		/*
		System.out.println("Texte: ");
	    String text = scanner.nextLine();
	    int j = 0;
	    
		for (int i=0; i < text.length(); i++) {
			if (text.charAt(i) == 'a')
				j++;
		}
		System.out.println("Nombre de a dans " + text + " est: " + j);
	    
		*/
		// ex14
	    /*
		System.out.println("Note 1");
	    float n1 = scanner.nextFloat();
	    System.out.println("Note 2");
	    float n2 = scanner.nextFloat();
	    System.out.println("Note 3");
	    float n3 = scanner.nextFloat();
	    System.out.println("Note 4");
	    float n4 = scanner.nextFloat();
	    
	    float moyenne = (n1+n2+n3+n4) / 4;
	    String mention = null;
	    
	    if (moyenne >= 10 && moyenne < 12)
	    	mention = "Passable";
	    if (moyenne >= 12 && moyenne < 14)
	    	mention = "Assez bien";
	    if (moyenne >= 14 && moyenne < 16)
	    	mention = "Bien";
	    if (moyenne >= 16)
	    	mention = "Très bien";
	    
		System.out.println("Mention: " + mention);
		*/
		// ex15
		
		System.out.println("n: ");
	    int n = scanner.nextInt();
	    for (int i = 0; i <= n; i++) {
	    	for (int j = 0; j < i; j++) {	    		
	    		System.out.print("*");
	    	}
	    	System.out.println();
	    }
	   
	    	
		

	}
}
