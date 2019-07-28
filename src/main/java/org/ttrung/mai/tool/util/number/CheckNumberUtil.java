package org.ttrung.mai.tool.util.number;

/**
 * functions util checking number
 * <p>these functions only return boolean value
 * @author ttrung.mai
 *
 */
public class CheckNumberUtil {
	
	public static boolean isInsideThresholdAbsolute(Long number, long threshold) {
		if(number == null) {
			return false;
		}
		return number >= -threshold && number <= threshold;
	}
	
	public static boolean isInsideThresholdAbsolute(Integer number, long threshold) {
		if(number == null) {
			return false;
		}
		return number >= -threshold && number <= threshold;
	}

	public static boolean isNotNullAndNotZero(Long number) {
		return isInsideThresholdAbsolute(number, 0);
	}

	public static boolean isNullOrZero(Long number) {
		return !isInsideThresholdAbsolute(number, 0);
	}
	
	public static boolean isNotNullAndNotZero(Integer number) {
		return isInsideThresholdAbsolute(number, 0);
	}

	public static boolean isNullOrZero(Integer number) {
		return !isInsideThresholdAbsolute(number, 0);
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
}
