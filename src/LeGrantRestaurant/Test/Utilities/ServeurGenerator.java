package LeGrantRestaurant.Test.Utilities;

import LeGrandRestaurant.Serveur;

import java.util.ArrayList;

public class ServeurGenerator {
    private ServeurBuilder builder = new ServeurBuilder();

    public static Serveur[] Stubs(int nb){
        return (Serveur[]) new ServeurGenerator().Generate(nb).toArray(new Serveur[0]);
    }


    public ServeurGenerator Nommes(String nom){
        this.builder.Nomme(nom);
        return this;
    }

    public  ArrayList<Serveur> Generate(int limit){
        ArrayList<Serveur> serveurs = new ArrayList<>();
        for(int i =0 ; i< limit; i++){
            serveurs.add(builder.Build());
        }
        return  serveurs;
    }
}
