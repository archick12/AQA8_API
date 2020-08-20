import io.restassured.http.Cookies;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
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
                        get("http://jira.hillel.it/rest/api/2/issue/WEBINAR-9060").
                        then().
                        extract().response();

        Cookies coockies = response.getDetailedCookies();

        assertEquals(response.statusCode(), 200);
        assertEquals("WEBINAR-9060", response.path("key"));
        final Matcher<String> matcher = new MatchesPattern(Pattern.compile("[A-Z]+\\-[0-9]+"));
        assertTrue(matcher.matches("WEBINAR-9060"));
    }


    @Test
    public void createIssue() {
        Response response = JiraAPISteps.createIssue();
        assertEquals(201, response.statusCode());
        response.then().extract().path("key");
    }
}
