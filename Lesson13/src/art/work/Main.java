package art.work;

import java.util.List;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Main {

	public static void main(String[] args) {

		Document dom = null;
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			dom = db.parse("test.xml");

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return;
		}

		Element root = dom.getDocumentElement();

		System.out.println("TAG 1 = " + root.getTagName());

		NodeList nameNodeList = root.getElementsByTagName("name");
		Node nameNode = nameNodeList.item(0);
		System.out.println("TAG 1 = " + nameNode.getNodeName());

		// способ 1
		String name = nameNode.getFirstChild().getNodeValue();
		System.out.println("TAG 2 value: " + name);

		// способ 2
		String name2 = nameNode.getTextContent();
		System.out.println("TAG 2 value: " + name2);

		NodeList peopleNodeList = root.getElementsByTagName("people");
		Node peopleNode = peopleNodeList.item(0);
		System.out.println("TAG 3 value: " + peopleNode.getNodeName());
		
		NodeList elementsNodeList = peopleNode.getChildNodes();
		
		List<ElementMy> listMy = new ArrayList<>();
		
		for(int i = 0; i < elementsNodeList.getLength(); i++){
			
			Node node = elementsNodeList.item(i);
			if(node.getNodeType() != Node.ELEMENT_NODE){
				continue;
			}
			
			ElementMy elementMy = new ElementMy();
			Element element =(Element) node;
			
			//name
			NodeList nameNodeListE1 = element.getElementsByTagName("name");
			Node nameElementE1 = nameNodeListE1.item(0);
			String peopleName = nameElementE1.getFirstChild().getNodeValue();
			System.out.println("NAME = " + peopleName);
			elementMy.setName(peopleName);
			
			//age
			String agePeople = element.getElementsByTagName("age").item(0).getTextContent();
			System.out.println("AGE = " + agePeople);
			elementMy.setAge(Integer.valueOf(agePeople));
			
			//isDegree
			String isDegreePeople = element.getElementsByTagName("isDegree").item(0).getTextContent();
			System.out.println("isDegree = " + isDegreePeople);
			elementMy.setDegree(Boolean.valueOf(isDegreePeople));
			
			//записываем элемент в массив
			listMy.add(elementMy);
			
		}
		
		System.out.println("FINAL ARRAY = " + listMy);

	}
	
	//private static String () {
	

}












