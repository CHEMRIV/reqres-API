package in.reqres.userinfo;


import in.reqres.model.StudentPojo;
import in.reqres.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class PostTest extends TestBase {

    @Test
    public void createId() {

        StudentPojo studentPojo = new StudentPojo();
        studentPojo.setName("morpheus");
        studentPojo.setJob("leader");


        Response response = given()
                .header("Content-Type", "application/json")
                .body(studentPojo)
                .when()
                .post("/users");

        response.then().statusCode(200);
        response.prettyPrint();

    }

}
