package metier;

import domaine.AgeDeLaChaudiere;

public interface ListeContrats<T extends AgeDeLaChaudiere> { // les éléments de cette liste doivent être capables d'indiquer l'AgeDeLaChaudiere (pour les trier correctement)
    void add(T contrat);
    T remove();
    int size();
    boolean isEmpty();
}