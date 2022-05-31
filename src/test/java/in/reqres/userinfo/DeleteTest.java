package in.reqres.userinfo;

import in.reqres.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class DeleteTest extends TestBase {

    @Test
    public void getAllRecordInfo() {

        Response response=given()
                .header("Content-type", "application/json")
                .when()
                .delete("/users/2")
                .then()
                .extract().response();
        response.then().statusCode(204);
        response.prettyPrint();
    }

}
