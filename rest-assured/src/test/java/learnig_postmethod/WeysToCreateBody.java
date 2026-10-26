package learnig_postmethod;

import java.io.File;
import java.util.HashMap;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class WeysToCreateBody {
	
	RequestSpecification reqSpec = new RequestSpecBuilder()
			.setBaseUri("https://anvnacare.alwaysdata.net")
			.setContentType(ContentType.JSON)
			.build();
	
//	1> by hashmap
	@Test
	public void byHashMap() {
		String name ="Arun singha";
		
		HashMap<String, Object> data = new HashMap<>();
		data.put("name", name);
		data.put("email", "arunsinghaa123@gmail.com");
		data.put("phone","0868144583");
		data.put("password","anti@123");
		data.put("role","QA Engineer");

		given()
		.baseUri("https://anvnacare.alwaysdata.net")
			.contentType("application/json")
			.body(data)
		.when()
		 	.post("/api/users.php")
		.then()
			.log().all()
			.statusCode(201)
			.body("success",equalTo(true))
			.body("user.name",equalTo(name));	
	}

//	2>by json object
	@SuppressWarnings("unchecked")
	@Test
	public void byJsonObject() {
		String name ="Ayush singh";
		
		JSONObject data = new JSONObject();
//		data.put("name", name);
		data.put("email", "Ojasmishra@gmail.com");
		data.put("phone", "0987654321");
		data.put("password", "Ojasmishra1234");
		data.put("role", "user");
		
		given()
			.body(data.toString())
		.when()
			.post("/api/users.php")
		.then()
		.statusCode(201)
		.body("message", containsString("user created successfully"))
		.body("user.name", equalTo(name))
		.log().all();
	}
	
//	3>by pojo
	@Test
	public void byPOJO() {
		
		String name ="Ayush singh";
		
		User data = new User(name,"ayus23@gmail.com", "9130405070", "ayuu@23", "user");
				given()
				.body(data)
				.when()
					.post("/api/users.php")
				.then()
					.statusCode(201)
					.body("succes", equalTo(true))
					.body("message", containsString("User crested succesfully"))
					.body("user.name", equalTo(name))
					.log().all();
	}
	

//	4>by json file
public void byJsonFile() {
	File data = new File (".src/test/resources/user.json");
//	FileReader fr = new FileReader("./src/test/resources/user.json");
//	JSONTokener jt = new JSONTokener(fr);
//	JSONObject data = new JSONObject(jt);
	given()
		.body(data)
	.when()
		.post("")
	.then()
		.statusCode(2001)
		.body("success", equalTo(true))
		.body("message", containsString("User created successfully"))
		.body("user.name", equalTo("Raju"))
		.log().all();
}
}
