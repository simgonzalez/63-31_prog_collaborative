import metier.applic.GestionDesImmeubles;
import metier.applic.GestionDesVillas;
import metier.applic.GestionSuccursaleVS;

public class Main {
    public static void main(String[] args) {
        new GestionDesImmeubles();      // Application fonctionnelle, déjà en production (vous pouvez mettre cette ligne en commentaire) 
        new GestionDesVillas();         // Application fonctionnelle, déjà en production (vous pouvez mettre cette ligne en commentaire)
        new GestionSuccursaleVS();      // TODO: Nouvelle application à développer
    }
}