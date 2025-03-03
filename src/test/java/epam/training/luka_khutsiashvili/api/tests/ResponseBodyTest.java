package epam.training.luka_khutsiashvili.api.tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class ResponseBodyTest {

  private static final String BASE_URL = "https://jsonplaceholder.typicode.com/users";

  @Test
  public void verifyResponseBodyContainsTenUsers() {
    Response response = RestAssured.get(BASE_URL);

    List<?> users = response.jsonPath().getList("$");

    assertNotNull(users, "Response body is null.");
    assertEquals(users.size(), 10, "Expected 10 users in response, but found: " + users.size());
  }
}
