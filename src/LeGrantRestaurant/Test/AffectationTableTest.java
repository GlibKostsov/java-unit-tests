package LeGrantRestaurant.Test;

import LeGrandRestaurant.MaitreHotel;
import LeGrandRestaurant.Salle;
import LeGrandRestaurant.Serveur;
import LeGrandRestaurant.Table;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AffectationTableTest {

    @DisplayName("Etant donné une salle ayant une table, elle est affectée par défault au maîttre d'hôtel")
    @Test
    public void Affectation_Initiale(){
        //étant donné une salle ayant une table
        MaitreHotel maitreHotel = new MaitreHotel();
        Table table = new Table();
        new Salle(maitreHotel, table);
        //alors cette table est afféctée par défault au maître d'hôtel
        Assertions.assertEquals(maitreHotel, table.Affectaire);
    }


    @DisplayName("Etant donné une salle ayant deux tables, l'affectation de l'une d'entre" +
    "elles a un serveur ne change que son affectation.")
    @Test
    public void Deux_Tables_Une_Est_Affecte_A_Autrui(){
        //etant donne une salle ayant une table
        MaitreHotel maitreHotel = new MaitreHotel();
        Table tableDuMaitreHotel = new Table();
        Table tableDuServeur = new Table();

        new Salle(maitreHotel, tableDuServeur, tableDuMaitreHotel);
        //quand j'affecte une des tables a un serveur
        var serveur = new Serveur();
        tableDuServeur.AffecterA(serveur);

        //alors la table est affectee au serveur et l'autre reste au maitre d'hotel
        Assertions.assertEquals(serveur, tableDuServeur.Affectaire);
        Assertions.assertEquals(maitreHotel, tableDuMaitreHotel.Affectaire);
    }
}