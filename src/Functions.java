import java.util.ArrayList;


public class Functions {

	public static String average(ArrayList<Object> cellContents) {
		// TODO Auto-generated method stub
		return null;
	}

	public static String count(ArrayList<Object> cellContents) {
		// TODO Auto-generated method stub
		return null;
	}

	public static String counta(ArrayList<Object> cellContents) {
		// TODO Auto-generated method stub
		return null;
	}

	public static String countif(ArrayList<Object> cellContents) {
		// TODO Auto-generated method stub
		return null;
	}

	public static String ifFunction(ArrayList<Object> cellContents) {
		// TODO Auto-generated method stub
		return null;
	}

	public static String intFunction(ArrayList<Object> cellContents) {
		// TODO Auto-generated method stub
		return null;
	}

	public static String islogical(ArrayList<Object> cellContents) {
		// TODO Auto-generated method stub
		return null;
	}

	public static String iseven(ArrayList<Object> cellContents) {
		// TODO Auto-generated method stub
		return null;
	}

	public static String isnumber(ArrayList<Object> cellContents) {
		// TODO Auto-generated method stub
		return null;
	}

	public static String lower(ArrayList<Object> input) {
		if (input.size() > 1) {
			throw new IllegalArgumentException("Please select only one cell.");
		}
		if (input.get(0) instanceof Double) {
			throw new IllegalArgumentException("Please don't enter numbers.");
		}
		if (input.get(0) instanceof String) {

			String inputtext = (String) input.get(0);
			return inputtext.toLowerCase();
		}

		return "This isn't supposed to happen.";
	}

	public static String upper(ArrayList<Object> input) {
		if (input.size() > 1) {
			throw new IllegalArgumentException("Please select only one cell.");
		}
		if (input.get(0) instanceof Double) {
			throw new IllegalArgumentException("Please don't enter numbers.");
		}
		if (input.get(0) instanceof String) {

			String inputtext = (String) input.get(0);
			return inputtext.toUpperCase();
		}

		return "This isn't supposed to happen.";
	}

	public static String max(ArrayList<Object> cellContents) {
		// TODO Auto-generated method stub
		return null;
	}

	public static String median(ArrayList<Object> cellContents) {
		// TODO Auto-generated method stub
		return null;
	}

	public static String min(ArrayList<Object> cellContents) {
		// TODO Auto-generated method stub
		return null;
	}

	public static String mod(ArrayList<Object> cellContents) {
		// TODO Auto-generated method stub
		return null;
	}

	public static String not(ArrayList<Object> cellContents) {
		// TODO Auto-generated method stub
		return null;
	}

	public static String or(ArrayList<Object> cellContents) {
		// TODO Auto-generated method stub
		return null;
	}

	public static String power(ArrayList<Object> cellContents) {
		// TODO Auto-generated method stub
		return null;
	}

	public static String product(ArrayList<Object> cellContents) {
		// TODO Auto-generated method stub
		return null;
	}

	public static String proper(ArrayList<Object> cellContents) {
		// TODO Auto-generated method stub
		return null;
	}

	public static String rounddown(ArrayList<Object> cellContents) {
		// TODO Auto-generated method stub
		return null;
	}

	public static String roundup(ArrayList<Object> cellContents) {
		// TODO Auto-generated method stub
		return null;
	}

	public static String sign(ArrayList<Object> cellContents) {
		// TODO Auto-generated method stub
		return null;
	}

	public static String sqrt(ArrayList<Object> cellContents) {
		// TODO Auto-generated method stub
		return null;
	}

	public static String sum(ArrayList<Object> cellContents) {
		// TODO Auto-generated method stub
		return null;
	}

	public static String sumif(ArrayList<Object> cellContents) {
		// TODO Auto-generated method stub
		return null;
	}

}
