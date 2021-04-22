

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class XMLParser {
   

     
    	  public static void main(String argv[]) {

    		    try {

    			File fXmlFile = new File("C://wurfl.xml");
    			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
    			Document doc = dBuilder.parse(fXmlFile);

    			
    		    try {
					System.setOut(outputFile("wurfldatabasev2.txt"));
				} catch (FileNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
		        
    			
    			
    			//optional, but recommended
    			//read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
    			doc.getDocumentElement().normalize();

    			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

    			NodeList nList = doc.getElementsByTagName("capability");
    			
    			String name = "";
    			
    			String content = "";

    			System.out.println("----------------------------");

    			for (int temp = 0; temp < nList.getLength(); temp++) {

    				Node nNode = nList.item(temp);

    			//	System.out.println("\nCurrent Element :" + nNode.getNodeName());

    				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

    					Element eElement = (Element) nNode;

    					NamedNodeMap node_attr = nNode.getAttributes();
    					for (int i = 0; i < node_attr.getLength(); ++i)
    					{
    					    Node attr = node_attr.item(i);
    					 //   if(attr.getNodeName().equals("brand_name"))
    					  //  System.out.println(attr.getNodeName() + " = \"" + attr.getNodeValue() + "\"");
    					/*    
    					    if(attr.getNodeName().equals("model_name"))
    	    					    System.out.println(attr.getNodeName() + " = \"" + attr.getNodeValue() + "\"");
    					    
    					    if(attr.getNodeName().equals("marketing_name"))
    	    					    System.out.println(attr.getNodeName() + " = \"" + attr.getNodeValue() + "\"");
    					
    					*/
    					
    					 if(name.equals("brand_name")){   
    					    //System.out.println(attr.getNodeValue());
    					    content = attr.getNodeValue();
    					 }
    					    
    					 if(name.equals("model_name")) {  
     					    //System.out.println(attr.getNodeValue());
    					    content = content + " "+ attr.getNodeValue();
    					 }
    					 
    					
    					if(name.equals("marketing_name")) {  
     					   // System.out.println(attr.getNodeValue());
     					    content = content +" "+ attr.getNodeValue();
    					    
    					}   
     					  
    					if(name.equals("release_date")) {  
     					    //System.out.println(attr.getNodeValue());
    					    content = content + " "+ attr.getNodeValue();
    					    System.out.println(content);
    					    content="";
    					
    					}
    					
    					
    					
    					
    					
    					name =  attr.getNodeValue();
    					 
    					
    					}
    					
    				//	System.out.println("brand_name : " + eElement.getAttributes());
    				//	System.out.println("First Name : " + eElement.getElementsByTagName("firstname").item(0).getTextContent());
    				//	System.out.println("Last Name : " + eElement.getElementsByTagName("lastname").item(0).getTextContent());
    				//	System.out.println("Nick Name : " + eElement.getElementsByTagName("nickname").item(0).getTextContent());
    				//	System.out.println("Salary : " + eElement.getElementsByTagName("salary").item(0).getTextContent());

    				}
    			}
    		    } catch (Exception e) {
    			e.printStackTrace();
    		    }
    		  }
 
    		 public static PrintStream outputFile(String name) throws FileNotFoundException {
    		      
    				return new PrintStream(new BufferedOutputStream(new FileOutputStream(name)));
    			
    		   }




}
