package avanacare;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class curdOpration {
	@Test
	public void getUsers(){
		given()
		.when()
		.get("https://anvnacare.alwaysdata.net/login")
		.then()
		.log().all();
		
	}

}
