import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import cucumber.api.CucumberOptions;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import cucumber.runtime.java.StepDefAnnotation;
import giants.training.restaurants.model.Restaurant;
import giants.training.restaurants.service.RestaurantService;
import giants.training.restaurants.service.RestaurantServiceConfiguration;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;
import static org.junit.Assert.assertEquals;


//@RunWith(Cucumber.class)
//@CucumberOptions(features = "src/test/java/giants/training/restaurants/resources/cucumbers.feature")
//@StepDefAnnotation
public class RestaurantServiceStepdefs extends RestaurantServiceConfiguration {

    /*
    @Autowired
    RestaurantService restaurantService;
    String output;
    WireMockServer wireMockServer;
    String inputJson;
    HttpPost request;
    HttpResponse response;
    List<Restaurant> restaurants;

    @Given("Create new restaurant service")
    public void createNewRestaurantService(){
        //restaurantService = new RestaurantService();
        wireMockServer = new WireMockServer(options().port(8080));
        wireMockServer.start();

        WireMock.configureFor("localhost", wireMockServer.port());
        inputJson = "{}";
        WireMock.stubFor(WireMock.post(urlEqualTo("/api/restaurants"))
                .withHeader("content-type", WireMock.equalTo("application/json"))
                .withRequestBody(WireMock.containing("testing-framework"))
                .willReturn(aResponse().withStatus(200)));



        //throw new PendingException();

    }
    @When("Users upload data on a project")
    public void usersUploadDataOnAProject() throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        request = new HttpPost("http://localhost:" + wireMockServer.port() + "/api/restaurants");
        StringEntity entity = new StringEntity(inputJson);
        request.addHeader("content-type", "application/json");
        request.setEntity(entity);
        response = httpClient.execute(request);

        restaurants = new ArrayList<Restaurant>();
        Restaurant restaurant1 = new Restaurant("ny", "Taggiatelle","C/snt Mcgarry , 29", 200.0, 300.0, "600098978", true, "http://dummyimage.com/75x75.png/ff4444/ffffff", 7.0);
        Restaurant restaurant2 = new Restaurant("bcn", "Tapas Manoli","C/snt Antoni , 8", 100.0, 200.0, "600098978", true, "http://dummyimage.com/75x75.png/ff4444/ffffff", 7.0);
        Restaurant restaurant3 = new Restaurant("fr", "Le petit cuisine","C/snt Clarise , 16", 400.0, 500.0, "600098978", true, "http://dummyimage.com/75x75.png/ff4444/ffffff", 7.0);

        restaurants.add(restaurant1);
        restaurants.add(restaurant2);
        restaurants.add(restaurant3);
        restaurantService.addRestaurants(restaurants);

    }

    @Then("The server should handle it and return a success status")
    public void theServerShouldHandleItAndReturnASuccessStatus(){
        assertEquals(200, response.getStatusLine().getStatusCode());
        verify(postRequestedFor(urlEqualTo("/api/restaurants"))
                .withHeader("content-type", equalTo("application/json")));

        wireMockServer.stop();
    }

     */

    @io.cucumber.java.en.Given("^Create new restaurant service$")
    public void create_new_restaurant_service2() {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Given("^Create new restaurant service$")
    public void create_new_restaurant_service() {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^Users upload data on a project$")
    public void users_upload_data_on_a_project() {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^The server should handle it and return a success status$")
    public void the_server_should_handle_it_and_return_a_success_status() {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

}
