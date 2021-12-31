package LeGrantRestaurant.Test.Utilities;

import LeGrandRestaurant.Restaurant;
import LeGrandRestaurant.Serveur;

public class RestaurantBuilder {

    private Serveur[] serveurs ;
    int nombreServeurs;

    public static Restaurant Stub(){
        return new RestaurantBuilder().Build();
    }

    public RestaurantBuilder AyantPourServeurs(Serveur ...serveurs){
        this.serveurs = serveurs;
        return this;
    }

    public RestaurantBuilder AyantXServeurs(int nombreServeurs, Serveur ...serveursCrees ){
        this.serveurs =serveursCrees;
        this.nombreServeurs = nombreServeurs;
        return this;
    }

    public Restaurant Build() {
        return new Restaurant(this.serveurs);
    }


}
