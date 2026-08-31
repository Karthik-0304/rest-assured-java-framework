package com.api.tests;

import com.api.base.BaseApiTest;
import com.api.models.User;
import com.api.services.UserClient;
import com.api.utils.TestDataProviders;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class UserTests extends BaseApiTest {

    private final UserClient userClient = new UserClient();

    @Test
    public void testGetSingleUserSuccessfully(){
        Response response = userClient.getUserById(2);

        Assert.assertEquals(response.getStatusCode(), 200, "Status code is mismatched");

        Integer userId = response.jsonPath().get("data.id");
        Assert.assertEquals(userId, Integer.valueOf(2), "User ID does not match!");

        String email = response.jsonPath().getString("data.email");
        Assert.assertNotNull(email, "Email is null");
    }

    @Test(dataProvider = "userCreationData", dataProviderClass = TestDataProviders.class)
    public void testCreateNewUserSuccessfully(String name, String job) {
        // Using model object instead of hardcoded JSON string
        User newUser = new User(name, job);

        Response response = userClient.createUser(newUser);

        Assert.assertEquals(response.getStatusCode(), 201, "Creation status code mismatch!");

        String resName = response.jsonPath().getString("name");
        Assert.assertEquals(resName, name, "Created user name mismatch!");

        String createdId = response.jsonPath().getString("id");
        Assert.assertNotNull(createdId, "Generated user ID should not be null!");
    }

    @Test
    public void testUpdateUserSuccessfully() {
        User updatedUser = new User("Karthik", "Lead SDET");

        Response response = userClient.updateUser(2, updatedUser);

        Assert.assertEquals(response.getStatusCode(), 200, "Update status code mismatch!");
        String updatedJob = response.jsonPath().getString("job");
        Assert.assertEquals(updatedJob, "Lead SDET", "Updated job title mismatch!");
    }

    @Test
    public void testDeleteUserSuccessfully() {
        Response response = userClient.deleteUser(2);
        Assert.assertEquals(response.getStatusCode(), 204, "Deletion status code mismatch!");
    }

    @Test
    public void testUserJsonSchemaContract() {
        given()
                .spec(requestSpec)
                .pathParam("userId", 2)
                .when()
                .get("/users/{userId}")
                .then()
                .statusCode(200)
                .body(matchesJsonSchemaInClasspath("schemas/user-schema.json"));
    }
}