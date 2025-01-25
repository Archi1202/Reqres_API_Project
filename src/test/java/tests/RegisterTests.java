package tests;

import api.RegisterApi;
import models.RegisterResponseModel;
import models.RequestModel;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;



@DisplayName("Registration tests")
public class RegisterTests extends TestBase {

    RegisterApi registerApi = new RegisterApi();

    @Test
    @DisplayName("Verification of the successful registration")
    void successfulRegistrationTest() {
        RequestModel request = new RequestModel();
        request.setEmail("eve.holt@reqres.in");
        request.setPassword("pistol");
        RegisterResponseModel response = registerApi.doSuccessfulRegisterPostRequest(request);
        registerApi.checkTokenAndId(response);
    }

    @Test
    @DisplayName("Verification of unsuccessful registration flow")
    void unsuccessfulRegistrationTest() {
        RequestModel request = new RequestModel();
        request.setEmail("sydney@fif");
        RegisterResponseModel response = registerApi.doUnSuccessfulRegisterPostRequest(request);
        Assertions.assertThat(response.getError()).isEqualTo("Missing password");
    }
}