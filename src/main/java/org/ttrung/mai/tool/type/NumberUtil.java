package org.ttrung.mai.tool.type;

import java.math.BigDecimal;

public class NumberUtil {

	/**
	 * check if num1 is bigger than num2 
	 * @param num1
	 * @param num2
	 * @return <p>true if num1 > num2
	 * 			<p>	false if num1 or num2 is null or num1 <= num2
	 */
	public static boolean isBiggerThan(Number num1, Number num2) {
		if(num1 == null || num2 == null)
			return false;
		
		return new BigDecimal(num1.toString()).compareTo(new BigDecimal(num2.toString())) == 1;
	}

}
