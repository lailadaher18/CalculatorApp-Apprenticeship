package calculatorService.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CalculatorSteps {

    @LocalServerPort
    private int port;

    private WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Given("I am on the calculator page")
    public void i_am_on_the_calculator_page() {
        driver.get("http://localhost:" + port + "/calc.html");
    }

    @When("I enter {string}")
    public void i_enter(String expression) {
        for (char c : expression.toCharArray()) {
            driver.findElement(By.xpath("//input[@value='" + c + "']")).click();
            try {
                Thread.sleep(500); // 500ms delay between button presses to view the test in action
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @When("I press {string}")
    public void i_press(String button) {
        driver.findElement(By.xpath("//input[@value='" + button + "']")).click();
        try {
            Thread.sleep(700); // 700ms delay after pressing =
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("the result should be {string}")
    public void the_result_should_be(String expectedResult) {
        try {
            // Introducing a small delay to wait for the async operation to complete
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String actualResult = driver.findElement(By.id("display")).getAttribute("value");
        assertEquals(expectedResult, actualResult);
    }
}