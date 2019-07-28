package org.ttrung.mai.tool.util.number;

import static org.junit.Assert.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckNumberUtilInThresholdStep {
	Long num;
	int threshold;
	boolean result;

	@Given("I have a number {long}")
	public void i_have_a_number(Long long1) {
		num = long1;
	}

	@Given("I have a threshold {int}")
	public void i_have_a_threshold(Integer int1) {
		threshold = int1;
	}

	@When("I check if {int} is inside range [{int}, Math.abs\\({int})]")
	public void i_check_if_is_inside_range_Math_abs(Integer int1, Integer int2, Integer int3) {
		result = CheckNumberUtil.isInsideThresholdAbsolute(num, threshold);
	}

	@Then("it should be true")
	public void it_should_be_true() {
		assertEquals(result, true);
	}

	@Then("it should be false")
	public void it_should_be_false() {
		assertEquals(result, false);
	}

}
