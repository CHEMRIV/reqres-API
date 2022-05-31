package in.reqres.userinfo;


import in.reqres.model.StudentPojo;
import in.reqres.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class PatchTest extends TestBase {

    @Test
    public void updateId() {

        StudentPojo studentPojo = new StudentPojo();
        studentPojo.setName("morpheus");
        studentPojo.setJob("leader");


        Response response = given()
                .header("Content-Type", "application/json")
                .body(studentPojo)
                .when()
                .post("/users");

        response.then().statusCode(201);
        response.prettyPrint();

    }

}
