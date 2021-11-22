package giants.training.restaurants.service;

import giants.training.restaurants.model.Star;
import org.apache.http.HttpResponse;
import org.apache.http.impl.client.CloseableHttpClient;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.List;


@SpringBootTest
public class StarServiceTest {

    @Autowired
    private StarService starService;


    @Test
    public void getAllPonderations() throws IOException {


        List<Star> stars = starService.getAllPonderations();

        Assert.assertEquals(stars.get(0).getPlace_id(), "Gevee");
        Assert.assertTrue(stars.get(0).getPonderation() == 5.0);
        Assert.assertEquals(stars.get(1).getPlace_id(), "Kimia");
        Assert.assertTrue(stars.get(1).getPonderation() == 4.0);


    }

    @Test
    public void getPonderationByPlaceId() throws IOException {

        Star result = starService.getPonderationByPlaceId("Kimia");
        //Assert.assertTrue(4.0 == result);
    }


}
