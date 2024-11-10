package helpers;

import config.BrowserStackConfig;
import drivers.BrowserStackDriver;

import static io.restassured.RestAssured.given;

public class BrowserStackVideoHelper {

    public static String videoUrl(String sessionId) {
        String url = String.format("https://api.browserstack.com/app-automate/sessions/%s.json", sessionId);

        BrowserStackConfig config = BrowserStackDriver.getBrowserStackConfig();

        return given()
                .auth().basic(config.username(), config.password())
                .get(url)
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .extract().path("automation_session.video_url");
    }
}