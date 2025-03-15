package domaine;

public class ContratEntretienVS implements AgeDeLaChaudiere{
    private String marqueChaudiere;
    private String contact;
    private Object contrat;

    public ContratEntretienVS(String marqueChaudiere, String contact, Object contrat) {
        this.marqueChaudiere = marqueChaudiere;
        this.contact = contact;
        this.contrat = contrat;
    }

    @Override
    public int getAgeChaudiere() {
        return 0;
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
