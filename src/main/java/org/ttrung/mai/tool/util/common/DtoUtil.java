package org.ttrung.mai.tool.util.common;

import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;
import org.ttrung.mai.tool.model.inf.Dto;

public class DtoUtil {

	public static <T, D extends Dto> List<T> convertToModel(List<D> dto, Class<T> modelType)
			throws InstantiationException, IllegalAccessException {
		List<T> results = new ArrayList<T>();
		for (D d : dto) {
			T mdl = convertToModel(d, modelType);
			results.add(mdl);
		}
		return results;
	}

	public static <T, D extends Dto> T convertToModel(D dto, Class<T> modelType)
			throws InstantiationException, IllegalAccessException {
		PropertyDescriptor[] props = PropertyUtils.getPropertyDescriptors(modelType);
		T mdl = modelType.newInstance();

		for (PropertyDescriptor prop : props) {
			Object value;
			try {
				value = PropertyUtils.getProperty(dto, prop.getName());
				PropertyUtils.setProperty(mdl, prop.getName(), value);
			} catch (IllegalAccessException e) {
			} catch (InvocationTargetException e) {
			} catch (NoSuchMethodException e) {
			}

		}
		return mdl;

	}

}
