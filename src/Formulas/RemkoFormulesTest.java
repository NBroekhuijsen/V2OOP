package Formulas;

import java.util.ArrayList;

public class RemkoFormulesTest {
	
	@Test
	public void testAverageThree() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add(2);
		testlijst.add(7);
		testlijst.add(9);
		assertTrue(RemkoFormules.average(testlijst).equals("6"));
	}
	
	@Test
	public void testAverageTwo() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add(2);
		testlijst.add(8);
		assertTrue(RemkoFormules.average(testlijst).equals("5"));
	}
	
	@Test
	public void testAverageOne() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add(2);
		assertTrue(RemkoFormules.average(testlijst).equals("2"));
	}
	
	@Test
	public void testAverageFalse() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add(1);
		testlijst.add(2);
		testlijst.add(3);
		assertTrue(!(RemkoFormules.average(testlijst).equals("8")));
	}
	
	@Test
	public void testAverageStringInputs() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add(1);
		testlijst.add("tekst hier");
		testlijst.add(3);
		assertTrue(RemkoFormules.average(testlijst).equals("2"));
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testAverageOnlyStringInputs() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add("tekst");
		testlijst.add("tekst hier");
		assertTrue(RemkoFormules.average(testlijst).equals("2"));
	}
	
	@Test
	public void testCount() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add(1);
		testlijst.add(2);
		assertTrue(RemkoFormules.count(teslijst).equals("2"));
	}
	
	@Test
	public void testCountFalse() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add(5);
		testlijst.add(66);
		assertFalse(RemkoFormules.count(teslijst).equals("2"));
	}
	
	@Test
	public void testCountWithStrings() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add(1);
		testlijst.add("STRING");
		testlijst.add(2);
		assertTrue(RemkoFormules.count(teslijst).equals("2"));
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testCountWithOnlyStrings() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add("STRING");
		testlijst.add("NOG EEN STRING");
		assertTrue(RemkoFormules.count(teslijst).equals("2"));
	}
	
	@Test
	public void testCountA() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add(1);
		testlijst.add(2);
		assertTrue(RemkoFormules.count(teslijst).equals("2"));
	}
	
	@Test
	public void testCountAFalse() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add(5);
		testlijst.add(66);
		assertFalse(!(RemkoFormules.count(teslijst).equals("2")));
	}
	
	@Test
	public void testCountAWithStrings() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add(1);
		testlijst.add("STRING");
		testlijst.add(2);
		assertTrue(RemkoFormules.count(teslijst).equals("3"));
	}
	
	
	@Test
	public void testCountAWithOnlyStrings() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add("STRING");
		testlijst.add("NOG EEN STRING");
		assertTrue(RemkoFormules.count(teslijst).equals("2"));
	}
	
	@Test
	public void testCountAWithNulls() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add(1);
		testlijst.add(null);
		testlijst.add("STRING");
		testlijst.add(2);
		testlijst.add(null);
		assertTrue(RemkoFormules.count(teslijst).equals("3"));
	}
	
	@Test
	public void testCountAWithOnlyNulls() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add(null);
		testlijst.add(null);
		assertTrue(RemkoFormules.count(teslijst).equals("0"));
	}
	
	@Test
	public void testCountIf() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add(4);
		testlijst.add(4);
		testlijst.add(1);
		testlijst.add(4);
		assertTrue(RemkoFormules.count(teslijst).equals("2"));
	}
	
	@Test
	public void testCountIfFalse() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add(2);
		testlijst.add(5);
		testlijst.add(2);
		assertFalse(RemkoFormules.count(teslijst).equals("2"));
	}
	
	@Test
	public void testCountIfLogical() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add("false");
		testlijst.add("true");
		testlijst.add("false");
		testlijst.add(55);
		testlijst.add("false");
		assertTrue(RemkoFormules.count(teslijst).equals("2"));
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testCountIfStrings() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add("holler at je string");
		testlijst.add("55");
		testlijst.add("55");
		assertTrue(RemkoFormules.count(teslijst).equals("1"));
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testCountIfOneInput() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add("5");
		assertTrue(RemkoFormules.count(teslijst).equals("1"));
	}
	
	@Test
	public void testifFunction1st() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add("1+1=2");
		testlijst.add(2);
		testlijst.add("blabla");
		assertTrue(RemkoFormules.count(teslijst).equals("2"));
	}
	
	@Test
	public void testifFunction2nd() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add("1+1=6");
		testlijst.add(2);
		testlijst.add("blabla");
		assertTrue(RemkoFormules.count(teslijst).equals("blabla"));
	}
	
	@Test
	public void testifFunctionFalse() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add("(44-22=22)&&(22+22=66)");
		testlijst.add(2);
		testlijst.add("blabla");
		assertFalse(RemkoFormules.count(teslijst).equals("2"));
	}
	
	@Test (expected IllegalArgumentException.class)
	public void testifFunctionNotLogical() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add("blabla3");
		testlijst.add(2);
		testlijst.add("blabla");
		assertFalse(RemkoFormules.count(teslijst).equals("2"));
	}
	
	@Test (expected IllegalArgumentException.class)
	public void testifFunctionNotEnoughInputs() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add("44-22=22");
		testlijst.add(2);
		assertFalse(RemkoFormules.count(teslijst).equals("2"));
	}
}

