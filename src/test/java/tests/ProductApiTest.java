package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.ProductApi;
import io.restassured.response.Response;

public class ProductApiTest extends BaseTest{
@Test
	public void verifyProductApi(){
	test.info("Calling Products API");
		ProductApi product = new ProductApi();
		Response response = product.getAllProductList();
		Assert.assertEquals(response.getStatusCode(), 200);
		System.out.println(
		        response.getBody().asPrettyString());
		String body =
		        response.getBody().asString();
        test.pass("Products API validated successfully");

	}
	
}
