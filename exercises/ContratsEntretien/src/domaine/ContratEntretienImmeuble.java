package domaine;

import java.util.Calendar;
import java.util.Objects;

public class ContratEntretienImmeuble implements AgeDeLaChaudiere {
    private int noContrat;
    private String adresse;
    private String canton;
    private String responsable;
    private String tel;
    private String nomChaudiereProf;
    private int puissance;
    private int annee;

    public ContratEntretienImmeuble(int noContrat, String adresse, String canton, String responsable, String tel, String nomChaudiereProf, int puissance, int annee) {
        this.noContrat = noContrat;
        this.adresse = adresse;
        this.canton = canton;
        this.responsable = responsable;
        this.tel = tel;
        this.nomChaudiereProf = nomChaudiereProf;
        this.puissance = puissance;
        this.annee = annee;
    }

    public int getNoContrat() { return noContrat; }
    public String getAdresse() { return adresse; }
    public String getCanton() { return canton; }
    public String getResponsable() { return responsable; }
    public String getTel() { return tel; }
    public String getNomChaudiereProf() { return nomChaudiereProf; }
    public int getPuissance() { return puissance; }
    public int getAnnee() { return annee; }
    @Override
    public int getAgeChaudiere() { return Calendar.getInstance().get(Calendar.YEAR)-annee; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContratEntretienImmeuble that = (ContratEntretienImmeuble) o;
        return noContrat == that.noContrat;
    }

    @Override
    public int hashCode() {
        return Objects.hash(noContrat);
    }

    @Override
    public String toString() {
        return "ContratEntretienImmeuble{" +
                "noContrat=" + noContrat +
                ", adresse='" + adresse + '\'' +
                ", canton='" + canton + '\'' +
                ", responsable='" + responsable + '\'' +
                ", tel='" + tel + '\'' +
                ", nomChaudiereProf='" + nomChaudiereProf + '\'' +
                ", puissance=" + puissance +
                ", annee=" + annee +
                '}';
    }
}