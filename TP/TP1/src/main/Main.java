import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import votation.CannotReadCommuneRowException;
import votation.Commune;
import votation.CommuneUtils;
import votation.Electors;
import votation.MostParticipated;

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
    URL resource = Main.class.getResource("results.csv");
    try (BufferedReader reader = new BufferedReader(
        new FileReader(resource.getPath()))) {
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

  /**
   * Affiche le résultat de la plus grande commune (plus grand nombre d'électeurs)
   */
  private static void afficherPlusGrandeCommune() {
    Commune biggestCommune = Collections.max(communesVotantes, new Electors());
    System.out.println(
        "Plus grande commune : %s".formatted(biggestCommune));
  }

  /** Affiche tous les résultats, triés par nom de commune */
  private static void afficherParOrdreAlphabetique() {
    Collections.sort(communesVotantes);
    communesVotantes.forEach(System.out::println);
  }

  /**
   * Affiche tous les résultats, triés du plus grand taux de participation au plus
   * petit
   */
  private static void afficherParParticipation() {
    Collections.sort(communesVotantes, new MostParticipated().reversed());
    communesVotantes.forEach(System.out::println);
  }
}