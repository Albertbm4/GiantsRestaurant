package giants.training.restaurants.service;

import giants.training.restaurants.model.Restaurant;
import org.apache.juli.logging.Log;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.origin.SystemEnvironmentOrigin;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.containsString;

@SpringBootTest
public class RestaurantServiceRealData {

    @Autowired
    private RestaurantService restaurantService;


    @Test
    public void getAllRestaurants(){


        List<Restaurant> restaurants = restaurantService.getAllRestaurants();

        Restaurant firstRestaurant = restaurants.get(0);

        Assert.assertNotNull(firstRestaurant.getName());
        Assert.assertNotNull(firstRestaurant.getAddress());
        Assert.assertNotNull(firstRestaurant.getIcon());
        Assert.assertEquals(34, firstRestaurant.getPlace_id().length());

        Assert.assertTrue( 0.0 < firstRestaurant.getLongitude());
        Assert.assertTrue(0.0 < firstRestaurant.getLatitude());
        Assert.assertTrue( 0 < firstRestaurant.getRating() && 5 >= firstRestaurant.getRating());
        assertThat(firstRestaurant.getIcon(), containsString("http://dummyimage"));
        int restaurantsNum = restaurants.size();
        Assert.assertTrue(20 <= restaurantsNum);


    }

    @Test
    public void AddRestaurants(){

        Restaurant restaurant1 = new Restaurant("1DFMw349ocywy1dq8NzLF97RKWE8fsrFsg", "Taggiatelle",
                "558 Butterfield Alley", 41.423954, 2.1678598, "739 415 7276",
                false, "http://dummyimage.com/75x75.png/cc0000/ffffff", 2.9);
        Restaurant restaurant2 = new Restaurant("1FSZLG7QFjmryFT7p4Y8evW4nZQsnvf8r3",
                "Tapas Manoli", "127 Carey Way",41.41659, 2.1234858, "397 718 0237",
                true, "http://dummyimage.com/75x75.png/ff4444/ffffff", 1.7);

        List<Restaurant> restaurants = List.of(restaurant1, restaurant2);
        int restaurantsNum = restaurantService.getAllRestaurants().size();

        List<Restaurant> restaurantsOutput = restaurantService.addRestaurants(restaurants);


        Assert.assertEquals(2, restaurantsOutput.size());
        Restaurant outputRestaurant = restaurantsOutput.get(0);
        Assert.assertEquals("Taggiatelle", outputRestaurant.getName());
        restaurantsNum += 2;

        restaurants = restaurantService.getAllRestaurants();
        Assert.assertEquals(restaurantsNum, restaurantService.getAllRestaurants().size());
        Assert.assertEquals("Taggiatelle", restaurants.get(restaurants.size() -2).getName());




    }
}
