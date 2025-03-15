package domaine;

import java.util.Calendar;
import java.util.Objects;

public class ContratEntretienVilla implements AgeDeLaChaudiere {
    private int noClient;
    private String client;
    private String canton;
    private String modeleChaudiere;
    private int annee;

    public ContratEntretienVilla(int noClient, String client, String canton, String modeleChaudiere, int annee) {
        this.noClient = noClient;
        this.client = client;
        this.canton = canton;
        this.modeleChaudiere = modeleChaudiere;
        this.annee = annee;
    }

    public int getNoClient() { return noClient; }
    public String getClient() { return client; }
    public String getCanton() { return canton; }
    public String getModeleChaudiere() { return modeleChaudiere; }
    public int getAnnee() { return annee; }
    @Override
    public int getAgeChaudiere() { return Calendar.getInstance().get(Calendar.YEAR)-annee; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContratEntretienVilla that = (ContratEntretienVilla) o;
        return noClient == that.noClient;
    }

    @Override
    public int hashCode() {
        return Objects.hash(noClient);
    }

    @Override
    public String toString() {
        return "ContratEntretienVilla{" +
                "noClient=" + noClient +
                ", client='" + client + '\'' +
                ", canton='" + canton + '\'' +
                ", modeleChaudiere='" + modeleChaudiere + '\'' +
                ", annee=" + annee +
                '}';
    }
}