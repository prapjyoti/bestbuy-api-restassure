package com.bestbuy.model.bestbuytest;


import com.bestbuy.model.CategoriesPojo;
import com.bestbuy.model.testbase.TestBase;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;




public class CategoriesTest extends TestBase {

//    @BeforeClass
//    public static void init() {
//        RestAssured.baseURI = "http://localhost:3030/categories";
//    }

    @Test
    public void getAllCategories() {

        Response response =
                given()
                        .basePath("/categories")
                        .when()
                        .get();
        response.then().statusCode(200);
        response.prettyPrint();

    }
   @Test
   public void createNewCategory() {
       CategoriesPojo categoriesPojo = new CategoriesPojo();
       categoriesPojo.setId("Bt02354");
       categoriesPojo.setName("Beauty Salon");

       Response response =
               given()
                       .basePath("/categories")
               .header("Content-Type","application/json")
               .body(categoriesPojo)
               .when()
               .post();
       response.then().statusCode(201);
       response.prettyPrint();

   }//delete product id abcat0101000  so its shows error 404 status code id not found
   @Test
    public void deleteCategoriesById(){

       Response response =
               given()
                       .basePath("/categories")
                       .pathParam("id","abcat0101000")
                       .when()
                       .delete("/{id}");
       response.then().statusCode(404);
       response.prettyPrint();

   }
   @Test
    public void categoriesBasedOnCategoryId(){

       Response response =
               given()
                       .basePath("/categories")
                       .pathParam("id", "abcat0020001")
                       .when()
                       .get("/{id}");
       response.then().statusCode(200);
       response.prettyPrint();

   }
   @Test
    public void updateCategoriesById(){
       CategoriesPojo categoriesPojo = new CategoriesPojo();
       categoriesPojo.setName("Toshaba LED");

       Response response =
               given()
                       .basePath("/categories")
                       .header("Content-Type","application/json")
                       .body(categoriesPojo)
                       .when()
                       .patch("/abcat0100000");
       response.then().statusCode(200);
       response.prettyPrint();
   }


}
