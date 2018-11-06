package com.cacau.api;

import io.github.bonigarcia.wdm.WebDriverManager;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {
    private WebDriver driver;

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setupTest() {
        driver = new ChromeDriver();
    }

    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void test() throws InterruptedException {
        driver.get("http://localhost:8081/cacau/api/ping");
        Thread.sleep(1000);
        String expected = "{\"version\":\"0.0.5\"}";
        String actual = driver.getPageSource();
        assertTrue(actual.contains(expected));
    }
}
