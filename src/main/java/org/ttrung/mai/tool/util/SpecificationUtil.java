package org.ttrung.mai.tool.util;

import org.springframework.data.jpa.domain.Specification;

public class SpecificationUtil {
	@SafeVarargs
	public static <T> Specification<T> combine(Specification<T>... specs) {
		Specification<T> firstSpec = specs[0];
		for (int i = 1; i < specs.length; i++) {
			firstSpec = firstSpec.and(specs[i]);
		}
		return firstSpec;
	}

	public static <T> Specification<T> distinct(Class<T> domain) {
		return (root, query, criteriaBuilder) -> {
			query.distinct(true);
			return criteriaBuilder.conjunction();
		};
	}
}
