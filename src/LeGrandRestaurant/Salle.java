package LeGrandRestaurant;

import LeGrandRestaurant.MaitreHotel;

public class Salle {

    public Salle(MaitreHotel maitreHotel, Table tableDuServeur, Table table){
        table.AffecterA(maitreHotel);
    }

    public Salle(MaitreHotel maitreHotel, Table...tables ) {
        for (Table table : tables){
            table.AffecterA(maitreHotel);

        }
    }
}
