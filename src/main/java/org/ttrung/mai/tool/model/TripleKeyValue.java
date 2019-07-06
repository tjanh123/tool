package org.ttrung.mai.tool.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TripleKeyValue<K, V1, V2> {

	private K key;
	private V1 value1;
	private V2 value2;
	
}
