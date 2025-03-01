package votation;

import java.util.Comparator;
import java.util.Map;

public class Commune implements Comparable<Commune> {
  private String nom;
  private int nombreElecteur;
  private Map<VotationType, Integer> nombreVotationParChoix;
  private int tauxDeParticipation;

  public Commune(
      String nom, int nombreElecteur, int nombreVoteOui, int nombreVoteNon, int nombreVoteBlanc) {
    this.nom = nom;
    this.nombreElecteur = nombreElecteur;
    this.nombreVotationParChoix = Map.of(
        VotationType.OUI,
        nombreVoteOui,
        VotationType.NON,
        nombreVoteNon,
        VotationType.ABSTENTION,
        nombreVoteBlanc);
    this.tauxDeParticipation = tauxDeParticipation();
  }

  public String getNom() {
    return nom;
  }

  public int getNombreElecteur() {
    return nombreElecteur;
  }

  public int getTauxDeParticipation() {
    return tauxDeParticipation;
  }

  private int tauxDeParticipation() {
    return 100
        * this.nombreVotationParChoix.values().stream()
            .reduce(0, (sum, votes) -> sum + votes, Integer::sum)
        / this.nombreElecteur;
  }

  @Override
  public String toString() {
    return String.format(
        "%s (%d électeurs, participation: %d%%) : %d oui, %d non",
        nom,
        nombreElecteur,
        this.tauxDeParticipation,
        nombreVotationParChoix.get(VotationType.OUI),
        nombreVotationParChoix.get(VotationType.NON));
  }

  @Override
  public int compareTo(Commune o) {
    return this.getNom().compareTo(o.getNom());
  }
}