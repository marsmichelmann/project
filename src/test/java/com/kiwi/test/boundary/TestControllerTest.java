package com.kiwi.test.boundary;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

/**
 * Test class for {@link TestController}.
 */
@QuarkusTest
class TestControllerTest {

    @Test
    @DisplayName("Test getting Test")
    public void getTest() {
        given()
                .when().get("/spring/test/1")
                .then()
                .statusCode(200)
                .body(is("Test(text=text123)"));
    }

    @Test
    @DisplayName("Test getting all Test")
    public void getAllTest() {
        given()
                .when().get("/spring/test/getAll")
                .then()
                .statusCode(200)
                .body("$.size()", is(2),
                        "[0].text", is("t1"),
                        "[1].text", is("t2"));
    }

}