package tests.in.reqreg;

import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import tests.TestBase;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


@DisplayName("Check API methods from website - https://reqres.in for practice purposes")

public class LoginApiWithAssertThatTests extends TestBase {

    LoginPage loginPage = new LoginPage();

    @Test
    public void successLoginWithHashMap200Test() {
        Map<String, String> loginPayload = new HashMap<>();
        loginPayload.put("email", "eve.holt@reqres.in");
        loginPayload.put("password", "cityslicka");

        Response response = loginPage.loginUser(loginPayload);

        assertThat("Expected status code 200 for successful login.", response.statusCode(), is(200));
        assertThat("Token should not be null for a successful login.", response.jsonPath().getString("token"), is(notNullValue()));
    }

    @Test
    public void missingEmailLogin400Test() {
        Map<String, String> loginPayload = new HashMap<>();
        loginPayload.put("email", "");
        loginPayload.put("password", "cityslicka");

        Response response = loginPage.loginUser(loginPayload);

        assertThat("Expected status code 400 for invalid login.", response.statusCode(), is(400));
        assertThat("Token should be NULL for a invalid login.", response.jsonPath().getString("token"), is(nullValue()));
    }

    @Test
    public void emptyLogin400Test() {
        Map<String, String> loginPayload = new HashMap<>();
        loginPayload.put("email", "");
        loginPayload.put("password", "");

        Response response = loginPage.loginUser(loginPayload);

        assertThat("Expected status code 400 for invalid login.", response.statusCode(), is(400));
        assertThat("Token should be NULL for a invalid login.", response.jsonPath().getString("token"), is(nullValue()));
    }



}
