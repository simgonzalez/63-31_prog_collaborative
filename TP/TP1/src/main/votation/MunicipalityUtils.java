package votation;

public abstract class MunicipalityUtils {
  private static final int INDEX_NOM_COMMUNE = 0;
  private static final int INDEX_NOMBRE_HABITANT_COMMUNE = 1;
  private static final int INDEX_NOMBRE_VOTE_OUI_COMMUNE = 2;
  private static final int INDEX_NOMBRE_VOTE_NON_COMMUNE = 3;
  private static final int INDEX_NOMBRE_VOTE_BLANC_COMMUNE = 4;

  public static Municipality fromCsvRow(String row) throws CannotReadCommuneRowException {
    String[] communeProperty = row.split(";");

    if (communeProperty.length == 5) {
      String nomCommune = communeProperty[INDEX_NOM_COMMUNE];
      int nombreHabitant = parseIntValue(communeProperty[INDEX_NOMBRE_HABITANT_COMMUNE]);
      int nombreVoteOui = parseIntValue(communeProperty[INDEX_NOMBRE_VOTE_OUI_COMMUNE]);
      int nombreVoteNon = parseIntValue(communeProperty[INDEX_NOMBRE_VOTE_NON_COMMUNE]);
      int nombreVoteBlanc = parseIntValue(communeProperty[INDEX_NOMBRE_VOTE_BLANC_COMMUNE]);
      return new Municipality(nomCommune, nombreHabitant, nombreVoteOui, nombreVoteNon, nombreVoteBlanc);
    } else {
      throw new CannotReadCommuneRowException(row);
    }
  }

  private static int parseIntValue(String supposedInt) throws CannotReadCommuneRowException {
    try {
      return Integer.parseInt(supposedInt);
    } catch (NumberFormatException e) {
      throw new CannotReadCommuneRowException("Typing error");
    }
  }
}
