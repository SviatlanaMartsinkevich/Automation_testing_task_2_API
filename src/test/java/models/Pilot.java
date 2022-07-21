package models;

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
public class Pilot {
    public String name;
    public String height;
    public String mass;
    public String hair_color;
    public String skin_color;
    public String eye_color;
    public String birth_year;
    public String gender;
    public String homeworld;
    public ArrayList<String> films;
    public ArrayList<Object> species;
    public ArrayList<String> vehicles;
    public ArrayList<String> starships;
    public Date created;
    public Date edited;
    public String url;
}
