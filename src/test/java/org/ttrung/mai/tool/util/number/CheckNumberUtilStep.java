package org.ttrung.mai.tool.util.number;

import static org.junit.Assert.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckNumberUtilStep {
	Long number;
	int threshold;
	boolean result;

	@Given("I have a number {long}")
	public void i_have_a_number(Long long1) {
		number = long1;
	}

	@Given("I have a threshold {int}")
	public void i_have_a_threshold(Integer int1) {
		threshold = int1;
	}

	@When("I check if {int} is inside range [{int}, Math.abs\\({int})]")
	public void i_check_if_is_inside_range_Math_abs(Integer int1, Integer int2, Integer int3) {
		result = CheckNumberUtil.isInsideThresholdAbsolute(number, threshold);
	}

	@Then("it should be true")
	public void it_should_be_true() {
		System.out.println(number + "ss" + result);
		assertEquals(result, true);
	}

	@Then("it should be false")
	public void it_should_be_false() {
		assertEquals(result, false);
	}
	
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
		System.out.println(number + "check " + result);
	}

	@When("I check if null is not null and not zero")
	public void i_check_if_null_is_not_null_and_not_zero() {
		result = CheckNumberUtil.isNotNullAndNotZero(number);
		System.out.println(number + "check " + result);
	}

}
