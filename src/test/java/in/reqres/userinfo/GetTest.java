package in.reqres.userinfo;


import in.reqres.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetTest extends TestBase {

    @Test
    public void getAllStudentsInfo() {

        Response response=given()
                .when()
                .get("users?page=2");
        response.then().statusCode(200);
        response.prettyPrint();
    }



    @Test
    public void getSingleStudentInfo() {
        Response response = given()
                .pathParams("id", 2)
                .when()
                .get("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();

    }




}
