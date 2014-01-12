/**
 * Class to create a Table in which all the information from a XML can be stored
 */
import java.util.*;

public class Table {

	private ArrayList<ArrayList<Object>> table;

	/**
	 * Constructor to create the table
	 */
	public Table() {
		table = new ArrayList<ArrayList<Object>>();
	}

	/**
	 * Method to get the content from a cell in the table
	 * 
	 * @param x
	 *            - Variable that indicates the Row (x - axis) of the cell that
	 *            content is to be read from
	 * @param y
	 *            - Variable that indicates the Column (y - axis) of the cell
	 *            that content is to be read from
	 * @return returns the content of the cell as an Object
	 */
	public String getContent(Coor coordinate) {
		try {
			int x = coordinate.getX();
			int y = coordinate.getY();
			if (this.getSizeRow() >= x) {
				if (this.getSizeCol(x) >= y) {
					return (String) table.get(y).get(x);
				}
			}
		} catch (IndexOutOfBoundsException e) {
			System.out.print("There is no such cell, so: ");
		}
		return null;
	}

	/**
	 * Method to add content to the end of a row
	 * 
	 * @param x
	 * @param y
	 * @param content
	 */
	public void addContent(int y, Object content) {
		this.hasRow(y);
		table.get(y).add(content);
	}

	/**
	 * Method to set the content of a cell in the table
	 * 
	 * @param x
	 *            - Variable that specifies the Row of the cell
	 * @param y
	 *            - Variable that specifies the Column of the cell
	 * @param content
	 *            - Content to be put in the cell
	 */
	public void setContent(Coor coordinate, Object content) {
		this.hasRow(coordinate.getY());
		this.hasCol(coordinate.getX(), coordinate.getY());
		table.get(coordinate.getY()).set(coordinate.getX(), content);
	}

	/**
	 * check if table has y rows, otherwise creates row till it has
	 * 
	 * @param y
	 *            - number of rows to be checked
	 */
	public void hasRow(int y) {
		while (table.size() <= y) {
			table.add(new ArrayList<Object>());
		}
	}

	/**
	 * Checks if specified row has the number of columns, otherwise creates the
	 * amount
	 * 
	 * @param x
	 * @param y
	 */
	public void hasCol(int x, int y) {
		while (table.get(y).size() <= x) {
			table.get(y).add(null);
		}
	}

	/**
	 * Method to get the size of the table (amount of rows)
	 */
	public int getSizeRow() {
		return table.size();
	}

	/**
	 * Method to get the size of the table (amount of columns)
	 * 
	 * @param i
	 *            - number of the row you want the Column amount from
	 */
	public int getSizeCol(int x) {
		return table.get(x).size();
	}

	/**
	 * method CellReader
	 * 
	 * checks if cellcontent begins with "=" If so, calls methods to perform
	 * conversions and calculations
	 * 
	 * @param cell
	 * @return String (either with the calculation result or the original
	 *         cellcontent
	 */
	public String cellReader(String cell) {
		// trim cell from empty spaces at beginning and ending
		cell = cell.trim();
		// String where the content of cell will be kept while being processed
		// (until become the index)
		String nwcell;
		// check if cellcontent starts with "="
		if (cell.charAt(0) == ('=')) {
			// cut "=", the remaining will be our index and operations
			nwcell = cell.replaceFirst("=", "");
			nwcell = nwcell.trim();

			// remove brackets and function
			String index = functionTrimmer(nwcell);
			String function = getFunction(nwcell);

			// Expand index (remove ":" and replace them with "," and the right
			// indexes
			ArrayList<Coor> cellIndexes = indexExpander(index);

			// Arraylist for the cellcontent objects
			ArrayList<Object> result = new ArrayList<Object>();

			// Get the cellcontents and put them into an ArrayList
			for (Coor nwcoor : cellIndexes) {

				result.add(this.getContent(nwcoor));
			}

			// Call the method to perform calculations
			return callFunction(function, result);
			// TO DO: RETURN IN THE RIGHT CELL!!
			// TO DO: IF EXCEPTION THROWN, PUT #ERROR! IN CELL AND PUT EXCEPTION
			// MESSAGE IN EXCEPTIONMESSAGELINE

		}

		else
			return cell;

	}

	/**
	 * method functionTrimmer removes String function and brackets from
	 * cellcontent Receives input as: "FUNCTION(X1,Y2)" (So "=" is already
	 * removed) Returns input as: X1,Y2
	 * 
	 * @param input
	 * @return String
	 */
	public static String functionTrimmer(String input) {

		String function = getFunction(input);

		if (functionExist(function)) {
			// remove String function and brackets
			input = input.replace(function, "");
			input = input.replace(" ", "");
			input = input.replaceFirst("(", "");
			if(!(input.substring(input.length()-1).equals(")"))){
				input = input.substring(0, input.length()-1);
			}
			for(int i = 0; i < input.length(i)){
				if(Character.isLetter(char))
			}
		}

		return input;
	}

	/**
	 * method getFunction returns the name of the function method which will
	 * have to be used Receives input as: "FUNCTION(X1,Y1)" ("=" has already
	 * been removed)
	 * 
	 * @param input
	 * @return
	 */
	public static String getFunction(String input) {
		String function = input.split("\\(")[0];

		return function;

	}

	/**
	 * method indexExpander Sorts indexes alphabetically and numerically and
	 * replaces all ":" with ",", while adding the indexes between the values
	 * next to ":" Receives input as: "X1,/: Y1" ("=", function and brackets are
	 * already removed) Returns indexes containing only comma's (only ",", no
	 * more ":")
	 * 
	 * @param index
	 */
	public static ArrayList<Coor> indexExpander(String index) {
		ArrayList<Coor> indexes = new ArrayList<Coor>();
		String[] temp = new String[2];

		char x1;
		int y1;
		char x2;
		int y2;

		// Cut out white spaces
		index = index.replace(" ", "");

		// Get indexes separated bij commas in an arraylist
		ArrayList<String> items = new ArrayList<String>(Arrays.asList(index
				.split(",")));

		for (String item : items) {
			// check if stringpiece contains ":"
			if (item.contains(":")) {
				// separate by ":" into two stringpieces
				temp = item.split(":");

				// get coordinations in the right parameters
				x1 = temp[0].substring(0, 1).charAt(0);
				y1 = Integer.parseInt(temp[0].substring(1, 2));
				x2 = temp[1].substring(0, 1).charAt(0);
				y2 = Integer.parseInt(temp[1].substring(1, 2));

				// loop for the char
				for (char a = x1; a <= x2; a++) {
					// loop for the int
					for (int j = y1; j <= y2; j++) {
						indexes.add(new Coor(a, j));

					}
				}

			}

			// handle when String piece does not contain ":"
			else {
				for (String item1 : items) {
//					TO DO: This should check wether the element starts with a char and ends with one (or more) ints. If so, it should
//					treat it like a coor and add it like a coor. If not, it should take it as a String and just push it in the ArrayList and
//					through
					
					indexes.add(new Coor(item1.substring(0, 1).charAt(0),
							Integer.parseInt(item1.substring(1, 2))));
				}

			}

		}

		return indexes;

	}

	/**
	 * method functionExist tests if the function, extracted from the input from
	 * cell, is one of the implemented functions
	 * 
	 * @param function
	 * @return
	 */
	public static boolean functionExist(String function) {
		switch (function) {

		case "AVERAGE": {
			return true;
		}
		case "COUNT": {
			return true;
		}
		case "COUNTA": {
			return true;
		}
		case "COUNTIF": {
			return true;
		}
		case "IF": {
			return true;
		}
		case "INT": {
			return true;
		}
		case "ISLOGICAL": {
			return true;
		}
		case "ISEVEN": {
			return true;
		}
		case "ISNUMBER": {
			return true;
		}
		case "LOWER": {
			return true;
		}
		case "MAX": {
			return true;
		}
		case "MEDIAN": {
			return true;
		}
		case "MIN": {
			return true;
		}
		case "MOD": {
			return true;
		}
		case "NOT": {
			return true;
		}
		case "OR": {
			return true;
		}
		case "POWER": {
			return true;
		}
		case "PRODUCT": {
			return true;
		}
		case "PROPER": {
			return true;
		}
		case "ROUNDDOWN": {
			return true;
		}
		case "ROUNDUP": {
			return true;
		}
		case "SIGN": {
			return true;
		}
		case "SQRT": {
			return true;
		}
		case "SUM": {
			return true;
		}
		case "SUMIF": {
			return true;
		}
		default:
			return false;

		}
	}

	/**
	 * method callFunction calls the right method of the right function, returns
	 * the result of that function
	 * 
	 * @param function
	 * @return
	 */
	public static String callFunction(String function,
			ArrayList<Object> cellContents) {
		// I count on the fact that the functions return strings
		switch (function) {

		case "AVERAGE": {
			return Functions.average(cellContents);
		}
		case "COUNT": {
			return Functions.count(cellContents);
		}
		case "COUNTA": {
			return Functions.counta(cellContents);
		}
		case "COUNTIF": {
			return Functions.countif(cellContents);
		}
		case "IF": {
			// WE CALL THE FUNCTION "IF"-METHOD: ifFunction, because a method
			// cannot be called "if"
			return Functions.ifFunction(cellContents);
		}
		case "INT": {
			return Functions.intFunction(cellContents);
			// WE CALL THE FUNCTION "INT"-METHOD: intFunction, because a method
			// cannot be called "int"
		}
		case "ISLOGICAL": {
			return Functions.islogical(cellContents);
		}
		case "ISEVEN": {
			return Functions.iseven(cellContents);
		}
		case "ISNUMBER": {
			return Functions.isnumber(cellContents);
		}
		case "LOWER": {
			return Functions.lower(cellContents);
		}
		case "MAX": {
			return Functions.max(cellContents);
		}
		case "MEDIAN": {
			return Functions.median(cellContents);
		}
		case "MIN": {
			return Functions.min(cellContents);
		}
		case "MOD": {
			return Functions.mod(cellContents);
		}
		case "NOT": {
			return Functions.not(cellContents);
		}
		case "OR": {
			return Functions.or(cellContents);
		}
		case "POWER": {
			return Functions.power(cellContents);
		}
		case "PRODUCT": {
			return Functions.product(cellContents);
		}
		case "PROPER": {
			return Functions.proper(cellContents);
		}
		case "ROUNDDOWN": {
			return Functions.rounddown(cellContents);
		}
		case "ROUNDUP": {
			return Functions.roundup(cellContents);
		}
		case "SIGN": {
			return Functions.sign(cellContents);
		}
		case "SQRT": {
			return Functions.sqrt(cellContents);
		}
		case "SUM": {
			return Functions.sum(cellContents);
		}
		case "SUMIF": {
			return Functions.sumif(cellContents);
		}
		default:
			throw new IllegalArgumentException("Fill in a valid function");
			// TO DO: how do I sent a message with this
			// IllegalArgumentException?

		}
	}

}
