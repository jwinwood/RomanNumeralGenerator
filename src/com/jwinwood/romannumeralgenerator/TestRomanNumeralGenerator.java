package com.jwinwood.romannumeralgenerator;

import junit.framework.TestCase;

public class TestRomanNumeralGenerator extends TestCase {
	
	private RomanNumeralGenerator mRNG;
	
	public TestRomanNumeralGenerator() {
		mRNG = new RomanNumeralGeneratorImpl();
	}
	
	public void testGenerator() {
		assertEquals("generate(3999) should return 'MMMCMXCIX'", "MMMCMXCIX", mRNG.generate(3999));
	}
	
	public void testGeneratorBounds() {
		assertEquals("generate(0) should return ''", "", mRNG.generate(0));
		assertEquals("generate(4000) should return ''", "", mRNG.generate(4000));
	}
	
	public void testThousands() {
		assertEquals("generate(1000) should return 'M'", "M", mRNG.generate(1000));
	}
	
	public void testHundreds() {
		assertEquals("generate(100) should return 'C'", "C", mRNG.generate(100));
	}
	
	public void testHundredsSubtractionNotation() {
		assertEquals("generate(400) should return 'CD'", "CD", mRNG.generate(400));
		assertEquals("generate(900) should return 'CM'", "CM", mRNG.generate(900));
	}
	
	public void testTens() {
		assertEquals("generate(10) should return 'X'", "X", mRNG.generate(10));
	}
	
	public void testTensSubtractionNotation() {
		assertEquals("generate(40) should return 'XL'", "XL", mRNG.generate(40));
		assertEquals("generate(90) should return 'XC'", "XC", mRNG.generate(90));
	}
	
	public void testUnits() {
		assertEquals("generate(1) should return 'I'", "I", mRNG.generate(1));
	}
	
	public void testUnitsSubtractionNotation() {
		assertEquals("generate(4) should return 'IV'", "IV", mRNG.generate(4));
		assertEquals("generate(9) should return 'IX'", "IX", mRNG.generate(9));
	}
}
