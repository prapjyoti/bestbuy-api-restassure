package com.bestbuy.model.extractingresponce;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class ExtractTest {

    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        response = given()
                .when()
                .get("/stores")
                .then();

    }


    //    1. Extract the limit
    @Test
    public void extractTheLimit() {
        int limit = response.extract().path("limit");


        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The total number of limit is:" + limit);
        System.out.println("------------------End of Test---------------------------");

    }

    //2. Extract the total
    @Test
    public void extractTheTotal() {

        int total = response.extract().path("total");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println(" Extract the  total is:" + total);
        System.out.println("------------------End of Test---------------------------");

    }


    //3. Extract the name of 5th store
    @Test
    public void extractTheNameOfFifthStore() {
        String name = response.extract().path("data[4].name");


        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The store name is:" + name);
        System.out.println("------------------End of Test---------------------------");
    }

    //4. Extract the names of all the store
    @Test
    public void allStoreName() {
        List<String> storeName = response.extract().path("data.name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The names of all the store:" + storeName);
        System.out.println("------------------End of Test---------------------------");
    }

    //5. Extract the storeId of all the store
    @Test
    public void storeIdOfAllStore() {
        List<String> storeId = response.extract().path("data.id");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The storeId of all the store:" + storeId);
        System.out.println("------------------End of Test---------------------------");
    }

    //6. Print the size of the data list
    @Test
    public void printTheSizeOfDataList() {
        int size = response.extract().path("data.size()");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The size of the data is:" + size);
        System.out.println("------------------End of Test---------------------------");
    }

    //7. Get all the value of the store where store name = St Cloud
    @Test
    public void getValueOfTheStore() {
        List<HashMap<String, ?>> values = response.extract().path("data.findAll{it.name=='St Cloud'}");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Get all the value of the store where store name = St Cloud" + values);
        System.out.println("------------------End of Test---------------------------");

    }

    //8. Get the address of the store where store name = Minnetonka
    @Test
    public void getTheStoreAddress() {
        List<HashMap<String, ?>> storeAddress = response.extract().path("data.findAll{it.name=='Minnetonka'}.address");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Get the address of the store where store name = Minnetonka" + storeAddress);
        System.out.println("------------------End of Test---------------------------");

    }

    //9. Get all the services of 8th store
    @Test
    public void getAllTheServicesOfEightStore() {
        List<String> services = response.extract().path("data[7].services");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println(" Get all the services of 8th store" + services);
        System.out.println("------------------End of Test---------------------------");


    }

    //10. Get storeservices of the store where service name = Sony Experience
    @Test
    public void getStoreServicesName() {
        List<String> storeServicesName = response.extract().path("data.services[9].storeservices");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println(" Get storeservices of the store where service name = Sony Experience" + storeServicesName);
        System.out.println("------------------End of Test---------------------------");
    }

    //11. Get all the storeId of all the store
    @Test
    public void getAllStoreId() {
        List<Integer> storeId = response.extract().path("data.services.storeservices.storeId");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println(" Get all the storeId of all the store" + storeId);
        System.out.println("------------------End of Test---------------------------");

    }

    //12. Get id of all the store
    @Test
    public void getIdOfAllTheStore() {
        List<Integer> storeId = response.extract().path("data.services.storeservices.storeId");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println(" Get all the storeId of all the store" + storeId);
        System.out.println("------------------End of Test---------------------------");

    }

    //13. Find the store names Where state = MN
    @Test
    public void findStoreNameWhereStateName() {

        List<String> state = response.extract().path("data.findAll{it.state=='MN'}.name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println(" Find the store names Where state = MN" + state);
        System.out.println("------------------End of Test---------------------------");
    }

    //14. Find the Total number of services for the store where store name = Roseville
    @Test
    public void totalNumberOfServicesForStore() {

        int totalNumberServices = response.extract().path("data[2].services.size");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Find the Total number of services for the store where store name" + totalNumberServices);
        System.out.println("------------------End of Test---------------------------");
    }

    //15. Find the createdAt for all services whose name = “Windows Store”
    @Test
    public void createdAtForAllServices() {

        List<String> name = response.extract().path("data.findAll{it.services=='Windows Store'}.storeservices");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("  Find the createdAt for all services whose name = “Windows Store” " + name);
        System.out.println("------------------End of Test---------------------------");
    }

    //16. Find the name of all services Where store name = “Northtown”
    @Test
    public void nameAllServicesStoreName() {
        List<String> storeName = response.extract().path("data.findAll{it.name=='Northtown'}.services.name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println(" Find the name of all services Where store name = Northtown " + storeName);
        System.out.println("------------------End of Test---------------------------");

    }

    //17. Find the zip of all the store
    @Test
    public void findZipOfAllStore() {
        List<String> storeZip = response.extract().path("data.zip");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println(" Find the zip of all the store " + storeZip);
        System.out.println("------------------End of Test---------------------------");

    }

    //18. Find the zip of store name = maplewood
    @Test
    public void zipStoreName() {
        List<Integer> zip = response.extract().path("data.findAll{it.name=='Maplewood'}.zip");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println(" Find the zip of all the store = Maplewood " + zip);
        System.out.println("------------------End of Test---------------------------");
    }

    //19. Find the storeservices details of the service name = Samsung Experience
    @Test
    public void storeServicesDetails() {

        List<HashMap<String, ?>> storeServicesDetails = response.extract().path("data.findAll{it.name==' Samsung Experience'}.storeservices");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println(" Find the storeservices details of the service name = Samsung Experience are " + storeServicesDetails);
        System.out.println("------------------End of Test---------------------------");

    }

    // 20. Find the lat of all the stores
    @Test
    public void findLatOfAllStores() {
        List<String> lat = response.extract().path("data.lat");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println(" Find the lat of all the stores" + lat);
        System.out.println("------------------End of Test---------------------------");
    }
}
