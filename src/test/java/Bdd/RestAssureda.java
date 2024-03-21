package Bdd;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.specification.MultiPartSpecification;

public class RestAssureda {

//	@Test(priority =0)
	public void getReq() {

		RestAssured.given().baseUri("https://betaapi.zippyform.io/api/v1/form/").when()
				.request(Method.GET, "builder/account/list").prettyPrint();

	}

//	@Test(priority =1)
	public void getCreatedAccount() {

		RestAssured.given().baseUri("https://betaapi.zippyform.io/api/v1/form/").when()
				.get("builder/account/list/7d2a90e0-36e6-49b8-a399-2d181309b73d").then().log().all().statusCode(200);

	}

    @Test
	public void postReq() {

		RestAssured.given().baseUri("https://betaapi.zippyform.io/api/v1/form/")
				.header("Content-Type", "multipart/form-data").multiPart("name", "Manojmj")
				.multiPart("admin_email", "manojnatarajan20@gmail.com").multiPart("timezone", "Asia/Calcutta")
				.multiPart("meta_detail", "191194").multiPart("is_payment_collect_enabled", "")
				.multiPart("primary_payment_gateway", "").multiPart("stripe_connect_redirect_url", "").when()
				.request(Method.POST, "builder/account/create").asPrettyString();

	}

//	@Test
	public void passingValuesinMap() {

		Map<String, String> map = new HashMap<String, String>();

		map.put("name", "Arumuganm");
		map.put("admin_email", "arugum@gmail.com");
		map.put("timezone", "Asia/Calcutta");
		map.put("Primary_payment_gateway", "stripe");

		RestAssured.given().baseUri("https://betaapi.zippyform.io/api/v1/form/")
				.header("Content-Type", "application/json").body(map).log().all()

				.when().request().post("builder/account/create").then().log().all();

	}


		
		
		
	

}
