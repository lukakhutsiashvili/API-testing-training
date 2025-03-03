package epam.training.luka_khutsiashvili.api.tests;

import epam.training.luka_khutsiashvili.api.utils.Endpoints;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class ResponseBodyTest {

  @Test
  public void verifyResponseBodyContainsTenUsers() {
    Response response = RestAssured.get(Endpoints.USERS);
    List<?> users = response.jsonPath().getList("$");

    SoftAssert softAssert = new SoftAssert();
    softAssert.assertNotNull(users, "Response body is null.");
    softAssert.assertEquals(users.size(), 10, "Expected 10 users in response, but found: " + users.size());
    softAssert.assertAll();
  }
}
