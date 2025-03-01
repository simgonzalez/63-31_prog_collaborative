import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import votation.CannotReadCommuneRowException;
import votation.Municipality;
import votation.MunicipalityUtils;
import votation.Electors;
import votation.Participation;

public class Main {
  private static final List<Municipality> municipalities = new ArrayList<>();

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
          municipalities.add(MunicipalityUtils.fromCsvRow(row));
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
    Municipality biggestMunicipality = Collections.max(municipalities, new Electors());
    System.out.println(
        "Plus grande commune : %s".formatted(biggestMunicipality));
  }

  /** Affiche tous les résultats, triés par nom de commune */
  private static void afficherParOrdreAlphabetique() {
    Collections.sort(municipalities);
    municipalities.forEach(System.out::println);
  }

  /**
   * Affiche tous les résultats, triés du plus grand taux de participation au plus
   * petit
   */
  private static void afficherParParticipation() {
    Collections.sort(municipalities, new Participation().reversed());
    municipalities.forEach(System.out::println);
  }
}