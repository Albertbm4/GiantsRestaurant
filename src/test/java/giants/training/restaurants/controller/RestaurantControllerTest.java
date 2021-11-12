package giants.training.restaurants.controller;

import giants.training.restaurants.model.Restaurant;
import giants.training.restaurants.service.RestaurantService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(RestaurantController.class)
class RestaurantControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RestaurantService restaurantService;

    private List <Restaurant> restaurants;
    @BeforeEach
    public void setUp(){

        Restaurant restaurant1 = new Restaurant("ny", "Taggiatelle","C/snt Mcgarry , 29", 200.0, 300.0, "600098978", true, "http://dummyimage.com/75x75.png/ff4444/ffffff", 7.0);
        Restaurant restaurant2 = new Restaurant("bcn", "Tapas Manoli","C/snt Antoni , 8", 100.0, 200.0, "600098978", true, "http://dummyimage.com/75x75.png/ff4444/ffffff", 7.0);

        restaurants = List.of(restaurant1, restaurant2);
        Mockito.when(restaurantService.getAllRestaurants()).thenReturn(restaurants);
    }

    @Test
    void getAllRestaurants() throws Exception {

        mockMvc.perform(get("/api/restaurants")
            .contentType("application/json"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$[0].place_id").value("ny"))
            .andExpect(jsonPath("$[0].latitude").value("200.0"))
            .andExpect(jsonPath("$[1].place_id").value("bcn"));
    }

    @Test
    void addRestaurants() throws Exception {

        Restaurant restaurant3 = new Restaurant("fr", "Le petit cuisine","C/snt Clarise , 16", 400.0, 500.0, "600098978", true, "http://dummyimage.com/75x75.png/ff4444/ffffff", 7.0);
        List<Restaurant> inputRestaurants = List.of(restaurant3);

        mockMvc.perform(post("/api/restaurants")
                .content(new ObjectMapper().writeValueAsString(inputRestaurants))
                .contentType("application/json"))
                .andExpect(status().isOk());
    }

    @Test
    void addRestaurantsNullParameters() throws Exception{


        mockMvc.perform(post("/api/restaurants")
                .content(new ObjectMapper().writeValueAsString(null))
                .contentType("application/json"))
                .andExpect(status().isBadRequest());

    }
    @Test
    void addRestaurantsBlankParameters() throws Exception{


        Restaurant restaurant3 = new Restaurant("","","",0.0, 0.0, "",true,"icon", 0.0 );
        List<Restaurant> inputRestaurants = List.of(restaurant3);

        mockMvc.perform(post("/api/restaurants")
                .content(new ObjectMapper().writeValueAsString(inputRestaurants))
                .contentType("application/json"))
                .andExpect(status().isOk());

    }

    @Test
    void addRestaurantsUrlErrorFailure() throws Exception{


        Restaurant restaurant3 = new Restaurant("fr", "Le petit cuisine","C/snt Clarise , 16", 400.0, 500.0, "600098978", true, "http://dummyimage.com/75x75.png/ff4444/ffffff", 7.0);
        List<Restaurant> inputRestaurants = List.of(restaurant3);

        mockMvc.perform(post("/api/restaurant")
                .content(new ObjectMapper().writeValueAsString(inputRestaurants))
                .contentType("application/json"))
                .andExpect(status().isNotFound());

    }
}