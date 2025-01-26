package tests;

import api.RegisterApi;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import models.RegisterResponseModel;
import models.RequestModel;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Owner("Anuar Zhangeldi")
@Feature("Register API")
@DisplayName("Tests for registration executions")
public class RegisterTests extends TestBase {

    RegisterApi registerApi = new RegisterApi();

    @Test
    @Tag("API")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Verify successful registration")
    void shouldVerifySuccessfulRegistration() {
        RequestModel request = new RequestModel();
        request.setEmail("eve.holt@reqres.in");
        request.setPassword("pistol");

        RegisterResponseModel response = step("Send request for successful registration", () ->
                registerApi.doSuccessfulRegisterPostRequest(request));

        step("Verify registration response", () -> {
            assertNotNull(response.getId(), "ID should not be null");
            assertNotNull(response.getToken(), "Token should not be null");
            registerApi.checkTokenAndId(response);
        });
    }

    @Test
    @Tag("API")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Verify unsuccessful registration with missing password")
    void shouldVerifyUnsuccessfulRegistrationWithMissingPassword() {
        RequestModel request = new RequestModel();
        request.setEmail("sydney@fif");

        RegisterResponseModel response = step("Send request for unsuccessful registration", () ->
                registerApi.doUnSuccessfulRegisterPostRequest(request));

        step("Verify error message in the response", () ->
                Assertions.assertThat(response.getError())
                        .isEqualTo("Missing password")
                        .as("Error message should indicate missing password"));
    }

    @Test
    @Tag("API")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Verify unsuccessful registration with invalid email format")
    void shouldFailRegistrationWithInvalidEmailFormat() {
        RequestModel request = new RequestModel();
        request.setEmail("ssss-email");
        request.setPassword("pistol");

        RegisterResponseModel response = step("Send request for registration with invalid email format", () ->
                registerApi.doUnSuccessfulRegisterPostRequest(request));

        step("Verify error message for invalid email format", () ->
                Assertions.assertThat(response.getError())
                        .isEqualTo("Note: Only defined users succeed registration")
                        .as("Error message should indicate 'Note: Only defined users succeed registration'"));
    }

    @Test
    @Tag("API")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Verify unsuccessful registration with missing email and password")
    void shouldFailRegistrationWithoutEmailAndPassword() {
        RequestModel request = new RequestModel();
        request.setEmail("");
        request.setPassword("");

        RegisterResponseModel response = step("Send request for registration without email and password", () ->
                registerApi.doUnSuccessfulRegisterPostRequest(request));

        step("Verify error message for missing email and password", () ->
                Assertions.assertThat(response.getError())
                        .isEqualTo("Missing email or username")
                        .as("Error message should indicate missing email or username"));
    }

}
