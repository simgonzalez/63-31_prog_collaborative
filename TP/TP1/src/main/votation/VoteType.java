package votation;

public enum VoteType {
  OUI,
  NON,
  ABSTENTION;

  public String getName() {
    return switch (this) {
      case ABSTENTION -> "Abstention";
      case OUI -> "Oui";
      case NON -> "Non";
    };
  }
}
