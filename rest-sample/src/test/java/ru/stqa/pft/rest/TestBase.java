//package ru.stqa.pft.rest;
//
//import org.apache.http.client.fluent.Request;
//import org.testng.SkipException;
//
//import static com.sun.javafx.runtime.async.BackgroundExecutor.getExecutor;
//
//public class TestBase {
//
//
//    public boolean isIssueOpen(int issueId) {
//        if (getExecutor().execute(Request.Get("https://bugify.stqa.ru/api/issues/341.json"))
//                .returnContent().asString().size() == 1) {
//            return true;
//        }
//        return false;
//    }
//
//    public void skipIfNotFixed(int issueId) {
//        if (isIssueOpen(issueId)) {
//            throw new SkipException("Ignored because of issue " + issueId);
//        }
//    }
//}
//
