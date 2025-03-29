package metier;

import dao.Bdd;
import domaine.ListeParCategorie;
import domaine.Personnel;
import domaine.PersonnelTeste;
import domaine.PileParCategorie;
import outils.Test;

import java.util.*;

public class Main {

    /* Méthode principale : teste tout le personnel, affiche les taux, puis contacte le personnel positif d'une catégorie choisie aléatoirement */
    public static void main(String[] args) {
        ListeParCategorie<PersonnelTeste> lst = testerToutLePersonnel(Bdd.getLstPersonnel());
        afficherTauxParCategorie(lst);
        int categorie = (int) (Math.random() * 3);   // choisi aléatoirement une catégorie entre 0 et 2 (pour contacter ces personnes)
        contacterPersonnelPositif(lst, categorie);
    }

    /* Teste tout le personnel, conserve le résultat, puis retourne une collection contenant tous les résultats.
     *  Pour des questions de performance, il est indispensable que la collection retournée comporte 3 listes distinctes,
     *  soit une liste par catégorie (selon l'âge de la personne) ==> categorie = age<25 ? 0 : age>=50 ? 2 : 1; */
    private static ListeParCategorie<PersonnelTeste> testerToutLePersonnel(List<Personnel> lstPers) {
       ListeParCategorie<PersonnelTeste> lst = new PileParCategorie<>();
        PersonnelTeste personnelTeste;
        for (Personnel pers : lstPers) {
            personnelTeste = new PersonnelTeste(pers);
            lst.add(personnelTeste);
        }
        return lst;
    }

    /* Affiche le pourcentage de personnel testé positif de chaque catégorie.
     *  Pour des questions de performance, le pourcentage doit pouvoir être retrouvé(calculé) SANS PARCOURIR la liste des personnes testées !
     *  Comme il doit y avoir une liste de personnes par catégorie (voir la méthode testerToutLePersonnel), le taux est calculé simplement
     *  en divisant le nombre de positifs par le nombre de personnes dans la liste */
    private static void afficherTauxParCategorie(ListeParCategorie<PersonnelTeste> lst) {
        long tauxPositif;
        int nombreTotalElement;
        for (int i = 0; i < lst.size(); i++) {
            nombreTotalElement = lst.get(i).size();
            tauxPositif = lst.nombreTauxPositif(i) * 100 /  (nombreTotalElement == 0 ? 1 : nombreTotalElement);
            System.out.println("Pourcentage de personnel testé positif dans la catégorie " + i + " : " + tauxPositif+ "%");
        }

    }

    /* Récupère et affiche le contact des personnes positives d'une certaine catégorie (reçue en paramètre) */
    private static void contacterPersonnelPositif(ListeParCategorie<PersonnelTeste> lst, int categorie) {
        System.out.println("Personnes positives de la catégorie " + categorie + (categorie == 0 ? " (-25 ans)" : categorie == 1 ? " (25-49 ans)" : " (50+ ans)"));
        for (PersonnelTeste p : lst.get(categorie)) {
            if (p.isPositif())
                System.out.println(p.getPersonnel().getContact());
        }
    }
}