package org.ttrung.mai.tool.util.number;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "pretty" }, features = {
		"src/test/resources/org/ttrung/mai/tool/util/number/CheckNumberUtilFeature.feature" }, glue = {
				"CheckNumberUtilStep", "CheckNumberUtilNullZeroStep" })
public class CheckNumberUtilTest {

}
