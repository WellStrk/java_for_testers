package ru.stqa.addressbook.manager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import ru.stqa.addressbook.model.Group;
import ru.stqa.addressbook.model.PhoneNumber;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.*;

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
                    .withLastName(lastname.getText())
                   );
        }
        return numbers;
    }

    public void createPhoneNumber(PhoneNumber NumberData) {
        openPhoneNumberPage();
        fillPhoneNumberForm(NumberData);
        SubmitPhoneNumberCreation();
        ReturnToHomePage();
    }

    public void createPhoneNumberInGroup(PhoneNumber NumberData, Group group) {
        openPhoneNumberPage();
        fillPhoneNumberForm(NumberData);
        SelectGroup(group);
        SubmitPhoneNumberCreation();
        ReturnToHomePage();
    }

    public void addPhoneNumberToGroup(PhoneNumber phoneNumber, Group group) {
        OpenHomePage();
        ResetGroupFilter();
        SelectPhoneNumber(phoneNumber);
        selectGroupForAdding(group);
        clickAddToGroup();
        ReturnToGroupPage(group);
    }

    private void ResetGroupFilter() {
        Select groupSelect = new Select(manager.driver.findElement(By.name("group")));
        groupSelect.selectByVisibleText("[all]");
    }

    private void ReturnToGroupPage(Group group) {
        click(By.linkText(String.format("group page \"%s\"", group.name())));
    }

    public void removePhoneNumberFromGroup(PhoneNumber phoneNumber, Group group) {
        selectGroupForSearch(group);
        SelectPhoneNumber(phoneNumber);
        clickRemoveFromGroup();
    }


    private void selectGroupForSearch(Group group) {
        new Select(manager.driver.findElement(By.name("group"))).selectByValue(group.id());
    }

    private void SelectPhoneNumber(PhoneNumber phoneNumber) {
        click(By.cssSelector(String.format("input[value='%s']", phoneNumber.id())));
    }

    private void clickRemoveFromGroup() {
        manager.driver.findElement(By.name("remove")).click();
    }

    private void selectGroupForAdding(Group group) {
        new Select(manager.driver.findElement(By.name("to_group"))).selectByValue(group.id());
    }

    private void clickAddToGroup() {
        manager.driver.findElement(By.name("add")).click();
    }


    private void SelectGroup(Group group) {
        new Select(manager.driver.findElement(By.name("new_group"))).selectByValue(group.id());
    }

    public void modifyPhoneNumber(PhoneNumber phoneNumber, PhoneNumber modifiedPhoneNumber) {
        OpenHomePage();
        InitNumberModification(phoneNumber);
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

    private void InitNumberModification(PhoneNumber phoneNumber) {
        click(By.xpath(String.format("//input[@value='%s']/ancestor::tr//img[@alt='Edit']", phoneNumber.id())));
    }
    
    private void ReturnToHome() {
        click(By.linkText("home"));
    }

    private void RemoveSelectedPhoneNumber() {
        click(By.name("delete"));
    }


    private void ReturnToHomePage() {
        WebDriverWait wait = new WebDriverWait(manager.driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("home page")));
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
        attach(By.name("photo"),NumberData.photo());
    }

    public void OpenHomePage() {
        click(By.linkText("home"));
    }

    public int getNumberCount() {
        OpenHomePage();
        return manager.driver.findElements(By.name("selected[]")).size();
    }

    public String getPhones(PhoneNumber contact) {
        return manager.driver.findElement(By.xpath(
                String.format("//input[@id='%s']/../../td[6]", contact.id()))).getText();
    }

    public Map<String, String> getPhones() {
        var result = new HashMap<String, String>();
        List<WebElement> rows = manager.driver.findElements(By.name("entry"));
        for (WebElement row : rows) {
            var id = row.findElement(By.tagName("input")).getAttribute("id");
            var phones = row.findElements(By.tagName("td")).get(5).getText();
            result.put(id,phones);
        }
            return result;
    }
}
