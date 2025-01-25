package api;

import models.RegisterResponseModel;
import models.RequestModel;
import org.assertj.core.api.Assertions;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static specs.Specs.*;

public class RegisterApi {
    public RegisterResponseModel doSuccessfulRegisterPostRequest(RequestModel request) {
        return step("Create request for registration", () ->
                given(commonRequest)
                        .body(request)

                        .when()
                        .post("/register")

                        .then()
                        .spec(response200)
                        .extract().as(RegisterResponseModel.class));
    }

    public void checkTokenAndId(RegisterResponseModel response) {
        step("Verify, that id AND token are not null", () -> {
            Assertions.assertThat(response.getId()).asInt();
            Assertions.assertThat(response.getToken()).isAlphanumeric();
        });
    }

    public RegisterResponseModel doUnSuccessfulRegisterPostRequest(RequestModel request) {
        return step("Create registration request", () ->
                given(commonRequest)
                        .body(request)

                        .when()
                        .post("/register")

                        .then()
                        .spec(response400)
                        .extract().as(RegisterResponseModel.class));
    }
}