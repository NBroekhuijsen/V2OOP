public class XMLReadertest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Table t = XMLParserM.readXML("spreadsheet.xml");
		System.out.println(t.printMap(5, 5));
	}
}