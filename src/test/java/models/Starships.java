package models;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;

@AllArgsConstructor
@Data
@Builder
@NoArgsConstructor
public class Starships {
    public String name;
    public String model;
    public String manufacturer;
    public String cost_in_credits;
    public String length;
    public String max_atmosphering_speed;
    public String crew;
    public String passengers;
    public String cargo_capacity;
    public String consumables;
    public String hyperdrive_rating;
    @SerializedName(value = "MGLT")
    public String mGLT;
    public String starship_class;
    public ArrayList<String> pilots;
    public ArrayList<String> films;
    public Date created;
    public Date edited;
    public String url;
}
