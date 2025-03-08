package compte;

import valorisable.Valorisable;

public class Compte implements Valorisable {
  private int no;
  private double solde;

  public Compte(int no, double solde) {
    this.no = no;
    this.solde = solde;
  }

  public Number getValeur() {
    return solde;
  }
}
