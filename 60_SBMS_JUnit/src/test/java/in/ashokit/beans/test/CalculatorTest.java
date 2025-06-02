package in.ashokit.beans.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.util.StringUtils;

import in.ashokit.beans.Calculator;

public class CalculatorTest {
	
	
	@Test
	public void  testAdd() {
		Calculator cal = new Calculator();
		Integer actualInteger = cal.add(10, 20);
		Integer expencedInteger=30;
		assertEquals(expencedInteger, actualInteger);
	}
	
	@Test
	public void testMultiply() {
		Calculator cal = new Calculator();
		Integer actualInteger = cal.multiply(10, 10);
		Integer expectedInteger=100;
		assertEquals(actualInteger, expectedInteger);
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"appa","jahaj","aooa","liril"})
	public void testPallindrom(String str) {
		Calculator cal = new Calculator();
		assertTrue(cal.isPallindrom(str));
	}
	
//	@ParameterizedTest
//	@ValueSource(strings = {"1234","1111","2222",""})
	
	@Test
	public void testConvertToInt() {
		Calculator cal = new Calculator();
		String str=null;
//		Integer actual=cal.convertToInt(str);
//		assertEquals(actual, Integer.valueOf(str));
//		assertNotNull(actual);
		assertThrows(IllegalArgumentException.class, ()->cal.convertToInt(str));
		
		
		
		
	}
	
	
}