package api;

import io.restassured.RestAssured;

public class ApiBase {

	static {
	RestAssured.baseURI = "https://automationexercise.com";
	}
}
