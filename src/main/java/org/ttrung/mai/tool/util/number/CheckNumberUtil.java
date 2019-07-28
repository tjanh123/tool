package org.ttrung.mai.tool.util.number;

import java.math.BigDecimal;

/**
 * functions util checking number
 * <p>
 * these functions only return boolean value
 * 
 * @author ttrung.mai
 *
 */
public class CheckNumberUtil {

	public static boolean isInsideThresholdAbsolute(Long number, long threshold) {
		if (number == null) {
			return false;
		}
		long positive = Math.abs(threshold);
		return number >= Math.negateExact(positive) && number <= positive;
	}

	public static boolean isInsideThresholdAbsolute(Integer number, long threshold) {
		if (number == null) {
			return false;
		}
		return number >= -threshold && number <= threshold;
	}

	public static boolean isNotNullAndNotZero(Long number) {
		return number != null && number.intValue() != 0;
	}

	public static boolean isNullOrZero(Long number) {
		return number == null || number.intValue() == 0;
	}

	public static boolean isNotNullAndNotZero(Integer number) {
		return number != null && number.intValue() != 0;
	}

	public static boolean isNullOrZero(Integer number) {
		return number == null || number.intValue() == 0;
	}

	public static boolean isClassNumber(Class<?> clazz) {
		if (Number.class.isAssignableFrom(clazz) || isClassPrimitifNumber(clazz))
			return true;
		return false;
	}

	private static boolean isClassPrimitifNumber(Class<?> clazz) {
		return clazz.equals(int.class) || clazz.equals(long.class) || clazz.equals(double.class)
				|| clazz.equals(float.class);
	}
	
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
