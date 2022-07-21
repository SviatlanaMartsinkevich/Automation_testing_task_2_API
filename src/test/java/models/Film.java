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
public class Film {

    public String title;
    public int episode_id;
    public String opening_crawl;
    public String director;
    public String producer;
    public String release_date;
    public ArrayList<String> characters;
    public ArrayList<String> planets;
    public ArrayList<String> starships;
    public ArrayList<String> vehicles;
    public ArrayList<String> species;
    public Date created;
    public Date edited;
    public String url;
}
