package org.rest;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class RestAss {

//	@Test
	public void get() {

		RestAssured.baseURI = "https://reqres.in/";

		RequestSpecification given = RestAssured.given();
		Response re = given.request(Method.GET, "api/users?page=2");
		int statusCode = re.statusCode();
		System.out.println(statusCode);

		ResponseBody body = re.getBody();
		String asPrettyString = body.asPrettyString();
		System.out.println(asPrettyString);

	}

	
//	@Test(priority=1)
	public void post() {
		RestAssured.baseURI = "https://reqres.in/";
		RequestSpecification given = RestAssured.given().header("Content-Type","application/json").body("{\"id\":2,\"email\":\"manoj@gmail.com\",\"first_name\":\"Manoj\",\"last_name\":\"kumar\"}");
		
		Response re =given.request(Method.POST,"api/users");
		int statusCode = re.statusCode();
		System.out.println(statusCode);
        
		ResponseBody body =re.getBody();
		String asPrettyString = body.asPrettyString();
		System.out.println(asPrettyString);
		
		
		
		
		
	}
	
	@Test(priority=2)
	public void put() {
		
		RestAssured
		.given().baseUri("https://reqres.in")
		.header("Content-Type","application/Json").body("{\"id\":2,\"email\":\"janet.weaver@reqres.in\",\"first_name\":\"Janet\",\"last_name\":\"Weaver\"}")
		.when().request().put("api/users/2")
		.statusCode()
	;
	 

	}
	
	
	
	
	
	

}
