package votation;

import java.util.Comparator;

public class Electors implements Comparator<Commune> {

    @Override
    public int compare(Commune o1, Commune o2) {
        return o1.getNombreElecteur() - o2.getNombreElecteur();
    }
}
