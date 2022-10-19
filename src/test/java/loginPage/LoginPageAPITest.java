package loginPage;

import org.testng.annotations.Test;

import static apiRequests.LoginPageAPI.getLoginPageRequest;

public class LoginPageAPITest {

    @Test(description = "Verify that the status code of the GET Login Page request equals 200")
    public void verifyGetLoginPageRequestTest() {
        getLoginPageRequest();
    }
}