package votation;

import java.util.Comparator;

public class Participation implements Comparator<Municipality> {

    @Override
    public int compare(Municipality o1, Municipality o2) {
        return o1.getTauxDeParticipation() - o2.getTauxDeParticipation();
    }

}
