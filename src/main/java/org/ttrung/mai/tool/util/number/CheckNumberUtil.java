package org.ttrung.mai.tool.util.number;

/**
 * functions util checking number
 * <p>these functions only return boolean value
 * @author ttrung.mai
 *
 */
public class CheckNumberUtil {
	
	public static boolean isNotNullAndNotZero(Number number, float threshold) {
		if (number == null) {
			return false;
		}
		double valDou = number.doubleValue();
		return valDou >= -threshold && valDou <= threshold;
	}

	public static boolean isNotNullAndNotZero(Number number) {
		return isNotNullAndNotZero(number, 0.0f);
	}

	public static boolean isNullOrZero(Number number) {
		return !isNotNullAndNotZero(number, 0.0f);
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
