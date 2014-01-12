package Formulas;

import java.util.ArrayList;

public class JuliantiFormules {
	
	//TODO: JAVADOCCEN
	
	// Input is een arraylist van objecten (doubles en strings enzo)...
	public static String intFunction(ArrayList<Object> input)
	{
		if(input.size() >= 2)
		{
			throw new IllegalArgumentException("Please select only one cell.");
		}
		
		if(input.get(0) instanceof Double)
		{
			double inputdouble = (double) input.get(0);
			double outputdouble = Math.floor(inputdouble);
			//Math.floor rond het altijd af naar een lager geheel getal
			//Dus moet je nu nog kijken of je hem naar boven moet afronden:
			if((outputdouble + 0.5) < inputdouble)
			{
				outputdouble++;
			}
			
			String outputstring = Double.toString(outputdouble);
			
			return outputstring;
		}
		else
		{
			throw new IllegalArgumentException("Please select a cell containing a number.");
		}
	}
	
	public static String islogical(ArrayList<Object> input)
	{
		if(input.size() > 1)
		{
			throw new IllegalArgumentException("Please select only one cell.");
		}
		
		if(input.get(0) instanceof String)
		{
			String inputstring = (String) input.get(0);
			if(inputstring.matches("true")|| inputstring.matches("TRUE") || inputstring.matches("True") || inputstring.matches("false") || inputstring.matches("False") || inputstring.matches("FALSE"))
			{
				return "true";
			}
		}
		return "false";
	}	
		
	
	public static String iseven(ArrayList<Object> input)
	{
		if(input.size() > 1)
		{
			throw new IllegalArgumentException("Please select only one cell.");
		}
		if(!(input.get(0) instanceof Double))
		{
			throw new IllegalArgumentException("Please select a cell containing a number.");
		}
		if(input.get(0) instanceof Double)
		{
			double inputdouble = (double) input.get(0);
			if(inputdouble%2 == 0)
			{
				return "true";
			}
		}
		return "false";
	}
	
	public static String isnumber(ArrayList<Object> input)
	{
		if(input.size() > 1)
		{
			throw new IllegalArgumentException("Please select only one cell.");
		}
		if(input.get(0) instanceof Double)
		{
			return "true";
		}
		return "false";
	}
}