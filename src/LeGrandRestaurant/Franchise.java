package LeGrandRestaurant;

import java.util.Arrays;

public class Franchise {

    private final Restaurant[] restaurants;

    public Franchise(Restaurant ...restaurants) {
        this.restaurants = restaurants;
    }

    public double ChiffreAffaires (){
        return  Arrays.stream(restaurants).mapToDouble(restaurant -> restaurant.ChiffreAffaires()).sum();
    }
}
