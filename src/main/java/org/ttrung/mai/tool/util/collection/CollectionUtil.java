package org.ttrung.mai.tool.util.collection;

import static java.lang.reflect.Array.newInstance;

import java.util.Collection;

public class CollectionUtil {

	private CollectionUtil() {}
	
	public static <T> T[] toArray(Collection<? extends T> collection, Class<T> clazz) {
		if (collection == null) {
			return null;
		}

		T[] transformedArray = (T[]) newInstance(clazz, collection.size());

		int index = 0;
		for (T fromObject : collection) {
			transformedArray[index] = fromObject;
			index++;
		}

		return transformedArray;
	}

}
