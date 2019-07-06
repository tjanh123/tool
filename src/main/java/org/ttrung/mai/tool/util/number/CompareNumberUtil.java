package org.ttrung.mai.tool.util.number;

import java.math.BigDecimal;
import java.util.Comparator;

/**
 * functions comparing the numbers
 * <p>by default, if the number is null, it will be converted to ZERO
 * <p>these functions only return value -1,0,1 like result {@link Comparator}
 * @author ttrung.mai
 *
 */
public class CompareNumberUtil {
	
	/**
	 * compare the absolute value of two numbers
	 * @param num1
	 * @param num2
	 * @return
	 */
	public static int compareByAbs(Number num1, Number num2) {
		BigDecimal v1 = NumberUtil.initNumberValueIfNull(num1).abs();
		BigDecimal v2 = NumberUtil.initNumberValueIfNull(num2).abs();
		return v1.compareTo(v2);
	}

	/**
	 * calculate the distance of 2 numbers 
	 * <p>compare the distance with deviation 
	 * @param num1
	 * @param num2
	 * @param deviation
	 * @return
	 */
	public static int compareWithDeviation(Number num1, Number num2, Double deviation) {
		BigDecimal v1 = NumberUtil.initNumberValueIfNull(num1).abs();
		BigDecimal v2 = NumberUtil.initNumberValueIfNull(num2).abs();
		BigDecimal devi = NumberUtil.initNumberValueIfNull(deviation);
		BigDecimal distance = v1.subtract(v2);
		return distance.abs().compareTo(devi.abs());
	}
}
