package com.bridgelabz.json;
  import io.restassured.http.ContentType;
  import io.restassured.response.Response;
  import org.junit.jupiter.api.Assertions;
  import org.junit.jupiter.api.Test;

  import static io.restassured.RestAssured.given;

  public class TestingRestAssuredForJson {

      @Test
      public void postRequestForPost() {
          Response response = given()
                  .contentType(ContentType.JSON)
                  .body("[\n" +
                          "  {\n" +
                          "    \"id\": 1,\n" +
                          "    \"title\": \"json-server\",\n" +
                          "    \"author\": \"typicode\"\n" +
                          "  }\n" +
                          "]")

                  .when()
                  .post("https://localhost:3000/posts");
          response.prettyPrint();
          Assertions.assertEquals(201, response.statusCode());
      }

      @Test
      public void bgetRequestForPost() {
          Response response = given()
                  .contentType(ContentType.JSON)
                  .when()
                  .get("http://localhost:3000/posts");
          response.prettyPrint();
          response.then().assertThat().statusCode(200);

      }
      @Test
      public void putRequestForPosts() {
          Response response = given()
                  .contentType(ContentType.JSON)
                  .body("[\n" +
                          "    {\n" +
                          "        \"id\": 1,\n" +
                          "        \"title\": \"json-server\",\n" +
                          "        \"author\": \"typicode\"\n" +
                          "    },\n" +
                          "    {\n" +
                          "        \"id\": 2,\n" +
                          "        \"title\": \"json-server\",\n" +
                          "        \"author\": \"manish\"\n" +
                          "    }\n" +
                          "]")
                  .when()
                  .put("http://localhost:3000/posts/2");
          response.prettyPrint();
          Assertions.assertEquals(200, response.statusCode());
      }

      // Test for comments
      @Test
      public void postRequestForComments() {
          Response response = given()
                  .contentType(ContentType.JSON)
                  .body("[\n" +
                          "    {\n" +
                          "    \"id\": 2,\n" +
                          "    \"body\": \"some comment\",\n" +
                          "    \"postId\": 1\n" +
                          "\n" +
                          "},\n" +
                          "{\n" +
                          "\"id\": 10,\n" +
                          "    \"body\": \"some comment\",\n" +
                          "    \"postId\": 1\n" +
                          "}\n" +
                          "]")
                  .when()
                  .post("http://localhost:3000/comments");
          response.prettyPrint();
          Assertions.assertEquals(201, response.statusCode());
      }
      @Test
      public void getRequestForComments() {
          Response response = given()
                  .accept(ContentType.JSON)
                  .contentType(ContentType.JSON)
                  .when()
                  .get("http://localhost:3000/comments");
          response.prettyPrint();
          response.then().assertThat().statusCode(200);

      }
      @Test
      public void putRequestForComments() {
          Response response = given()
                  .contentType(ContentType.JSON)
                  .body("[\n" +
                          "    {\n" +
                          "        \"id\": 2,\n" +
                          "        \"body\": \"This is me Pranali\",\n" +
                          "        \"postId\": 1\n" +
                          "    },\n" +
                          "    {\n" +
                          "        \"id\": 3,\n" +
                          "        \"body\": \"My name is Rachit prakash jadhav\",\n" +
                          "        \"postId\": 1\n" +
                          "    }\n" +
                          "]")
                  .when()
                  .put("http://localhost:3000/comments/2");
          response.prettyPrint();
          Assertions.assertEquals(200, response.statusCode());
      }

      // Test for Profile
      @Test
      public void postRequestForProfile() {
          Response response = given()
                  .contentType(ContentType.JSON)
                  .body("{\n" +
                          "    \"id\" : 18,\n" +
                          "    \"name\": \"pranali prakash jadhav\",\n" +
                          "    \"Address\" : \"Mumbai , plot no. 381\",\n" +
                          "    \"Email\" : \"jadhavpranali55@gmail.com\"\n" +
                          "\n" +
                          "}")
                  .when()
                  .post("http://localhost:3000/profile");
          response.prettyPrint();
          Assertions.assertEquals(201, response.statusCode());
      }
      @Test
      public void getRequestForProfile() {
          Response response = given()
                  .accept(ContentType.JSON)
                  .contentType(ContentType.JSON)
                  .when()
                  .get("http://localhost:3000/profile");
          response.prettyPrint();
          response.then().assertThat().statusCode(200);

      }
      @Test
      public void putRequestForProfile() {
          Response response = given()
                  .contentType(ContentType.JSON)
                  .body("{\n" +
                          "    \"id\" : 101,\n" +
                          "    \"name\": \"Pranali prakash jadhav\",\n" +
                          "    \"Address\" : \"Maharashtra ,vile parle , plot no. 381\",\n" +
                          "    \"Email\" : \"jadhavpranali55@gmail.com\"\n" +
                          "\n" +
                          "}")
                  .when()
                  .put("http://localhost:3000/profile/101");
          response.prettyPrint();
          Assertions.assertEquals(200, response.statusCode());
      }
      @Test
      public void deleteRequestForProfile() {
          Response response = given()
                  .accept(ContentType.JSON)
                  .contentType(ContentType.JSON)
                  .when()
                  .delete("http://localhost:3000/profile/17");
          response.prettyPrint();
          response.then().assertThat().statusCode(200);

      }
  }




































