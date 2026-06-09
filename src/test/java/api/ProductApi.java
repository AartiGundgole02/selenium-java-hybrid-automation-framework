package api;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
public class ProductApi extends ApiBase{
	
	public Response getAllProductList() {
		
		return given()
				.when()
				.get("/api/productsList");
		
	}

}
