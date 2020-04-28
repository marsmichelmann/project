package com.kiwi.restcountries.boundary;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

/**
 * Test class for {@link CountryResource}.
 */
@QuarkusTest
class CountryResourceTest {

    @Test
    @DisplayName("Tests requesting country germany")
    public void getCountryByName() {
        given()
                .when().get("/country/name/germany")
                .then()
                .statusCode(200)
                .body("$.size()", is(1),
                        "[0].alpha2Code", is("DE"),
                        "[0].capital", is("Berlin"),
                        "[0].currencies.size()", is(1),
                        "[0].currencies[0].name", is("Euro")
                );
    }
}