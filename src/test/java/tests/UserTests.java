package tests;

import api.UsersApi;
import models.RequestModel;
import models.UserListResponseModel;
import models.UserResponseModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertEquals;



@DisplayName("Тесты с базой пользователей")
public class UserTests extends TestBase {

    UsersApi usersApi = new UsersApi();

    @Test
    @DisplayName("Проверка конкретного email")
    void checkUserEmailTest() {
        UserListResponseModel response = usersApi.getUserList();
        step("Проверить email пользователя",
                () -> assertEquals("lindsay.ferguson@reqres.in", response.getData().get(1).getEmail()));
    }


    @Test
    @DisplayName("Проверка обновления данных")
    void patchRequestTest() {
        RequestModel request = new RequestModel();
        request.setName("morpheus");
        request.setJob("zion resident");
        UserResponseModel response = usersApi.patchUserData(request);
        step("Проверить обновленные данные пользователя", () -> {
            assertEquals(response.getName(), "morpheus");
            assertEquals(response.getJob(), "zion resident");
        });
    }

    @Test
    @DisplayName("Проверка удаления данных пользователя")
    void deleteRequestTest() {
        usersApi.deleteData();
    }

    @Test
    @DisplayName("Проверка обновления данных")
    void putRequestTest() {
        RequestModel request = new RequestModel();
        request.setName("morpheus");
        request.setJob("zion resident");
        UserResponseModel response = usersApi.insertNewData(request);
        step("Проверить обновленные данные пользователя", () -> {
            assertEquals("morpheus", response.getName());
            assertEquals("zion resident", response.getJob());
        });
    }
}