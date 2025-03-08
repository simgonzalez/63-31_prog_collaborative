import compte.Compte;
import produit.Produit;

public class App {
  public static void main(String[] args) throws Exception {
    System.out.println("Testing ListeDonnees with Produit objects");

    // Create a ListeDonnees to hold Produit objects
    ListeDonnees<Produit> ldProduit = new ListeDonnees<>();
    System.out.println("Empty ListeDonnees created");

    // Test adding products
    Produit p1 = new Produit(1, "Laptop", 999);
    Produit p2 = new Produit(2, "Phone", 599);
    Produit p3 = new Produit(3, "Headphones", 149);

    ldProduit.add(p1);
    ldProduit.add(p2);
    ldProduit.add(p3);

    // Print total and moyenne for Produit
    System.out.println("Total for Produit: " + ldProduit.total());
    System.out.println("Moyenne for Produit: " + ldProduit.moyenne());

    System.out.println("\nTesting ListeDonnees with Compte objects");

    // Create a ListeDonnees to hold Compte objects
    ListeDonnees<Compte> ldCompte = new ListeDonnees<>();
    System.out.println("Empty ListeDonnees created");

    // Test adding comptes
    Compte c1 = new Compte(1, 1500.00);
    Compte c2 = new Compte(2, 2500.00);
    Compte c3 = new Compte(3, 3500.00);

    ldCompte.add(c1);
    ldCompte.add(c2);
    ldCompte.add(c3);

    // Print total and moyenne for Compte
    System.out.println("Total for Compte: " + ldCompte.total());
    System.out.println("Moyenne for Compte: " + ldCompte.moyenne());
  }
}