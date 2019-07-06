package org.ttrung.mai.tool.util;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import org.ttrung.mai.tool.type.NumberUtil;


@RunWith(SpringRunner.class)
public class NumberUtilBiggerThanTest {

	@Test
	public void shouldFalse_WhenOneNumberIsNull() {
		assertFalse(NumberUtil.isBiggerThan(null, 0L));
		assertFalse(NumberUtil.isBiggerThan(1.2, null));
		assertFalse(NumberUtil.isBiggerThan(null, null));
	}
	
	@Test
	public void shouldFalse_WhenNum1LessThanNum2() {
		assertFalse(NumberUtil.isBiggerThan(0L, 0L));
		assertFalse(NumberUtil.isBiggerThan(1.2, 1.3));
	}
	
	@Test
	public void shouldTrue_WhenNum1BiggerThanNum2() {
		assertTrue(NumberUtil.isBiggerThan(4, 1.3));
	}
	
}
