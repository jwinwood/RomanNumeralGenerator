package com.jwinwood.romannumeralgenerator;

public class RomanNumeralGeneratorImpl implements RomanNumeralGenerator {

	private final int THOUSANDS_MODIFIER = 1000;
	private final int HUNDREDS_MODIFIER = 100;
	private final int TENS_MODIFIER = 10;
	
	private final String THOUSAND_NUMERAL = "M";
	private final String FIVE_HUNDRED_NUMERAL = "D";
	private final String HUNDRED_NUMERAL = "C";
	private final String FIFTY_NUMERAL = "L";
	private final String TEN_NUMERAL = "X";
	private final String FIVE_NUMERAL = "V";
	private final String ONE_NUMERAL = "I";
	
	@Override
	public String generate(int number) {
		if (number <= 0 || number > 3999)
			return "";
		
		StringBuilder numeralBuilder = new StringBuilder();
		
		numeralBuilder.append(generateThousands(number));
		number %= THOUSANDS_MODIFIER;
		numeralBuilder.append(generateHundreds(number));
		number %= HUNDREDS_MODIFIER;
		numeralBuilder.append(generateTens(number));
		number %= TENS_MODIFIER;
		numeralBuilder.append(generateUnits(number));
		
		return numeralBuilder.toString();
	}
	
	private String generateThousands(int number) {
		String thousandsStr = "";
		int thousands = number / THOUSANDS_MODIFIER;
		for (int i = 0; i < thousands; i++) {
			thousandsStr += THOUSAND_NUMERAL;
		}
		return thousandsStr;
	}
	
	private String generateHundreds(int number) {
		String hundredsStr = "";
		int hundreds = number / HUNDREDS_MODIFIER;
		
		// check for subtraction notation, i.e. 4 or 9
		hundredsStr += doSubtractionNotation(hundreds,
				HUNDRED_NUMERAL+FIVE_HUNDRED_NUMERAL, 
				HUNDRED_NUMERAL+THOUSAND_NUMERAL);
		if (!hundredsStr.isEmpty()) return hundredsStr;
		
		if (hundreds >= 5) {
			hundredsStr += FIVE_HUNDRED_NUMERAL;
			hundreds -= 5;
		}
		
		for (int i = 0; i < hundreds; i++) {
			hundredsStr += HUNDRED_NUMERAL;
		}
		return hundredsStr;
	}
	
	private String generateTens(int number) {
		String tensStr = "";
		int tens = number / TENS_MODIFIER;
		
		// check for subtraction notation, i.e. 4 or 9
		tensStr += doSubtractionNotation(tens, 
				TEN_NUMERAL+FIFTY_NUMERAL, 
				TEN_NUMERAL+HUNDRED_NUMERAL);
		if (!tensStr.isEmpty()) return tensStr;
		
		if (tens >= 5) {
			tensStr += FIFTY_NUMERAL;
			tens -= 5;
		}
		
		for (int i = 0; i < tens; i++) {
			tensStr += TEN_NUMERAL;
		}
		
		return tensStr;
	}
	
	private String generateUnits(int number) {
		String unitsStr = "";
		
		// check for subtraction notation, i.e. 4 or 9
		unitsStr += doSubtractionNotation(number, 
				ONE_NUMERAL+FIVE_NUMERAL, 
				ONE_NUMERAL+TEN_NUMERAL);
		if (!unitsStr.isEmpty()) return unitsStr;
		
		if (number >= 5) {
			unitsStr += FIVE_NUMERAL;
			number -= 5;
		}
		
		for (int i = 0; i < number; i++) {
			unitsStr += ONE_NUMERAL;
		}
		
		return unitsStr;
	}
	
	private String doSubtractionNotation(int number, String four, String nine) {
		if (number == 9) {
			return nine;
		}
		if (number == 4) {
			return four;
		}
		
		return "";
	}
}
