package Formulas;

import java.util.ArrayList;

//WE CALL THE FUNCTION "IF"-METHOD: ifFunction, because a method cannot be called "if" 
//WE CALL THE FUNCTION "INT"-METHOD: intFunction, because a method cannot be called "int" 

public class MilaFormules {
	
	/**
	 * Method SUM
	 * returns String with all the cells summed up
	 * @return String result
	 */
	public static String sum(ArrayList<Object> input)
	{
		double result = 0;
		
			for(Object number: input)
			{
//				Do we want our methods to ignore when something other than int's or double's is selected? Or shall we throw an Exception?

//				if(number instanceof Integer || number instanceof Double)
//				{
//					throw new IllegalArgumentException("Please select only cells containing numbers!);
//				}
				
				if(number instanceof Integer || number instanceof Double)
				{
					result = result + (double)number;
				}
			}
		
		return Double.toString(result);
		
	}
	
	

	/**Method SUMIF
	 * Returns String witch all the cells that meet the criteria
	 * summed up.
	 * criteria = input.get(0)
	 * range = the rest of ArrayList Object
	 * @return String
	 */
	public static String sumif(ArrayList<Object> input)
	{
		double result = 0;
		if(input.get(0) instanceof Integer || input.get(0) instanceof Double)
		{
			double criteria = (double)input.get(0);
			if(input.size()<2)
			{
				throw new IllegalArgumentException("Please select at least two cells for the SUMIF function");
			}
			
			for(Object number: input)
			{
	//			Do we want our methods to ignore when something other than int's or double's is selected? Or shall we throw an Exception?
	
				if(!(number instanceof Integer || number instanceof Double))
				{
					throw new IllegalArgumentException("Please select only cells containing numbers!");
				}
				
				if(number instanceof Integer || number instanceof Double)
				{
					// TODO CASTEN NIET GOED
					if((double)number == criteria)
					result = result + (double)number;
				}
			}
		}
		else
		{
			throw new IllegalArgumentException("Please select only cells containing numbers!");
		}
	
	return Double.toString(result);
	}
	
	/**
	 * Method  sign
	 * Takes just one cell in
	 * returns a String with "isNegative", "isZero", or "isPositive"
	 * depending on whether the input was a negative, equal to 
	 * zero or positive number
	 * @param input
	 * @return String "isNegative", "isZero", or "isPositive"
	 */
	public static String sign(ArrayList<Object> input)
	{
		if(!(input.size() ==1))
			{
				throw new IllegalArgumentException("Please select one cell for the function SIGN");
			}
		else 
		{
			if((input.get(0) instanceof Integer || input.get(0) instanceof Double))
		
			{
				if((double)input.get(0)<0)
				{
					return "isNegative";
				}
				
				if((double)input.get(0)==0)
				{
					return "isZero";
				}
				
				if((double)input.get(0)>0)
				{
					return "isPositive";
				}
			}
			else
			{
				throw new IllegalArgumentException("Please select a cell containing a number");
			}
		}	
		return "Something went wrong in the SIGN method. Trust me.";
	}
	
	
	
	/**
	 * Method SQRT
	 * Returns 
	 */
	public static String sqrt(ArrayList<Object> input)
	{
		double result;
	
		if(!(input.size() ==1))
		{
			throw new IllegalArgumentException("Please select one cell for the function SQRT");
		}
		if(!(input.get(0) instanceof Integer || input.get(0) instanceof Double))
		{
			throw new IllegalArgumentException("Please select a cell containing a number");
		}
		else 
		{
			if((input.get(0) instanceof Integer || input.get(0) instanceof Double) && input.size() == 1)
			{
				result = Math.sqrt((double)input.get(0));
				return Double.toString(result);
			}
			
		}
		
		return "Something went wrong in the SQRT method. Trust me.";
	}	
	
	/**
	 * 
	 */
	public static String roundup(ArrayList<Object> input)
	{
		
	}
	
	
	
	
	
	
	
	

}
