package tests.in.reqreg;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.TestBase;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.is;


@DisplayName("Check API methods from website - https://reqres.in for practice purposes")

public class ApiTests extends TestBase {

    @Test
    public void successUpdateOfUserTest(){
        String updateData = "{\"name\": \"morpheus\",\"job\": \"zion resident\"}";
        given()
                .body(updateData)
                .contentType(JSON)
                .when()
                .put("/users/2")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .body("name",is("morpheus"));
    }

    @Test
    public void unsuccessUpdateOfUserWithInvalidDataTest(){
        String updateData = "03948390485";
        given()
                .body(updateData)
                .contentType(JSON)
                .when()
                .put("/users/2")
                .then()
                .log().status()
                .log().body()
                .statusCode(400);
    }

}
