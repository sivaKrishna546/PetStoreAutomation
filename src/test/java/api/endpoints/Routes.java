package api.endpoints;


/* Swagger Pet Store End points
 * 
 * Create User (post) : https://petstore.swagger.io/v2/user
 * Get :  https://petstore.swagger.io/v2/user/{username}
 * Put Update:  https://petstore.swagger.io/v2/user/{username}
 * Patch :  https://petstore.swagger.io/v2/user/{username}
 * Delete :  https://petstore.swagger.io/v2/user/{username}
 * 
 */
public class Routes {

	public static String base_url="https://petstore.swagger.io/v2";
	
	// User Module
	
	public static String post_url = base_url+"/user";
	public static String get_url = base_url+"/user/{username}";
	public static String put_url = base_url+"/user/{username}";
	public static String delete_url = base_url+"/user/{username}";
	
	// Store Module
	   /* Here you create Store module urls */
	   
	// Pet Module
	  /* Here you create pet  module urls */
}
