package day48restAssured;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class RestAssuredPracticeTest {
    @BeforeClass
    public void setup(){
        RestAssured.baseURI= "https://api.escuelajs.co";
        RestAssured.useRelaxedHTTPSValidation();
    }

    @Test
    public void check(){

        String loginbody = """
                {
                 "email": "john@mail.com",
                  "password": "changeme"
                  }
                """;
        String accessToken =
                given()
                        .contentType(ContentType.JSON)
                        .body(loginbody)
                        .when()
                        .post("/api/v1/auth/login")
                        .then()
                        .statusCode(201) // 201 Created is typically used by this API for login
//                       .body("access_token", notNullValue())
                        .extract()
                        .path("access_token");

        System.out.println(accessToken);

        given()
                .contentType(ContentType.JSON)
                .header("Authorization","Bearer "+accessToken)
                .when()
                .get("/api/v1/auth/profile")
                .then()
                .statusCode(200)
                .body("email", equalTo("john@mail.com"))
                .body("name", equalTo("Jhon"))
                .body("role", equalTo("customer"));


    }
}
