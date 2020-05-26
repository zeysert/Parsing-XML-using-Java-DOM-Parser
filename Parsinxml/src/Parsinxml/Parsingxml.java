package Parsinxml;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class Parsingxml {

	public static void main(String[] args)
	{

		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		
		try 
		{
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc=builder.parse("employees.xml");
			NodeList employeeList=doc.getElementsByTagName("employee");
			for(int i=0;i<employeeList.getLength();i++)
			{
				Node r=employeeList.item(i);
				if(r.getNodeType()==Node.ELEMENT_NODE)
				{
					Element employee=(Element) r;
					String id=employee.getAttribute("id");
					NodeList nameList=employee.getChildNodes();
					for(int j=0;j<nameList.getLength();j++)
					{
						Node n =nameList.item(j);
						if(n.getNodeType()==Node.ELEMENT_NODE)
						{
							Element name=(Element) n;
							System.out.println("employee" + id + " :"+name.getTagName()+"=" + name.getTextContent());
							
						}
					}
					
					
				}
			}
			
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
