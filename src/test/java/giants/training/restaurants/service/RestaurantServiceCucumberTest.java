package giants.training.restaurants.service;

//import com.google.common.base.Verify;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import cucumber.api.CucumberOptions;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import giants.training.restaurants.dao.RestaurantDao;
import giants.training.restaurants.model.Restaurant;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;

@RunWith(Cucumber.class)
@CucumberOptions(  monochrome = true,
        features = "src/test/java/giants/training/restaurants/resources/" ,
        format = { "pretty","html: cucumber-html-reports",
                "json: cucumber-html-reports/cucumber.json" },
        dryRun = false,
        glue = "giants.training.restaurants" )
public class RestaurantServiceCucumberTest {


    /*
    @InjectMocks
    private RestaurantService restaurantService;

    @Mock
    private RestaurantDao restaurantDao;


    private List<Restaurant> restaurants;
    WireMockServer wireMockServer;


    @BeforeEach
    void setUp() {
        restaurants = new ArrayList<Restaurant>();
        Restaurant restaurant1 = new Restaurant("ny", "Taggiatelle","C/snt Mcgarry , 29", 200.0, 300.0, "600098978", true, "http://dummyimage.com/75x75.png/ff4444/ffffff", 7.0);
        Restaurant restaurant2 = new Restaurant("bcn", "Tapas Manoli","C/snt Antoni , 8", 100.0, 200.0, "600098978", true, "http://dummyimage.com/75x75.png/ff4444/ffffff", 7.0);
        Restaurant restaurant3 = new Restaurant("fr", "Le petit cuisine","C/snt Clarise , 16", 400.0, 500.0, "600098978", true, "http://dummyimage.com/75x75.png/ff4444/ffffff", 7.0);

        restaurants.add(restaurant1);
        restaurants.add(restaurant2);
        restaurants.add(restaurant3);
        //Mockito.when(restaurantDao.findAll()).thenReturn(restaurants);


        //start wiremock
        wireMockServer = new WireMockServer(options().port(8080));
        wireMockServer.start();

        //maybe change url
        WireMock.configureFor("localhost", wireMockServer.port());

    }

    @AfterEach
    void Stop(){

        wireMockServer.stop();
    }
    */



    /*
    @When("^users upload data on a project$")
    public void users_upload_data_on_a_project() throws IOException {
        // Write code here that turns the phrase above into concrete actions


        String jsonString = "{}";
        WireMock.stubFor(WireMock.post(urlEqualTo("/api/restaurants"))
                .withHeader("content-type", WireMock.equalTo("application/json"))
                .withRequestBody(WireMock.containing("testing-framework"))
                .willReturn(aResponse().withStatus(200)));

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost request = new HttpPost("http://localhost:" + wireMockServer.port() + "/api/restaurants");
        StringEntity entity = new StringEntity(jsonString);
        request.addHeader("content-type", "application/json");
        request.setEntity(entity);
        HttpResponse response = httpClient.execute(request);


        assertEquals(200, response.getStatusLine().getStatusCode());
        verify(postRequestedFor(urlEqualTo("/create"))
                .withHeader("content-type", equalTo("application/json")));

        wireMockServer.stop();

        throw new PendingException();
    }

    @Then("^the server should handle it and return a success status$")
    public void the_server_should_handle_it_and_return_a_success_status() {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }*/

    /*private String convertResponseToString(HttpResponse response) throws IOException {
        InputStream responseStream = response.getEntity().getContent();
        Scanner scanner = new Scanner(responseStream, "UTF-8");
        String responseString = scanner.useDelimiter("\\Z").next();
        scanner.close();
        return responseString;
    }*/

    /*
    @When("^users want to get information on the 'restaurant' project$")
    public void users_want_to_get_information_on_the_restaurant_project() {
        // Write code here that turns the phrase above into concrete actions

        WireMock.stubFor(WireMock.post(urlEqualTo("/api/restaurants"))
                .withHeader("content-type", WireMock.equalTo("application/json"))
                .willReturn(aResponse().withBody(jsonString)));

        HttpGet request = new HttpGet("http://localhost:" + wireMockServer.port() + "/projects/" + projectName.toLowerCase());
        request.addHeader("accept", "application/json");
        HttpResponse httpResponse = httpClient.execute(request);

        String responseString = convertResponseToString(httpResponse);

        assertThat(responseString, containsString("\"testing-framework\": \"cucumber\""));
        assertThat(responseString, containsString("\"website\": \"cucumber.io\""));
        verify(getRequestedFor(urlEqualTo("/projects/cucumber"))
                .withHeader("accept", equalTo("application/json")));


        List<Restaurant> response = restaurantService.getAllRestaurants();

        verify(restaurantDao, times(1) ).findAll();
        assertThat(response).isEqualTo(restaurants);
        assertEquals(3, this.restaurants.size());
        throw new PendingException();
    }*/


    /*
    @When("users want to get information on the {string} project")
    @Test
    void getAllRestaurants() {

        WireMock.configureFor("localhost", wireMockServer.port());
        WireMock.stubFor(WireMock.get(urlEqualTo("/projects/cucumber"))
                .withHeader("accept", equalTo("application/json"))
                .willReturn(aResponse().withBody(jsonString)));

        HttpGet request = new HttpGet("http://localhost:" + wireMockServer.port() + "/projects/" + projectName.toLowerCase());
        request.addHeader("accept", "application/json");
        HttpResponse httpResponse = httpClient.execute(request);

        String responseString = convertResponseToString(httpResponse);

        assertThat(responseString, containsString("\"testing-framework\": \"cucumber\""));
        assertThat(responseString, containsString("\"website\": \"cucumber.io\""));
        verify(getRequestedFor(urlEqualTo("/projects/cucumber"))
                .withHeader("accept", equalTo("application/json")));


        List<Restaurant> response = restaurantService.getAllRestaurants();

        verify(restaurantDao, times(1) ).findAll();
        assertThat(response).isEqualTo(restaurants);
        assertEquals(3, this.restaurants.size());
    }*/

    /*
    @When("users upload data on a project")
    void addRestaurants() {



        WireMock.stubFor(WireMock.post(urlEqualTo("/api/restaurants"))
                .withHeader("content-type", WireMock.equalTo("application/json"))
                .withRequestBody(WireMock.containing("testing-framework"))
                .willReturn(aResponse().withStatus(200)));

        HttpPost request = new HttpPost("http://localhost:" + wireMockServer.port() + "/create");
        StringEntity entity = new StringEntity(jsonString);
        request.addHeader("content-type", "application/json");
        request.setEntity(entity);
        HttpResponse response = httpClient.execute(request);


        assertEquals(200, response.getStatusLine().getStatusCode());
        verify(postRequestedFor(urlEqualTo("/create"))
                .withHeader("content-type", equalTo("application/json")));

        wireMockServer.stop();

        List <Restaurant> tRestaurants = new ArrayList<Restaurant>();
        Restaurant restaurant1 = new Restaurant("ny", "Taggiatelle","C/snt Mcgarry , 29", 200.0, 300.0, "600098978", true, "http://dummyimage.com/75x75.png/ff4444/ffffff", 7.0);
        Restaurant restaurant2 = new Restaurant("bcn", "Tapas Manoli","C/snt Antoni , 8", 100.0, 200.0, "600098978", true, "http://dummyimage.com/75x75.png/ff4444/ffffff", 7.0);

        tRestaurants.add(restaurant1);
        tRestaurants.add(restaurant2);

        List<Restaurant> restaurantsAdded = new ArrayList<Restaurant>();
        restaurantsAdded = this.restaurantService.addRestaurants(tRestaurants);

        //restaurantsAdded = this.restaurantService.getAllRestaurants();
        verify(restaurantDao, times(1)).insert(tRestaurants);
        //assertEquals(2, restaurantService.addRestaurants(tRestaurants));



    }*/
}