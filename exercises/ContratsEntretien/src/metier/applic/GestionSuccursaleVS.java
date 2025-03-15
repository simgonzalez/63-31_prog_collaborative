package metier.applic;

import dao.Bdd;
import domaine.ContratEntretienImmeuble;
import domaine.ContratEntretienVS;
import domaine.ContratEntretienVilla;
import metier.*;

import java.util.*;

public class GestionSuccursaleVS {

    public static final String CANTON_VALAIS = "VS";
    private ListContratsEntretienVS contratsVS = new ListContratsEntretienVS();

    public GestionSuccursaleVS() {
        System.out.println("====================  Test de l'application GestionSuccursaleVS  ====================");
        recupererContratsVS();
        System.out.println("Liste des contrats actuels en Valais : " + contratsVS);
        traiterUnContrat("Bosch");
        traiterTousLesContrats("Bosch");
        System.out.println("Liste des contrats restants en Valais : " + contratsVS);
        System.out.println("=====================================================================================");
    }

    /* Cette procédure remplit la structure de données contratsVS avec tous les contrats du canton du Valais */
    private void recupererContratsVS() {
        ListeContrats<ContratEntretienImmeuble> contratsImmeubles = Bdd.getLstContratsImmeubles();  // contient TOUS les ContratEntretienImmeuble (GE,VD,VS,...)
        ListeContrats<ContratEntretienVilla> contratsVillas = Bdd.getLstContratsVillas();           // contient TOUS les ContratEntretienVilla (GE,VD,VS,...)
        ContratEntretienImmeuble c;
        while (!contratsImmeubles.isEmpty()) {
            c = contratsImmeubles.remove();
            if (c.getCanton().equals(CANTON_VALAIS)) {
                contratsVS.add(new ContratEntretienVS(c.getNomChaudiereProf(), c.getResponsable(),c));
            }
        }
        ContratEntretienVilla cv;
        while (!contratsVillas.isEmpty()) {
            cv = contratsVillas.remove();
            if (cv.getCanton().equals(CANTON_VALAIS)) {
                contratsVS.add(new ContratEntretienVS(cv.getModeleChaudiere(), cv.getClient(),cv));
            }
        }
    }

    /* Cette procédure récupère le 1er contrat d’entretien d’une chaudière de la marque indiquée, puis l'affiche (ainsi que le contact) */
    private void traiterUnContrat(String marqueChaudiere) {
        ContratEntretienVS contrat = contratsVS.remove(marqueChaudiere);
        System.out.println("- Traitement de la chaudière " + marqueChaudiere + ", contact=" +  contrat.getContact() +  " : " + contrat);
    }

    /* Cette procédure récupère TOUS LES contrats d’entretien des chaudières de la marque indiquée, puis les affiche (ainsi que leur contact) */
    private void traiterTousLesContrats(String marqueChaudiere) {
        System.out.println("Traitement de toutes les chaudières " + marqueChaudiere + " en Valais : ");
        for (int i =0; i< contratsVS.size(); i++) {
            ContratEntretienVS contrat = contratsVS.remove(marqueChaudiere);
            if (contrat != null) {
                System.out.println("- Traitement de la chaudière " + marqueChaudiere + ", contact=" +  contrat.getContact() +  " : " + contrat);
            }
        }
    }
}