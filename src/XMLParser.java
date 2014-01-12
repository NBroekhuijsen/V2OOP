import java.io.*;

import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;

import org.w3c.dom.*;

import javax.xml.parsers.*;

import org.xml.sax.*;

public class XMLParser {

	/**
	 * Method that reads a XML-file, and returns a Table that contains the
	 * information
	 * 
	 * @param file
	 * @return
	 */
	public static Table readXML(String file) {
		// initialize table to be filled with content of XML file
		Table t = new Table();
		try {
			// Create file to be parsed by document parser
			File xmlfile = new File(file);
			// create parser
			DocumentBuilder parser = DocumentBuilderFactory.newInstance()
					.newDocumentBuilder();
			// parse the file
			Document parsedfile = parser.parse(xmlfile);
			// normalize the parsed file (make it more user-friendly)
			parsedfile.getDocumentElement().normalize();

			NodeList cells = parsedfile.getElementsByTagName("CELL");
			for (int i = 0; i < cells.getLength(); i++) {
				// Get cell at list index i
				Node currentcell = cells.item(i);
				// read the elements "location" attributes row/column
				if (Node.ELEMENT_NODE == currentcell.getNodeType()) {
					Element cellinfo = (Element) currentcell;
					// get the row number from node attribute
					int tabley = Integer.parseInt(cellinfo.getAttribute("row"));
					// get the column number from the node attribute
					int tablex = Integer.parseInt(cellinfo
							.getAttribute("column"));
					// get content from node
					String content = cellinfo.getTextContent();
					if (content != null) {
						content = content.replace("\n", "");
					}
					// Make the content an Integer (if it is a number), easier
					// for
					// using it later on
					if (checkInt(content)) {
						Integer.parseInt(content);
					}
					// put content in table, with row/column inserted as x/y
					t.setContent(tablex, tabley, content);
				}

			}

		} catch (ParserConfigurationException e) {
			System.out.println("Fileparser could not be made");
		} catch (IOException f) {
			System.out.println("File could not be parsed");
		} catch (SAXException g) {
			System.out.println("Something went wrong in parsing the file");
		}
		return t;
	}

	/**
	 * Writes a table to a XML-file
	 * 
	 * @param t
	 *            - Output Table
	 * @param destination
	 *            - File Destination
	 */
	public static void writeXML(Table t, String destination) {

		try {
			// Create the XML document builder, and document that will be used
			DocumentBuilderFactory xmlBuilder = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder Builder = xmlBuilder.newDocumentBuilder();
			Document xmldoc = Builder.newDocument();

			// create Document node, and get it into the file
			Element Documentnode = xmldoc.createElement("SPREADSHEET");
			xmldoc.appendChild(Documentnode);

			// create element nodes, and their attributes (Cells, and row/column
			// data) and their content
			for (int i = 1; i < t.getSizeRow(); i++) {
				for (int j = 1; j < t.getSizeCol(i); j++) {
					Element cell = xmldoc.createElement("CELL");
					// set attributes
					cell.setAttribute("column", Integer.toString(j));
					cell.setAttribute("row", Integer.toString(i));
					// set content if string
					if (t.getContent(j, i) instanceof String) {
						cell.appendChild(xmldoc.createTextNode((String) t
								.getContent(j, i)));
					}
					// set content if integer
					else {
						cell.appendChild(xmldoc.createTextNode(Integer
								.toString((int) t.getContent(j, i))));
					}
					// append node to document node
					Documentnode.appendChild(cell);
				}
			}
			// Creating a datastream for the DOM tree
			TransformerFactory transformerFactory = TransformerFactory
					.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			// Indentation to make the XML file look better
			transformer.setOutputProperty(OutputKeys.METHOD, "xml");
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			// remove the java version
			transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION,
					"yes");
			DOMSource stream = new DOMSource(xmldoc);
			StreamResult target = new StreamResult(new File(destination));
			// write the file
			transformer.transform(stream, target);

		} catch (ParserConfigurationException e) {
			System.out.println("Can't create the XML document builder");
		} catch (TransformerConfigurationException e) {
			System.out.println("Can't create transformer");
		} catch (TransformerException e) {
			System.out.println("Can't write to file");
		}
	}

	/**
	 * Method to determine if a String is an integer
	 * 
	 * @param input
	 * @return
	 */
	public static boolean checkInt(String input) {
		try {
			Integer.parseInt(input);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}
}
