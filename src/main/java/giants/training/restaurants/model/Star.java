package giants.training.restaurants.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "stars")
public class Star {

    @Id
    private String place_id;
    private double ponderation;

    public Star( @JsonProperty("place_id") String place_id, @JsonProperty("ponderation") double ponderation) {
        this.place_id = place_id;
        this.ponderation = ponderation;
    }

    public String getPlace_id() {
        return place_id;
    }

    public void setPlace_id(String place_id) {
        this.place_id = place_id;
    }

    public double getPonderation() {
        return ponderation;
    }

    public void setPonderation(double ponderation) {
        this.ponderation = ponderation;
    }
}
