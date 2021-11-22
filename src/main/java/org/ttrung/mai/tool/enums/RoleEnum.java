package org.ttrung.mai.tool.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * if want to check ROLE_XXX, we should declare XXX, not ROLE_XXX because spring
 * are going to add prefix ROLE_
 * 
 * @author ttrun
 *
 */
@Getter
@RequiredArgsConstructor
public enum RoleEnum {
	USER("ROLE_USER"), ADMIN("ROLE_ADMIN");

	private final String value;

}
