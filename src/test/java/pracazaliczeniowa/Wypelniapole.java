package pracazaliczeniowa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Wypelniapole {
    @FindBy(name = "alias")
    private WebElement alias;
    @FindBy(name = "company")
    private WebElement company;
    @FindBy(name = "vat_number")
    private WebElement vatNumber;
    @FindBy(name = "address1")
    private WebElement address;
    @FindBy(name = "address2")
    private WebElement addressComplement;
    @FindBy(name = "postcode")
    private WebElement zipCode;
    @FindBy(name = "city")
    private WebElement city;
    @FindBy(name = "id_country")
    private WebElement country;
    @FindBy(name = "phone")
    private WebElement phone;
    @FindBy(xpath = "//button[contains(@class, 'btn-primary')]")
    private WebElement saveAddress;

    public Wypelniapole(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void filledFormAddress(pracazaliczeniowa.ShoppingUserData shoppingUserData) {


        alias.sendKeys(shoppingUserData.getAlias());
        company.sendKeys(shoppingUserData.getCompany());
        vatNumber.sendKeys(shoppingUserData.getVatNumber());
        address.sendKeys(shoppingUserData.getAddress());
        addressComplement.sendKeys(shoppingUserData.getAddressComplement());
        zipCode.sendKeys(shoppingUserData.getZipCode());
        city.sendKeys(shoppingUserData.getCity());
        country.sendKeys(shoppingUserData.getCountry());
        phone.sendKeys(shoppingUserData.getPhone());
    }
    public void addAddress() {saveAddress.click();}
}