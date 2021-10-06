package giants.training.restaurants.spring;

import com.fasterxml.jackson.databind.ObjectMapper;
import giants.training.restaurants.controller.RestaurantController;
import giants.training.restaurants.model.Restaurant;
import giants.training.restaurants.service.RestaurantService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(RestaurantController.class)
public class RestaurantControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private RestaurantService restaurantService;

    private Restaurant firstRestaurant;

    @BeforeEach
    public void setUp() {
        firstRestaurant = new Restaurant("1DFMw349occwy1dq8NzLF97RKWE8fsrFfg", "Brainlounge",
                "558 Butterfield Alley", 41.423954, 2.1678598, "739 415 7276",
                false, "http://dummyimage.com/75x75.png/cc0000/ffffff", 2.9);
    }

    @Test
    public void getAllRestaurantsTest() throws Exception {
        List<Restaurant> allRestaurants = List.of(firstRestaurant);

        given(restaurantService.getAllRestaurants()).willReturn(allRestaurants);

        mockMvc.perform(get("/api/restaurants")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].name", Matchers.is(firstRestaurant.getName())));
    }

    @Test
    public void addRestaurantsTest() throws Exception {
        List<Restaurant> restaurant = List.of(firstRestaurant);

        mockMvc.perform(post("/api/restaurants")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("utf-8")
                .content(new ObjectMapper().writeValueAsString(restaurant)))
                .andExpect(status().isOk());
    }
}
