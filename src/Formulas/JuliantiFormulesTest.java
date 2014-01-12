package Formulas;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class JuliantiFormulesTest {

	@Test
	public void testintFunctionWithDoubleToRoundDown() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add(123.3);
		assertTrue(JuliantiFormules.intFunction(testlijst).equals("123.0"));
	}
	
	@Test
	public void testintFunctionWithDoubleToRoundUp() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add(123.7);
		assertTrue(JuliantiFormules.intFunction(testlijst).equals("124.0"));
	}
	
	@Test
	public void testintFunctionWithInt() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add(123.0);
		assertTrue(JuliantiFormules.intFunction(testlijst).equals("123.0"));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testintFunctionWithString() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add("hola que tal");
		assertEquals(JuliantiFormules.intFunction(testlijst), "hola que tal");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testintFunctionWithTooManyInputs() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add(123);
		testlijst.add(123);
		assertEquals(JuliantiFormules.intFunction(testlijst), "gefeliciteerd je snapt niks van excel");
	}
	
	@Test
	public void testislogicalWithTrue() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add("true");
		assertEquals(JuliantiFormules.islogical(testlijst), "true");
	}
	
	@Test
	public void testislogicalWithFalse() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add("false");
		assertEquals(JuliantiFormules.islogical(testlijst), "true");
	}
	
	@Test
	public void testislogicalWithWrongString() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add("afles");
		assertEquals(JuliantiFormules.islogical(testlijst), "false");
	}
	
	@Test
	public void testislogicalWithValue() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add(1);
		assertEquals(JuliantiFormules.islogical(testlijst), "false");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testislogicalWithMultipleValues() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add(true);
		testlijst.add(true);
		assertEquals(JuliantiFormules.islogical(testlijst), "false");
	}
	
	@Test
	public void testisevenWithEvenDouble() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add(2.0);
		assertEquals(JuliantiFormules.iseven(testlijst), "true");
	}
	
	@Test
	public void testisevenWithOddDouble() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add(1.0);
		assertEquals(JuliantiFormules.iseven(testlijst), "false");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testisevenWithMultipleValues() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add("hallo hoe start ik windows");
		testlijst.add("ik snap 1+1=2 niet kan je dit uitleggen");
		assertEquals(JuliantiFormules.iseven(testlijst), "false");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testisevenWithWrongValue() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add("ik wil graag kijken of deze zin een even getal is");
		assertEquals(JuliantiFormules.iseven(testlijst), "false");
	}

	@Test
	public void testisnumber() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add(5.0);
		assertEquals(JuliantiFormules.isnumber(testlijst), "true");
	}
	
	@Test
	public void testisNotANumber() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add("vijf");
		assertEquals(JuliantiFormules.isnumber(testlijst), "false");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testisnumberWithMultipleValues() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add(1);
		testlijst.add(2);
		assertEquals(JuliantiFormules.isnumber(testlijst), "false");
	}
}
