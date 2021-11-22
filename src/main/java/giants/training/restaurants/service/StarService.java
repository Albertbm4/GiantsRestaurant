package giants.training.restaurants.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import giants.training.restaurants.model.Star;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Rule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.CollectionUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;

@Service
public class StarService {

    private WireMockServer wireMockServer;
    private HttpResponse response;
    private CloseableHttpClient httpClient;


    private void setupMockService() throws JsonProcessingException {

        wireMockServer = new WireMockServer(options().port(8005));
        httpClient = HttpClients.createDefault();
        wireMockServer.start();
        WireMock.configureFor("localhost", wireMockServer.port());

        Star starRestaurant1 = new Star("Gevee", 5.0);
        Star starRestaurant2 = new Star("Kimia", 4.0);
        Star starRestaurant3 = new Star("Blogtags", 3.0);
        Star starRestaurant4 = new Star("Photobug", 2.0);
        Star starRestaurant5 = new Star("Tazzy", 5.0);
        Star starRestaurant6 = new Star("Tekfly", 3.5);
        Star starRestaurant7 = new Star("Quimba", 2.0);
        Star starRestaurant8 = new Star("Skidoo", 2.5);
        Star starRestaurant9 = new Star("Brainlounge", 4.0);
        Star starRestaurant10 = new Star("Gabtype", 5.0);
        Star starRestaurant11 = new Star("Voonte", 3.5);
        Star starRestaurant12 = new Star("Yadel", 3.0);
        Star starRestaurant13 = new Star("Katz", 3.5);
        Star starRestaurant14 = new Star("Divape", 4.0);
        Star starRestaurant15 = new Star("Skyvu", 5.0);
        Star starRestaurant16 = new Star("Mydo", 2.0);
        Star starRestaurant17 = new Star("Gabspot", 1.0);
        Star starRestaurant18 = new Star("Ailane", 1.5);
        Star starRestaurant19 = new Star("Oyonder", 2.0);
        Star starRestaurant20 = new Star("Brightbean", 4.0);
        Star starRestaurant21 = new Star("Mydeo", 3.0);
        Star starRestaurant22 = new Star("Tagchat", 4.0);
        Star starRestaurant23 = new Star("Dabjam", 4.5);
        Star starRestaurant24 = new Star("Voomm", 3.0);
        Star starRestaurant25 = new Star("Chatterbridge", 3.0);
        Star starRestaurant26 = new Star("Taggiatelle", 4.5);
        Star starRestaurant27 = new Star("Tapas Manoli", 5.0);
        Star starRestaurant28 = new Star("Chatterbridge", 5.0);


        List<Star> stars = List.of(starRestaurant1, starRestaurant2, starRestaurant3, starRestaurant4, starRestaurant5,
                starRestaurant6, starRestaurant7, starRestaurant8, starRestaurant9, starRestaurant10, starRestaurant11,
                starRestaurant12, starRestaurant13, starRestaurant14, starRestaurant15, starRestaurant16, starRestaurant17,
                starRestaurant18, starRestaurant19, starRestaurant20, starRestaurant21, starRestaurant22, starRestaurant23,
                starRestaurant24, starRestaurant25, starRestaurant26, starRestaurant27, starRestaurant28);

        String jsonResponse = new ObjectMapper().writeValueAsString(stars);

        stubFor(get(urlEqualTo("/api/stars"))
                .withHeader("content-type", equalTo("application/json"))
                .willReturn(aResponse().withBody(jsonResponse)));



    }

    private void stopService(){
        wireMockServer.stop();
    }

    private String convertResponseToString(HttpResponse response) throws IOException {
        InputStream responseStream = response.getEntity().getContent();
        Scanner scanner = new Scanner(responseStream, "UTF-8");
        String responseString = scanner.useDelimiter("\\Z").next();
        scanner.close();
        return responseString;
    }


    public  List<Star> getAllPonderations() throws IOException {

        setupMockService();

        HttpGet request = new HttpGet("http://localhost:" + wireMockServer.port() + "/api/stars");
        request.addHeader("content-type", "application/json");
        response = httpClient.execute(request);

        String jsonStr = convertResponseToString(response);
        ObjectMapper mapper = new ObjectMapper();
        List<Star> stars = mapper.readValue(jsonStr, new TypeReference<List<Star>>(){});

        stopService();

        return stars;

    }

    public Star getPonderationByPlaceId(String id) throws IOException {

        List<Star> stars = getAllPonderations();

        CollectionUtils.filter(stars, s -> ((Star) s).getPlace_id().equals(id));

        if(stars.size() > 0){
            return stars.get(0);
        }else{
            return new Star("", 0.0);
        }

    }



}



