package by.mopahta.task01.dao.impl;


import java.util.ArrayList;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;


import by.mopahta.task01.dao.ApplianceDAO;


public class FileApplianceDAOImpl implements ApplianceDAO{
	private static final String FILE_PATH = "DataBase.xml";
	private Document doc;

	public ArrayList<ArrayList<String>> find(String groupName) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			doc = builder.parse(FILE_PATH);

			ArrayList<ArrayList<String>> objectsInformation = new ArrayList<>();
			NodeList elementList = doc.getElementsByTagName(groupName);
			for (int i = 0; i < elementList.getLength(); i++) {
				Node p = elementList.item(i);
				if (p.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) p;
					NodeList nameList = element.getChildNodes();
					ArrayList<String> currentObjectInfo = new ArrayList<>();
					for (int j = 0; j < nameList.getLength(); j++) {
						Node n = nameList.item(j);
						if (n.getNodeType() == Node.ELEMENT_NODE) {
							Element name = (Element) n;
							currentObjectInfo.add(name.getTextContent());
						}
					}
					objectsInformation.add(currentObjectInfo);
				}
			}

			return objectsInformation;
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
