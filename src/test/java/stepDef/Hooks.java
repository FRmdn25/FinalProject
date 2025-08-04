package stepDef;

import io.cucumber.java.*;
import helper.Utility;

public class Hooks {

    @Before
    public void beforeTest(Scenario scenario) {
        if (scenario.getSourceTagNames().contains("@ui")) {
            Utility.startDriver();
        }
    }

    @After
    public void afterTest(Scenario scenario) throws InterruptedException {
        if (scenario.getSourceTagNames().contains("@ui")) {
            Thread.sleep(3000); // Optional delay if needed for debugging
            Utility.quitDriver();
        }
    }
}
