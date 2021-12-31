package LeGrantRestaurant.Test;
import LeGrandRestaurant.Franchise;
import LeGrandRestaurant.Restaurant;
import LeGrandRestaurant.Serveur;
import LeGrantRestaurant.Test.Utilities.RestaurantBuilder;
import LeGrantRestaurant.Test.Utilities.ServeurBuilder;
import LeGrantRestaurant.Test.Utilities.ServeurGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;


class ChiffreAffaireTest {
     @DisplayName("Etant donné un nouveau serveur " +
                  "Quand je calcule son chiffre d'affaires " +
                  "Alors il est de zero")
     @Test
     public void Serveur_Initial(){
         //Etant donne un nouveau serveur
         Serveur serveur = ServeurBuilder.Stub();

         //Quand je regarde son chiffre d'affaires
         double chiffreAffaires = serveur.ChiffreAffaires;

        //Alors il est de 0
         Assertions.assertEquals(0,chiffreAffaires);

     }

     @DisplayName ("Étant donné un nouveau serveur " +
                   "Quand il prend une commande " +
                   "Alors son chiffre d'affaires est le montant de cette commande")
     @Test
     public void Serveur_Commande()
     {
         // Étant donné un nouveau serveur
         var serveur = ServeurBuilder.Stub();

         // Quand il prend une commande
         double montantCommande = 67.8;
         serveur.PrendreCommande(montantCommande);

         // Alors son chiffre d'affaires est le montant de cette commande
         var chiffreAffaires = serveur.ChiffreAffaires;
         Assertions.assertEquals(montantCommande, chiffreAffaires);
     }



     @DisplayName("Étant donné un serveur ayant déjà une commande " +
             "Quand il prend une autre commande " +
             "Alors son chiffre d'affaires est l'addition des deux")
     @Test
     public void Serveur_2_Commandes()
     {
         // Étant donné un serveur ayant déjà une commande
         var serveur = ServeurBuilder.Stub();
         double montantPremiereCommande = 67.8;
         serveur.PrendreCommande(montantPremiereCommande);

         // Quand il prend une autre commande
         double montantSecondeCommande = 178.5;
         serveur.PrendreCommande(montantSecondeCommande);

         // Alors son chiffre d'affaires est l'addition des deux
         Assertions.assertEquals(
                 montantPremiereCommande + montantSecondeCommande,
                 serveur.ChiffreAffaires
         );
     }


     @DisplayName("Étant donné un restaurant ayant 2 serveurs " +
             "Quand chacun prend une commande " +
             "Alors le chiffre d'affaire du restaurant est la somme des deux")
     @Test
     public void Restaurant2Serveurs()
     {
         // Étant donné un restaurant ayant 2 serveurs
         var serveurs = new Serveur[] { ServeurBuilder.Stub(), ServeurBuilder.Stub() };
         var restaurant = new Restaurant(serveurs);

         // Quand chacun prend une commande
         double montantCommande = 67.8;
         for(Serveur serveur : serveurs){
         serveur.PrendreCommande(montantCommande);
        }


         // Alors le chiffre d'affaire du restaurant est la somme des deux
         Assertions.assertEquals(
                 montantCommande * 2,
                 restaurant.ChiffreAffaires()
         );
     }

     @DisplayName("Étant donné un restaurant ayant X serveurs " +
             "Quand chacun prend une commande " +
             "Alors le chiffre d'affaire du restaurant est le produit de " +
             "X par le montant de la commande")
     @ParameterizedTest
     @ValueSource( ints = {0,1,2,10000})
     public void RestaurantXServeurs(int nombreServeurs)
     {
         // Étant donné un restaurant ayant X serveurs
         Serveur[] serveurs = ServeurGenerator.Stubs(nombreServeurs);

         Restaurant restaurant = new Restaurant(serveurs);

         // Quand chacun prend une commande
         double montantCommande = 67.8;

         for (Serveur serveur : serveurs)
         serveur.PrendreCommande(montantCommande);

         // Alors le chiffre d'affaire du restaurant est
         // le produit du montant par le nombre de serveurs
         Assertions.assertEquals(
                 montantCommande * nombreServeurs,
                 restaurant.ChiffreAffaires()
         );
     }


    @DisplayName("Étant donné une franchise ayant 2 restaurants avec chacun un serveur " +
            "Quand chaque serveur prend une commande " +
            "Alors le chiffre d'affaires de la franchise est la somme de ces commandes")

    @Test
    public void Franchise() {

        // Étant donné une franchise ayant 2 restaurants avec chacun un serveur
        Serveur serveurRestaurant1 = ServeurBuilder.Stub();
        Serveur serveurRestaurant2 = ServeurBuilder.Stub();

        Restaurant restaurant1 = new RestaurantBuilder().AyantPourServeurs(serveurRestaurant1).Build();
        Restaurant restaurant2 = new RestaurantBuilder().AyantPourServeurs(serveurRestaurant2).Build();

        Franchise franchise = new Franchise(restaurant1, restaurant2);

        // Quand chaque serveur prend une commande
      double  montantCommande =  67.8;

        serveurRestaurant1.PrendreCommande(montantCommande);
        serveurRestaurant2.PrendreCommande(montantCommande);

        // Alors le chiffre d'affaires de la franchise est la somme de ces commandes
        Assertions.assertEquals(montantCommande * 2, franchise.ChiffreAffaires());

    }



    private static Stream<Arguments> provideParameters() {
        return Stream.of(
                Arguments.of(0, 0),
                Arguments.of(1, 0),
                Arguments.of(2, 0),
                Arguments.of(100, 0),
                Arguments.of(0, 1)
        );
    }


    @DisplayName("Étant donné une franchise ayant X restaurants avec chacun Y serveurs " +
            "Quand chaque serveur prend une commande " +
            "Alors le chiffre d'affaires de la franchise est la somme de ces commandes")

    @ParameterizedTest
    @MethodSource("provideParameters")
    public void FranchiseAvecParametres(
            int nombreRestaurants, int nombreServeursParRestaurant)
    {
        // Étant donné une franchise ayant X restaurants avec chacun Y serveurs
        ArrayList<Restaurant> restaurantsList = new ArrayList<>();

        for(int i = 0; i < nombreRestaurants; i++) {
            Serveur[] serveurs =  ServeurGenerator.Stubs(nombreServeursParRestaurant);
            Restaurant restaurant = new RestaurantBuilder().AyantPourServeurs(serveurs).Build();
            restaurantsList.add(restaurant);
        }
        Restaurant[] restaurants = restaurantsList.toArray(new Restaurant[0]);

        Franchise franchise = new Franchise(restaurants);


        // Quand chaque serveur prend une commande
        double montantCommande = 67.8;

        for(Restaurant restaurant : restaurants){
            Serveur [] serveurs = restaurant.getServeurs();
            for(Serveur serveur : serveurs){
                serveur.PrendreCommande(montantCommande);
            }
        }
// Alors le chiffre d'affaires de la franchise est la somme de ces commandes
        Assertions.assertEquals(  montantCommande * nombreServeursParRestaurant * nombreRestaurants,
                franchise.ChiffreAffaires());

    }







}
