package giants.training.restaurants.controller;


import giants.training.restaurants.model.Restaurant;
import giants.training.restaurants.model.Star;
import giants.training.restaurants.service.RestaurantService;
import giants.training.restaurants.service.StarService;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RequestMapping("api/stars")
@RestController
public class StarController {

    private final StarService starService;

    public StarController(StarService starService) {
        this.starService = starService;
    }

    @GetMapping
    public List<Star> getAllStars() throws IOException { return starService.getAllPonderations();}

    @GetMapping("/")
    @ResponseBody
    public Star getPonderationByPlaceId(@RequestParam(name= "id", required = true) String id) throws IOException { return starService.getPonderationByPlaceId(id);}
}
