package com.bestbuy.model.bestbuytest;

import com.bestbuy.model.StorePojo;
import com.bestbuy.model.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class StoreTest extends TestBase{


    @Test
    public void bringsAllStoresInformation() {

        Response response =
                given()
                        .basePath("/stores")
                        .when()
                        .get();
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void createANewStore() {

        StorePojo storePojo = new StorePojo();

        storePojo.setName("Rural Town ");
        storePojo.setType("Rural");
        storePojo.setAddress("Wolstreet");
        storePojo.setAddress2("SeacroftVelly");
        storePojo.setCity("Perly");
        storePojo.setState("North Valli");
        storePojo.setZip("4520243");
        storePojo.setLat(6);

        Response response =
                given()
                        .basePath("/stores")
                        .header("Content-Type", "application/json")
                        .body(storePojo)
                        .when()
                        .post();
        response.then().statusCode(201);
        response.prettyPrint();


    }

    @Test
    public void deleteStoreById() {

        Response response = given()
                .basePath("/stores")
                .pathParam("id", "7")
                .when()
                .delete("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();


    }

    @Test
    public void getStoredById() {
        Response response =
                given()
                        .basePath("/stores")
                        .pathParam("id", 10)
                        .when()
                        .get("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();


    }

    @Test
    public void updateStoreWithPatch() {

        StorePojo storesPojo = new StorePojo();

        storesPojo.setName("South Velly");


        Response response =
                given()
                        .basePath("/stores")
                        .header("Content-Type", "application/json")
                        .body(storesPojo)
                        .when()
                        .patch("/8922");
        response.then().statusCode(200);
        response.prettyPrint();


    }
}
