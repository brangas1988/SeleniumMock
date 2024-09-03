package org.apistep;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.example.common.RequestLoggingFilter;
import org.example.common.RestAssuredSetUp;
import org.example.pojoVo.product;
import org.json.JSONObject;

import java.util.*;
import java.io.File;
import java.io.IOException;
import java.sql.Array;

public class apistep {


    private Scenario scenario;
    RestAssuredSetUp reste=new RestAssuredSetUp();
    @Before
    public void before(Scenario scenario){
        this.scenario=scenario;
        reste.setupassureddefault();
    }

    @Given("insert call for products")
    public void insertCallForProducts() {
        scenario.log("Empty String");
    }

    @When("enter details {int} {string} {string}")
    public void enterDetails(int arg0, String arg1, String arg2) throws IOException {

        product prod=new product();
        ObjectMapper mapper=new ObjectMapper();
        //JSON
        prod=mapper.readValue(new File("C:\\SeleniumProj\\SeleniumProj\\src\\test\\resources\\insert.json"), product.class);
        //given().
        prod.productid=arg0;
        prod.name=arg1;
        prod.description=arg2;

        //RestAssured.baseURI="http://localhost:8080/insert";
        Response res= RestAssured.given().contentType("application/json").filter(new RequestLoggingFilter(scenario)).
                body(mapper.writeValueAsString(prod)).when().post("/insert");
        scenario.log(res.asPrettyString());
        System.out.println(res.toString());

        if(res.statusCode()==200){
            System.out.println("Success");
        }

    }

    @Then("record should be inserted")
    public void recordShouldBeInserted() {

        System.out.println("Dummy Rules");
    }

    @Given("records inserted")
    public void records_inserted() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Dummy Rules");
    }
    @When("enter details details with {int}")
    public void enter_details_details_with(Integer int1) {
        product prod=new product();

        Response res= RestAssured.given().contentType("application/json").queryParam("productid",2).
                filter(new RequestLoggingFilter(scenario))
              .when().get("/product");
        scenario.log(res.asPrettyString());
        System.out.println(res.toString());
        System.out.println( res.then().extract().body().jsonPath().getString("name"));
        if(res.statusCode()==200){
            System.out.println("Success");
        }

    }
    @Then("record retrieved successfully")
    public void record_retrieved_successfully() {
        System.out.println("Retrieved Successfully");
    }

    @Given("available records in Database")
    public void available_records_in_database() {
        Response res= RestAssured.given().contentType("application/json").
                filter(new RequestLoggingFilter(scenario))
                .when().get("/getproducts");
        scenario.log(res.asPrettyString());
    }
    @When("getproducts endpoint called")
    public void getproducts_endpoint_called() {
        product prod=new product();

        Response res= RestAssured.given().contentType("application/json").
                filter(new RequestLoggingFilter(scenario))
                .when().get("/getproducts");

        scenario.log(res.asPrettyString());
        //RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
       Headers heads= res.headers();
       for(Header header:heads){

           System.out.println(header.getName() + ": " + header.getValue());
       }
       // List<product> productarr=res.as(ArrayList.class);
        List<product> products = res.jsonPath().getList("", product.class);
        for(product prodlist:products){

            scenario.log(prodlist.name+"-" +prodlist.description );
            System.out.println(prodlist.description);
        }

        //System.out.println(res.then().log().all().toString());
        System.out.println( res.then().extract().body().jsonPath().getString("name"));
        if(res.statusCode()==200){
            System.out.println("Success");
        }

    }
}
