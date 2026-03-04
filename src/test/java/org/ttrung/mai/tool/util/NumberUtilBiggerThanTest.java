package org.ttrung.mai.tool.util;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.ttrung.mai.tool.util.number.CheckNumberUtil;

public class NumberUtilBiggerThanTest {

	@Test
	public void shouldFalse_WhenOneNumberIsNull() {
		assertFalse(CheckNumberUtil.isBiggerThan(null, 0L));
		assertFalse(CheckNumberUtil.isBiggerThan(1.2, null));
		assertFalse(CheckNumberUtil.isBiggerThan(null, null));
	}
	
	@Test
	public void shouldFalse_WhenNum1LessThanNum2() {
		assertFalse(CheckNumberUtil.isBiggerThan(0L, 0L));
		assertFalse(CheckNumberUtil.isBiggerThan(1.2, 1.3));
	}
	
	@Test
	public void shouldTrue_WhenNum1BiggerThanNum2() {
		assertTrue(CheckNumberUtil.isBiggerThan(4, 1.3));
	}
	
}
