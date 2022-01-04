package LeGrandRestaurant;

import LeGrantRestaurant.Test.Utilities.ServeurBuilder;
import LeGrantRestaurant.Test.Utilities.ServeurGenerator;
import com.sun.tools.jconsole.JConsoleContext;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ServeurBuilder builder = new ServeurBuilder();
        ArrayList<Serveur> list = new ArrayList<>();
        list.add(builder.Build());
        list.add(builder.Build());
        Serveur[] serveurs = list.toArray(new Serveur[0]);
        serveurs[0].PrendreCommande(50);
        System.out.println(serveurs[0].ChiffreAffaires);
        System.out.println(serveurs[1].ChiffreAffaires);
    }
}