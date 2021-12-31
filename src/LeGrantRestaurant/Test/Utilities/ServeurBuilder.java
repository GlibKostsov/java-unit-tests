package LeGrantRestaurant.Test.Utilities;

import LeGrandRestaurant.Serveur;

public class ServeurBuilder {

private String nom;


public ServeurBuilder Nomme(String nom){
    this.nom = nom;
    return this;
}

public static Serveur Stub(){
        return new ServeurBuilder().Build();
    }

    public Serveur Build(){
        return this.nom != null ? new Serveur(): new Serveur(this.nom);

    }

}
