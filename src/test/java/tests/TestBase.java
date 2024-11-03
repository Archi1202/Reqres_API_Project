package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    @BeforeAll
    static void setUp() {
        RestAssured.baseURI = "https://reqres.in";
        RestAssured.basePath = "/api";
    }

    protected RequestSpecification request() {
        return RestAssured.given()
                .contentType("application/json")
                .log().all();
    }

    protected Response postRequest(String endpoint, Object body) {
        return request().body(body).post(endpoint);
    }
}
