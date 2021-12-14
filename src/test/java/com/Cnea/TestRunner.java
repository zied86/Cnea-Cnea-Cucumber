package com.Cnea;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/specs/features"},
		//glue = {""},
		plugin = {"pretty", "html:target/cucumber-html-report"},
		snippets = SnippetType.CAMELCASE,
		tags = {("@authentication")},
		monochrome = true  
		)

public class TestRunner{
	
	
}