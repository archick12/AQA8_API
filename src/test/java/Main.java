import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;

public class Main {

    public static void main(String[] args) {
        Project project = new Project("10000");

        String resultingJSON = extractPOJO(project);
        System.out.println("RESULT: " + resultingJSON);
    }

    public static String extractPOJO(Object obj) {
        ObjectMapper mapper = new ObjectMapper();
        String result = null;
        try {
            result = mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return result;
    }

}
















//        JSONObject newIssueJSON = new JSONObject();
//        JSONObject fields = new JSONObject();
//        fields.put("summary", "Test Summary");
//        JSONObject issueType = new JSONObject();
//        issueType.put("id", "10107");
//        JSONObject project = new JSONObject();
//        project.put("id", "11400");
//        JSONObject assignee = new JSONObject();
//        assignee.put("name", "webinar5");
//
//        fields.put("issuetype", issueType);
//        fields.put("project", project);
//        fields.put("assignee", assignee);
//
//        newIssueJSON.put("fields", fields);
//        System.out.println(newIssueJSON.toJSONString());
