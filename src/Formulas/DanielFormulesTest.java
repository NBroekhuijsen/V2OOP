package Formulas;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class DanielFormulesTest {

	@Test
	public void testNot() {
		String test = "1+1=2AND(2+2=4OR4+4=12512)";
		assertTrue(DanielFormules.not(test).equals("false"));
	}
	
	@Test
	public void testNotReverse() {
		String test = "1+1=125AND(2+2=4OR4+4=125)";
		assertTrue(DanielFormules.not(test).equals("true"));
	}
	
	@Test
	public void testNotFalse() {
		String test = "1+1=2AND(2+2=4OR4+4=12512)";
		assertTrue(!(DanielFormules.not(test).equals("true")));
	}
	
	@Test
	public void testNotFalseReverse() {
		String test = "1+1=125AND(2+2=4OR4+4=125)";
		assertTrue(!(DanielFormules.not(test).equals("false")));
	}
	
	@Test
	public void testNotFalseGeenLogica() {
		String test = "bla";
		assertTrue(!(DanielFormules.not(test).equals("false")));
	}
	
	@Test (expected = Exception.class)
	public void testNotFalseMultipleInputs() {
		String test = "1+1=125AND(2+2=4OR4+4=125)";
		assertTrue(!(DanielFormules.not(test).equals("false")));
	}
	
	@Test
	public void testOrOneInput() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add("1+1=2");
		assertTrue(!(DanielFormules.or(testlijst).equals("true")));
	}
	
	@Test
	public void testOrOneInputFalse() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add("1+1=13");
		assertTrue(!(DanielFormules.or(testlijst).equals("false")));
	}
	
	@Test
	public void testOrMultipleInputs() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add("1+1=2");
		testlijst.add("2+2=4");
		assertTrue(!(DanielFormules.or(testlijst).equals("true")));
	}
	
	@Test
	public void testOrMultipleInputsHalf() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add("1+1=2");
		testlijst.add("2+2=151266");
		assertTrue(!(DanielFormules.or(testlijst).equals("true")));
	}
	
	@Test
	public void testOrMultipleInputsFalse() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add("1+1=4");
		testlijst.add("2+2=8");
		assertTrue(!(DanielFormules.or(testlijst).equals("false")));
	}


}
