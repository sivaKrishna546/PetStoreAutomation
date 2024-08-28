package api.endpoints;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.ResourceBundle;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import api.payload.User;

public class UserEndPoints2 {

 // Method create for gettng URL's from properties file
	static ResourceBundle getURL()
 {
	 ResourceBundle routes=ResourceBundle.getBundle("routes"); // routes.properties file
	 return routes;
 }


// User Endponits
// Created  to perform Create, Read, Update, Delete requests of the user API

	
 public static Response createUser(User payload) // payload Request body
  {
	 
	 String post_url=getURL().getString("post_url");
	 Response response=
      given()
	     .contentType(ContentType.JSON)
	     .accept(ContentType.JSON)
	     .body(payload)
	  .when()
	  	 .post(post_url);
	 return response;
  }
 
  public static Response getUser(String userName )
  {
	  String get_url=getURL().getString("get_url");
	  Response response=
			  given()
			    .pathParam("username",userName)
			    
			  .when()
			  	.get(get_url);
	 
	  return response;
  }
  
  public static Response updateUser(String userName,User payload) // payload Request body
  {
	  String update_url=getURL().getString("put_url");
	 Response response=
      given()
	     .contentType(ContentType.JSON)
	     .accept(ContentType.JSON)
	     .pathParam("username", userName)
	     .body(payload)
	  .when()
	  	 .put(update_url);
	 return response;
  }
  
  public static Response deleteUser(String userName)
  {
	  String delete_url=getURL().getString("delete_url");
	  Response response=
			  given()
			   		.pathParam("username", userName)
			  .when()
			    	.delete(delete_url);
	  return response;
  }
}
