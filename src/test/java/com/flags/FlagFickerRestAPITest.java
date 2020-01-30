package com.flags;

import java.io.IOException;

 
import org.testng.annotations.Test;

import io.restassured.RestAssured;
 

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
 
public class FlagFickerRestAPITest {

	// given().config(config).post("http://localhost:8884");
 
	@Test
	public void getCountriesListSuccess() {

		given().when().get("http://localhost:8080/listing?continent=Asia").then().assertThat().body("countries[0].name",
				hasItems("India", "China", "Indonesia"));
	}

	@Test
	public void getContinentListSuccess() {

		RestAssured.baseURI = "http://localhost";
		RestAssured.port = 8080;

		get("/listing?continent=Europe").then().body("countries[0].name",
				hasItems("Russia", "Germany", "UK", "Italy", "France"));
	}

	@Test
	public void getFlagListSuccess() {
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = 8080;

		get("/listing/flag?continent=asia&country=India").then().body("",
				hasItems("🇮🇳"));
	}
 	    @Test
 	    public void getAllListSuccess() {
 	        RestAssured.baseURI = "http://localhost";
 	        RestAssured.port = 8080;
 	
 	    	get("/list/Europe").then()
 	    	.body("countries[0].name", hasItems("Russia", "Germany","UK","Italy","France"));
 	         
 	    }
}
