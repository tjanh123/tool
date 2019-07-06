package org.ttrung.mai.tool.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TupleKeyValue<K, V> {

	private K key;
	private V value;
	
}
