package domaine;

public class ContratEntretienVS implements AgeDeLaChaudiere {
    private String marqueChaudiere;
    private String contact;
    private AgeDeLaChaudiere contrat;

    public ContratEntretienVS(String marqueChaudiere, String contact, AgeDeLaChaudiere contrat) {
        this.marqueChaudiere = marqueChaudiere;
        this.contact = contact;
        this.contrat = contrat;
    }

    @Override
    public int getAgeChaudiere() {
        return contrat.getAgeChaudiere();
    }

    public String getMarqueChaudiere() {
        return marqueChaudiere;
    }

    public String getContact() {
        return contrat.toString();
    }

    @Override
    public String toString() {
        return "ContratEntretienVS(marqueChaudiere='" + marqueChaudiere +   ", contact=" + contact +
                ')';
    }
}
