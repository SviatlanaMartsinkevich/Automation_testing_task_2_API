package baseEntities;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.protocol.HTTP;
import org.testng.annotations.BeforeTest;
import utils.ReadProperties;

import static io.restassured.RestAssured.given;

public class BaseTest {

    @BeforeTest
    public void setUpApiTest() {

        RestAssured.baseURI = ReadProperties.getUrl();

        RestAssured.requestSpecification = given()
                .header(HTTP.CONTENT_TYPE, ContentType.JSON);
    }
}
