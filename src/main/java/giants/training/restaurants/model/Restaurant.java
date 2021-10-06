package giants.training.restaurants.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

@Document(collection = "restaurants")
public class Restaurant {
    @Id
    private String place_id;
    @NotNull
    private String name;
    @NotNull
    private String address;
    @NotNull
    private double latitude;
    @NotNull
    private double longitude;
    @NotNull
    private String phone;
    @NotNull
    private boolean status;
    @NotNull
    private String icon;
    @NotNull
    private double rating;

    public Restaurant(@JsonProperty("place_id") String place_id,
                      @JsonProperty("name") String name,
                      @JsonProperty("address") String address,
                      @JsonProperty("latitude") double latitude,
                      @JsonProperty("longitude") double longitude,
                      @JsonProperty("phone") String phone,
                      @JsonProperty("status") boolean status,
                      @JsonProperty("icon") String icon,
                      @JsonProperty("rating") double rating) {
        this.place_id = place_id;
        this.name = name;
        this.address = address;
        this.longitude = longitude;
        this.latitude = latitude;
        this.phone = phone;
        this.status = status;
        this.icon = icon;
        this.rating = rating;
    }

    public String getPlace_id() {
        return place_id;
    }

    public void setPlace_id(String place_id) {
        this.place_id = place_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
