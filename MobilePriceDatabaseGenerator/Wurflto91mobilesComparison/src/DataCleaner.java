import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;


public class DataCleaner {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		
		
		try {
				System.setOut(outputFile("map91mobileswurfl21.txt"));
				} catch (FileNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
		        
		
	
		
			    BufferedReader in = new BufferedReader(new FileReader("map91mobileswurfl6.txt"));
			    String str;
			    String str1 = "";
			    int i =0;
			    String [] stream1= null;
			    int flag=0;
			    int flag1= 0;
			    while ((str = in.readLine()) != null){
			        
			 //  	System.out.println(str);
			//	    System.out.println();
			    	
			    	flag1=0;
	            	flag=0;
			    	str1="";
			        stream1  = str.split("\\s+");	
			        for(int j= 0; j < stream1.length; j++ ){
			        	
			        	if(stream1[j].contains("_")==true){
			        		
			        	    if(flag > 0){
			        	    	
			        	    	if(stream1[j].equals(str1))
			        	        flag1++;
			        	    
			        	    }
			        		str1 = stream1[j];
			        		flag++;
			        	}
			       
			            if(flag1==1){
			            	
			            	
			            	System.out.println(str);
			            	
			            }
			        }
			        
			        
			        
			        //      System.out.println(str);
			        //        reachReportData = reachReport[5];  	
			        
			      
			    
			    }
	
		
	
	
	}

	
	 public static PrintStream outputFile(String name) throws FileNotFoundException {
	      
			return new PrintStream(new BufferedOutputStream(new FileOutputStream(name)));
		
	   }

	
	
}
