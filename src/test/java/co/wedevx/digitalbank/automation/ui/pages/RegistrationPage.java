package co.wedevx.digitalbank.automation.ui.pages;

import co.wedevx.digitalbank.automation.ui.utils.MockData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Map;

public class RegistrationPage extends BasePage{

    public RegistrationPage(WebDriver driver) {
        super(driver);

    }

    MockData mockData = new MockData();

    @FindBy(id = "title")
    private WebElement titleDropDown;

    @FindBy(id = "firstName")
    private WebElement firstNameTxtBox;

    @FindBy(id = "lastName")
    private WebElement lastNameTxtBox;

    @FindBy(xpath = "//label[@for='male']//input")
    private WebElement genderMRadio;

    @FindBy(xpath = "//label[@for='female']//input")
    private WebElement genderFRadio;

    @FindBy(id = "dob")
    private WebElement dobTxtBox;

    @FindBy(id = "ssn")
    private WebElement ssnTxtBox;

    @FindBy(id = "emailAddress")
    private WebElement emailAddressTxtBox;

    @FindBy(id = "password")
    private WebElement passwordTxtBox;

    @FindBy(id = "confirmPassword")
    private WebElement confirmPasswordTxtBox;

    @FindBy(xpath = "//button[@class='btn btn-primary btn-flat m-b-30 m-t-30']")
    private WebElement registrationButton;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement nextButton;

    @FindBy(id = "address")
    private WebElement addressTxtBox;

    @FindBy(id = "locality")
    private WebElement localityTxtBox;

    @FindBy(id = "region")
    private WebElement regionTxtBox;

    @FindBy(id = "postalCode")
    private WebElement postalCodeTxtBox;

    @FindBy(id = "country")
    private WebElement countryTxtBox;

    @FindBy(id = "homePhone")
    private WebElement homePhoneTxtBox;

    @FindBy(id = "mobilePhone")
    private WebElement mobilePhoneTxtBox;

    @FindBy(id = "workPhone")
    private WebElement workPhoneTxtBox;

    @FindBy(id = "agree-terms")
    private WebElement agreeTermsCheckbox;

    @FindBy(xpath = "//div[@class='sufee-alert alert with-close alert-success alert-dismissible fade show']/span[2]")
    private WebElement messageLabel;


    public void fillOutRegistrationPage(List<Map<String, String>> registrationPageTestDataListOfMap) {
        Select titleSelect = new Select(titleDropDown);
        Map<String, String> firstRow = registrationPageTestDataListOfMap.get(0);

        if (firstRow.get("title") != null) {
            titleSelect.selectByVisibleText(firstRow.get("title"));
        }

        if (firstRow.get("firstName") != null) {
            firstNameTxtBox.sendKeys(firstRow.get("firstName"));
        }

        if (firstRow.get("lastName") != null) {
            lastNameTxtBox.sendKeys(firstRow.get("lastName"));
        }


        if (firstRow.get("gender") != null) {
            if (firstRow.get("gender").equalsIgnoreCase("M")) {
                genderMRadio.click();
            } else if (firstRow.get("gender").equalsIgnoreCase("F")) {
                genderFRadio.click();
            } else {
                System.out.println("Wrong Gender");
            }
        }

        if (firstRow.get("dob") != null) {
            dobTxtBox.sendKeys(firstRow.get("dob"));
        }

        if (firstRow.get("ssn") != null) {
            ssnTxtBox.sendKeys(firstRow.get("ssn"));
        }

        if (firstRow.get("email") != null) {
            emailAddressTxtBox.sendKeys(firstRow.get("email"));
        }

        if (firstRow.get("password") != null) {
            passwordTxtBox.sendKeys(firstRow.get("password"));
            confirmPasswordTxtBox.sendKeys(firstRow.get("password"));
        }

        nextButton.click();

        if (addressTxtBox.isDisplayed()) {
            if (firstRow.get("address") != null) {
                addressTxtBox.sendKeys(firstRow.get("address"));
            }

            if (firstRow.get("locality") != null) {
                localityTxtBox.sendKeys(firstRow.get("locality"));
            }

            if (firstRow.get("region") != null) {
                regionTxtBox.sendKeys(firstRow.get("region"));
            }

            if (firstRow.get("postalCode") != null) {
                postalCodeTxtBox.sendKeys(firstRow.get("postalCode"));
            }

            if (firstRow.get("country") != null) {
                countryTxtBox.sendKeys(firstRow.get("country"));
            }

            if (firstRow.get("homePhone") != null) {
                homePhoneTxtBox.sendKeys(firstRow.get("homePhone"));
            }

            if (firstRow.get("mobilePhone") != null) {
                mobilePhoneTxtBox.sendKeys(firstRow.get("mobilePhone"));
            }

            if (firstRow.get("workPhone") != null) {
                workPhoneTxtBox.sendKeys(firstRow.get("workPhone"));
            }

            if (firstRow.get("termsCheckMark") != null && firstRow.get("termsCheckMark").equalsIgnoreCase("true")) {
                agreeTermsCheckbox.click();
            }

            registrationButton.click();
        }
    }

    public String getMessage() {
        System.out.println(messageLabel.getText());
        return messageLabel.getText();
    }

    public String getRequiredFieldErrorMessage(String fieldName){
        switch(fieldName.toLowerCase()){
            case "title":
                return titleDropDown.getAttribute("validationMessage");
            case "firstname":
                return firstNameTxtBox.getAttribute("validationMessage");
            case "lastname":
                return lastNameTxtBox.getAttribute("validationMessage");
            case "gender":
                return genderMRadio.getAttribute("validationMessage");
            case "dob":
                return dobTxtBox.getAttribute("validationMessage");
            case "ssn":
                return ssnTxtBox.getAttribute("validationMessage");
            case "email":
                return emailAddressTxtBox.getAttribute("validationMessage");
            case "password":
                return passwordTxtBox.getAttribute("validationMessage");
            case "address":
                return addressTxtBox.getAttribute("validationMessage");
            case "locality":
                return localityTxtBox.getAttribute("validationMessage");
            case "region":
                return regionTxtBox.getAttribute("validationMessage");
            case "postalcode":
                return postalCodeTxtBox.getAttribute("validationMessage");
            case "country":
                return countryTxtBox.getAttribute("validationMessage");
            case "homephone":
                return homePhoneTxtBox.getAttribute("validationMessage");
            case "mobilephone":
                return mobilePhoneTxtBox.getAttribute("validationMessage");
            case "workphone":
                return workPhoneTxtBox.getAttribute("validationMessage");
            case "termscheckmark":
                return agreeTermsCheckbox.getAttribute("validationMessage");
            default:
                return null;
        }
    }
}
