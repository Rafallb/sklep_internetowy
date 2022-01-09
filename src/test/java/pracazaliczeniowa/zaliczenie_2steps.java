package pracazaliczeniowa;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


public class zaliczenie_2steps {
    private WebDriver driver;

    @Given("^Landing page3 (.*) opened in browser$")
    public void openBrowser(String url) {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(16));
        this.driver.get(url);
    }

    @When("^Sign in button pressed3$")
    public void pressSignIn3() {
        WebElement signInBtn3 = driver.findElement(By.id("_desktop_user_info"));
        signInBtn3.click();
    }

    @And("^Log in to your account3$")
    public void login() {
        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("regina@gmail.com");
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("123456789");
        WebElement logInto = driver.findElement(By.id("submit-login"));
        logInto.click();
    }

    @And("^select to purchase Hummingbird Printed Sweater$")
    public void sweater() {
        WebElement clothes = driver.findElement(By.id("category-3"));
        clothes.click();
        WebElement sweater = driver.findElement(By.xpath("//img[@alt='Brown bear printed sweater']"));
        sweater.click();
    }

    @And("^chose size and take 5 thinks$")
    public void sizeM() {
        WebElement sizeM = driver.findElement(By.xpath("//*[@id=\"group_1\"]/option[2]"));
        sizeM.click();
        WebElement quantity = driver.findElement(By.xpath("//*[@name='qty']"));
        quantity.clear();
        quantity.sendKeys("5");
    }

    @And("^add to cart$")
    public void addToCart() {
        WebElement add = driver.findElement(By.className("add"));
        add.click();
        WebElement koszyk = driver.findElement(By.className("close"));
        koszyk.click();
        WebElement koszyk2 = driver.findElement(By.className("shopping-cart"));
        koszyk2.click();
        WebElement zaplac = driver.findElement(By.className("btn-primary"));
        zaplac.click();
    }
    @And("^confirm address$")
    public void continuee() {
        WebElement sprawdzadress = driver.findElement(By.xpath("//*[contains(@type, \"radio\")]"));
        assertNotNull(sprawdzadress);
        WebElement continueInput2 = driver.findElement(By.name("confirm-addresses"));
        continueInput2.click();
    }
    @And("^select a pickup method pick up in store$")
    public void reception() {
        WebElement delivery2 = driver.findElement(By.name("confirmDeliveryOption"));
        delivery2.click();
    }
    @And("^select payment options Pay by Check$")
    public void paymentType() {
        WebElement paymentType = driver.findElement(By.id("payment-option-1"));
        paymentType.click();
    }
    @Then("^click order with an obligation to pay$")
    public void transaction() {
        WebElement agreePersonalData = driver.findElement(By.id("conditions_to_approve[terms-and-conditions]"));
        agreePersonalData.click();
        WebElement obligationToPay = driver.findElement(By.id("payment-confirmation"));
        obligationToPay.click();
    }
    @And("Take screenshot")
    public void takeScreenshot() throws IOException {
        TakesScreenshot screenshot = (TakesScreenshot)driver;
        File tmpScreenshot = screenshot.getScreenshotAs(OutputType.FILE);
        String currentDateTime = LocalDateTime.now().toString().replaceAll(":", "_");
        Files.copy(tmpScreenshot.toPath(), Paths.get("C:", "test-evidence", "registration-success-evidence-12-"+currentDateTime+".png"));
    }
    @And("^check money status$")
    public void status2() {
        WebElement Regina = driver.findElement(By.xpath("//a[@title='Orders']"));
        Regina.click();
        WebElement successMessage3 = driver.findElement(By.xpath("//tr[1]/td[2]"));
        String successMessageText3 = successMessage3.getText();
        assertEquals("€143.60", successMessageText3);
        WebElement successMessage2 = driver.findElement(By.xpath("//tr[1]/td[4]/span[1]"));
        String successMessageText2 = successMessage2.getText();
        assertEquals("Awaiting check payment", successMessageText2);
    }
    @Then("^check payment status$")
    public void paymentStatus() {
        WebElement successMessage2 = driver.findElement(By.xpath("//tr[1]/td[4]/span[1]"));
        String successMessageText2 = successMessage2.getText();
        assertEquals("Awaiting check payment", successMessageText2);
    }
}
