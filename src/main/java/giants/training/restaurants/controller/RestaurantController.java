package giants.training.restaurants.controller;

import giants.training.restaurants.model.Restaurant;
import giants.training.restaurants.service.RestaurantService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/restaurants")
@RestController
public class RestaurantController {

    private final RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping
    public List<Restaurant> getAllRestaurants() {
        return restaurantService.getAllRestaurants();
    }

    @PostMapping
    public List<Restaurant> addRestaurants(@RequestBody List<Restaurant> restaurants) {
        return restaurantService.addRestaurants(restaurants);
    }
}

