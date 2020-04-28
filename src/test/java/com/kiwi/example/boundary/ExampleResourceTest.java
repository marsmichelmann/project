package com.kiwi.example.boundary;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

/**
 * Test class for {@link ExampleResource}
 */
@QuarkusTest
public class ExampleResourceTest {

    @Test
    @DisplayName("Test getting 'Hello world!'")
    public void hello() {
        given()
                .when().get("/example/hello")
                .then()
                .statusCode(200)
                .body(is("Hello, World!"));
    }

    @Test
    @DisplayName("Test getting a json object")
    public void object() {
        given()
                .when().get("/example/object")
                .then()
                .statusCode(200)
                .body("key1", is("value1"))
                .and().body("key2", is("value2"));
    }

    @Test
    @DisplayName("Test getting the current version")
    public void version() {
        given()
                .when().get("/example/version")
                .then()
                .statusCode(200)
                .body(is("1.2.3"));
    }
}