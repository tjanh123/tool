package org.ttrung.mai.tool.converter;

public interface Converter<S, D> {

	D convert(S source, D destination);
}
