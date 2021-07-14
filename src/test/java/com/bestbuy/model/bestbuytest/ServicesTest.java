package com.bestbuy.model.bestbuytest;

import com.bestbuy.model.ServicesPojo;
import com.bestbuy.model.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;



import static io.restassured.RestAssured.given;

public class ServicesTest extends TestBase {


    @Test
    public void getAllServices(){

        Response response =
                given()
                        .basePath("/services")
                .when()
                .get();
        response.then().statusCode(200);
        response.prettyPrint();



    }
    @Test
    public void createNewServices(){

        ServicesPojo servicesPojo = new ServicesPojo();
        servicesPojo.setName("ANB Money Services");

        Response response =
                given()
                        .basePath("/services")
                .header("Content-Type","application/json")
                .body(servicesPojo)
                .when()
                .post();
           response.then().statusCode(201);
           response.prettyPrint();

    }
    //delete the id 6 in postman so there shows status 200 ok but here run shown id not found 404
    @Test
    public void deleteServicesById(){
        Response response =
                given()
                        .basePath("/services")
                        .pathParam("id","6")
                        .when()
                        .delete("/{id}");
        response.then().statusCode(404);
        response.prettyPrint();


    }
    @Test
    public void getServicesById() {
        Response response =
                given()
                        .basePath("/services")
                        .pathParam("id", 4)
                        .when()
                        .get("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();


    }
    @Test
    public void updateServicesBasedOnServiceId(){
        ServicesPojo servicesPojo = new ServicesPojo();
        servicesPojo.setName("Euro Exchange");

        Response response =
                given()
                        .basePath("/services")
                .header("Content-Type","application/json")
                .body(servicesPojo)
                .when()
                .patch("/4");
        response.then().statusCode(200);
        response.prettyPrint();
    }
}

