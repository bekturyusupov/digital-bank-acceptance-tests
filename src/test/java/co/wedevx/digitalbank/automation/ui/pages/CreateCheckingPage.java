package co.wedevx.digitalbank.automation.ui.pages;

import co.wedevx.digitalbank.automation.ui.models.NewCheckingAttributes;
import co.wedevx.digitalbank.automation.ui.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;
import java.util.NoSuchElementException;
import static co.wedevx.digitalbank.automation.ui.utils.Driver.getDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreateCheckingPage extends BaseMenuPage{

    public CreateCheckingPage(WebDriver driver) {
        super(driver);
    }



    @FindBy(id = "Standard Checking")
    private WebElement standardCheckingAccountTypeRadioButton;

    @FindBy(id = "Interest Checking")
    private WebElement interestCheckingAccountTypeRadioButton;

    @FindBy(id = "Individual")
    private WebElement individualOwnershipTypeRadioButton;

    @FindBy(id = "Joint")
    private WebElement jointOwnershipTypeRadioButton;

    @FindBy(id = "name")
    private WebElement accountNameTxtBox;

    @FindBy(id = "openingBalance")
    private WebElement openingBalanceTxtBox;

    @FindBy(id = "newCheckingSubmit")
    private WebElement submitButton;

    public void createNewChecking(List<NewCheckingAttributes> newCheckingAttributesList) {
        NewCheckingAttributes checkingData = newCheckingAttributesList.get(0);
        checkingMenu.click();
        newCheckingButton.click();

        //need to check expected url
        assertEquals(ConfigReader.getPropertiesValue("digitalbank.createnewcheckingurl"), getDriver().getCurrentUrl(), "new Checking Button did not take the " + getDriver().getCurrentUrl());

        if(checkingData.getCheckingAccountType().equalsIgnoreCase("Standard Checking")){
            standardCheckingAccountTypeRadioButton.click();
        }
        else if(checkingData.getCheckingAccountType().equalsIgnoreCase("Interest Checking")){
            interestCheckingAccountTypeRadioButton.click();
        }
        else{
            throw new NoSuchElementException("Invalid checking account type option provided. Only supports Standard Checking and Interest Checking.");
        }

        if(checkingData.getAccountOwnership().equalsIgnoreCase("Individual")){
            individualOwnershipTypeRadioButton.click();
        }
        else if(checkingData.getAccountOwnership().equalsIgnoreCase("Joint")){
            jointOwnershipTypeRadioButton.click();
        }
        else{
            throw new NoSuchElementException("Invalid account ownership type option provided. Only supports Individual and Joint.");
        }

        accountNameTxtBox.sendKeys(checkingData.getAccountName());
        openingBalanceTxtBox.sendKeys(String.valueOf(checkingData.getInitialDepositAmount()));
        submitButton.click();
    }
}
