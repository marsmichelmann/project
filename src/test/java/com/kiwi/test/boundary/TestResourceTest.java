package com.kiwi.test.boundary;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import io.vertx.core.json.JsonObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

/**
 * Test class for {@link TestResource}.
 */
@QuarkusTest
class TestResourceTest {

    @Test
    @DisplayName("Test getting Test")
    public void getTest() {
        given()
                .when().get("/test/test")
                .then()
                .statusCode(200)
                .body("text", is("text123"));
    }

    @Test
    @DisplayName("Test getting all Test")
    public void getAllTest() {
        given()
                .when().get("/test/getAll")
                .then()
                .statusCode(200)
                .body("$.size()", is(9));
    }

    @Test
    @DisplayName("Test creating a Test")
    public void create() {
        // init
        String body = new JsonObject().put("text", "test123").toString();

        // run
        given().contentType(ContentType.JSON)
                .body(body)
                .when().post("/test")
                .then()
                .statusCode(200)
                .body("text", is("test123"));
    }

}