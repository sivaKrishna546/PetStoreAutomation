package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.payload.User;
import io.restassured.response.Response;

public class UserTests {
	
	
	
	Faker faker;
	User userPayload;
	
	public Logger logger;
	 
	@BeforeClass
	
	public void setUp()
	{
		faker=new Faker();
		userPayload=new User();
		
		
		  userPayload.setId(faker.idNumber().hashCode());
		  userPayload.setUserName(faker.name().username());
		  userPayload.setFirstName(faker.name().firstName());
		  userPayload.setLastName(faker.name().lastName());
		  userPayload.setEmail(faker.internet().safeEmailAddress());
		  userPayload.setPassword(faker.internet().password(5,10));
		 userPayload.setPhone(faker.phoneNumber().cellPhone());
		 userPayload.setUserStatus(0);
		 
		 
		 
		/*
		 * userPayload.setId(31); userPayload.setUserName("AMHS1Test");
		 * userPayload.setFirstName("TH"); userPayload.setLastName("TS");
		 * userPayload.setEmail("T@example.com"); userPayload.setPassword("1213313");
		 * userPayload.setPhone("1212121"); userPayload.setUserStatus(0);
		 */
		

       // logs
		 
		 logger=LogManager.getLogger(this.getClass());
		 logger.debug("***** debugging********");
	}
	
	@Test(priority=1, description="Create User")
	
	public void testPostUser()
	{
		logger.info("***********Creating User ***********");
		Response response=UserEndPoints.createUser(userPayload);
		//response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("***********User Created Successfully ***********");
	}
	
	
	
	@Test(priority=2 , description="Get User By Name")
	public void testGetUserByName()
	{
		
		logger.info("******* Get User By Name********");
		Response response =UserEndPoints.getUser(this.userPayload.getUserName());
		//response.then().log().all();
		
		Assert.assertEquals(response.statusCode(), 200);
		logger.info("******* End of Get User by Name********");
	}
	
	@Test(priority=3, description="Update User By Name")
	public void testUpdateUserByName()
	{
		logger.info("***** Update User******");
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		Response response=UserEndPoints.updateUser(this.userPayload.getUserName(), userPayload);
		//response.then().log().all();
		Assert.assertEquals(response.statusCode(), 200);
		logger.info("***** User Updated Successfully******");
		
		
	}
	@Test (priority=4, description="Delete User By Name")
  public void testDeleteUserName()
  {
		logger.info("***** Delete  User******");
		Response response= UserEndPoints.deleteUser(this.userPayload.getUserName());
	// response.then().log().all();
	 Assert.assertEquals(response.statusCode(), 200);
	 
	 logger.info("***** User deleted successfully******");
  }
}
