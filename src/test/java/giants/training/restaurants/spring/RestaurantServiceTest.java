package giants.training.restaurants.spring;


import giants.training.restaurants.dao.RestaurantDao;
import giants.training.restaurants.model.Restaurant;
import giants.training.restaurants.service.RestaurantService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class RestaurantServiceTest {

    @InjectMocks
    private RestaurantService restaurantService;

    @Mock
    private RestaurantDao restaurantDao;

    private List<Restaurant> restaurants;

    @BeforeEach
    public void setUp() {
        Restaurant firstRestaurant = new Restaurant("1DFMw349occwy1dq8NzLF97RKWE8fsrFfg", "Brainlounge",
                "558 Butterfield Alley", 41.423954, 2.1678598, "739 415 7276",
                false, "http://dummyimage.com/75x75.png/cc0000/ffffff", 2.9);
        Restaurant secondRestaurant = new Restaurant("1FSZLG7QFjmraFT7p4Y8evW4nZQsnvf8A3",
                "Divape", "127 Carey Way",41.41659, 2.1234858, "397 718 0237",
                true, "http://dummyimage.com/75x75.png/ff4444/ffffff", 1.7);

        restaurants = List.of(firstRestaurant, secondRestaurant);
        Mockito.when(restaurantDao.findAll()).thenReturn(restaurants);
        Mockito.when(restaurantDao.insert(restaurants)).thenReturn(restaurants);
    }

    @Test
    public void getAllRestaurants() {
        List<Restaurant> response = restaurantService.getAllRestaurants();

        assertThat(this.restaurants).isEqualTo(response);
    }

    @Test
    public void addRestaurants() {
        List<Restaurant> response = restaurantService.addRestaurants(restaurants);

        assertThat(this.restaurants).isEqualTo(response);
    }

}
