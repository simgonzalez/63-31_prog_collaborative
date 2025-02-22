import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import votation.CannotReadCommuneRowException;
import votation.Commune;
import votation.CommuneUtils;

public class Main {
  private static final List<Commune> communesVotantes = new ArrayList<>();

  public static void main(String[] args) {
    chargerResultats();
    afficherPlusGrandeCommune();
    System.out.println(
        "=========================================================================================");
    afficherParOrdreAlphabetique();
    System.out.println(
        "=========================================================================================");
    afficherParParticipation();
  }

  /** Lit le fichier results.csv et le conserve en mémoire dans une Collection */
  private static void chargerResultats() {
    try (BufferedReader reader = new BufferedReader(new FileReader("src/resources/results.csv"))) {
      String row;
      while ((row = reader.readLine()) != null) {
        try {
          communesVotantes.add(CommuneUtils.fromCsvRow(row));
        } catch (CannotReadCommuneRowException e) {
          System.out.println("Erreur ligne non traitée: " + row);
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
      throw new RuntimeException(e.getMessage());
    }
  }

  /** Affiche le résultat de la plus grande commune (plus grand nombre d'électeurs) */
  private static void afficherPlusGrandeCommune() {
    System.out.println(
        "Plus grande commune : %s".formatted(CommuneUtils.getMostElectors(communesVotantes)));
  }

  /** Affiche tous les résultats, triés par nom de commune */
  private static void afficherParOrdreAlphabetique() {
    CommuneUtils.sortedAlphabetically(communesVotantes).forEach(System.out::println);
  }

  /** Affiche tous les résultats, triés du plus grand taux de participation au plus petit */
  private static void afficherParParticipation() {
    CommuneUtils.sortedParticipation(communesVotantes).forEach(System.out::println);
  }
}