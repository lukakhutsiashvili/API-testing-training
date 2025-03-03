package epam.training.luka_khutsiashvili.api.tests;

import epam.training.luka_khutsiashvili.api.utils.Endpoints;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

public class ResponseHeaderTest {

  @Test
  public void verifyContentTypeHeaderExists() {
    Response response = RestAssured.get(Endpoints.USERS);

    assertTrue(response.getHeaders().hasHeaderWithName("Content-Type"),
        "Response does not contain 'Content-Type' header.");
  }

  @Test
  public void verifyContentTypeHeaderValue() {
    Response response = RestAssured.get(Endpoints.USERS);

    String expectedContentType = "application/json; charset=utf-8";
    String actualContentType = response.getHeader("Content-Type");

    assertEquals(actualContentType, expectedContentType,
        "Expected 'Content-Type' to be: " + expectedContentType + ", but got: " + actualContentType);
  }
}
