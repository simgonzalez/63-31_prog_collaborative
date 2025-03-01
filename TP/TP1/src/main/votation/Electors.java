package votation;

import java.util.Comparator;

public class Electors implements Comparator<Municipality> {

    @Override
    public int compare(Municipality o1, Municipality o2) {
        return o1.getNombreElecteur() - o2.getNombreElecteur();
    }
}
