package adapters;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import lombok.extern.log4j.Log4j2;
import org.apache.http.protocol.HTTP;
import utils.PropertyReader;

import static io.restassured.RestAssured.given;

@Log4j2
public class BaseAdapter {
    protected Gson gson;
    protected final String ACCESS_TOKEN = System.getenv().getOrDefault("access_token", PropertyReader.getProperty("access_token"));
    protected final String API_BASE_URL = System.getenv().getOrDefault("api_base_url", PropertyReader.getProperty("api_base_url"));

    public BaseAdapter() {
        gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .create();
    }

    @Step("Make get request")
    public String post(String url, String body, int status) {
        log.info("Sending post request with {} url and {} body", url, body);
        return
                given()
                        .header("Token", ACCESS_TOKEN)
                        .header(HTTP.CONTENT_TYPE, ContentType.JSON)
                        .body(body)
                        .log().all()
                        .when()
                        .post(API_BASE_URL + url)
                        .then()
                        .log().all()
                        .statusCode(status)
                        .contentType(ContentType.JSON).extract().body().asString();
    }

    @Step("Make get request")
    public String get(String url, String body, int status) {
        log.info("Sending get request with {} url and {} body", url, body);
        return
                given()
                        .header("Token", ACCESS_TOKEN)
                        .header(HTTP.CONTENT_TYPE, ContentType.JSON)
                        .body(body)
                        .log().all()
                        .when()
                        .get(API_BASE_URL + url)
                        .then()
                        .log().all()
                        .statusCode(status)
                        .contentType(ContentType.JSON).extract().body().asString();
    }

    @Step("Make delete request")
    public String delete(String url, String body, int status) {
        log.info("Sending delete request with {} url and {} body", url, body);
        return
                given()
                        .header("Token", ACCESS_TOKEN)
                        .header(HTTP.CONTENT_TYPE, ContentType.JSON)
                        .body(body)
                        .log().all()
                        .when()
                        .delete(API_BASE_URL + url)
                        .then()
                        .log().all()
                        .statusCode(status)
                        .contentType(ContentType.JSON).extract().body().asString();
    }
}
