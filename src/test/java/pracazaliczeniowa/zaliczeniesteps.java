package pracazaliczeniowa;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class zaliczeniesteps {
    private WebDriver driver;
    private Wypelniapole wypelniapole;

    @Given("^Landing page2 (.*) opened in browser$")
    public void openBrowser(String url) {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(16));
        this.driver.get(url);
    }

    @When("^Sign in button pressed2$")
    public void pressSignIn2() {
        WebElement signInBtn = driver.findElement(By.id("_desktop_user_info"));
        signInBtn.click();
    }

    @And("^Log in to your account2$")
    public void loginData() {
        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("regina@gmail.com");
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("123456789");
        WebElement logInto = driver.findElement(By.id("submit-login"));
        logInto.click();
    }

    @And("^clicks on the option Addresses$")
    public void clickAddress() {
        WebElement address = driver.findElement(By.xpath("//a[@title='Addresses']"));
        address.click();
    }

    @And("^clicks on the option Create new address$")
    public void CreateAddress() {
    WebElement address2 = driver.findElement(By.xpath("/html/body/main/section/div/div/section/section/div[3]/a/span"));
    address2.click();
    }

    @And("^New address form filled out and save (.*),(.*),(.*),(.*),(.*),(.*),(.*),(.*),(.*)$")
    public void filledFormAddress(String alias, String company, String vatNumber, String address, String addressComplement, String zipCode, String city, String country, String phone) {
        pracazaliczeniowa.ShoppingUserData shoppingUserData = new pracazaliczeniowa.ShoppingUserData()
                .setAlias(alias)
                .setCompany(company)
                .setVatNumber(vatNumber)
                .setAddress(address)
                .setAddressComplement(addressComplement)
                .setZipCode(zipCode)
                .setCity(city)
                .setCountry(country)
                .setPhone(phone);

        this.wypelniapole = new pracazaliczeniowa.Wypelniapole(driver);
        wypelniapole.filledFormAddress(shoppingUserData);

        assertEquals(alias,shoppingUserData.getAlias());
        assertEquals(company,shoppingUserData.getCompany());
        assertEquals(vatNumber,shoppingUserData.getVatNumber());
        assertEquals(address,shoppingUserData.getAddress());
        assertEquals(addressComplement,shoppingUserData.getAddressComplement());
        assertEquals(zipCode,shoppingUserData.getZipCode());
        assertEquals(city,shoppingUserData.getCity());
        assertEquals(country,shoppingUserData.getCountry());
        assertEquals(phone,shoppingUserData.getPhone());
    }
    @And("^save address data$")
    public void addAddressss() {wypelniapole.addAddress(); }

    @Then("^New account registered on (.*) website$")
    public void checkAccount() {
        WebElement successMessage = driver.findElement(By.xpath("//*[@id='notifications']/div/article[1]"));
        String succesMessageText = successMessage.getText();
        assertEquals("Address successfully added!", succesMessageText);
    }
}
