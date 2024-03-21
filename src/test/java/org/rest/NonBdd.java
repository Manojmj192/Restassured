package org.rest;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class NonBdd {

//	@Test(enabled = true,priority=0)
	public void getResponse() {

		RestAssured.baseURI = "https://reqres.in/";

		RequestSpecification given = RestAssured.given();
		Response request = given.request(Method.GET, "api/users?page=2");
//		System.out.println(request.asPrettyString());
		int statusCode = request.statusCode();
		System.out.println("My status code" + statusCode);
		ResponseBody body = request.getBody();
		System.out.println(body.asPrettyString());
		String contentType = request.getContentType();
		System.out.println("my content type " + contentType);

	}

	
	@Test(priority=1)
	public void getParticularUser() {
		
		RestAssured.given().baseUri("https://reqres.in/")
		.when().get("api/users?page=2/7").prettyPrint();
		
		
		

	}
	
	
	
	
	
	
	
//	@Test(priority = 0)
	private void postReq() {

		RestAssured.baseURI = "https://reqres.in/";

		RequestSpecification given = RestAssured.given().header("Content-Type", "application/json").body(
				"{\"email\":\"manoj@zaigoinfotechcom\",\"first_name\":\"Manoj\",\"last_name\":\"Kumar\"}");

		Response request = given.request(Method.POST, "api/users");
		System.out.println(request.asPrettyString());

	}

//	@Test
	public void putReq() {

		RestAssured.baseURI = "https://reqres.in/";
		RequestSpecification spe = RestAssured.given().header("Content-Type", "application/json").body(
				"{\"id\":4,\"email\":\"manoj@zaigoinfotechcom\",\"first_name\":\"Manoj\",\"last_name\":\"Kumar\"}");
		Response res = spe.request(Method.PUT, "api/users/2");
		System.out.println(res);

	}

}
