package org.ttrung.mai.tool.util.common;

import static org.junit.Assert.assertTrue;

import java.util.Objects;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import org.ttrung.mai.tool.model.inf.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@RunWith(SpringRunner.class)
public class DtoUtilConvertTest {

	@Test
	public void shouldTrue_WhenSameValue() throws InstantiationException, IllegalAccessException {
		SimpleDto dto = new SimpleDtoImpl(11, "String 11");
		SimpleModel model = DtoUtil.convertToModel(dto, SimpleModel.class);
		assertTrue(model.getId().equals(dto.getId()));
		assertTrue(model.getName().equals(dto.getName()));
	}

	@Test
	public void shouldTrue_WhenSomePropretiesNotFoundInModel() throws InstantiationException, IllegalAccessException {
		SimpleDto dto = new SimpleDtoImpl(11, "String 11");
		SimpleModel2 model = DtoUtil.convertToModel(dto, SimpleModel2.class);
		assertTrue(model.getId().equals(dto.getId()));
		assertTrue(Objects.isNull(model.getName2()));
	}

	@Test(expected = InstantiationException.class)
	public void shouldException_WhenNoConstructorWithoutArgs() throws InstantiationException, IllegalAccessException {
		SimpleDto dto = new SimpleDtoImpl(11, "String 11");
		DtoUtil.convertToModel(dto, SimpleModel3.class);
	}

	@Getter
	@Setter
	public static class SimpleModel {
		private Integer id;
		private String name;
	}

	@Getter
	@Setter
	public static class SimpleModel2 {
		private Integer id;
		private String name2;
	}

	@Getter
	@Setter
	@AllArgsConstructor
	public static class SimpleModel3 {
		private Integer id;
		private String name3;
	}

	public static interface SimpleDto extends Dto {
		public String getName();

		public Integer getId();
	}

	@AllArgsConstructor
	public static class SimpleDtoImpl implements SimpleDto {
		private Integer var1;
		private String var2;

		@Override
		public String getName() {
			return var2;
		}

		@Override
		public Integer getId() {
			return var1;
		}
	}
}
