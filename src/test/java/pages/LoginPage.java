package pages;

import io.restassured.response.Response;
import tests.TestBase;

public class LoginPage extends TestBase {

    public Response loginUser(Object loginPayload) {
        return postRequest("/login", loginPayload);
    }
}