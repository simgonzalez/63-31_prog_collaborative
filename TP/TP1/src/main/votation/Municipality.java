package votation;

import java.util.Comparator;
import java.util.Map;

public class Municipality implements Comparable<Municipality> {
  private String nom;
  private int nombreElecteur;
  private Map<VoteType, Integer> nombreVotationParChoix;
  private int tauxDeParticipation;

  public Municipality(
      String nom, int nombreElecteur, int nombreVoteOui, int nombreVoteNon, int nombreVoteBlanc) {
    this.nom = nom;
    this.nombreElecteur = nombreElecteur;
    this.nombreVotationParChoix = Map.of(
        VoteType.OUI,
        nombreVoteOui,
        VoteType.NON,
        nombreVoteNon,
        VoteType.ABSTENTION,
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
        nombreVotationParChoix.get(VoteType.OUI),
        nombreVotationParChoix.get(VoteType.NON));
  }

  @Override
  public int compareTo(Municipality o) {
    return this.getNom().compareTo(o.getNom());
  }
}