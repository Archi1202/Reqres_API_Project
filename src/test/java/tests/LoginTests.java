package tests;

import api.LoginApi;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import models.LoginResponseModel;
import models.RequestModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@Owner("Anuar Zhangeldi")
@Feature("Login API")
@DisplayName("Tests for Login verifications")
public class LoginTests extends TestBase {

    LoginApi loginApi = new LoginApi();

    @Test
    @Tag("API")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Verify successful login")
    void shouldVerifySuccessfulLogin() {
        RequestModel loginData = new RequestModel();
        loginData.setEmail("eve.holt@reqres.in");
        loginData.setPassword("cityslicka");

        LoginResponseModel response = step("Send request for successful login", () -> loginApi.doLoginPostRequest(loginData));

        step("Verify token is present in the response", () -> {
            assertNotNull(response.getToken(), "Token should not be null");
            loginApi.checkToken(response);
        });
    }

    @Test
    @Tag("API")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Verify unsuccessful login with invalid email")
    void shouldVerifyUnsuccessfulLogin() {
        RequestModel loginData = new RequestModel();
        loginData.setEmail("123424@dogdog");
        loginData.setPassword("");

        LoginResponseModel response = step("Send request for unsuccessful login", () -> loginApi.doUnSuccessfulLoginPostRequest(loginData));

        step("Verify error message in the response", () -> {
            assertEquals("Missing password", response.getError(), "Error message does not match");
            loginApi.checkErrorLogin(response);
        });
    }

    @Test
    @Tag("API")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Verify unsuccessful login without password")
    void shouldFailLoginWithoutPassword() {
        RequestModel loginData = new RequestModel();
        loginData.setEmail("eve.holt@reqres.in");
        loginData.setPassword("");

        LoginResponseModel response = step("Send request for login without password", () -> loginApi.doUnSuccessfulLoginPostRequest(loginData));

        step("Verify error message for missing password", () -> assertEquals("Missing password", response.getError(), "Expected 'Missing password' error message."));
    }

    @Test
    @Tag("API")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Verify unsuccessful login without email")
    void shouldFailLoginWithoutEmail() {
        RequestModel loginData = new RequestModel();
        loginData.setEmail("");
        loginData.setPassword("cityslicka");

        LoginResponseModel response = step("Send request for login without email", () -> loginApi.doUnSuccessfulLoginPostRequest(loginData));

        step("Verify error message for missing email", () -> assertEquals("Missing email or username", response.getError(), "Expected 'Missing email or username' error message."));
    }

    @Test
    @Tag("API")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Verify unsuccessful login with invalid email format")
    void shouldFailLoginWithInvalidEmailFormat() {
        RequestModel loginData = new RequestModel();
        loginData.setEmail("aaaaa-testtest");
        loginData.setPassword("cityslicka");

        LoginResponseModel response = step("Send request for login with invalid email format", () -> loginApi.doUnSuccessfulLoginPostRequest(loginData));

        step("Verify error message for invalid email format", () -> assertEquals("user not found", response.getError(), "Expected 'user not found' error message."));
    }
}
