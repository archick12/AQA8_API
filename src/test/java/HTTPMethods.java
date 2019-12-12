import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class HTTPMethods {

    public static Response post(String urlPath, String body) {
        Response response = given().
                auth().preemptive().basic("webinar5", "webinar5").
                header("Content-Type", "application/json").
                body(body).
                when().
                post(APIPathes.baseURL + urlPath);
        return response;
    }
}
