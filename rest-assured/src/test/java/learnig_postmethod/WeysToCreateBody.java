package learnig_postmethod;

import java.util.HashMap;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

public class WeysToCreateBody {
	@Test
	public void byHashMap() {
		String name ="Tanit";
		
		HashMap<String, Object> data =new HashMap<>();
		data.put("name", name);
		data.put("eamil", "tanti@123ggmail.com");
		data.put("Phone No","989812983");
		data.put("password","anti@123");
		data.put("role","QA Engineer");

		given()
		.baseUri("https://anvnacare.alwaysdata.net")
		.contentType("application/json")
		.body(data)
		.when()
		.post("/api/user.php")
		.then()
		.log().all()
		.statusCode(201)
		.body("succes",equalTo(true))
		.body("user.name",equalTo(name))
		;
	}

}
