package in.ashokit.beans;

public class Calculator {

	public Integer add(Integer a, Integer b) {
		return a + b;
	}

	public Integer multiply(Integer a, Integer b) {
		return a * b;
	}

	public boolean isPallindrom(String str) {
		String reverseStr = "";
		int strLength = str.length();
		for (int i = (strLength - 1); i >= 0; --i) {
			reverseStr = reverseStr + str.charAt(i);
		}
		if (str.toLowerCase().equals(reverseStr.toLowerCase())) {
			return true;
		}
		return false;
	}
	
	public  Integer convertToInt(String str) {
		if(str==null || str.trim().length()==0) {
			throw new IllegalArgumentException("String must not be null or empty");
		}
		return Integer.valueOf(str);
	}
}
