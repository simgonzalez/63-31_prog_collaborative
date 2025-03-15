package metier;

import dao.Bdd;
import domaine.Personnel;
import domaine.PersonnelTeste;
import outils.Test;

import java.util.*;

public class Main {
    private static int CATEGORIE_JEUNE = 0;
    private static int CATEGORIE_ADULTE = 1;
    private static int CATEGORIE_ANCIEN = 2;

    /* Méthode principale : teste tout le personnel, affiche les taux, puis contacte le personnel positif d'une catégorie choisie aléatoirement */
    public static void main(String[] args) {
        List<List<PersonnelTeste>> lst = testerToutLePersonnel(Bdd.getLstPersonnel());
        afficherTauxParCategorie(lst);
        int categorie = (int) (Math.random() * 3);   // choisi aléatoirement une catégorie entre 0 et 2 (pour contacter ces personnes)
        contacterPersonnelPositif(lst, categorie);
    }

    /* Teste tout le personnel, conserve le résultat, puis retourne une collection contenant tous les résultats.
     *  Pour des questions de performance, il est indispensable que la collection retournée comporte 3 listes distinctes,
     *  soit une liste par catégorie (selon l'âge de la personne) ==> categorie = age<25 ? 0 : age>=50 ? 2 : 1; */
    private static List<List<PersonnelTeste>> testerToutLePersonnel(List<Personnel> lstPers) {
        List<List<PersonnelTeste>> lst = List.of(new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        PersonnelTeste personnelTeste;
        for (Personnel pers : lstPers) {
            personnelTeste = new PersonnelTeste(pers);
            lst.get(personnelTeste.getCategorie()).add(personnelTeste);
        }
        return lst;
    }

    /* Affiche le pourcentage de personnel testé positif de chaque catégorie.
     *  Pour des questions de performance, le pourcentage doit pouvoir être retrouvé(calculé) SANS PARCOURIR la liste des personnes testées !
     *  Comme il doit y avoir une liste de personnes par catégorie (voir la méthode testerToutLePersonnel), le taux est calculé simplement
     *  en divisant le nombre de positifs par le nombre de personnes dans la liste */
    private static void afficherTauxParCategorie(List<List<PersonnelTeste>> lst) {
        long nombreCasPositif;
        for (int i = 0; i < lst.size(); i++) {
            nombreCasPositif = lst.get(i).stream().filter(PersonnelTeste::isPositive).count();
            System.out.println("Pourcentage de personnel testé positif dans la catégorie " + i + " : " + (nombreCasPositif * 100 / (lst.get(i).isEmpty() ? 1 : lst.get(i).size())) + "%");
        }

    }

    /* Récupère et affiche le contact des personnes positives d'une certaine catégorie (reçue en paramètre) */
    private static void contacterPersonnelPositif(List<List<PersonnelTeste>> lst, int categorie) {
        System.out.println("Personnes positives de la catégorie " + categorie + (categorie == 0 ? " (-25 ans)" : categorie == 1 ? " (25-49 ans)" : " (50+ ans)"));
        for (PersonnelTeste p : lst.get(categorie)) {
            if (p.isPositive())
                System.out.println(p.getPersonnel().getContact());
        }
    }
}