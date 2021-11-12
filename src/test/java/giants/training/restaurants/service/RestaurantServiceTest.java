package giants.training.restaurants.service;

//import com.google.common.base.Verify;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import giants.training.restaurants.dao.RestaurantDao;
import giants.training.restaurants.model.Restaurant;
import org.assertj.core.api.junit.jupiter.InjectSoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpInputMessage;
import static org.mockito.Mockito.times;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RestaurantServiceTest {

    @InjectMocks
    private RestaurantService restaurantService;

    @Mock
    private RestaurantDao restaurantDao;


    private List<Restaurant> restaurants;

    @BeforeEach
    void setUp() {
        restaurants = new ArrayList<Restaurant>();
        Restaurant restaurant1 = new Restaurant("ny", "Taggiatelle","C/snt Mcgarry , 29", 200.0, 300.0, "600098978", true, "http://dummyimage.com/75x75.png/ff4444/ffffff", 7.0);
        Restaurant restaurant2 = new Restaurant("bcn", "Tapas Manoli","C/snt Antoni , 8", 100.0, 200.0, "600098978", true, "http://dummyimage.com/75x75.png/ff4444/ffffff", 7.0);
        Restaurant restaurant3 = new Restaurant("fr", "Le petit cuisine","C/snt Clarise , 16", 400.0, 500.0, "600098978", true, "http://dummyimage.com/75x75.png/ff4444/ffffff", 7.0);

        restaurants.add(restaurant1);
        restaurants.add(restaurant2);
        restaurants.add(restaurant3);


        Mockito.when(restaurantDao.findAll()).thenReturn(restaurants);
        //Mockito.when(restaurantDao.insert(restaurants)).thenReturn(restaurants);

    }

    @Test
    void getAllRestaurants() {

        List<Restaurant> response = restaurantService.getAllRestaurants();

        verify(restaurantDao, times(1) ).findAll();
        assertThat(response).isEqualTo(restaurants);
        assertEquals(3, this.restaurants.size());
    }

    @Test
    void addRestaurants() {

        List <Restaurant> tRestaurants = new ArrayList<Restaurant>();
        Restaurant restaurant1 = new Restaurant("ny", "Taggiatelle","C/snt Mcgarry , 29", 200.0, 300.0, "600098978", true, "http://dummyimage.com/75x75.png/ff4444/ffffff", 7.0);
        Restaurant restaurant2 = new Restaurant("bcn", "Tapas Manoli","C/snt Antoni , 8", 100.0, 200.0, "600098978", true, "http://dummyimage.com/75x75.png/ff4444/ffffff", 7.0);

        tRestaurants.add(restaurant1);
        tRestaurants.add(restaurant2);

        List<Restaurant> restaurantsAdded = new ArrayList<Restaurant>();
        restaurantsAdded = this.restaurantService.addRestaurants(tRestaurants);

        //restaurantsAdded = this.restaurantService.getAllRestaurants();
        verify(restaurantDao, times(1)).insert(tRestaurants);
        //assertEquals(2, restaurantService.addRestaurants(tRestaurants));



    }
}