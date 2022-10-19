package apiRequests;
import static io.restassured.RestAssured.given;

public class LoginPageAPI {

    public static final String ENDPOINT = "https://www.pecodesoftware.com/qa-portal/registerlogin/registerlogin.php";
    public static void getLoginPageRequest() {
        given().get(ENDPOINT).then().assertThat().statusCode(200);
    }
}