package tests;

import baseEntities.BaseTest;
import io.restassured.response.Response;
import models.Pilot;
import models.Film;
import models.Starship;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Endpoints;
import utils.Utils;

import static io.restassured.RestAssured.given;

public class ApiTest extends BaseTest {
    private final String titleOfFilm = "A New Hope";
    private final String pilotName = "Biggs Darklighter";
    private final String starshipClass = "Starfighter";
    private final String skyWalker = "Luke Skywalker";


    @Test
    public void getDataTest() {
        Response response = given().when().get(Endpoints.GET_ALL_FILMS);
        Film film = Utils.findFilmByTitle(response, titleOfFilm);
        Pilot pilot = Utils.findPilotByName(film, pilotName);
        Starship starship = Utils.getStarshipByPilot(pilot);
        Assert.assertEquals(starship.getStarship_class(),starshipClass);
        Assert.assertNotNull(Utils.findPilotOfStarshipByName(starship, skyWalker),
                "Luke Skywalker was not pilot of " + starship.getName());
    }
}

