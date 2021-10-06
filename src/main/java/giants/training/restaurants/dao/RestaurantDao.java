package giants.training.restaurants.dao;

import giants.training.restaurants.model.Restaurant;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantDao extends MongoRepository<Restaurant, String> {

}
