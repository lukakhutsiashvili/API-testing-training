package epam.training.luka_khutsiashvili.api.tests;

import epam.training.luka_khutsiashvili.api.utils.Endpoints;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class StatusCodeTest {

  @Test
  public void verifyHttpStatusCode() {
    Response response = RestAssured.get(Endpoints.USERS);

    assertEquals(response.getStatusCode(), 200,
        "Expected HTTP status code 200, but found: " + response.getStatusCode());
  }
}
