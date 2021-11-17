package giants.training.restaurants.stepdefs;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import giants.training.restaurants.controller.RestaurantController;
import giants.training.restaurants.model.Restaurant;
import giants.training.restaurants.service.RestaurantService;
import giants.training.restaurants.service.RestaurantServiceConfiguration;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.containsString;

@WebMvcTest(RestaurantController.class)
public class RestaurantServiceStepdefs extends RestaurantServiceConfiguration {


    @Autowired
    private RestaurantService restaurantService;

    private String output;
    private WireMockServer wireMockServer;
    private String inputJson;
    private HttpPost request;
    private HttpResponse response;
    private List<Restaurant> restaurants;
    private CloseableHttpClient httpClient;

    @Given("Create new restaurant service")
    public void createNewRestaurantService() throws JSONException, JsonProcessingException {

        wireMockServer = new WireMockServer(options().port(3031));
        httpClient = HttpClients.createDefault();
        wireMockServer.start();

        WireMock.configureFor("localhost", wireMockServer.port());

        WireMock.stubFor(WireMock.post(urlEqualTo("/api/restaurants"))
                .withHeader("content-type", WireMock.equalTo("application/json"))
                .withRequestBody(WireMock.containing("place_id"))
                .willReturn(aResponse().withStatus(200)));

        restaurants = new ArrayList<Restaurant>();
        Restaurant restaurant1 = new Restaurant("ny", "Taggiatelle","C/snt Mcgarry , 29", 200.0, 300.0, "600098978", true, "http://dummyimage.com/75x75.png/ff4444/ffffff", 7.0);
        Restaurant restaurant2 = new Restaurant("bcn", "Tapas Manoli","C/snt Antoni , 8", 100.0, 200.0, "600098978", true, "http://dummyimage.com/75x75.png/ff4444/ffffff", 7.0);
        restaurants = List.of(restaurant1,restaurant2);
        inputJson = new ObjectMapper().writeValueAsString(restaurants);

        stubFor(get(urlEqualTo("/api/restaurants"))
                .withHeader("content-type", equalTo("application/json"))
                .willReturn(aResponse().withBody(inputJson)));

    }

    @When("Users upload data on a project")
    public void usersUploadDataOnAProject() throws Exception {

        restaurants = new ArrayList<Restaurant>();
        Restaurant restaurant1 = new Restaurant("ny", "Taggiatelle","C/snt Mcgarry , 29", 200.0, 300.0, "600098978", true, "http://dummyimage.com/75x75.png/ff4444/ffffff", 7.0);
        Restaurant restaurant2 = new Restaurant("bcn", "Tapas Manoli","C/snt Antoni , 8", 100.0, 200.0, "600098978", true, "http://dummyimage.com/75x75.png/ff4444/ffffff", 7.0);
        Restaurant restaurant3 = new Restaurant("fr", "Le petit cuisine","C/snt Clarise , 16", 400.0, 500.0, "600098978", true, "http://dummyimage.com/75x75.png/ff4444/ffffff", 7.0);

        restaurants.add(restaurant1);
        restaurants.add(restaurant2);
        restaurants.add(restaurant3);

        request = new HttpPost("http://localhost:" + wireMockServer.port() + "/api/restaurants");

        inputJson = new ObjectMapper().writeValueAsString(restaurants);
        StringEntity entity = new StringEntity(inputJson);
        request.addHeader("content-type", "application/json");
        request.setEntity(entity);
        httpClient = HttpClients.createDefault();
        response = httpClient.execute(request);


    }

    @Then("The server should handle it and return a success status")
    public void theServerShouldHandleItAndReturnASuccessStatus(){
        assertEquals(200, response.getStatusLine().getStatusCode());
        System.out.println(response);
        verify(postRequestedFor(urlEqualTo("/api/restaurants"))
                .withHeader("content-type", equalTo("application/json")));

        wireMockServer.stop();

    }

    private String convertResponseToString(HttpResponse response) throws IOException {
        InputStream responseStream = response.getEntity().getContent();
        Scanner scanner = new Scanner(responseStream, "UTF-8");
        String responseString = scanner.useDelimiter("\\Z").next();
        scanner.close();
        return responseString;
    }

    @When("users want to get information")
    public void usersWantToGetInformation() throws IOException {

        HttpGet request = new HttpGet("http://localhost:" + wireMockServer.port() + "/api/restaurants");
        request.addHeader("content-type", "application/json");
        response = httpClient.execute(request);

    }

    @Then("the requested data is returned")
    public void theRequestedDataIsReturned() throws IOException {

        String responseString = convertResponseToString(response);
        assertThat(responseString, containsString("\"place_id\":\"ny\""));
        assertThat(responseString, containsString("\"place_id\":\"bcn\""));
        verify(getRequestedFor(urlEqualTo("/api/restaurants"))
                .withHeader("content-type", equalTo("application/json")));

        wireMockServer.stop();
    }





}
