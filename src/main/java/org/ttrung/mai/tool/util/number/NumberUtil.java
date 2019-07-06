package org.ttrung.mai.tool.util.number;

import java.math.BigDecimal;

/**
 * some functions util number in general
 * @author ttrung.mai
 *
 */
public class NumberUtil {

	/**
	 * init a number if null
	 * <p> if number is float or double, by default will take 2 decimaux
	 * @param num
	 * @return
	 */
	public static BigDecimal initNumberValueIfNull(Number num) {
		return initNumberValueIfNull(num, 2);
	}
	
	/**
	 * init a number if null with number of scale decimal
	 * @param num
	 * @return
	 */
	public static BigDecimal initNumberValueIfNull(Number num, int scaleDecimal) {
		return num == null ? BigDecimal.ZERO : BigDecimal.valueOf(num.doubleValue()).setScale(scaleDecimal, BigDecimal.ROUND_HALF_UP);
	}
}
