package LeGrandRestaurant;

import java.util.Arrays;

public class Restaurant {

    private Serveur[] serveurs;

    public Serveur[] getServeurs() {
        return serveurs;
    }

    public Restaurant(Serveur...serveurs) {
        this.serveurs = serveurs;
    }
    public double ChiffreAffaires(){
      return  Arrays.stream(serveurs).mapToDouble(serveur -> serveur.ChiffreAffaires).sum();
    }
}
