package api;

import models.RequestModel;
import models.UserListResponseModel;
import models.UserResponseModel;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static specs.Specs.*;

public class UsersApi {

    public UserListResponseModel getUserList() {
        return step("Make a request for a full list of users", () ->
                given(commonRequest)
                        .queryParam("page", "2")
                        .get("/users")
                        .then()
                        .spec(response200)
                        .extract().as(UserListResponseModel.class));
    }


    public UserResponseModel patchUserData(RequestModel request) {
        return step("Send request to update user data", () ->

                given(commonRequest)
                        .body(request)

                        .when()
                        .patch("/users/2")

                        .then()
                        .spec(response200)

                        .extract().as(UserResponseModel.class));
    }

    public void deleteData() {
        step("Execute user deletion flow", () ->
                given(commonRequest)
                        .delete("/users/2")
                        .then()
                        .spec(response204));
    }

    public UserResponseModel insertNewData(RequestModel request) {
        return step("Send a request to update user data", () ->
                given(commonRequest)
                        .body(request)

                        .when()
                        .put("/users/2")

                        .then()
                        .spec(response200)
                        .extract().as(UserResponseModel.class));
    }

}