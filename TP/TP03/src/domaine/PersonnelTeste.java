package domaine;

import outils.Test;

public class PersonnelTeste {
    private Personnel personnel;
    private boolean resultat;

    public Personnel getPersonnel() {
        return personnel;
    }

    public boolean isPositive() {
        return resultat;
    }

    public PersonnelTeste(Personnel personnel) {
        this.personnel = personnel;
        try {
            this.resultat = Test.resultat(personnel.getNo());
        } catch (Test.PersonneInconnueException e) {
            throw new RuntimeException(e);
        }
    }

    public int getCategorie() {
        return personnel.getAge()<25 ? 0 : personnel.getAge()>=50 ? 2 : 1;
    }
}
