package tests;

import api.UsersApi;
import models.RequestModel;
import models.UserListResponseModel;
import models.UserResponseModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("User Database Tests")
public class UserTests extends TestBase {

    UsersApi usersApi = new UsersApi();

    @Test
    @DisplayName("Verify user email")
    void shouldVerifyUserEmail() {
        UserListResponseModel response = usersApi.getUserList();
        step("Verify that the email of the second user is correct", () -> assertEquals("lindsay.ferguson@reqres.in", response.getData().get(1).getEmail()));
    }

    @Test
    @DisplayName("Verify updated user data using PATCH")
    void shouldUpdateUserDataWithPatch() {
        RequestModel request = new RequestModel();
        request.setName("morpheus");
        request.setJob("zion resident");

        UserResponseModel response = usersApi.patchUserData(request);

        step("Verify the updated user data", () -> {
            assertEquals("morpheus", response.getName());
            assertEquals("zion resident", response.getJob());
        });
    }

    @Test
    @DisplayName("Verify user deletion")
    void shouldDeleteUserData() {
        step("Send request to delete the user", () -> usersApi.deleteData());
    }

    @Test
    @DisplayName("Verify updated user data using PUT")
    void shouldUpdateUserDataWithPut() {
        RequestModel request = new RequestModel();
        request.setName("morpheus");
        request.setJob("zion resident");

        UserResponseModel response = usersApi.insertNewData(request);

        step("Verify the updated user data", () -> {
            assertEquals("morpheus", response.getName());
            assertEquals("zion resident", response.getJob());
        });
    }

    @Test
    @DisplayName("Verify total number of users on page 2")
    void shouldVerifyTotalNumberOfUsers() {
        UserListResponseModel response = usersApi.getUserList();
        step("Verify that the total number of users is 6", () -> assertEquals(6, response.getData().size(), "The total number of users does not match the expected value."));
    }

    @Test
    @DisplayName("Verify specific user data from the list")
    void shouldVerifySpecificUserDataFromList() {
        UserListResponseModel response = usersApi.getUserList();
        step("Verify the details of the second user in the list", () -> {
            assertEquals("Lindsay", response.getData().get(1).getFirst_name(), "First name does not match.");
            assertEquals("Ferguson", response.getData().get(1).getLast_name(), "Last name does not match.");
            assertEquals("https://reqres.in/img/faces/8-image.jpg", response.getData().get(1).getAvatar(), "Avatar URL does not match.");
        });
    }

    @Test
    @DisplayName("Verify partial update of user data using PATCH")
    void shouldPartiallyUpdateUserData() {
        RequestModel request = new RequestModel();
        request.setJob("developer");
        UserResponseModel response = usersApi.patchUserData(request);
        step("Verify the updated job field of the user", () -> assertEquals("developer", response.getJob(), "Job does not match the updated value."));
    }
}
