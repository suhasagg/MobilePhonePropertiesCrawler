import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


public class MergedWurfl91Mobile1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

                String [] stream1 = null;
                
                String [] stream2 = null;
                
                String keyword = null;
		
		        List<String> streamList1 = new ArrayList<String>();
		        
		        List<String> streamList2 = new ArrayList<String>(); 
		        
		        List<String> intersectionList = new ArrayList<String>();
		        
		        Map<String,Integer> modelMap = new HashMap<String,Integer>();
                 
		        BufferedReader in1 = null;
		/*        
		        try {
					System.setOut(outputFile("map91mobileswurfl3.txt"));
				} catch (FileNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
		     */   
		        BufferedWriter bw = null;
				FileWriter fw = null;

				File file = new File("mappedwurfl91mobiles.txt");

				// if file doesnt exists, then create it
				if (!file.exists()) {
					try {
						file.createNewFile();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				// true = append file
		        
		        
				
                
                try {
			    BufferedReader in = new BufferedReader(new FileReader("91mobiles5.txt"));
			    String str;
			    int i =0;
			    
			    
			    
			    while ((str = in.readLine()) != null){
			        
			    	System.out.println();
				    System.out.println();
			    	
			        stream1  = str.split("\\s+");	
			        for(int j= 0; j < stream1.length; j++ )
			        streamList1.add(stream1[j].trim());
			  //      System.out.println("91mobile"+str);
			        //        reachReportData = reachReport[5];  	
			        
			      
			    
		 
		
			    
			    String str1;
			    
			    try {
					in1 = new BufferedReader(new FileReader("wurfldatabasev2.txt"));
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			  //  int i = 0;
			    while ((str1 = in1.readLine()) != null){
			      
			        	stream2 = str1.split("\\s+");
			        	 for(int k=0; k < stream2.length; k++ )
						      streamList2.add(stream2[k].trim());
					//	 System.out.println("wurfl"+str1);       
				//Calculate intersection of list 1 and list 2 	
			    //Get intersection count, if greater than > 0 , put in map
			    
			     if(str1.contains("Speed 8") && str.toLowerCase().contains("oppo")) {
			    	 System.out.println("Oppo debug");
			    	// System.out.println(str1);
			    	 
			     }
			    	 
			    if(streamList1!=null && streamList2!=null && streamList1.isEmpty()==false && streamList2.isEmpty()==false )   	 
			    intersectionList = intersect(streamList1,streamList2);
			    if(intersectionList.size() > 0){
			    	
			    	modelMap.put(str1+":"+str,intersectionList.size());
			    	
			    	
			    }
			    
			    //Map will be populated here..			    
			    intersectionList.clear();
			    streamList2.clear();
			    }
			    
			    int maxValueInMap = 0;
			   
			    //Map is complete at this stage
			    if(modelMap.isEmpty()==false && modelMap!=null)
			     maxValueInMap = Collections.max(modelMap.values()); // This
				// will
				// return
                // max value in the
                // Hashmap
              
			      for (Entry<String, Integer> entry : modelMap.entrySet()) { // Iterate
					// through
					// hashmap
                  if (entry.getValue() == maxValueInMap && maxValueInMap >= 2) {
                      keyword = entry.getKey(); // Print the key
                      System.out.println(keyword+":"+maxValueInMap);
                   }

                   }
			       
			        fw = new FileWriter(file.getAbsoluteFile(), true);
					bw = new BufferedWriter(fw);
					bw.write(keyword);

					modelMap.clear();
				//	System.out.println(keyword);
			        streamList1.clear();
			      
			      
			  //    in1.close();
			    
			    }        
               
			    in1.close();
			    in.close();
                fw.close();
                bw.close();
                
                }    
			    catch(Exception e){
			    	
			    	
			    	
			    }
			
		
               
	
	
	
	}

	 private static List<String> intersect(List<String> A, List<String> B) {
         List<String> rtnList = new ArrayList<>();
         for(String dto : A) {
             if(B.contains(dto)) {
                 rtnList.add(dto);
             }
         }
         return rtnList;
     }
	
	
	 public static PrintStream outputFile(String name) throws FileNotFoundException {
	      
			return new PrintStream(new BufferedOutputStream(new FileOutputStream(name)));
		
	   }

	
}
