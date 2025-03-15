package metier.applic;

import dao.Bdd;
import domaine.ContratEntretienVilla;
import metier.ListeContrats;

public class GestionDesVillas {

    public GestionDesVillas() {
        System.out.println("====================  Test de l'application GestionDesVillas  ====================");
        ListeContrats<ContratEntretienVilla> contrats = Bdd.getLstContratsVillas();
        System.out.println("Traitement du 1er contrat d'entretien d'une villa : " + contrats.remove());
        System.out.println("Liste des contrats d'entretien de villas encore à traiter :" + contrats);
        System.out.println("==================================================================================\n");
    }
}