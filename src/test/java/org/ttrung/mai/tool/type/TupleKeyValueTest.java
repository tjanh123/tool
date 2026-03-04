package org.ttrung.mai.tool.type;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.ttrung.mai.tool.model.TupleKeyValue;

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
