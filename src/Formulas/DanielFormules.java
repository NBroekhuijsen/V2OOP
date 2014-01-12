package Formulas;

import java.util.ArrayList;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class DanielFormules {

	public static String not(String expression) {
		// Replace some String input to logical operators (To be sure)
		expression = expression.replaceAll("AND", "&&");
		expression = expression.replaceAll("OR", "||");
		expression = expression.replaceAll("=", "==");
		// Initiating solution boolean
		String solution = "";

		try {

			ScriptEngineManager manager = new ScriptEngineManager();
			ScriptEngine engine = manager.getEngineByName("JavaScript");
			solution = String.valueOf(!((boolean) engine.eval(expression)));

		} catch (Exception e) {

			System.out.println("Not a valid Expression");
			e.printStackTrace();

		}
		return solution;
	}

	public static String or(String expression) {

		// Replace some String input to logical operators (To be sure)
		expression = expression.replaceAll("AND", "&&");
		expression = expression.replaceAll("OR", "||");
		expression = expression.replaceAll("=", "==");
		String[] split = expression.split(",");
		boolean solution = false;
		try {

			ScriptEngineManager manager = new ScriptEngineManager();
			ScriptEngine engine = manager.getEngineByName("JavaScript");
			// iterate trough every individual expression, setting 'solution'to
			// true if it finds a true one
			for (int i = 1; i < split.length; i++) {
				if (((boolean) engine.eval(split[i]))) {
					solution = true;
				}
			}
		} catch (Exception e) {

			System.out.println("Not a valid Expression");
			e.printStackTrace();

		}
		return String.valueOf(solution);
	}

	public static String power(ArrayList<Object> input) {
		double base = 0;
		double power = 0;
		if (input.size() > 2) {
			throw new IllegalArgumentException(
					"Please use 2 numbers for this function");
		}
		if (input.get(0) instanceof Double) {
			base = (double) input.get(0);
		} else {
			throw new IllegalArgumentException("Please use a number as base");
		}
		if (input.get(1) instanceof Double) {
			power = (double) input.get(1);
		} else {
			throw new IllegalArgumentException("Please use a number as base");
		}

		return Double.toString(Math.pow(base, power));
	}

	public static String product(ArrayList<Object> input) {
		double solution = 1;
		for (Object number : input) {
			if (number instanceof Double) {
				solution *= (double) number;
			} else {
				throw new IllegalArgumentException(
						"Please use numbers for this function");
			}
		}
		return Double.toString(solution);
	}

	public static String proper(ArrayList<Object> input) {
		String solution = "";
		if (input.size() > 1) {
			throw new IllegalArgumentException("Please select only one cell.");
		}
		if (input.get(0) instanceof String) {
			StringBuilder builder = new StringBuilder();
			String capsafter = " '-/";
			boolean captionnext = true;
			// for loop that checks and captions letters
			for (char c : ((String) input.get(0)).toCharArray()) {
				//turn Character into capital or not, based on captionnext 
				c = (captionnext) ? Character.toUpperCase(c) : Character
						.toLowerCase(c);
				builder.append(c);
				captionnext = (capsafter.indexOf((int) c) >= 0);
			}
			solution = builder.toString();
		}
		return solution;
	}

}