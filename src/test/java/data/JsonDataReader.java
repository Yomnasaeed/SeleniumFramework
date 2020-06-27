package data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class JsonDataReader {
	
	public String firstName, lastName, email, password;
	
	// i have to download json library from the maven repository (search for json google the find json.simple) and paste the dependency in the pom.xml
	
	public void jsonReader() throws FileNotFoundException, IOException, ParseException
	{
		String filePath = System.getProperty("user.dir")+"\\src\\test\\java\\data\\userData.json";
		
		File srcFile = new File(filePath);
		JSONParser parser = new JSONParser();			//choose json parser eli gaya mn simple
		JSONArray jarray = (JSONArray) parser.parse(new FileReader(srcFile));
		
		for (Object jsonObj : jarray) {
			JSONObject person = (JSONObject) jsonObj;
			firstName = (String) person.get("firstname");  //L.H.S eli howa el string eli fou2 w el R.H.s eli howa eli gowa el json file
			System.out.println(firstName);
			
			lastName = (String) person.get("lastname");
			System.out.println(lastName);
			
			email = (String) person.get("email");
			System.out.println(email);
			
			password = (String) person.get("password");
			System.out.println(password);

		}
		
		
	}

}
