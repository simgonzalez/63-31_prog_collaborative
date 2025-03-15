package metier;

import domaine.AgeDeLaChaudiere;

public class ListeContratsEntretien<T extends AgeDeLaChaudiere> implements ListeContrats<T> {

    private class Noeud {
        private T data;
        private Noeud next;
        public Noeud(T data, Noeud next) { this.data = data; this.next = next; }
    }
    private Noeud liste;
    private int size;

    public ListeContratsEntretien() { liste=null; size=0; }

    /** Ajoute un nouveau contrat dans la liste triée selon l'âge de la chaudière (les plus âgées en premier) */
    @Override
    public void add(T contrat) {
        Noeud n=liste,prev=null; while (n!=null && contrat.getAgeChaudiere()<n.data.getAgeChaudiere()) { prev=n; n=n.next; }
        Noeud nouveau = new Noeud(contrat, n);
        if (prev==null) { liste=nouveau; } else { prev.next=nouveau; }
        size++;
    }

    /** Retourne le 1er contrat de la liste (donc concernant la chaudière la plus ancienne: cf add() qui les insère de façon triée) */
    @Override
    public T remove() {
        if (isEmpty()) { throw new RuntimeException("Aucun contrat !"); }
        T val = liste.data;
        liste = liste.next;
        size--;
        return val;
    }

    @Override
    public int size() { return size; }

    @Override
    public boolean isEmpty() { return liste==null; }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (Noeud n=liste; n!=null; n=n.next) { str.append("\n").append(n.data); }
        return str.toString();
    }
}