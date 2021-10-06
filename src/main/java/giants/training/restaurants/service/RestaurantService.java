package giants.training.restaurants.service;

import giants.training.restaurants.dao.RestaurantDao;
import giants.training.restaurants.model.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {

    @Autowired
    RestaurantDao restaurantDao;

    public List<Restaurant> getAllRestaurants() {
        return restaurantDao.findAll();
    }

    public List<Restaurant> addRestaurants(List<Restaurant> restaurants) {
        return restaurantDao.insert(restaurants);
    }
}
