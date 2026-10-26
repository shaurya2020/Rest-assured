package request;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
public class curdOpration {
	@Test
	public void getUsers(){
		given()
		.when()
		.get("https://reqres.in/api/users/2")
		.then()
		.statusCode(200)
		.body("data.id", equalTo(2));
	}
	
	@Test
	public void postUsers() {
	    given()
	        .contentType("application/json")
	        .body("{\"name\":\"ayush\""
	        		+ ",\"job\":\"QA\"}")

	    .when()
	        .post("https://reqres.in/api/users/2")
	    .then()
	        .statusCode(201)
	        .body("name", equalTo("ayush"));
	}
	
	@Test
	public void putUser() {
	given()
		.header("Content-Type","application/json")
		.body("{\"job\":\"Lead\"}")

	.when()
		.put("https://reqres.in/api/users/2")
	.then()
        .statusCode(200);
	}
	
	@Test
	public void deleteUser() {
		given()
		.when()
			.delete("https://reqres.in/api/users/2")
		.then()
	        .statusCode(204);
		}
}
	
	

