package stepDef;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import static helper.Utility.*;

public class Hooks {

    @Before("@web")  // hanya jalan untuk scenario yang pakai tag @web
    public void beforeScenario() {
        System.out.println("=== Starting WebDriver ===");
        startDriver(); // ini dari Utility, inisialisasi driver
    }

    @After("@web")   // hanya jalan untuk scenario yang pakai tag @web
    public void afterScenario() {
        System.out.println("=== Quitting WebDriver ===");
        quitDriver();  // stop driver dan bersihkan
    }
}
