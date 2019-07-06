package org.ttrung.mai.tool.type;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import org.ttrung.mai.tool.model.TupleKeyValue;

@RunWith(SpringRunner.class)
public class TupleKeyValueTest {

	@Test
	public void whenGivingClassKeyAndValue_thenReturnSameClassGiven() {
		TupleKeyValue<String, Integer> tup = new TupleKeyValue<String, Integer>("Hello", 1);
		assertEquals(String.class, tup.getKey().getClass());
		assertEquals(Integer.class, tup.getValue().getClass());
	}
	
	@Test
	public void whenGivingValueKeyAndValue_thenReturnSameValueGiven() {
		TupleKeyValue<String, Integer> tup = new TupleKeyValue<String, Integer>("Hello", 1);
		assertEquals("Hello", tup.getKey());
		assertEquals(1, tup.getValue().intValue());
	}
}
