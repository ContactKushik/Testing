package day48restAssured;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class RestAssuredTestCase {

    @BeforeClass
    public void setup() {
        // Setting the base URI for the EscuelaJS API
        RestAssured.baseURI = "https://api.escuelajs.co";
        RestAssured.useRelaxedHTTPSValidation();
    }
    @Test
    public void testLoginAndFetchProfile() {

        // ---------------------------------------------------------
        // STEP 1 — POST: Authenticate and extract the access token
        // ---------------------------------------------------------
        String loginBody = """
                {
                  "email": "john@mail.com",
                  "password": "changeme"
                }
                """;

        String accessToken =
                given()

                        .contentType(ContentType.JSON)
                        .body(loginBody)
                        .when()
                        .post("/api/v1/auth/login")
                        .then()
                        .statusCode(201) // 201 Created is typically used by this API for login
//                       .body("access_token", notNullValue())
                        .extract()
                        .path("access_token"); // Extracting the JWT token as a String


        System.out.println(accessToken);
        // ---------------------------------------------------------
        // STEP 2 — GET: Fetch the user profile using the token
        // ---------------------------------------------------------
        given()
                // Passing the token in the Authorization header using the Bearer scheme
                .header("Authorization", "Bearer " + accessToken)
                .when()
                .get("/api/v1/auth/profile")
                .then()
//                .statusCode(200)
                // Verifying the response matches the expected profile data
                .body("email", equalTo("john@mail.com"))
                .body("name", equalTo("Jhon"))
                .body("role", equalTo("customer"));


        // 1. Send the request and extract the ENTIRE response
        Response profileResponse =
                given()
                        .header("Authorization", "Bearer " + accessToken)
                        .when()
                        .get("/api/v1/auth/profile")
                        .then()
//                        .statusCode(200)
                        .extract()
                        .response(); // This saves the full JSON response into the variable
//        System.out.println("RAW RESPONSE: "+profileResponse);


// 2. Extract specific fields from that saved response
        String email = profileResponse.path("email");
        String name = profileResponse.path("name");
        String role = profileResponse.path("role");
        int id = profileResponse.path("id"); // Assuming ID is a number, you can extract it as an int

// 3. Use them for "further things"
        System.out.println("User's Email is: " + email);
        System.out.println("User's Name is: " + name);

// Example: Passing the extracted role to another API call
/*
given()
    .body("{ \"roleToUpdate\": \"" + role + "\" }")
.when()
    .post("/api/admin/permissions")
...
*/
    }
}