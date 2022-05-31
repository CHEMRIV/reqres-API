package in.reqres.extractingresponsedata;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

/*
 *  Created by Jay
 */
public class TestValidation {

    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "https://reqres.in";
        RestAssured.basePath="/api";
             response = given()
                .when()
                .get("/users?page=2")
                .then().statusCode(200);


    }


    // 1) page = 2
    @Test
    public void test001() {

        int page = response.extract().path("page");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("page : " + page);
        System.out.println("------------------End of Test---------------------------");
    }

    //2)per_page = 6
    @Test
    public void test002() {

        int perPage = response.extract().path("per_page");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("per_page : " + perPage);
        System.out.println("------------------End of Test---------------------------");
    }

    //3)data[1].id = 8
    @Test
    public void test003() {

        int findId = response.extract().path("data[1].id");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("data[1].id : " + findId);
        System.out.println("------------------End of Test---------------------------");
    }


    //data[3].first_name = Byron
    @Test
    public void test004() {

        String findName = response.extract().path("data[3].first_name");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("data[3].first_name : " + findName);
        System.out.println("------------------End of Test---------------------------");
    }

    //list of data = 6
    @Test
    public void test005() {

        String listOfData = response.extract().path("per_page");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("list of data = 6: " + listOfData);
        System.out.println("------------------End of Test---------------------------");
    }
    //data[5].avatar
    @Test
    public void test006() {

        String avatar = response.extract().path("data[5].avatar");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : " + avatar);
        System.out.println("------------------End of Test---------------------------");
    }


}
