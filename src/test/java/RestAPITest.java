package TrelloApiAutomation;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.requestSpecification;

public class RestAPITest {

    @Test
    public void CreateBoard()
    {
        requestSpecification=given().queryParam("key", "")
                .queryParam("token", "")
                .queryParam("name", "Things to do").log().all()
                .contentType(ContentType.JSON);

        Response response = requestSpecification.when().post("https://api.trello.com/1/boards/");

        System.out.println(response.body());

        //response.then().statusCode(200).contentType(ContentType.JSON);

        response.then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .extract()
                .body()
                .jsonPath();

         Map<String,?> map = response.jsonPath().getMap("$");
         String Boardid = map.get("id").toString();
         System.out.println("Board id is "+Boardid);
         Assert.assertEquals();







    }

}

