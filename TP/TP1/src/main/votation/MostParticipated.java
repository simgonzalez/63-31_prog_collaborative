package votation;

import java.util.Comparator;

public class MostParticipated implements Comparator<Commune> {

    @Override
    public int compare(Commune o1, Commune o2) {
        return o1.getTauxDeParticipation() - o2.getTauxDeParticipation();
    }

}
