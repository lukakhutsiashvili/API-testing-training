package epam.training.luka_khutsiashvili.api.utils;

public class Endpoints {

  private static final String BASE_URL = "https://jsonplaceholder.typicode.com";

  public static final String USERS = BASE_URL + "/users";
  public static final String USER_BY_ID = USERS + "/{userId}";

  private Endpoints() {}
}
