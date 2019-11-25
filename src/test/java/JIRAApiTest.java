import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class JIRAApiTest {

  @Test
  public void
  getIssue() {

    Response response =
        given().
            auth().preemptive().basic("webinar5", "webinar5").
            when().
            get("http://jira.hillel.it/rest/api/2/issue/WEBINAR-8887").
            then().
            extract().response();

    assertEquals(200, response.statusCode());
    assertEquals("WEBINAR-8887", response.path("key"));
  }
}
