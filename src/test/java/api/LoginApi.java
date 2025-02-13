package api;

import models.LoginResponseModel;
import models.RequestModel;
import org.assertj.core.api.Assertions;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static specs.Specs.*;

public class LoginApi {

    public LoginResponseModel doLoginPostRequest(RequestModel loginData) {

        return step("Execute login request", () ->
                given(commonRequest)
                        .body(loginData)

                        .when()
                        .post("/login")

                        .then()
                        .spec(response200)
                        .extract().as(LoginResponseModel.class));
    }

    public void checkToken(LoginResponseModel response) {
        step("Verify that response has token", () ->
                Assertions.assertThat(response.getToken()).isAlphanumeric());
    }

    public LoginResponseModel doUnSuccessfulLoginPostRequest(RequestModel loginData) {

        return step("Execute login request", () ->
                given(commonRequest)
                        .body(loginData)

                        .when()
                        .post("/login")

                        .then()
                        .spec(response400)
                        .extract().as(LoginResponseModel.class));
    }

}