package produit;

import valorisable.Valorisable;

public class Produit implements Valorisable {
  private int no;
  private String nom;
  private int prix;

  public Produit(int no, String nom, int prix) {
    this.no = no;
    this.nom = nom;
    this.prix = prix;
  }

  public Number getValeur() {
    return prix;
  }
}
