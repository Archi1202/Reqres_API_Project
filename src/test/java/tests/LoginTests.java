package tests;

import api.LoginApi;
import models.LoginResponseModel;
import models.RequestModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;



@DisplayName("Тесты на логин")
public class LoginTests extends TestBase {

    LoginApi loginApi = new LoginApi();

    @Test
    @DisplayName("Verification of the successful login")
    void successfulLoginTest() {
        RequestModel loginData = new RequestModel();
        loginData.setEmail("eve.holt@reqres.in");
        loginData.setPassword("cityslicka");
        LoginResponseModel response = loginApi.doLoginPostRequest(loginData);
        loginApi.checkToken(response);
    }

    @Test
    @DisplayName("Unsuccessful validation test")
    void unSuccessfulLoginTest() {
        RequestModel loginData = new RequestModel();
        loginData.setEmail("123424@dogdog");
        LoginResponseModel response = loginApi.doUnSuccessfulLoginPostRequest(loginData);
        loginApi.checkErrorLogin(response);
    }
}