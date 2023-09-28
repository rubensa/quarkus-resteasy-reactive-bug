package org.eu.rubensa.sample;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.containsString;

import org.junit.jupiter.api.Test;

import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
@TestHTTPEndpoint(SampleResource.class)
public class SampleResourceTest {

  @Test
  void testRunFunc() {
    given()
        .pathParam("name", "quarkus.test.sample")
        .pathParam("key", "data/test.txt")
        .when()
        .get("/sample/{name}/objects/{key}/func")
        .then()
        .statusCode(200)
        .body(
            allOf(
                containsString("quarkus.test.sample"),
                containsString("data/test.txt")));
  }

}
