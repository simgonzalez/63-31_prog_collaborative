package domaine;

import java.util.List;

public interface ListeParCategorie<E extends  Categorisable> {
    int NB_CATEGORIE = 3;

    void add(E element);
    List<E> get(int categorie);

    int size();

    int nombreTauxPositif(int categorie);
}
