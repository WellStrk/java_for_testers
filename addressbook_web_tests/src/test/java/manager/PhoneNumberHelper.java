package manager;

import model.PhoneNumber;
import org.openqa.selenium.By;

public class PhoneNumberHelper extends HelperBase{

    public PhoneNumberHelper(ApplicationManager manager) {
        super(manager);
    }


    public void createPhoneNumber(PhoneNumber NumberData) {
        openPhoneNumberPage();
        fillPhoneNumberForm(NumberData);
        SubmitPhoneNumberCreation();
        ReturnToHomePage();
    }

    private void ReturnToHomePage() {
        click(By.linkText("home page"));
    }

    private void SubmitPhoneNumberCreation() {
        click(By.name("submit"));
    }

    public void openPhoneNumberPage() {
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


}
