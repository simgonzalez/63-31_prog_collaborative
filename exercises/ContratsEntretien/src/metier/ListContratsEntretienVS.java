package metier;

import domaine.ContratEntretienVS;

import java.util.ArrayList;
import java.util.List;

public class ListContratsEntretienVS extends ListeContratsEntretien<ContratEntretienVS> {
    private List<ContratEntretienVS> tmpContrat = new ArrayList<>();
    public ContratEntretienVS remove(String marqueChaudiere) {
        for (int i = 0; i< size(); i++)
        {
            ContratEntretienVS contract= remove()  ;
            if (contract.getMarqueChaudiere().equals(marqueChaudiere)){
                tmpContrat.forEach(this::add);
                return contract;
            }
            tmpContrat.add(contract);
        }
        return null;
    }
}
