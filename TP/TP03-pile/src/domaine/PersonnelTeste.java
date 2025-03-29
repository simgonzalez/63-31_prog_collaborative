package domaine;

import outils.Test;

public class PersonnelTeste implements Categorisable {
    private Personnel personnel;
    private boolean resultat;

    public Personnel getPersonnel() {
        return personnel;
    }

    public PersonnelTeste(Personnel personnel) {
        this.personnel = personnel;
        try {
            this.resultat = Test.resultat(personnel.getNo());
        } catch (Test.PersonneInconnueException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int getCategory() {
        return personnel.getAge()<25 ? 0 : personnel.getAge()>=50 ? 2 : 1;
    }

    @Override
    public boolean isPositif() {
        return resultat;
    }
}
