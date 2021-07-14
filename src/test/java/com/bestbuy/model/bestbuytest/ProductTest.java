package com.bestbuy.model.bestbuytest;

import com.bestbuy.model.ProductPojo;
import com.bestbuy.model.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class ProductTest extends TestBase {

    private int randomInt;
    private String randomString;


    @Test
    public void getAllProductInfo() {
        Response response =
                given()
                        .basePath("/products")
                        .when()
                        .get();
        response.then().statusCode(200);
        response.prettyPrint();

    }

    @Test
    public void createNewProduct() {

        ProductPojo productPojo = new ProductPojo();
        // productPojo.setId(123+randomInt+11);
        productPojo.setName("Duralock - A++ Batteries (12-Pack)");
        productPojo.setType("HardCore");
        productPojo.setPrice(9.99);
        productPojo.setUpc("0513333424020");
        productPojo.setShipping(10.99);
        productPojo.setDescription("DURALOCK Power Preserve technology; 12-pack");
        productPojo.setManufacturer("Duralock");
        productPojo.setModel("PN2400B4D");
        productPojo.setUrl("gopu12@gmail.com");
        productPojo.setImage("http://img.bbystatic.com/BestBuy_US/images/products/4390/21500_sa.jpg");


        Response response = given()
                .basePath("/products")
                .header("Content-Type", "application/json")
                .body(productPojo)
                .when()
                .post();
        response.then().statusCode(201);
        response.prettyPrint();
    }

    @Test
    public void deleteRecord() {

        Response response = given()
                .basePath("/products")
                .pathParam("id", "333179")
                .when()
                .delete("/{id}");
        response.then().statusCode(404);
        response.prettyPrint();
    }

    @Test
    public void getProductById() {
        Response response =
                given()
                        .basePath("/products")
                        .pathParam("id", 48530)
                        .when()
                        .get("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();


    }

    @Test
    public void updateAProductById() {

        ProductPojo productPojo = new ProductPojo();
        productPojo.setName("Deluxe");

        Response response =
                given()
                        .basePath("/products")
                        .header("Content-Type", "application/json")
                        .body(productPojo)
                        .when()
                        .patch("/127687");
        response.then().statusCode(200);
        response.prettyPrint();

    }

}


