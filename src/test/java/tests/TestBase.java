package tests;

import config.ApiConfig;
import io.restassured.RestAssured;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;

public class TestBase {
    @BeforeAll
    @DisplayName("Setting initial data of Base URI and Path")
    public static void setUp() {
        ApiConfig apiConfig = ConfigFactory.create(ApiConfig.class, System.getProperties());
        RestAssured.baseURI = apiConfig.getBaseApiUri();
        RestAssured.basePath = apiConfig.getBasePath();
    }
}
