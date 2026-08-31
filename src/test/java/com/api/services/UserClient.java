package com.api.services;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static com.api.base.BaseApiTest.requestSpec;
import static com.api.base.BaseApiTest.responseSpec;

public class UserClient {

    public Response getUserById(int userId) {
        return given()
                .spec(requestSpec)
                .pathParam("userId", userId)
                .when()
                .get("/users/{userId}")
                .then()
                .spec(responseSpec)
                .extract()
                .response();
    }

    public Response createUser(Object requestBody) {
        return given()
                .spec(requestSpec)
                .body(requestBody)
                .when()
                .post("/users")
                .then()
                .spec(responseSpec)
                .extract()
                .response();
    }

    public Response updateUser(int userId, Object requestBody) {
        return given()
                .spec(requestSpec)
                .pathParam("userId", userId)
                .body(requestBody)
                .when()
                .put("/users/{userId}")
                .then()
                .spec(responseSpec)
                .extract()
                .response();
    }

    public Response deleteUser(int userId) {
        return given()
                .spec(requestSpec)
                .pathParam("userId", userId)
                .when()
                .delete("/users/{userId}")
                .then()
                .extract()
                .response();
    }
}