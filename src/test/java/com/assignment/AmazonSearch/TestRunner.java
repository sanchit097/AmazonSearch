package com.assignment.AmazonSearch;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "Resources/features" }, glue = "com/assignment/AmazonSearch/stepDefinitions", tags = { "@assignment" }, plugin = {
		"pretty", "html:target/cucumber" })
public class TestRunner {

}
