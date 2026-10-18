package avanacare;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
public class curdOpration {
	@Test
	public void getUsers(){
		given()
		.when()
		.get("https://anvnacare.alwaysdata.net/api/users.php?page=2")
		.then()
		.statusCode(200)
		.log().all();
	}
}
