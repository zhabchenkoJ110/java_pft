package ru.stqa.pft.rest;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import org.apache.http.client.fluent.Executor;
import org.apache.http.client.fluent.Request;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Set;

import static org.testng.Assert.assertEquals;

public class RestTests {

    @Test
    public void testCreateIssue() throws IOException {
        Set<Issue> oldIssues = getIssues();
        Issue newIssue = new Issue().withSubject("Test issue").withDescription("New test issue");
        int issueId = createIssue(newIssue);
        Set<Issue> newIssues = getIssues();
        oldIssues.add(newIssue.withId(issueId));
        assertEquals(newIssues, oldIssues);
    }

//
//    @Test (enabled = false)
//        public void testCheckIssue() throws IOException {
//            Set<Issue> oldIssues = getIssues();
//            int issueId = 341;
//            isIssueOpen(issueId);
//            System.out.println(isIssueOpen(issueId));
//    }

    private Set<Issue> getIssues() throws IOException {
        String json = getExecutor().execute(Request.Get("https://bugify.stqa.ru/api/issues.json"))
                .returnContent().asString();
        JsonElement parsed = new JsonParser().parse(json); //парсим json
        JsonElement issues = parsed.getAsJsonObject().get("issues"); //по ключу извлекаем нужную часть
        return new Gson().fromJson(issues, new TypeToken<Set<Issue>>() {
        }.getType());//костыль - преобразование в множество объектов типа Issue
    }

    private Executor getExecutor() {
        return Executor.newInstance().auth("288f44776e7bec4bf44fdfeb1e646490", "");
    }

    private int createIssue(Issue newIssue) throws IOException {
        String json = getExecutor().execute(Request.Post("https://bugify.stqa.ru/api/issues.json")
                .bodyForm(new BasicNameValuePair("subject", newIssue.getSubject()),
                        new BasicNameValuePair("description", newIssue.getDescription())))
                .returnContent().asString();
        JsonElement parsed = new JsonParser().parse(json);
        return parsed.getAsJsonObject().get("issue_id").getAsInt(); //идентификатор созданного багрепорта
    }

//    public boolean isIssueOpen(int issueId) throws IOException {
//        String json = getExecutor().execute(Request.Get("https://bugify.stqa.ru/api/issues/" + issueId + ".json"))
//                .returnContent().asString();
//        JsonElement parsed = new JsonParser().parse(json); //парсим json
//        JsonElement issue = parsed.getAsJsonObject().get("issues");
//
//        String issues = parsed.getAsJsonObject().get("state_name").getAsString();
//        if (issues == "Deleted") {
//            return true;
//        }
//        return false;
//    }
//
//    public void skipIfNotFixed(int issueId) throws IOException {
//        if (isIssueOpen(issueId)) {
//            throw new SkipException("Ignored because of issue " + issueId);
//        }
//    }

}
