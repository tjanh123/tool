package org.ttrung.mai.tool.type;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import org.ttrung.mai.tool.model.TripleKeyValue;

@RunWith(SpringRunner.class)
public class TripleKeyValueTest {

	@Test
	public void whenGivingClassKeyAndValue_thenReturnSameClassGiven() {
		TripleKeyValue<String, Integer, Double> tup = new TripleKeyValue<String, Integer, Double>("Hello", 1, 1.3d);
		assertEquals(String.class, tup.getKey().getClass());
		assertEquals(Integer.class, tup.getValue1().getClass());
		assertEquals(Double.class, tup.getValue2().getClass());
	}
	
	@Test
	public void whenGivingValueKeyAndValue_thenReturnSameValueGiven() {
		TripleKeyValue<String, Integer, Double> tup = new TripleKeyValue<String, Integer, Double>("Hello", 1, 1.3d);
		assertEquals("Hello", tup.getKey());
		assertEquals(1, tup.getValue1().intValue());
		assertEquals(1.3d, tup.getValue2().doubleValue(), 0.000001d);
	}
}
