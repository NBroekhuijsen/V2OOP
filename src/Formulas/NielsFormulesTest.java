package Formulas;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class NielsFormulesTest {

	
	@Test
	public void testLowerFalse() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add("H");
		assertFalse(NielsFormules.lower(testlijst).equals("H"));
	}
	
	@Test
	public void testLowerUppercase() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add("HALLO IK BEN NIELS IK TYP IN ALL CAPS WANT IK BEN BOOS");
		assertTrue(NielsFormules.lower(testlijst).equals("hallo ik ben niels ik typ in all caps want ik ben boos"));
	}
	
	@Test
	public void testLowerLowercase() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add("h");
		assertTrue(NielsFormules.lower(testlijst).equals("h"));
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testLowerMultipleInputs() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add("f");
		testlijst.add("u");
		testlijst.add("c");
		testlijst.add("k");
		assertTrue(NielsFormules.lower(testlijst).equals("f"));
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testLower() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add("42.42");
		assertTrue(NielsFormules.lower(testlijst).equals("42.42"));
	}
	
	@Test
	public void testMax() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add(1.1);
		testlijst.add(2.2);
		testlijst.add(3.3);
		assertEquals(NielsFormules.max(testlijst), ("3.3"));
	}
	
	@Test
	public void testMaxFalse() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add(5.5);
		testlijst.add(4.4);
		testlijst.add(3.3);
		assertTrue(!(NielsFormules.max(testlijst).equals("5.5")));
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testMaxStringInput() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add("hoi");
		testlijst.add("hoitwo");
		testlijst.add("hoidrie");
		assertTrue(NielsFormules.max(testlijst).equals("hoidrie"));
	}
	
	@Test
	public void testMaxOneInput() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add(555.0);
		assertEquals(NielsFormules.max(testlijst), ("555.0"));
	}
	
	@Test
	public void testMedian() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add(1);
		testlijst.add(2);
		testlijst.add(3);
		assertTrue(NielsFormules.median(testlijst).equals("2"));
	}
	
	@Test
	public void testMedianFalse() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add(2);
		testlijst.add(3);
		testlijst.add(4);
		assertFalse(!(NielsFormules.median(testlijst).equals("3")));
	}
	
	@Test
	public void testMedianOneInput() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add(2);
		assertTrue(NielsFormules.median(testlijst).equals("2"));
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testMedianString() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add(2);
		testlijst.add("HALLO IK STA HELEMAAL FOUT");
		testlijst.add(2);
		assertTrue(NielsFormules.median(testlijst).equals("HALLO IK STA HELEMAAL FOUT"));
	}
	
	@Test
	public void testMin() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add(1.1);
		testlijst.add(2.2);
		testlijst.add(3.3);
		assertTrue(NielsFormules.min(testlijst).equals("3.3"));
	}
	
	@Test
	public void testMinFalse() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add(5.5);
		testlijst.add(4.4);
		testlijst.add(3.3);
		assertTrue(!(NielsFormules.min(testlijst).equals("5.5")));
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testMinStringInput() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add("hoi");
		testlijst.add("hoitwee");
		testlijst.add("hoidrie");
		assertTrue(NielsFormules.min(testlijst).equals("hoitwo"));
	}
	
	@Test
	public void testMinOneInput() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add(555);
		assertTrue(NielsFormules.min(testlijst).equals("555"));
	}
	
	@Test
	public void testModLowerDivisor() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add(7);
		testlijst.add(3);
		assertTrue(NielsFormules.mod(testlijst).equals("1"));	
	}
	
	@Test
	public void testModHigherDivisor() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add(3);
		testlijst.add(7);
		assertTrue(NielsFormules.mod(testlijst).equals("3"));	
	}
	
	@Test
	public void testModEqualDivisor() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add(3);
		testlijst.add(3);
		assertTrue(NielsFormules.mod(testlijst).equals("0"));	
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testModOneInput() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add(3);
		assertTrue(NielsFormules.mod(testlijst).equals("3"));	
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testModTooManyInputs() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add(3);
		testlijst.add(3);
		testlijst.add(3);
		assertTrue(NielsFormules.mod(testlijst).equals("0"));	
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testModString() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add(3);
		testlijst.add("STRING");
		assertTrue(NielsFormules.mod(testlijst).equals("0"));	
	}
}
