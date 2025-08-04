package stepDef;

import io.cucumber.java.*;
import static helper.Utility.*;

public class Hooks {

    @Before
    public void beforeTest(Scenario scenario) {
        if (scenario.getSourceTagNames().contains("@web")) {
            startDriver();
        }
    }

    @After
    public void afterTest(Scenario scenario) throws InterruptedException {
        if (scenario.getSourceTagNames().contains("@web")) {
            Thread.sleep(3000);
            quitDriver();
        }
    }
}
