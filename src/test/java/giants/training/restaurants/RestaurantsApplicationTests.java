package giants.training.restaurants;

import giants.training.restaurants.controller.RestaurantController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class RestaurantsApplicationTests {

	@Autowired
	private RestaurantController restaurantController;

	@Test
	void contextLoads() {
		assertThat(restaurantController).isNotNull();
	}

}
