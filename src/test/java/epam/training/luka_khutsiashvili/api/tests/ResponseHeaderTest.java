package epam.training.luka_khutsiashvili.api.tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ResponseHeaderTest {

  private static final String BASE_URL = "https://jsonplaceholder.typicode.com/users";

  @Test
  public void verifyContentTypeHeaderExists() {
    Response response = RestAssured.get(BASE_URL);

    assertTrue(response.getHeaders().hasHeaderWithName("Content-Type"),
        "Response does not contain 'Content-Type' header.");
  }

  @Test
  public void verifyContentTypeHeaderValue() {
    Response response = RestAssured.get(BASE_URL);

    String expectedContentType = "application/json; charset=utf-8";
    String actualContentType = response.getHeader("Content-Type");

    assertEquals(actualContentType, expectedContentType,
        "Expected 'Content-Type' to be: " + expectedContentType + ", but got: " + actualContentType);
  }
}
