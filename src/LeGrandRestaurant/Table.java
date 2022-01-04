package LeGrandRestaurant;

import LeGrandRestaurant.IPeutServir;

public class Table {

    public IPeutServir Affectaire;

    public IPeutServir getAffectaire() {
        return Affectaire;
    }

    public void setAffectaire(IPeutServir affectaire) {
        Affectaire = affectaire;
    }

    public void AffecterA(IPeutServir serveur){
        Affectaire = serveur;
    }
}
