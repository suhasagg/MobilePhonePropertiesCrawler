import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class JSONParser1 {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		
		System.setOut(outputFile("91mobiles5.txt"));
		
		JSONParser parser = new JSONParser();
		
		String text = "text1";
		JSONArray a = null;
	    JSONObject b = null;
		try {
			b = (JSONObject)parser.parse(new FileReader("C:\\Users\\Suhas Aggarwal\\Downloads\\91mobilespricedata.json"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	//	  for (Object o : b)
		//  {
		    JSONObject mobiles = (JSONObject) b;

		  /*
		    String name = (String) person.get("name");
		    System.out.println(name);

		    String city = (String) person.get("city");
		    System.out.println(city);

		    String job = (String) person.get("job");
		    System.out.println(job);

		  
		    */
		    
		    JSONObject results = (JSONObject) mobiles.get("results");

		    JSONArray products = (JSONArray)results.get("products");
		    
		    
		    BufferedWriter bw = null;
			FileWriter fw = null;

		    
		    
		    File file = new File("MobilePricedatabase2.txt");

			// if file doesnt exists, then create it
			if (!file.exists()) {
				try {
					file.createNewFile();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		    
		    String releasedate = null;
		    String content = null;
		    String[] dates = null;
		    
		    for(Object model: products)
		    {
		      
		    	JSONObject obj1 = (JSONObject)model;
		    	
		    	releasedate =  obj1.get("expected_release_date").toString();
		    	
		    	//System.out.println(obj1.get("brand_name")+" "+obj1.get("display_name")+":"+obj1.get("latest_price"));
		      
		    	if( releasedate!=null && releasedate.contains("2017")== false && releasedate.compareToIgnoreCase("2016-04")<0){
		    	if(releasedate.equals("0000-00-00")==false && releasedate !=null)
		    	dates = releasedate.split("-");
		    //	System.out.println(dates[1]);
		    	//System.out.println(releasedate);
		    	if(releasedate.equals("0000-00-00")==false && releasedate !=null)
		    	content = obj1.get("brand_name")+" "+obj1.get("display_name")+ " "+dates[0]+"_"+theMonth(Integer.parseInt(dates[1])-1);
		    	
		    	}
		    	System.out.println(content);
		    	}
				

			//	System.out.println(content);
		    }	
				
		   
		    	
		    	//  System.out.println(obj1.get("latest_price"));
		    	//   System.out.println(model.brand_name);
		   //   System.out.println((String)model.get("latest_price"));
		  
		//  }
	
	 public static PrintStream outputFile(String name) throws FileNotFoundException {
	      
			return new PrintStream(new BufferedOutputStream(new FileOutputStream(name)));
		
	   }

	 public static String theMonth(int month){
		    String[] monthNames = {"january", "february", "march", "april", "may", "june", "july", "august", "september", "october", "november", "december"};
		    return monthNames[month];
		}



}


