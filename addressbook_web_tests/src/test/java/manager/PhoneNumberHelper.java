package manager;

import model.Group;
import model.PhoneNumber;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

public class PhoneNumberHelper extends HelperBase{

    public PhoneNumberHelper(ApplicationManager manager) {
        super(manager);
    }

    public List<PhoneNumber> getNumbersList() {
        OpenHomePage();
        var numbers = new ArrayList<PhoneNumber>();
        var trs = manager.driver.findElements(By.name("entry"));
        for (var tr : trs) {
            var checkbox = tr.findElement(By.name("selected[]"));
            var id = checkbox.getAttribute("value");
            var firstname =  tr.findElement(By.cssSelector("td:nth-child(3)"));
            var lastname =  tr.findElement(By.cssSelector("td:nth-child(2)"));
            numbers.add(new PhoneNumber()
                    .withId(id)
                    .withFirstName(firstname.getText())
                    .withLastName(lastname.getText()));
        }
        return numbers;
    }

    public void createPhoneNumber(PhoneNumber NumberData) {
        openPhoneNumberPage();
        fillPhoneNumberForm(NumberData);
        SubmitPhoneNumberCreation();
        ReturnToHomePage();
    }

    public void modifyPhoneNumber(PhoneNumber phoneNumber, PhoneNumber modifiedPhoneNumber) {
        OpenHomePage();
        SelectPhoneNumber(phoneNumber);
        InitNumberModification();
        fillPhoneNumberForm(modifiedPhoneNumber);
        SubmitPhoneModification();
        ReturnToHomePage();
    }

    public void createPhoneNumberWithIncorrectParameters(PhoneNumber NumberData) {
        openPhoneNumberPage();
        fillPhoneNumberForm(NumberData);
        SubmitPhoneNumberCreation();
        ReturnToHome();
    }

    public void removePhoneNumber(PhoneNumber phoneNumber) {
        OpenHomePage();
        SelectPhoneNumber(phoneNumber);
        RemoveSelectedPhoneNumber();
        ReturnToHomePage();
    }

    public void RemoveAllPhoneNumber() {
        OpenHomePage();
        SelectAllPhoneNumber();
        RemoveSelectedPhoneNumber();
    }

    private void SelectAllPhoneNumber() {
        var checkboxes = manager.driver.findElements(By.name("selected[]"));
        for (var checkbox : checkboxes) {
            checkbox.click();
        }
    }

    private void SubmitPhoneModification() {
        click(By.name("update"));
    }

    private void InitNumberModification() {
        click(By.xpath("//img[@alt=\'Edit\']"));
    }
    
    private void ReturnToHome() {
        click(By.linkText("home"));
    }

    private void RemoveSelectedPhoneNumber() {
        click(By.name("delete"));
    }

    private void SelectPhoneNumber(PhoneNumber phoneNumber) {
        click(By.cssSelector(String.format("input[value='%s']", phoneNumber.id())));
    }

    private void ReturnToHomePage() {
        click(By.linkText("home page"));
    }

    private void SubmitPhoneNumberCreation() {
        click(By.name("submit"));
    }

    private void openPhoneNumberPage() {
        if (!manager.isElementPresent(By.name("new"))) {
            click(By.linkText("add new"));
        }
    }

    private void fillPhoneNumberForm(PhoneNumber NumberData) {
        type(By.name("firstname"), NumberData.firstname());
        type(By.name("lastname"), NumberData.lastname());
        type(By.name("address"), NumberData.address());
        type(By.name("email"), NumberData.email());
        type(By.name("mobile"), NumberData.mobile());
    }

    public void OpenHomePage() {
        click(By.linkText("home"));
    }

    public int getNumberCount() {
        OpenHomePage();
        return manager.driver.findElements(By.name("selected[]")).size();
    }

}
