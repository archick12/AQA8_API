import io.restassured.response.Response;
import org.hamcrest.Matcher;
import org.hamcrest.text.MatchesPattern;
import org.testng.annotations.Test;
import java.util.regex.Pattern;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

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
    final Matcher<String> matcher = new MatchesPattern(Pattern.compile("[A-Z]+\\-[0-9]+"));
    assertTrue(matcher.matches("WEBINAR-8887"));
  }
}
