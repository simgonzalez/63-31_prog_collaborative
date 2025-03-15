package metier.applic;

import dao.Bdd;
import domaine.ContratEntretienImmeuble;
import metier.ListeContrats;

public class GestionDesImmeubles {

    public GestionDesImmeubles() {
        System.out.println("====================  Test de l'application GestionDesImmeubles  ====================");
        ListeContrats<ContratEntretienImmeuble> contrats = Bdd.getLstContratsImmeubles();

        System.out.println("Traitement du 1er  contrat d'entretien d'immeuble : " + contrats.remove());
        System.out.println("Traitement du 2ème contrat d'entretien d'immeuble : " + contrats.remove());
        System.out.println("Traitement du 3ème contrat d'entretien d'immeuble : " + contrats.remove());

        System.out.println("Liste des contrats d'entretien d'immeubles encore à traiter :" + contrats);
        System.out.println("=====================================================================================\n");
    }
}