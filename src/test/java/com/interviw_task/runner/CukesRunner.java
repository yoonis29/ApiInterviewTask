package com.interviw_task.runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
        @CucumberOptions(
                plugin = {"json:target/cucumber.json",
                        "html:target/default-html-reports"},
                features = "src/test/resources/features",
                glue = "com/interviw_task/step_definitions",
                tags = "@roomba",
                dryRun = false
        )

public class CukesRunner {
}
