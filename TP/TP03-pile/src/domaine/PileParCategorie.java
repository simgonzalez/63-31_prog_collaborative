package domaine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class PileParCategorie<E extends Categorisable> implements ListeParCategorie<E> {
    private Stack<E>[] piles = new Stack[NB_CATEGORIE];
    private Integer[] nombrePositifs = new Integer[NB_CATEGORIE];

    public PileParCategorie() {
        for (int i = 0; i < piles.length; i++) {
            this.piles[i] = new Stack<>();
            nombrePositifs[i] = 0;
        }
    }

    @Override
    public void add(E element) {
        piles[element.getCategory()].push(element);
        if (element.isPositif()) {
            nombrePositifs[element.getCategory()]++;
        }
    }

    @Override
    public List<E> get(int category) {
        return piles[category];
    }

    @Override
    public int size() {
        return piles.length;
    }

    @Override
    public int nombreTauxPositif(int categorie) {
        return nombrePositifs[categorie];
    }
}
