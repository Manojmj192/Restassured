package org.rest;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Swagger {
	
	
	@Test
	public void getResponse() {

		
		RestAssured.baseURI ="petstore.swagger.io/v2";
		
	RequestSpecification req =	RestAssured.given();
	Response request = req.request(Method.GET,"/pet/findPetsByStatus");
	
	String asPrettyString = request.getBody().asPrettyString();
	System.out.println("my response for get request" + asPrettyString);
	
		
		
		
		

	}
	

}
