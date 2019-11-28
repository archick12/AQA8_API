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
    public void getExistingIssue() {

        Response response =

                given().
                        auth().preemptive().basic("webinar5", "webinar5").
                        when().
                        get("http://jira.hillel.it/rest/api/2/issue/WEBINAR-8887").
                        then().
                        extract().response();

        assertEquals(response.statusCode(), 200);
        assertEquals("WEBINAR-8887", response.path("key"));
        final Matcher<String> matcher = new MatchesPattern(Pattern.compile("[A-Z]+\\-[0-9]+"));
        assertTrue(matcher.matches("WEBINAR-8887"));
    }


    @Test
    public void createIssue() {

        String issueJSON = JiraJSONObjects.newIssueJSON();

        Response response = given().
                auth().preemptive().basic("webinar5", "webinar5").
                header("Content-Type", "application/json").
                body(issueJSON).
                when().
                post("https://jira.hillel.it/rest/api/2/issue").
                then().
                extract().response();

        assertEquals(201, response.statusCode());
    }
}
