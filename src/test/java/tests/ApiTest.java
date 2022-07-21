package tests;

import baseEntities.BaseTest;
import models.Pilot;
import models.Root;
import models.Starships;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Endpoints;

import java.lang.reflect.Type;
import java.util.List;

import static io.restassured.RestAssured.given;

public class ApiTest extends BaseTest {
    public String findFilm = "A New Hope";
    public String name = "Biggs Darklighter";
    List<String> chars;
    List<String> starships;
    List<String> pilots;

    @Test
    public void searchFilm2() {
        Root root = given()
                .when()
                .get(Endpoints.GET_ALL_FILMS + Endpoints.SEARCH + findFilm)
                .then().log().body()
                .extract().as(Root.class);

        String actualTitle = root.getResults().get(0).getTitle();
        chars = root.getResults().get(0).getCharacters();

        Assert.assertEquals(actualTitle, findFilm);

    }

    @Test
    public void searchFilm3() {
        for (int i = 0; i < chars.size(); ) {
            String link = chars.get(i);

            Pilot pilot = given()
                    .when()
                    .get(link)
                    .then()
                    .extract().as((Type) Pilot.class);

            String actualName = pilot.getName();
            if (actualName.equals(name)) {
                starships = pilot.getStarships();
                break;
            } else {
                i++;
            }
        }

        Starships starship = given()
                .when()
                .get(starships.get(0))
                .then()
                .extract().as((Type) Starships.class);

        String actualNameStarship = starship.getName();
        System.out.println("Biggs Darklighter was flying on " + actualNameStarship);

        String actualClassStarship = starship.getStarship_class();
        Assert.assertEquals(actualClassStarship, "Starfighter");

        pilots = starship.getPilots();

        for (int i = 0; i < pilots.size(); ) {
            String namePilotLink = pilots.get(i);
            Pilot pilot1 = given()
                    .when()
                    .get(namePilotLink)
                    .then()
                    .extract().as((Type) Pilot.class);

            String namePilot = pilot1.getName();
            if (namePilot.contains("Luke Skywalker")) {
                System.out.println("Luke Skywalker is among pilots that were also flying this kind of starship");
                break;
            } else {
                i++;
            }
        }
    }
}

