package votation;

import java.util.Comparator;
import java.util.List;

public abstract class CommuneUtils {
  private static final int INDEX_NOM_COMMUNE = 0;
  private static final int INDEX_NOMBRE_HABITANT_COMMUNE = 1;
  private static final int INDEX_NOMBRE_VOTE_OUI_COMMUNE = 2;
  private static final int INDEX_NOMBRE_VOTE_NON_COMMUNE = 3;
  private static final int INDEX_NOMBRE_VOTE_BLANC_COMMUNE = 4;

  public static Commune fromCsvRow(String row) throws CannotReadCommuneRowException {
    String[] communeProperty = row.split(";");

    if (communeProperty.length == 5) {
      String nomCommune = communeProperty[INDEX_NOM_COMMUNE];
      int nombreHabitant = parseIntValue(communeProperty[INDEX_NOMBRE_HABITANT_COMMUNE]);
      int nombreVoteOui = parseIntValue(communeProperty[INDEX_NOMBRE_VOTE_OUI_COMMUNE]);
      int nombreVoteNon = parseIntValue(communeProperty[INDEX_NOMBRE_VOTE_NON_COMMUNE]);
      int nombreVoteBlanc = parseIntValue(communeProperty[INDEX_NOMBRE_VOTE_BLANC_COMMUNE]);
      return new Commune(nomCommune, nombreHabitant, nombreVoteOui, nombreVoteNon, nombreVoteBlanc);
    } else {
      throw new CannotReadCommuneRowException(row);
    }
  }

  public static Commune getMostElectors(List<Commune> communes) {
    return communes.stream().max(Comparator.comparing(Commune::getNombreElecteur)).orElseThrow();
  }

  public static List<Commune> sortedAlphabetically(List<Commune> communes) {
    return communes.stream().sorted(Comparator.comparing(Commune::getNom)).toList();
  }

  public static List<Commune> sortedParticipation(List<Commune> communes) {
    return communes.stream()
        .sorted(Comparator.comparing(Commune::getTauxDeParticipation).reversed())
        .toList();
  }

  private static int parseIntValue(String supposedInt) throws CannotReadCommuneRowException {
    try {
      return Integer.parseInt(supposedInt);
    } catch (NumberFormatException e) {
      throw new CannotReadCommuneRowException("Typing error");
    }
  }
}
