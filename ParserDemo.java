import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import com.psl.emp.Address;


public class ParserDemo {

	static{
		LogManager.getLogManager().addLogger(Logger.getLogger("ParserDemo"));
	}

	
	private Logger logger=null;
	{
		logger=LogManager.getLogManager().getLogger("ParserDemo");
		try {
			logger.addHandler(new FileHandler("C:\\parser.xml"));
		} catch (SecurityException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		ParserDemo demo=new ParserDemo();
			demo.testSaxParser();
		//  demo.testDOMparser();

	}

	public void testDOMparser() {

		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();

		try {
			DocumentBuilder builder= factory.newDocumentBuilder();
			Document doc=builder.parse(new File("./src/emp.xml"));
			System.out.println(doc);

			scanDocument(doc);
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void scanDocument(Node node) {
		short type=node.getNodeType();
		System.out.println("TYpe of node is : "+type);

		switch (type) {
		case Node.DOCUMENT_NODE :{
			System.out.println("This is document node :"+node);
			System.out.println("Node name: "+node.getNodeName());
			System.out.println("Node value :"+ node.getNodeValue());

			Document doc=(Document)node;
			scanDocument(doc.getDocumentElement());
			break;
		}
		case Node.ELEMENT_NODE:{
			System.out.println("The Element Node"+node.getNodeName());
			NamedNodeMap nnm=node.getAttributes();
			for (int i = 0; i < nnm.getLength(); i++) {
				Node attrnode=nnm.item(i);
				System.out.println("The attributes :"+attrnode.getNodeName());
				System.out.println("The attributes :"+attrnode.getNodeValue());
				scanDocument(attrnode);
			}

			NodeList list=node.getChildNodes();
			for (int i = 0; i < list.getLength(); i++) {
				Node childnode=list.item(i);
				System.out.println("The Child Node :"+childnode.getNodeName());
				scanDocument(childnode);
			}
			break;
		}
		case Node.ATTRIBUTE_NODE:{
			System.out.println("The Attribute Node "+node.getNodeName());
			System.out.println("The Attribute Node value:"+node.getNodeValue());
			break;
		}
		case Node.TEXT_NODE:{
			System.out.println("The Text Node "+node.getNodeName());
			System.out.println("The Text Node value:"+node.getNodeValue());
			break;
		}
		default:
			break;
		}
	}


	// Method for SAX Parser
	public void testSaxParser() {
		logger.info("inside Test SAX Parser Class");
		
		SAXParserFactory factory= SAXParserFactory.newInstance();
		
		try {

			SAXParser parser=factory.newSAXParser();
			parser.parse(new File("./src/emp.xml"),new MySaxHandeler());
			logger.warning("Warning Error may occure");
			logger.severe("Exiting");

		} catch (ParserConfigurationException e) {
			logger.info("Error");
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}


/* New class Extending Default handler */

class MySaxHandeler extends DefaultHandler{
	Employee emp;
	Address addr;
	String elementName="";

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {

		String text=new String(ch,start,length);
		//System.out.println("Text is : "+ text);
		if (elementName.equals("role")) {
			emp.setRole(text);
			//		System.out.println(emp);
		}
	}


	@Override
	public void startElement(String uri, String localname, String element,
			Attributes attributes) throws SAXException {

		//	System.out.println("The start element for: "+ element);

		// if new Employee root is found create ne instance of employee
		if(element.equals("Employee")){

			emp=new Employee();
			addr=new Address();
		}

		for (int i = 0; i < attributes.getLength(); i++) {

			System.out.println(attributes.getQName(i)+"="+attributes.getValue(i));
			elementName=attributes.getQName(i);
			if(attributes.getQName(i).equals("id")){
				emp.setId(Integer.parseInt(attributes.getValue(i)));
			}else if(attributes.getQName(i).equals("firstname")){
				emp.setFname(attributes.getValue(i));
			}else if(attributes.getQName(i).equals("lastname")){
				emp.setLname(attributes.getValue(i));
			}else if(attributes.getQName(i).equals("city")){
				addr.setCity(attributes.getValue(i));
			}else if(attributes.getQName(i).equals("zip")){
				addr.setZip(attributes.getValue(i));
				emp.setAddr(addr);
			}

		}
		System.out.println(emp);
	}

	@Override
	public void endElement(String uri, String localName, String qName)
	throws SAXException {
		//	System.out.println("End element for"+qName);
	}

	@Override
	public void startDocument() throws SAXException {
		System.out.println("Inside Start Document");	
	}

	@Override
	public void endDocument() throws SAXException {
		System.out.println("inside End Document");
	}
}