package dao;

import domaine.ContratEntretienImmeuble;
import domaine.ContratEntretienVilla;
import metier.ListeContrats;
import metier.ListeContratsEntretien;

public class Bdd {

    /** Retourne la liste de tous les contrats d'entretien des grandes chaudières d'immeubles */
    public static ListeContrats<ContratEntretienImmeuble> getLstContratsImmeubles() {
        ListeContrats<ContratEntretienImmeuble> lst = new ListeContratsEntretien<>();
        lst.add(new ContratEntretienImmeuble(11, "1227 Carouge", "GE", "Concierge au rez", "022 222 33 44", "Bosch", 100, 2020));
        lst.add(new ContratEntretienImmeuble(22, "1206 Champel", "GE", "Régie", "022 234 56 78", "Viessmann", 200, 2010));
        lst.add(new ContratEntretienImmeuble(33, "1400 Yverdon", "VD", "Concierge au rez", "021 123 45 67", "DeDietrich", 300, 2002));
        lst.add(new ContratEntretienImmeuble(44, "1950 Sion",    "VS", "Concierge au 1er", "027 765 43 21", "Bosch", 400, 2012));
        lst.add(new ContratEntretienImmeuble(55, "1223 Cologny", "GE", "Huissier à l'entrée", "022 222 44 66", "Viessmann", 500, 2019));
        lst.add(new ContratEntretienImmeuble(66, "1936 Verbier", "VS", "Propriétaire", "027 654 32 10", "Viessmann", 600, 2008));
        return lst;
    }

    /** Retourne la liste de tous les contrats d'entretien des petites chaudières de villas */
    public static ListeContrats<ContratEntretienVilla> getLstContratsVillas() {
        ListeContrats<ContratEntretienVilla> lst = new ListeContratsEntretien<>();
        lst.add(new ContratEntretienVilla(111, "Dupond", "GE", "Atlantic", 2011));
        lst.add(new ContratEntretienVilla(222, "Durand", "GE", "Bosch", 2012));
        lst.add(new ContratEntretienVilla(333, "Dufour", "VS", "Bosch", 2018));
        lst.add(new ContratEntretienVilla(444, "Duteil", "GE", "Viessmann", 2003));
        lst.add(new ContratEntretienVilla(555, "Dupuis", "VS", "DeDietrich", 2005));
        lst.add(new ContratEntretienVilla(666, "Dutoit", "VD", "Viessmann", 2011));
        return lst;
    }
}