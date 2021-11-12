package giants.training.restaurants.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;

class RestaurantTest {

    @Mock
    private Restaurant restaurant;

    @BeforeEach
    void setUp() {

        restaurant = new Restaurant("fr", "Le petit cuisine","C/snt Clarise , 16", 400.0, 500.0, "600098978", true, "http://dummyimage.com/75x75.png/ff4444/ffffff", 7.0);

    }

    @Test
    public void RestaurantDataIsCorrect(){
        assertEquals("Le petit cuisine", restaurant.getName());
        assertEquals(400.0, restaurant.getLatitude());
    }
}