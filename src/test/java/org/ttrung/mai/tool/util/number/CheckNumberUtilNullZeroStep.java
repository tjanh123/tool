package org.ttrung.mai.tool.util.number;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class CheckNumberUtilNullZeroStep {
	
	Integer number;
	boolean result;
	
	@When("I check if {int} is null or zero")
	public void i_check_if_is_null_or_zero(Integer int1) {
		result = CheckNumberUtil.isNullOrZero(number);
	}

	@Given("I have a number null")
	public void i_have_a_number_null() {
		number = null;
	}

	@When("I check if null is null or zero")
	public void i_check_if_null_is_null_or_zero() {
		result = CheckNumberUtil.isNullOrZero(number);
	}

	@When("I check if {int} is not null and not zero")
	public void i_check_if_is_not_null_and_not_zero(Integer int1) {
		result = CheckNumberUtil.isNotNullAndNotZero(number);
	}

	@When("I check if null is not null and not zero")
	public void i_check_if_null_is_not_null_and_not_zero() {
		result = CheckNumberUtil.isNotNullAndNotZero(number);
	}
}
