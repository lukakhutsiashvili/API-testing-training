package epam.training.luka_khutsiashvili.api.tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class StatusCodeTest {

  private static final String BASE_URL = "https://jsonplaceholder.typicode.com/users";

  @Test
  public void verifyHttpStatusCode() {
    Response response = RestAssured.get(BASE_URL);

    assertEquals(response.getStatusCode(), 200, "Expected HTTP status code 200, but found: " + response.getStatusCode());
  }
}
