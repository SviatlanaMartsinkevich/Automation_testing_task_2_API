package utils;

import io.restassured.response.Response;
import models.Film;
import models.Pilot;
import models.Root;
import models.Starship;

import java.util.List;

import static io.restassured.RestAssured.given;

public class Utils {

    public static Film findFilmByTitle(Response response, String title) throws NullPointerException {
        Film film = null;
        Root root = response.then().extract().as(Root.class);
        for (int i = 0; i < root.getResults().size(); i++) {
            if (root.getResults().get(i).getTitle().equals(title)) {
                film = root.getResults().get(i);
                break;
            }
        }
        return film;
    }

    public static Pilot findPilotByName(Film film, String name) throws NullPointerException {
        Pilot pilot = null;
        List<String> pilots = film.getCharacters();
        for (int i = 0; i < pilots.size(); i++) {
            Pilot currentPilot = given().when().get(pilots.get(i)).then().extract().as(Pilot.class);
            if (currentPilot.getName().equals(name)) {
                pilot = currentPilot;
                break;
            }
        }
        return pilot;
    }

    public static Starship getStarshipByPilot(Pilot pilot) throws NullPointerException {
        return given().when().get(pilot.getStarships().get(0)).then().extract().as(Starship.class);
    }

    public static Pilot findPilotOfStarshipByName(Starship starship, String name) throws NullPointerException {
        Pilot pilot = null;
        List<String> pilots = starship.getPilots();
        for (int i = 0; i < pilots.size(); i++) {
            Pilot currentPilot = given().when().get(pilots.get(i)).then().extract().as(Pilot.class);
            if (currentPilot.getName().equals(name)) {
                pilot = currentPilot;
                break;
            }
        }
        return pilot;
    }
}
