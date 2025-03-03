package epam.training.luka_khutsiashvili.api.tests;

import epam.training.luka_khutsiashvili.api.models.User;
import epam.training.luka_khutsiashvili.api.utils.Endpoints;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class CrudOperationsTest {

  @Test
  public void testCreateUser() {
    User user = new User("John Doe", "johndoe", "john.doe@example.com");

    Response response = given()
        .contentType(ContentType.JSON)
        .body(user)
        .when()
        .post(Endpoints.USERS);

    SoftAssert softAssert = new SoftAssert();
    softAssert.assertEquals(response.getStatusCode(), 201, "Expected status code 201 for user creation");
    softAssert.assertEquals(response.jsonPath().getString("name"), "John Doe", "User name should match request");
    softAssert.assertEquals(response.jsonPath().getString("email"), "john.doe@example.com", "Email should match request");
    softAssert.assertAll();
  }

  @Test
  public void testGetUser() {
    Response response = given()
        .pathParam("userId", 1)
        .when()
        .get(Endpoints.USER_BY_ID);

    assertEquals(response.getStatusCode(), 200, "Expected status code 200 for user retrieval.");
  }

  @Test
  public void testUpdateUser() {
    User updatedUser = new User("Updated Name", "updateduser", "updated@example.com");

    Response response = given()
        .contentType(ContentType.JSON)
        .pathParam("userId", 1)
        .body(updatedUser)
        .when()
        .put(Endpoints.USER_BY_ID);

    SoftAssert softAssert = new SoftAssert();
    softAssert.assertEquals(response.getStatusCode(), 200, "Expected status code 200 for user update.");
    softAssert.assertEquals(response.jsonPath().getString("name"), "Updated Name", "User name should be updated.");
    softAssert.assertAll();
  }

  @Test
  public void testDeleteUser() {
    Response response = given()
        .pathParam("userId", 1)
        .when()
        .delete(Endpoints.USER_BY_ID);

    assertEquals(response.getStatusCode(), 200, "Expected status code 200 for user deletion.");
  }
}
