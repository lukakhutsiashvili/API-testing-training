package epam.training.luka_khutsiashvili.api.tests;

import epam.training.luka_khutsiashvili.api.models.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.*;

public class CrudOperationsTest {

  private static final String BASE_URL = "https://jsonplaceholder.typicode.com/users";

  @Test
  public void testCreateUser() {
    User user = new User("John Doe", "johndoe", "john.doe@example.com");

    Response response = given()
        .contentType(ContentType.JSON)
        .body(user)
        .when()
        .post(BASE_URL);

    assertEquals(response.jsonPath().getString("name"), "John Doe", "User name should match the request");
    assertEquals(response.jsonPath().getString("email"), "john.doe@example.com", "Email should match the request");
  }

  @Test
  public void testGetUser() {
    Response response = given()
        .when()
        .get(BASE_URL + "/1");

    assertEquals(response.getStatusCode(), 200, "Expected status code 200 for user retrieval.");
    assertEquals(response.jsonPath().getString("id"), "1", "User ID should be 1.");
  }

  @Test
  public void testUpdateUser() {
    User updatedUser = new User("Updated Name", "updateduser", "updated@example.com");

    Response response = given()
        .contentType(ContentType.JSON)
        .body(updatedUser)
        .when()
        .put(BASE_URL + "/1");

    assertEquals(response.getStatusCode(), 200, "Expected status code 200 for user update.");
    assertEquals(response.jsonPath().getString("name"), "Updated Name", "User name should be updated.");
  }

  @Test
  public void testDeleteUser() {
    Response response = given()
        .when()
        .delete(BASE_URL + "/1");

    assertEquals(response.getStatusCode(), 200, "Expected status code 200 for user deletion.");
  }
}
