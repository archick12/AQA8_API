import io.restassured.response.Response;

public class JiraAPISteps {

    public static Response createIssue() {
        String issueJSON = JiraJSONObjects.newIssueJSON();
        Response response = HTTPMethods.post(APIPathes.issue, issueJSON);
        return response;
    }
}
